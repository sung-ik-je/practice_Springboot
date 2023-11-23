package com.mycompany.ordersystem;

import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    // @Repository("customerRepository")가 선언되어 있는 CustomerRepositoryImpl or CustomerRepositoryImpl2 객체 생성
    public CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        Customer cust = getCustomer(id);
        if(cust != null){
            customerRepository.delete(id);
        }
    }
}
