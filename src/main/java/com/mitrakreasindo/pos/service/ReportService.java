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
	
	ReportCategory reportByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] multiUserByteReportPdf(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
	public byte[] singleUserByteReportPdfByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate);
	
}
