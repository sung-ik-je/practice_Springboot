package com.mycompany.ordersystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {
    /**
     * 전체적으로 설명하자면 AppConfig를 이용해 애플리케이션의 기본 패키지를 설정
     * 
     * service interface를 상속받은 serviceImpl class, serviceImpl 내부에 repository를 상속 받은 repositoryImpl class 객체 사용
     * 
     * 실행 순서 : Main => SerivceImpl(Service 상속 받은 ,구현체) => RepositoryImpl(Repository 상속 받은, 구현체)
     * 
     * repostioryImpl에서 repostioryImpl2로 교체하면서 가능했던 것은 repostioryImpl class를 수정하지 않고 repostioryImpl2를 생성함으로써 
     * 다른 용도의 작업이 가능했다는 것
     *      개발자 입장에선 새로운 구현 클래스를 생성하고 @Repository 애터테이션을 변경함으로 새로운 작업을 진행가능하게 된다
     *      프레임워크 입장에선 똑같이 @Repository 애너테이션이 적용된 클래스에 객체를 사용하게끔 도와줌(service 구현체에 repositoryImpl or repositoryImpl2 구현체를 사용하게끔 해주는 것처럼)
     *              => 이 로직은 결국 의존성 주입을 이용한 방법이라는 것
     *
     * 인터페이스를 사용하며 class의 변화에 대해 보다 유연하게 대처가 가능하며 소프트웨어의 어려움(복잡성, 변경성)을 유리하게 가져갈 수 있다는 것
     */
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // @Service("customerService") 애너테이션이 적용된 CustomerServiceImpl class 객체 선언
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        // CustomerServiceImpl 내에 getCustomers() 메서드 호출
        List<Customer> customers = customerService.getCustomers();
            // customerServiceImpl 내부에서 CustomerRepositoryImpl 객체 생성

        for(Customer customer: customers)
            System.out.println(customer);

        System.out.println();
        System.out.println("============================================");

        Customer newCustomer = new Customer();
        newCustomer.setId(6);
        newCustomer.setName("김육");
        newCustomer.setAddress("제주시");
        newCustomer.setEmail("kim6@gmail.com");
        customerService.saveCustomer(newCustomer);
        Customer customer6 = customerService.getCustomer(6);
        System.out.println(customer6);

        System.out.println();
        System.out.println("============================================");

        customerService.deleteCustomer(1);
        List<Customer> customerList = customerService.getCustomers();
        for(Customer customer: customerList)
            System.out.println(customer);

    }
}
