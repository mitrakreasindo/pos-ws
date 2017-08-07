/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.service.ReportService;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/reports")
public class ReportController
{

	@Autowired
	private ReportService reportService;
	
	
	@GetMapping(value = "/{merchantCode}/multi")
	public Report getMultiUserReport(@PathVariable("merchantCode") String merchantCode)
	{
		return reportService.multiUserReport(merchantCode);
	}
	
	
//	@GetMapping(value = "/single")
//	public void getSingleReport(HttpServletResponse response) throws IOException
//	{
//		
//		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//		reportService.generatePdf(response.getOutputStream());
//	}
//	
//	
//	@GetMapping(value = "/test")
//	public void getSingleReporTestt(HttpServletResponse response) throws IOException
//	{
//		reportService.generatePdftest();
//	}
//	
//	@GetMapping(value = "/testtest")
//	public String getSingleReporTesttt(ModelMap map) throws IOException
//	{
//		Report r = new Report();
//		r.setMerchantName("mitra");
//		r.setMerchantAddress("Jl. ballikpapan");
//		
//		map.addAttribute("report", r);
//		map.addAttribute(Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF));
//		
//		return "xdock";
//	}
	
}
