package com.study.result;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/20 15:00
 */
public class ItSelector implements ImportSelector {
    /**
     * 指定扫描的包路径
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.study.entity.UserEntity"};
    }
}
