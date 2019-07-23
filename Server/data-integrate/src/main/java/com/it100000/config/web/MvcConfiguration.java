package com.it100000.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 杨新杰
 * @date 2019/7/1022:45
 */
@Slf4j
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    /**
     * 配置预配置响应的简单自动化控制器
     * 状态代码和/或呈现响应主体的视图。这在
     * 不需要自定义控制器逻辑的情况——例如render a
     * 主页，执行简单的站点URL重定向，返回404状态
     * HTML内容，204没有内容，等等。
     * @author 杨新杰
     * @param  registry
     * @date   2019/7/10 22:54
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * 跨域配置
     *
     * @return org.springframework.web.filter.CorsFilter
     * @author 杨新杰
     * @date 2019/7/10 22:54
     **/
    @Bean
    public CorsFilter corsFilter() {
        log.info("加载CORS跨域设置");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        /*
         * 请求常用的三种配置，*代表允许所有，
         * 当然你也可以自定义属性（比如header只能带什么，只能是post方式等等）
         */
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }
}
