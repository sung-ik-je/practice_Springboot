package com.mycompany.ordersystem.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class OrderSystemWebApplicationIntializer implements WebApplicationInitializer {

    /**
     * spring mvc application 시작할 때 호출되는 메서드
     * onStartup 메서드 내에서 웹 애플리케이션 컨텍스트를 생성한 후에 디스패처 서블릿을 등록하고 초기화하는 작업 수행
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        DispatcherServlet servlet = new DispatcherServlet(context);     // context는 코드 상으로는 오류이며 해당 부분에 IoC 객체를 넣어주면 된다
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}
