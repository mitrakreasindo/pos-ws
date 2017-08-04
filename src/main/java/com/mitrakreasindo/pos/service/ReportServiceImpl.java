/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.SalesItem;
import com.mitrakreasindo.pos.entities.ViewSale;

import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.DocumentKind;
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

	@Value(value = "classpath:report/report_single.odt")
	Resource templePath;
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SalesService salesService;
	
	@Autowired
	private ViewSalesService viewSalesService;
	
	@Autowired
	private ViewSalesItemService viewSalesItemService;

	public OutputStream generatePdf()
	{
		try
		{
			InputStream in = templePath.getInputStream();
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			IContext contect = report.createContext();
			contect.put("merchantName", "Mitra");
			contect.put("merchantAddress", "Jl. balikpapan");

			OutputStream out = new FileOutputStream(new File("/home/miftakhul/report.pdf"));

			report.process(contect, out);

			return out;
		} catch (IOException | XDocReportException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void generatePdftest()
	{
		Report r = new Report();
		r.setMerchantName("Mitra");
		r.setMerchantAddress("Jl. balik papan");

		try
		{
			InputStream in = templePath.getInputStream();
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			IContext contect = report.createContext();
			contect.put("report", r);

			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);

			OutputStream out = new FileOutputStream(new File("/home/miftakhul/report.pdf"));

			// report.process(contect, out);
			report.convert(contect, options, out);

			out.close();

		} catch (IOException | XDocReportException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OutputStream generatePdf(OutputStream output)
	{
		try
		{
			InputStream in = templePath.getInputStream();
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

			IContext contect = report.createContext();
			contect.put("merchantName", "Mitra");
			contect.put("merchantAddress", "Jl. balikpapan");

			report.process(contect, output);

			return output;
		} catch (IOException | XDocReportException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Report singleReport(String merchantCode) {
		Report report = new Report();
		
		List<People> peoples = new ArrayList<>();
		List<ViewSale> viewSales = new ArrayList<>();
		
		peoples = peopleService.findAll(merchantCode);
		
		
		
		return report;
	}

}
