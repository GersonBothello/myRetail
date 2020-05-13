package com.myretail.service.product.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetailsDto {
	
	@JsonProperty("item")
	private ItemDto item;

		
	public ProductDetailsDto() {
		super();
	}
	
	public ProductDetailsDto(ItemDto item) {
		super();
		this.item = item;
	}

	public ItemDto getItem() {
		return item;
	}

	public void setItem(ItemDto item) {
		this.item = item;
	}
	
	
}
