/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.OutputStream;

/**
 * @author miftakhul
 *
 */
public interface ReportService
{
	
	public OutputStream generatePdf();
	
	public void generatePdftest();
	
	public OutputStream generatePdf(OutputStream output);
	
}
