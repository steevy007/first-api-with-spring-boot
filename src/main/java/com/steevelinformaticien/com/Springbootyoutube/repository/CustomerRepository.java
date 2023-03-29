package com.steevelinformaticien.com.Springbootyoutube.repository;

import com.steevelinformaticien.com.Springbootyoutube.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
