package com.myretail.service.product.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDescriptionDto {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("downstream_description")
	private String description;
	
	
	public ProductDescriptionDto() {
		super();
		
	}

	public ProductDescriptionDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
