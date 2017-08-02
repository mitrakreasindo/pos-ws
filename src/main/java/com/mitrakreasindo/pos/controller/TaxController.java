/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.core.SimpleController;
import com.mitrakreasindo.pos.entities.Tax;
import com.mitrakreasindo.pos.service.TaxService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/taxes", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaxController extends SimpleController<Tax, Long, TaxService>
{

}
