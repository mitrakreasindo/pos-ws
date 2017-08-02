/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.core.SimpleController;
import com.mitrakreasindo.pos.entities.Product;
import com.mitrakreasindo.pos.service.ProductService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends SimpleController<Product, Long, ProductService>
{

}
