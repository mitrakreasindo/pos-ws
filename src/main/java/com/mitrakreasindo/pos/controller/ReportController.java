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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitrakreasindo.pos.entities.ReportSalesSub;
import com.mitrakreasindo.pos.entities.ReportSubCategorySub;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategorySub;
import com.mitrakreasindo.pos.entities.ReportDate;
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
	
	
	@GetMapping(value = "/sales")
	public Report<ReportSalesSub> getMultiUserReportSales(@RequestHeader("merchantCode") String merchantCode, 
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		return reportService.reportSales(merchantCode, fromDate, toDate);
	}
	
	@GetMapping(value = "/category")
	public Report<ReportCategorySub> reportByCategory(@RequestHeader("merchantCode") String merchantCode, 
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		return reportService.reportByCategory(merchantCode, fromDate, toDate);
	}
	
	@GetMapping(value = "/subcategory")
	public ReportDate<ReportSubCategorySub> reportBySubCategory(@RequestHeader("merchantCode") String merchantCode, 
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		return reportService.reportBySubCategory(merchantCode, fromDate, toDate);
	}
	
	
	
	
	
	@GetMapping(value = "/sales/{documentType}")
	public byte[] getMultiUserReportSalesByte(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			return reportService.byteReportPdfSales(merchantCode, fromDate, toDate);
		}
		
		return null;
	}
	
	@GetMapping(value = "/category/{documentType}")
	public byte[] getSingleUserReportByCategoryByte(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			return reportService.byteReportPdfByCategory(merchantCode, fromDate, toDate);
		}
		
		return null;
	}
	
	@GetMapping(value = "/subcategory/{documentType}")
	public byte[] getSingleUserReportBySubCategoryByte(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			return reportService.byteReportPdfBySubCategory(merchantCode, fromDate, toDate);
		}
		
		return null;
	}
	
	
	
	
	
	@GetMapping(value = "/sales/download/{documentType}")
	public void getMultiUserReportSalesExportDownload(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate, HttpServletResponse response)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			response.setHeader("Content-disposition", "attachment;filename=report "+merchantCode+".pdf");
			
			InputStream in = new ByteArrayInputStream(reportService.byteReportPdfSales(merchantCode, fromDate, toDate));
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
	
	@GetMapping(value = "/category/download/{documentType}")
	public void getSingleUserReportCategoryExportDownload(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate, HttpServletResponse response)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			response.setHeader("Content-disposition", "attachment;filename=report "+merchantCode+".pdf");
			
			InputStream in = new ByteArrayInputStream(reportService.byteReportPdfByCategory(merchantCode, fromDate, toDate));
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
	
	@GetMapping(value = "/subcategory/download/{documentType}")
	public void getSingleUserReportSubCategoryExportDownload(@RequestHeader("merchantCode") String merchantCode,
			@PathVariable("documentType") String documentType,
			@RequestParam("fromDate")  Timestamp fromDate, 
			@RequestParam("toDate") Timestamp toDate, HttpServletResponse response)
	{
		if (documentType.equalsIgnoreCase("pdf")) 
		{		
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			response.setHeader("Content-disposition", "attachment;filename=report "+merchantCode+".pdf");
			
			InputStream in = new ByteArrayInputStream(reportService.byteReportPdfBySubCategory(merchantCode, fromDate, toDate));
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
