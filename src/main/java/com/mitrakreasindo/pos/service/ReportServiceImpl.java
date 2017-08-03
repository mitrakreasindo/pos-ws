/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

/**
 * @author miftakhul
 *
 */
@Service
public class ReportServiceImpl implements ReportService
{

	@Value(value = "classpath:/report/report_single.odt")
	Resource templePath;
	
	public OutputStream generatePdf()
	{
		try
		{
			InputStream in = templePath.getInputStream();
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
			
			IContext contect = report.createContext();
			contect.put("merchantName", "Mitra");
			contect.put("merchantAddress", "Jl. balikpapan");
			
			OutputStream out = new FileOutputStream(new File("report.pdf"));
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			
			report.convert(contect, options, out);
			
			return out;
		} catch (IOException | XDocReportException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
