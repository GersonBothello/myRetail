package com.myretail.service.product.controller.v1.api;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.service.product.dto.model.ProductDto;
import com.myretail.service.product.service.ProductPriceService;
import com.myretail.service.product.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * The product service exposed CRUD methods to read and modify product data.
 *  * 
 * @author gersonbothello
 *
 */
@RestController
@RequestMapping("/v1")
@Api(value = "Product", tags = { "Product" })
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductPriceService productPriceService;

	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	/**
	 * * Handles the incoming Get request."
	 *
	 * @param the product ID for which you want to retrieve data.
	 * @return the product object populated with the data.
	 */
	@GetMapping("/products/{id}")
	@ApiOperation(value= "Find Product by Id.", notes="Provide an ID to look up specific products.", response=ProductDto.class)
	public ProductDto getItem(@PathVariable 
							  @Max(value = 999999999, 
							  message = "Product Id must be less than 9 digits") int id) {

		logger.debug("Method Name: 'Get Item' | Param (ID): {}",id);
		
		return productService.withPrice().findAndBuildById(id);
	}

	
	
	/**
	 * * Handles the incoming PUT for product "/v1/product/".
	 * Modifies only the pricing information. 
	 *
	 * @param prioduct Id for which you want to change the price 
	 */
	@PutMapping("/products/{id}")
	@ApiOperation(value= "Modify the product pricing", notes="Update the pricing information for a specific products.", response=ProductDto.class)
	public void updatePrice(@Valid @RequestBody ProductDto product) {

		logger.debug("Method Name: 'Update Price' | Parm (product): {}", product);
				
		productPriceService.update(product.getCurrentPrice());
	}

}
