package com.mingx.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuqiangxin
 * @Classname: MybatisPlusConfig
 * @Description: MybatisPlus分页插件
 * @date 2020/5/15 17:16
 */
@Configuration
@MapperScan("com.mingx.user.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
