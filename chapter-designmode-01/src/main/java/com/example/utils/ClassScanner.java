package com.example.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.util.TypeUtils;

/**
 * 类扫描器（获取指定包下的指定类型）
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 14:37
 */
@SuppressWarnings("all")
public class ClassScanner {


    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private final List<TypeFilter> includeFilters = new ArrayList<>();

    private final List<TypeFilter> excludeFilters = new ArrayList<>();

    private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);

    /**
     * 添加包含的Fiter
     *
     * @param includeFilter
     */
    public void addIncludeFilter(TypeFilter includeFilter) {
        this.includeFilters.add(includeFilter);
    }

    /**
     * 添加排除的Fiter
     *
     * @param excludeFilter
     */
    public void addExcludeFilter(TypeFilter excludeFilter) {
        this.excludeFilters.add(excludeFilter);
    }

    /**
     * 扫描指定的包，获取包下所有的Class
     *
     * @param basePackage 包名
     * @param targetTypes 需要指定的目标类型,可以是pojo,可以是注解
     * @return Set<Class<?>>
     */
    public static Set<Class<?>> scan(String basePackage, Class<?>... targetTypes) {
        ClassScanner cs = new ClassScanner();
        for (Class<?> targetType : targetTypes) {
            if (TypeUtils.isAssignable(Annotation.class, targetType)) {
                cs.addIncludeFilter(new AnnotationTypeFilter((Class<? extends Annotation>) targetType));
            } else {
                cs.addIncludeFilter(new AssignableTypeFilter(targetType));
            }
        }
        return cs.doScan(basePackage);
    }

    /**
     * 扫描指定的包，获取包下所有的Class
     *
     * @param basePackages 包名,多个
     * @param targetTypes  需要指定的目标类型,可以是pojo,可以是注解
     * @return Set<Class<?>>
     */
    public static Set<Class<?>> scan(String[] basePackages, Class<?>... targetTypes) {
        ClassScanner cs = new ClassScanner();
        for (Class<?> targetType : targetTypes) {
            if (TypeUtils.isAssignable(Annotation.class, targetType)) {
                cs.addIncludeFilter(new AnnotationTypeFilter((Class<? extends Annotation>) targetType));
            } else {
                cs.addIncludeFilter(new AssignableTypeFilter(targetType));
            }
        }
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (String s : basePackages) {
            classes.addAll(cs.doScan(s));
        }
        return classes;
    }

    /**
     * 扫描指定的包，获取包下所有的Class
     *
     * @param basePackages 包名
     * @return Set<Class<?>>
     */
    public Set<Class<?>> doScan(String[] basePackages) {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (String basePackage : basePackages) {
            classes.addAll(doScan(basePackage));
        }
        return classes;
    }

    /**
     * 扫描指定的包，获取包下所有的Class
     *
     * @param basePackage 包名
     * @return Set<Class<?>>
     */
    public Set<Class<?>> doScan(String basePackage) {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        try {
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage)) + "/**/*.class";
            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);
            for (int i = 0; i < resources.length; i++) {
                Resource resource = resources[i];
                if (resource.isReadable()) {
                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                    if ((includeFilters.size() == 0 && excludeFilters.size() == 0) || matches(metadataReader)) {
                        try {
                            classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                        } catch (ClassNotFoundException ignore) {
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("I/O failure during classpath scanning", ex);
        }
        return classes;
    }

    /**
     * 处理 excludeFilters和includeFilters
     *
     * @param metadataReader
     * @return boolean
     * @throws IOException
     */
    private boolean matches(MetadataReader metadataReader) throws IOException {
        for (TypeFilter tf : this.excludeFilters) {
            if (tf.match(metadataReader, this.metadataReaderFactory)) {
                return false;
            }
        }
        for (TypeFilter tf : this.includeFilters) {
            if (tf.match(metadataReader, this.metadataReaderFactory)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Class<?>> scan = ClassScanner.scan("com.example.strategicmodel.difficult");
        for (Class<?> c : scan) {
            System.out.println(c);
        }
    }
}


