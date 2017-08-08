/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.OutputStream;
import java.sql.Timestamp;

import com.mitrakreasindo.pos.entities.Report;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	Report multiUserReport(String merchantCode);
	
	Report multiUserReport(String merchantCode, Timestamp startDate, Timestamp untilDate);
	
	public OutputStream generatePdf();
	
	public void generatePdftest();
	
	public OutputStream generatePdf(OutputStream output);
	
}
