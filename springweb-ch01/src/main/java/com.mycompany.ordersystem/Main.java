package com.mycompany.ordersystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        List<Customer> customers = customerService.getCustomers();

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
