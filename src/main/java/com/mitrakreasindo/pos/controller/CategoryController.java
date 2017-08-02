package com.mitrakreasindo.pos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.core.SimpleController;
import com.mitrakreasindo.pos.entities.Category;
import com.mitrakreasindo.pos.service.CategoryService;

@RestController
@RequestMapping(value = "/api/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController extends SimpleController<Category, Long, CategoryService>
{

}
