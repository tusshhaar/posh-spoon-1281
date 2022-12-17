package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.ItemOrder;

public interface ItemOrderRepo extends JpaRepository<ItemOrder, Integer> {
	


}
