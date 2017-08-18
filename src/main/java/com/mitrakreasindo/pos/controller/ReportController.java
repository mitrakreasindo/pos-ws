/**
 * 
 */
package com.mitrakreasindo.pos.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategory;
import com.mitrakreasindo.pos.service.ReportService;

/**
 * @author miftakhul
 *
 */
@RestController
@RequestMapping(value = "/api/reports", produces = MediaType.APPLICATION_JSON_VALUE)
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
	
	@GetMapping(value = "/{merchantCode}/category")
	public ReportCategory reportByCategory(@PathVariable("merchantCode") String merchantCode, 
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		return reportService.reportByParentCategory(merchantCode, fromDate, toDate);
	}
	
	
	@GetMapping(value = "/{merchantCode}/multi/{documentType}")
	public byte[] getMultiUserReportByte(@PathVariable("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			return reportService.multiUserByteReportPdf(merchantCode, fromDate, toDate);
		}
		
		return null;
	}
	
	@GetMapping(value = "/{merchantCode}/single/{documentType}/category")
	public byte[] getSingleUserReportByCategoryByte(@PathVariable("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			return reportService.singleUserByteReportPdfByParentCategory(merchantCode, fromDate, toDate);
		}
		
		return null;
	}
	
	@GetMapping(value = "/{merchantCode}/multi/download/{documentType}")
	public void getMultiUserReportExportDownload(@PathVariable("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate, HttpServletResponse response)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			response.setHeader("Content-disposition", "attachment;filename=report "+merchantCode+".pdf");
			
			InputStream in = new ByteArrayInputStream(reportService.multiUserByteReportPdf(merchantCode, fromDate, toDate));
			try
			{
				IOUtils.copy(in, response.getOutputStream());
				response.flushBuffer();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	@GetMapping(value = "/{merchantCode}/single/download/{documentType}/category")
	public void getSingleUserReportExportDownload(@PathVariable("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate, HttpServletResponse response)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			response.setHeader("Content-disposition", "attachment;filename=report "+merchantCode+".pdf");
			
			InputStream in = new ByteArrayInputStream(reportService.singleUserByteReportPdfByParentCategory(merchantCode, fromDate, toDate));
			try
			{
				IOUtils.copy(in, response.getOutputStream());
				response.flushBuffer();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
}
