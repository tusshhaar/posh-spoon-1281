package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cart {
	
	private List<ItemOrder> list = new ArrayList<>();
	
}
