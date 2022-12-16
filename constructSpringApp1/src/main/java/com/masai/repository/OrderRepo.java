package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
