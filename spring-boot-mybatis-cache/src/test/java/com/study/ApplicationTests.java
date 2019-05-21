package com.study;

import com.study.entity.UserEntity;
import com.study.result.ImportUserConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportUserConfig.class);
		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//		UserEntity userEntity = (UserEntity) ctx.getBean("userEntity");
//		System.out.println("获取的对象bean : " + userEntity);
		for (String name : beanDefinitionNames) {
			System.out.println("从容器中获取的bean : " + name);
		}
	}

}
