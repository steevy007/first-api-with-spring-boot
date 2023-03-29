package com.steevelinformaticien.com.Springbootyoutube.controller;

import com.steevelinformaticien.com.Springbootyoutube.bean.Customer;
import com.steevelinformaticien.com.Springbootyoutube.repository.CustomerRepository;
import com.steevelinformaticien.com.Springbootyoutube.request.NewCustomerRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomer( ){
        return customerRepository.findAll();
    }

    @PostMapping
    public void saveCustomer(@RequestBody NewCustomerRequest request){
        Customer customer=new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());

        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@RequestBody NewCustomerRequest request , @PathVariable("customerId") Integer id){
        Customer customer=customerRepository.findById(id).get();
        customer.setAge(request.getAge());
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        customerRepository.save(customer);
    }
}
