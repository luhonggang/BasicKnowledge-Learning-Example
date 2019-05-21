package com.study.result;

import com.study.entity.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置一个注册UserEntity 实例到ioc容器中的配置类
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/20 15:02
 */
@Configuration
@Import(UserEntity.class)
public class ImportUserConfig {
}
