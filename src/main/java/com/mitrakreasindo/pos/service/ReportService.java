/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;

import com.mitrakreasindo.pos.entities.ReportSalesSub;
import com.mitrakreasindo.pos.entities.ReportSubCategorySub;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategorySub;
import com.mitrakreasindo.pos.entities.ReportDate;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	Report<ReportSalesSub> reportSales(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	Report<ReportCategorySub> reportByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	ReportDate<ReportSubCategorySub> reportBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfSales(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] byteReportPdfBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
}
	