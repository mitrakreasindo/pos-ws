/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.sql.Timestamp;

import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategory;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	Report multiUserReport(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	ReportCategory reportByParentCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] multiUserByteReportPdf(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] singleUserByteReportPdfByParentCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
}
