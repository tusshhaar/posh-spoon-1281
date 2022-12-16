package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.OrderTable;

public interface OrderRepo extends JpaRepository<OrderTable, Integer> {

}
