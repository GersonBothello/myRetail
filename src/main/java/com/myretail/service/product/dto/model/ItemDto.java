package com.myretail.service.product.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ItemDto {
	
	@JsonProperty("tcin")
	private String tcin;
	
	@JsonProperty("product_description")
	private ProductDescriptionDto description;
	
	
	public ItemDto() {
		super();
	}

	public ItemDto(String tcin, ProductDescriptionDto description) {
		super();
		this.tcin = tcin;
		this.description = description;
	}

	public String getTcin() {
		return tcin;
	}

	public void setTcin(String tcin) {
		this.tcin = tcin;
	}

	public ProductDescriptionDto getDescription() {
		return description;
	}

	public void setDescription(ProductDescriptionDto description) {
		this.description = description;
	}
	
	
	

}
