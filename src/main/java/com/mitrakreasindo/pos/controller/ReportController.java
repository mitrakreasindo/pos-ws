/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.service.ReportService;

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
	public Report getMultiUserReport(@PathVariable("merchantCode") String merchantCode, 
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		return reportService.multiUserReport(merchantCode, fromDate, toDate);
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
