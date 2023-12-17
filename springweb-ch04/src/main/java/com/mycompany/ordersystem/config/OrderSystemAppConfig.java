package com.mycompany.ordersystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc   /* MVC 구성 시에 필요한 스프링 빈 설정들을 자동 등록 해준다(핸들러 매핑에 대한 설정 포함)*/
@ComponentScan(basePackages = {"com.mycompany.ordersystem"})
public class OrderSystemAppConfig implements WebMvcConfigurer {

    /** 정적 리소스 파일에 대한 HTTP 요청을 처리할 물리적인 디렉터리 위치 지정 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(".resources/**")
                .addResourceLocations("/resources/");
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views", ".jsp");
    }
}
