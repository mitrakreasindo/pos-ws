/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;

import com.mitrakreasindo.pos.entities.ReportSales;
import com.mitrakreasindo.pos.entities.ReportSubCategorySub;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategory;
import com.mitrakreasindo.pos.entities.ReportDate;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	ReportSales reportSales(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	ReportCategory reportByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	ReportDate<ReportSubCategorySub> reportBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfSales(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
}
	