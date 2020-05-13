package com.myretail.service.product.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.service.exception.MyRetailExceptionHandler;
import com.myretail.service.product.controller.v1.api.ProductProxyController;
import com.myretail.service.product.dto.model.ItemDto;
import com.myretail.service.product.dto.model.ProductDescriptionDto;
import com.myretail.service.product.dto.model.ProductDetailsDto;
import com.myretail.service.product.dto.model.ProductDto;
import com.myretail.service.product.dto.model.ProductProxyDto;

import feign.FeignException;

/**
 * This method implements the product service interface.
 * 
 * @author Gerson Bothello
 *
 */

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired	
	private ProductPriceService productPriceService;
	  
	@Autowired
	private ProductProxyController proxy;
	
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private int id;
	private boolean includePrice; 
	
	/**
	 *Include the Price Info in the response
	 */
	@Override
	public ProductService withPrice() {
		this.includePrice = true;
		return this;
	}

	
	/**
	 * Gets and sets the the pricing information.
	 *    
	 * @param The product object which is populated with the product data 
	 */
	private void getProductPrice(ProductDto product)
	{
		logger.debug("Method Name: 'getProductPrice' | Parm (product): {}", product);
		
		product.setCurrentPrice(productPriceService.findById(id));
	}
	
	
	/**
	 * Get the product name for the product from a service.
	 * 
	 * @param The product object which is populated with the product data
	 */
	private void getProductName(ProductDto product)
	{
		
		logger.debug("Method Name: 'getProductName' | Parm (product): {}", product);
		
		try
		{
		  ProductProxyDto productProxy =  proxy.retrieveProduct(product.getProductId());
		  Optional<ProductDetailsDto>  optProductDetails = Optional.ofNullable(productProxy.getProduct()); 

		  if (optProductDetails.isPresent())
		  {
			  Optional<ItemDto> optItem =  Optional.ofNullable(optProductDetails.get().getItem());
			  
			  if (optItem.isPresent())
				{
				  Optional<ProductDescriptionDto> optProductDescription = Optional.ofNullable(optItem.get().getDescription());
				  
				  if (optProductDescription.isPresent()) 
				  {
					  Optional<String> optProductName = Optional.ofNullable(optProductDescription.get().getTitle());
					  
					  if (optProductName.isPresent())
					  {
						  String productName =  optProductName.get();
						  productName = org.springframework.web.util.HtmlUtils.htmlUnescape(productName);
						  product.setProductName(productName);
					  }
				  }
				}
		  }
		}
		catch (FeignException ex) {
			logger.error(ex.getMessage());
			throw new  MyRetailExceptionHandler.ProductNotFoundException(product.getProductId());
        }
	}

			
	/**
	 * Get Product Info for the product Id
	 * 
	 * @param The product ID of the product you want to retrieve data for. 
	 * @return The Product object populated with the data. 
	 */
	@Override
	public ProductDto findAndBuildById(int productId) {
		
		logger.debug("Method Name: 'findAndBuildById' | Parm (productId): {}", productId);
		
		this.id = productId;
		return build();
	}
	
	
	/**
	 * Builds the product response.
	 * 
	 *  @return The Product object populated with the data. 
	 */
	private ProductDto build() {
		
		logger.debug("Method Name: 'build'");
		
		ProductDto product = new ProductDto();
		
		product.setProductId(id);
		getProductName(product);
			
		if (product.getProductName() == null)
		{
			throw new MyRetailExceptionHandler.ProductNotFoundException(id);
		}
		
		if (this.includePrice)
		{
			getProductPrice(product);
		}
		
		return product;
	}
	
	

}
