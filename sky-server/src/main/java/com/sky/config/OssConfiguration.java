package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OssConfiguration {
    @Bean
    @ConditionalOnClass
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties ){
        log.info("开始创建阿里云文件上传客户端");
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                              aliOssProperties.getAccessKeyId(),
                              aliOssProperties.getAccessKeySecret(),
                              aliOssProperties.getBucketName()  );
    }
}
