/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.OutputStream;

import com.mitrakreasindo.pos.entities.Report;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	Report multiUserReport(String merchantCode);
	
	public OutputStream generatePdf();
	
	public void generatePdftest();
	
	public OutputStream generatePdf(OutputStream output);
	
}
