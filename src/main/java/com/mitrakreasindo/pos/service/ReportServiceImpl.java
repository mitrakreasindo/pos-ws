/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mitrakreasindo.pos.entities.Merchant;
import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.SubProductReport;
import com.mitrakreasindo.pos.entities.SubReport;
import com.mitrakreasindo.pos.entities.Tax;
import com.mitrakreasindo.pos.entities.ViewSale;
import com.mitrakreasindo.pos.entities.ViewSalesItem;
import com.mitrakreasindo.pos.util.GeneralFunction;


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
	private TaxService taxService;

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private ViewSalesService viewSalesService;

	@Autowired
	private ViewSalesItemService viewSalesItemService;

	public Report multiUserReport(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{
		Report report = new Report();

		List<Timestamp> listTime = rangeDate(fromDate, toDate);
		List<String> peoplesId = new ArrayList<>();
		List<SubReport> subReports = new ArrayList<>();

		for (Timestamp time: listTime)
		{
						
		// get all people doing transaction
			peoplesId = peopleService.findPeopleIdOnViewSales(merchantCode, getFromDate(time), getToDate(time));
			for (String peopleId : peoplesId)
			{

				List<ViewSale> sales = new ArrayList<>();
				List<ViewSalesItem> saleItems = new ArrayList<>();
				List<SubProductReport> subProductReports = new ArrayList<>();

				// get sales by people id
				sales = viewSalesService.findAllByPeopleId(merchantCode, peopleId, getFromDate(time), getToDate(time));

				for (ViewSale s : sales)
				{
					// get salesitem by sales id
					saleItems.addAll(viewSalesItemService.findAll(merchantCode, s.getId()));
				}

				for (ViewSalesItem s : saleItems)
				{
					Tax productTax = null;
					SubProductReport subProduct = null;
					Integer indexSubreport = null;

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
					double tax = ((s.getPrice() * productTax.getRate()) / 100) + subProduct.getTax();
					double discount = 0;

					double total = (subTotal - tax - discount);

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
					} else
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

				People people = peopleService.find(merchantCode, peopleId);
				
				SubReport subReport = new SubReport();
				subReport.setPeopleName(people.getName());
				subReport.setDate(new Date(time.getTime()));
				subReport.setSubProductReports(subProductReports);
				subReport.setTotaltax(totalTax);
				subReport.setTotalTransaction(totalTransaction);

				subReports.add(subReport);
			}
			
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

	public void multiUserReportPdf(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{

		Report report = multiUserReport(merchantCode, fromDate, toDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols decimalFormatSymbol = new DecimalFormatSymbols();
		
		decimalFormatSymbol.setCurrencySymbol("Rp. ");
		decimalFormatSymbol.setMonetaryDecimalSeparator(',');
		decimalFormatSymbol.setGroupingSeparator('.');
		
		decimalFormat.setDecimalFormatSymbols(decimalFormatSymbol);
		
		Document document = new Document(PageSize.A4);
		try
		{
			PdfWriter.getInstance(document, new FileOutputStream(new File("/home/miftakhul/testpdf.pdf")));
			document.open();

			Font titleFont = FontFactory.getFont("Times roman", 12, BaseColor.BLACK);
			Font title1Font = FontFactory.getFont("Times roman", 10, BaseColor.GRAY);
			Font colFont = FontFactory.getFont("Times roman", 6, BaseColor.BLACK);
			Font simpleFont = FontFactory.getFont("Times roman", 6, BaseColor.BLACK);

			Paragraph title = new Paragraph();
			title.setFont(titleFont);
			title.add(
					GeneralFunction.checkNullString(report.getMerchantName()) + "\n" + 
					GeneralFunction.checkNullString(report.getMerchantAddress()) + "\n" + 
					"NPWP. "+new String(GeneralFunction.checkNullString(report.getMerchantNpwp()).equalsIgnoreCase("") ? "---":report.getMerchantNpwp()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			

			Paragraph date = new Paragraph();
			date.setFont(title1Font);
			date.add(dateFormat.format(fromDate) + " - " + dateFormat.format(toDate));
			date.setAlignment(Element.ALIGN_CENTER);
			date.setSpacingAfter(10);
			document.add(date);

			PdfPTable table;			
			for (SubReport s : report.getSubReports())
			{
				Paragraph userInfo = new Paragraph();
				userInfo.setFont(simpleFont);
				userInfo.add("Sales : "+s.getPeopleName()+"\n"
						+ dateFormat.format(s.getDate()));
				userInfo.setAlignment(Element.ALIGN_RIGHT);
				userInfo.setSpacingAfter(5);
				userInfo.setLeading(10);
				document.add(userInfo);
				
				table = new PdfPTable(7);
				table.setWidthPercentage(100);
				table.addCell(pdfCell("PROD.DESCRIPTION", colFont));
				table.addCell(pdfCell("QTY", colFont));
				table.addCell(pdfCell("PRICE", colFont));
				table.addCell(pdfCell("SUB-TTL", colFont));
				table.addCell(pdfCell("DISC. %", colFont));
				table.addCell(pdfCell("TAX", colFont));
				table.addCell(pdfCell("TOTAL", colFont));
				for (SubProductReport p : s.getSubProductReports())
				{
					table.addCell(new Phrase(p.getProductName(), colFont));
					table.addCell(new Phrase(String.valueOf(p.getQty()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getPrice()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getSubTotal()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getDisc()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getTax()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getTotal()), colFont));
				}

				document.add(table);
				
				Paragraph subTotal = new Paragraph();
				subTotal.setFont(simpleFont);
				subTotal.add("Total "+s.getPeopleName()+"\nTax : "+s.getTotaltax()+" Total : "+decimalFormat.format(s.getTotalTransaction()));
				subTotal.setSpacingAfter(20);
				subTotal.setLeading(10);
				subTotal.setAlignment(Element.ALIGN_RIGHT);
				document.add(subTotal);
				
			}
			
			Paragraph allTotal = new Paragraph();
			allTotal.setFont(simpleFont);
			allTotal.add("Total Sales\nTax : "+report.getTotalTax()+" Total : "+decimalFormat.format(report.getTotalTransaction()));
			allTotal.setSpacingBefore(20);
			allTotal.setLeading(10);
			allTotal.setAlignment(Element.ALIGN_RIGHT);
			document.add(allTotal);

			document.close();

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public byte[] multiUserByteReportPdf(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		Report report = multiUserReport(merchantCode, fromDate, toDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols decimalFormatSymbol = new DecimalFormatSymbols();
		
		decimalFormatSymbol.setCurrencySymbol("Rp. ");
		decimalFormatSymbol.setMonetaryDecimalSeparator(',');
		decimalFormatSymbol.setGroupingSeparator('.');
		
		decimalFormat.setDecimalFormatSymbols(decimalFormatSymbol);
		
		Document document = new Document(PageSize.A4);
		try
		{
			PdfWriter.getInstance(document, output);
			document.open();

			Font titleFont = FontFactory.getFont("Times roman", 12, BaseColor.BLACK);
			Font title1Font = FontFactory.getFont("Times roman", 10, BaseColor.GRAY);
			Font colFont = FontFactory.getFont("Times roman", 6, BaseColor.BLACK);
			Font simpleFont = FontFactory.getFont("Times roman", 6, BaseColor.BLACK);

			Paragraph title = new Paragraph();
			title.setFont(titleFont);
			title.add(
					GeneralFunction.checkNullString(report.getMerchantName()) + "\n" + 
					GeneralFunction.checkNullString(report.getMerchantAddress()) + "\n" + 
					"NPWP. "+new String(GeneralFunction.checkNullString(report.getMerchantNpwp()).equalsIgnoreCase("") ? "---":report.getMerchantNpwp()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			

			Paragraph date = new Paragraph();
			date.setFont(title1Font);
			date.add(dateFormat.format(fromDate) + " - " + dateFormat.format(toDate));
			date.setAlignment(Element.ALIGN_CENTER);
			date.setSpacingAfter(10);
			document.add(date);

			PdfPTable table;			
			for (SubReport s : report.getSubReports())
			{
				Paragraph userInfo = new Paragraph();
				userInfo.setFont(simpleFont);
				userInfo.add("Sales : "+s.getPeopleName()+"\n"
						+ dateFormat.format(s.getDate()));
				userInfo.setAlignment(Element.ALIGN_RIGHT);
				userInfo.setSpacingAfter(5);
				userInfo.setLeading(10);
				document.add(userInfo);
				
				table = new PdfPTable(7);
				table.setWidthPercentage(100);
				table.addCell(pdfCell("PROD.DESCRIPTION", colFont));
				table.addCell(pdfCell("QTY", colFont));
				table.addCell(pdfCell("PRICE", colFont));
				table.addCell(pdfCell("SUB-TTL", colFont));
				table.addCell(pdfCell("DISC. %", colFont));
				table.addCell(pdfCell("TAX", colFont));
				table.addCell(pdfCell("TOTAL", colFont));
				for (SubProductReport p : s.getSubProductReports())
				{
					table.addCell(new Phrase(p.getProductName(), colFont));
					table.addCell(new Phrase(String.valueOf(p.getQty()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getPrice()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getSubTotal()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getDisc()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getTax()), colFont));
					table.addCell(new Phrase(decimalFormat.format(p.getTotal()), colFont));
				}

				document.add(table);
				
				Paragraph subTotal = new Paragraph();
				subTotal.setFont(simpleFont);
				subTotal.add("Total "+s.getPeopleName()+"\nTax : "+s.getTotaltax()+" Total : "+decimalFormat.format(s.getTotalTransaction()));
				subTotal.setSpacingAfter(20);
				subTotal.setLeading(10);
				subTotal.setAlignment(Element.ALIGN_RIGHT);
				document.add(subTotal);
				
			}
			
			Paragraph allTotal = new Paragraph();
			allTotal.setFont(simpleFont);
			allTotal.add("Total Sales\nTax : "+report.getTotalTax()+" Total : "+decimalFormat.format(report.getTotalTransaction()));
			allTotal.setSpacingBefore(20);
			allTotal.setLeading(10);
			allTotal.setAlignment(Element.ALIGN_RIGHT);
			document.add(allTotal);

			document.close();

			return output.toByteArray();
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


	private PdfPCell pdfCell(String content, Font font)
	{
		PdfPCell pdfPCell = new PdfPCell(new Phrase(content, font));
		pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
		return pdfPCell;
	}
	
	private SubProductReport findSubProductReportByProductName(List<SubProductReport> subProductReports, String productId)
	{
		for (SubProductReport s : subProductReports)
		{
			if (s.getProductId().equals(productId))
			{
				return s;
			}
		}
		return null;
	}
	
	private List<Timestamp> rangeDate(Timestamp fromDate, Timestamp toDate)
	{
		List<Timestamp> times = new ArrayList<Timestamp>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		
		while (calendar.getTime().before(toDate) || calendar.getTime().equals(toDate))
		{
			times.add(new Timestamp(calendar.getTimeInMillis()));
			calendar.add(Calendar.DATE, 1);
		}
		
		return times;
	}
	
	private Timestamp getFromDate(Timestamp fromDate)
	{
		return fromDate;
	}
	
	private Timestamp getToDate(Timestamp toDate)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		cal.add(Calendar.DATE, 1);
		
		return new Timestamp(cal.getTimeInMillis());
	}

}
