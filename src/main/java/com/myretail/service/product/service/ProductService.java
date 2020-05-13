package com.myretail.service.product.service;

import com.myretail.service.product.dto.model.*;


/**
 * This is an interface for the Product. 
 * It follows a builder pattern to build the product response.  
 *    
 * @author Gerson Bothello
 *
 */
public interface ProductService {
		
	/**
	 * This method is used as a flag to Include the Price in the response  
	 * 
	 * @return the interface to set the flag. 
	 */
	ProductService withPrice();
	
	
	/**
	 * Get the product information and build the response. 
	 * 
	 * @param The product ID of the product you want to retrieve data for. 
	 * @return The Product object populated with the data.
	 */
	ProductDto findAndBuildById(int productId);
}
