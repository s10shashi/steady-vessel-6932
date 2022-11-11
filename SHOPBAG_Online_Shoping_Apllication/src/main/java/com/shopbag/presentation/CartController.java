package com.shopbag.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopbag.exception.CartException;
import com.shopbag.model.Cart;
import com.shopbag.model.Product;
import com.shopbag.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addProductToCart")
	public ResponseEntity<Cart> addProductToCart(@Valid @RequestBody Cart cart, @Valid @RequestBody Product product, @RequestParam Integer quantity) throws CartException {
		
		Cart nCart = cartService.addProductToCart(cart, product, quantity);
		
		return new ResponseEntity<Cart>(nCart, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/removeProductFromCart")
	public ResponseEntity<Cart> removeProductFromCart(@Valid @RequestBody Cart cart, @Valid @RequestBody Product product) throws CartException {
		
		Cart nCart = cartService.removeProductFromCart(cart, product);
		
		return new ResponseEntity<Cart>(nCart, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateProductQuantity")
	public ResponseEntity<Cart> updateProductQuantity(@Valid @RequestBody Cart cart, @Valid @RequestBody Product product, @RequestParam Integer quantity) throws CartException{
		
		Cart nCart = cartService.updateProductQuantity(cart, product, quantity);
		
		return new ResponseEntity<Cart>(nCart, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/removeAllProducts")
	public ResponseEntity<Cart> removeAllProducts(@Valid @RequestBody Cart cart) throws CartException {
		
		Cart nCart = cartService.removeAllProducts(cart);
		
		return new ResponseEntity<Cart>(nCart, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<Cart> viewAllProducts(@Valid @RequestBody Cart cart) throws CartException {
		
		Cart nCart = cartService.viewAllProducts(cart);
		
		return new ResponseEntity<Cart>(nCart, HttpStatus.OK);
		
	}	
	
}
