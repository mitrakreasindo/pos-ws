/**
 * 
 */
package com.mitrakreasindo.pos.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.entities.Merchant;
import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.entities.Product;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.Sale;
import com.mitrakreasindo.pos.entities.SalesItem;
import com.mitrakreasindo.pos.entities.SubProductReport;
import com.mitrakreasindo.pos.entities.SubReport;
import com.mitrakreasindo.pos.entities.Tax;
import com.mitrakreasindo.pos.entities.ViewSale;
import com.mitrakreasindo.pos.entities.ViewSalesItem;

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

	@Value(value = "classpath:report/report_single.odt")
	Resource templePath;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PeopleService peopleService;

	@Autowired
	private ProductService productService;

	@Autowired
	private SalesService salesService;

	
	@Autowired
	private SalesItemService salesItemService;
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private MerchantService merchantService;

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


	public Report multiUserReport(String merchantCode)
	{
		Report report = new Report();

		List<People> peoples = new ArrayList<>();
		List<SubReport> subReports = new ArrayList<>();

		// get all people doing transaction
		peoples = peopleService.findPeopleOnSales(merchantCode);
		for (People p : peoples)
		{

			List<Sale> sales = new ArrayList<>();
			List<SalesItem> saleItems = new ArrayList<>();
			List<SubProductReport> subProductReports = new ArrayList<>();

			// get sales by people id
			sales = salesService.findSalesByPeopleId(merchantCode, p.getId());
			System.out.println("all sales by people id " + p.getId() + " size = " + sales.size());

			for (Sale s : sales)
			{
				// get salesitem by sales id
				saleItems.addAll(salesItemService.findAllBySalesId(merchantCode, s.getId()));
				System.out.println("all saleitems by sale id " + s.getId() + " size = " + saleItems.size());
			}

			for (SalesItem s: saleItems)
			{
				Tax productTax = null;
				SubProductReport subProduct = null;
				Integer indexSubreport = null;
				
				Product product = productService.find(merchantCode, s.getProduct().getId());
				System.out.println("product name by salesitem "+s.getId()+" is "+product.getName());
				
				subProduct = findSubProductReportByProductName(subProductReports, product.getId());
				
				if (subProduct == null)
				{
					subProduct = new SubProductReport();
				}
				else
				{
					indexSubreport = subProductReports.indexOf(subProduct);
				}
				
				if (s.getTaxid().getId() != null)
				{
					productTax = taxService.find(merchantCode, s.getTaxid().getId());
				}
				
				
				double price = s.getPrice();
				double qty = s.getUnits() + subProduct.getQty();
				double subTotal = qty * price;
				double tax = ((s.getPrice() * productTax.getRate()) / 100) + subProduct.getTax() ;
				double discount = 0;
				
				double total = ( subTotal - tax - discount);

				subProduct.setProductId(product.getId());
				subProduct.setProductName(product.getName());
				subProduct.setQty(qty);
				subProduct.setPrice(price);
				subProduct.setSubTotal(subTotal);
				subProduct.setDisc(discount);
				subProduct.setTax(tax);
				subProduct.setTotal(total);
				
				if (indexSubreport != null)
				{
					subProductReports.set(indexSubreport, subProduct);
				}
				else 
				{
					subProductReports.add(subProduct);
				}				
			}
			
			double totalTax = 0;
			double totalTransaction = 0;
			
			for (SubProductReport s : subProductReports)
			{
				totalTax += s.getTax();
				totalTransaction += s.getTotal();
			}
			
			SubReport subReport = new SubReport();
			subReport.setPeopleName(p.getName());
			subReport.setSubProductReports(subProductReports);
			subReport.setTotaltax(totalTax);
			subReport.setTotalTransaction(totalTransaction);
			
			subReports.add(subReport);
		}

		double totalTax = 0;
		double totalTransaction = 0;
		
		for (SubReport s : subReports)
		{
			totalTax += s.getTotaltax();
			totalTransaction += s.getTotalTransaction();
		}
		
		Merchant merchant = merchantService.findByMerchantCode(merchantCode);
		
		report.setMerchantName(merchant.getName());
		report.setMerchantAddress(merchant.getAddress());
		report.setMerchantNpwp(merchant.getNpwpperusahaan());
		report.setSubReports(subReports);
		report.setTotalTax(totalTax);
		report.setTotalTransaction(totalTransaction);
		
		return report;
	}
	
	
	public Report multiUserReport(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{
		Report report = new Report();

		List<People> peoples = new ArrayList<>();
		List<SubReport> subReports = new ArrayList<>();

		// get all people doing transaction
		peoples = peopleService.findPeopleOnViewSales(merchantCode, fromDate, toDate);
		for (People p : peoples)
		{

			List<ViewSale> sales = new ArrayList<>();
			List<ViewSalesItem> saleItems = new ArrayList<>();
			List<SubProductReport> subProductReports = new ArrayList<>();

			// get sales by people id
			sales = viewSalesService.findAllByPeopleId(merchantCode, p.getId(), fromDate, toDate);
			System.out.println("all sales by people id " + p.getId() + " size = " + sales.size());

			for (ViewSale s : sales)
			{
				// get salesitem by sales id
				saleItems.addAll(viewSalesItemService.findAll(merchantCode, s.getId()));
				System.out.println("all saleitems by sale id " + s.getId() + " size = " + saleItems.size());
			}

			for (ViewSalesItem s: saleItems)
			{
				Tax productTax = null;
				SubProductReport subProduct = null;
				Integer indexSubreport = null;
				
//				Product product = productService.find(merchantCode, s.getProduct().getId());
//				System.out.println("product name by salesitem "+s.getId()+" is "+product.getName());
				
				subProduct = findSubProductReportByProductName(subProductReports, s.getProduct());
				
				if (subProduct == null)
				{
					subProduct = new SubProductReport();
				}
				else
				{
					indexSubreport = subProductReports.indexOf(subProduct);
				}
				
				if (s.getTaxid() != null || !s.getTaxid().equalsIgnoreCase(""))
				{
					productTax = taxService.find(merchantCode, s.getTaxid());
				}
				
				
				double price = s.getPrice();
				double qty = s.getUnits() + subProduct.getQty();
				double subTotal = qty * price;
				double tax = ((s.getPrice() * productTax.getRate()) / 100) + subProduct.getTax() ;
				double discount = 0;
				
				double total = ( subTotal - tax - discount);

				subProduct.setProductId(s.getProduct());
				subProduct.setProductName(s.getProductName());
				subProduct.setQty(qty);
				subProduct.setPrice(price);
				subProduct.setSubTotal(subTotal);
				subProduct.setDisc(discount);
				subProduct.setTax(tax);
				subProduct.setTotal(total);
				
				if (indexSubreport != null)
				{
					subProductReports.set(indexSubreport, subProduct);
				}
				else 
				{
					subProductReports.add(subProduct);
				}				
			}
			
			double totalTax = 0;
			double totalTransaction = 0;
			
			for (SubProductReport s : subProductReports)
			{
				totalTax += s.getTax();
				totalTransaction += s.getTotal();
			}
			
			SubReport subReport = new SubReport();
			subReport.setPeopleName(p.getName());
			subReport.setSubProductReports(subProductReports);
			subReport.setTotaltax(totalTax);
			subReport.setTotalTransaction(totalTransaction);
			
			subReports.add(subReport);
		}

		double totalTax = 0;
		double totalTransaction = 0;
		
		for (SubReport s : subReports)
		{
			totalTax += s.getTotaltax();
			totalTransaction += s.getTotalTransaction();
		}
		
		Merchant merchant = merchantService.findByMerchantCode(merchantCode);
		
		report.setMerchantName(merchant.getName());
		report.setMerchantAddress(merchant.getAddress());
		report.setMerchantNpwp(merchant.getNpwpperusahaan());
		report.setSubReports(subReports);
		report.setTotalTax(totalTax);
		report.setTotalTransaction(totalTransaction);
		
		return report;
	}
	
	
	
	private SubProductReport findSubProductReportByProductName(List<SubProductReport> subProductReports, String productId)
	{
		for(SubProductReport s : subProductReports)
		{
			if (s.getProductId().equals(productId))
			{
				return s;
			}
		}
		return null;
	}
	

}
