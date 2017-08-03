/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.service.ReportService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/report")
public class ReportController
{

	@Autowired
	private ReportService reportService;
	
	@GetMapping(value = "/single")
	public @ResponseBody OutputStream getSingleReport()
	{
		return reportService.generatePdf();
	}
	
}
