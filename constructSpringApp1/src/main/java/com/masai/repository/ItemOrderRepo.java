package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.ItemOrder;

public interface ItemOrderRepo extends JpaRepository<ItemOrder, Integer> {
	
	public List<ItemOrder> findBySessionKey(String customerKey);
}
