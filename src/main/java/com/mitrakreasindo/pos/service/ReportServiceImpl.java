/**
 * 
 */
package com.mitrakreasindo.pos.service;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mitrakreasindo.pos.entities.Category;
import com.mitrakreasindo.pos.entities.Merchant;
import com.mitrakreasindo.pos.entities.People;
import com.mitrakreasindo.pos.entities.Report;
import com.mitrakreasindo.pos.entities.ReportCategorySubItem;
import com.mitrakreasindo.pos.entities.ReportDate;
import com.mitrakreasindo.pos.entities.ReportSalesSubItem;
import com.mitrakreasindo.pos.entities.ReportSubCategorySub;
import com.mitrakreasindo.pos.entities.ReportSubCategorySubItem;
import com.mitrakreasindo.pos.entities.ReportSubDate;
import com.mitrakreasindo.pos.entities.ReportSalesSub;
import com.mitrakreasindo.pos.entities.ReportCategorySub;
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

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CategoryService categoryService;

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

	public Report<ReportSalesSub> reportSales(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{
		Report<ReportSalesSub> report = new Report<>();
		List<Timestamp> listTime = rangeDate(fromDate, toDate);
		List<String> peoplesId = new ArrayList<>();
		List<ReportSalesSub> subReports = new ArrayList<>();
		for (Timestamp time : listTime)
		{
			peoplesId = peopleService.findPeopleIdOnViewSales(getFromDate(time), getToDate(time));
			for (String peopleId : peoplesId)
			{
				List<ViewSale> sales = new ArrayList<>();
				List<ViewSalesItem> saleItems = new ArrayList<>();
				List<ReportSalesSubItem> subProductReports = new ArrayList<>();
				sales = viewSalesService.findAllByPeopleId(peopleId, getFromDate(time), getToDate(time));
				for (ViewSale s : sales)
				{
					saleItems.addAll(viewSalesItemService.findAll(s.getId()));
				}
				for (ViewSalesItem s : saleItems)
				{
					Tax productTax = null;
					ReportSalesSubItem subProduct = null;
					Integer indexSubreport = null;
					subProduct = findReportSalesReportItemByProductName(subProductReports, s.getProduct());
					if (subProduct == null)
					{
						subProduct = new ReportSalesSubItem();
					} else
					{
						indexSubreport = subProductReports.indexOf(subProduct);
					}

					if (s.getTaxid() != null || !s.getTaxid().equalsIgnoreCase(""))
					{
						productTax = taxService.find(s.getTaxid());
					}

					double price = s.getPrice();
					double qty = s.getUnits() + subProduct.getQty();
					double subTotal = qty * price;
					double tax = (((s.getPrice() * productTax.getRate()) / 100) * s.getUnits()) + subProduct.getTax();
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
				for (ReportSalesSubItem s : subProductReports)
				{
					totalTax += s.getTax();
					totalTransaction += s.getTotal();
				}
				
				People people = peopleService.find(peopleId);
				ReportSalesSub subReport = new ReportSalesSub();
				subReport.setPeopleName(people.getName());
				subReport.setDate(new Date(time.getTime()));
				subReport.setSubItems(subProductReports);
				subReport.setTotaltax(totalTax);
				subReport.setTotalTransaction(totalTransaction);
				subReports.add(subReport);
			}
		}

		double totalTax = 0;
		double totalTransaction = 0;
		for (ReportSalesSub s : subReports)
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

	public Report<ReportCategorySub> reportByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{
		Report<ReportCategorySub> report = new Report<>();
		List<Timestamp> listTime = rangeDate(fromDate, toDate);
		List<Category> categories = new ArrayList<>();
		List<ReportCategorySub> subReports = new ArrayList<>();
		for (Timestamp time : listTime)
		{
			List<ReportCategorySubItem> subCategoryReports = new ArrayList<>();
			categories = categoryService.findCategoriesFromSalesItem(getFromDate(time), getToDate(time));
			for (Category category : categories)
			{
				List<ViewSalesItem> saleItems = new ArrayList<>();
				saleItems = viewSalesItemService.findAllByCategoryId(category.getId(), getFromDate(time), getToDate(time));
				for (ViewSalesItem s : saleItems)
				{
					Tax productTax = null;
					ReportCategorySubItem subCategory = null;
					Integer indexSubreport = null;
					subCategory = findReportCategoryReportItemByCategoryId(subCategoryReports, category.getId());

					if (subCategory == null)
					{
						subCategory = new ReportCategorySubItem();
					} else
					{
						indexSubreport = subCategoryReports.indexOf(subCategory);
					}

					if (s.getTaxid() != null || !s.getTaxid().equalsIgnoreCase(""))
					{
						productTax = taxService.find(s.getTaxid());
					}

					double price = s.getPrice() + subCategory.getPrice();
					double qty = s.getUnits() + subCategory.getQty();
					double subTotal = (s.getPrice() * s.getUnits()) + subCategory.getSubTotal();
					double tax = (((s.getPrice() * productTax.getRate()) / 100) * s.getUnits()) + subCategory.getTax();
					double discount = 0;
					double total = (subTotal - tax - discount);

					subCategory.setCategoryId(category.getId());
					subCategory.setCategoryName(category.getName());
					subCategory.setQty(qty);
					subCategory.setPrice(price);
					subCategory.setSubTotal(subTotal);
					subCategory.setDisc(discount);
					subCategory.setTax(tax);
					subCategory.setTotal(total);

					if (indexSubreport != null)
					{
						subCategoryReports.set(indexSubreport, subCategory);
					} else
					{
						subCategoryReports.add(subCategory);
					}
				}
			}

			if (categories.size() != 0)
			{
				double totalTax = 0;
				double totalTransaction = 0;
				for (ReportCategorySubItem s : subCategoryReports)
				{
					totalTax += s.getTax();
					totalTransaction += s.getTotal();
				}
				ReportCategorySub subReport = new ReportCategorySub();
				subReport.setDate(new Date(time.getTime()));
				subReport.setSubItems(subCategoryReports);
				subReport.setTotaltax(totalTax);
				subReport.setTotalTransaction(totalTransaction);
				subReports.add(subReport);
			}
		}

		double totalTax = 0;
		double totalTransaction = 0;

		for (ReportCategorySub s : subReports)
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

	public ReportDate<ReportSubCategorySub> reportBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{
		ReportDate<ReportSubCategorySub> report = new ReportDate<>();
		List<Timestamp> listTime = rangeDate(fromDate, toDate);
		List<Category> categories = new ArrayList<>();
		List<ReportSubDate<ReportSubCategorySub>> reportSubDates = new ArrayList<>();
		for (Timestamp time : listTime)
		{
			List<ReportSubCategorySub> subReportDateItem = new ArrayList<>();
			categories = categoryService.findParentCategoriesFromSalesItem(getFromDate(time), getToDate(time));
			for (Category category : categories)
			{
				List<Category> subCategories = new ArrayList<>();
				subCategories = categoryService.findSubCategoriesFromSalesItemByCategoryId(category.getId(), getFromDate(time), getToDate(time));
				for (Category subCategory : subCategories)
				{
					List<ReportSubCategorySubItem> subItems = new ArrayList<>();					
					List<ViewSalesItem> saleItems = new ArrayList<>();
					saleItems = viewSalesItemService.findAllByCategoryId(subCategory.getId(), getFromDate(time), getToDate(time));
					for (ViewSalesItem s : saleItems)
					{
						Tax productTax = null;
						ReportSubCategorySubItem subItem = null;
						Integer indexSubreport = null;
						subItem = findReportSubCategoryReportItemByProductId(subItems, s.getProduct());

						if (subItem == null)
						{
							subItem = new ReportSubCategorySubItem();
						} else
						{
							indexSubreport = subItems.indexOf(subItem);
						}

						if (s.getTaxid() != null || !s.getTaxid().equalsIgnoreCase(""))
						{
							productTax = taxService.find(s.getTaxid());
						}

						double price = s.getPrice();
						double qty = s.getUnits() + subItem.getQty();
						double subTotal = (s.getPrice() * s.getUnits()) + subItem.getSubTotal();
						double tax = (((s.getPrice() * productTax.getRate()) / 100) * s.getUnits()) + subItem.getTax();
						double discount = 0;

						double total = (subTotal - tax - discount);

						subItem.setProductId(s.getProduct());
						subItem.setProductName(s.getProductName());
						subItem.setQty(qty);
						subItem.setPrice(price);
						subItem.setSubTotal(subTotal);
						subItem.setDisc(discount);
						subItem.setTax(tax);
						subItem.setTotal(total);

						if (indexSubreport != null)
						{
							subItems.set(indexSubreport, subItem);
						} else
						{
							subItems.add(subItem);
						}
					}
					
					double totalTax = 0;
					double totalTransaction = 0;
					for (ReportSubCategorySubItem s : subItems)
					{
						totalTax += s.getTax();
						totalTransaction += s.getTotal();
					}

					ReportSubCategorySub subReport = new ReportSubCategorySub();
					subReport.setCategoryName(category.getName());
					subReport.setSubCategoryName(subCategory.getName());
					subReport.setDate(new Date(time.getTime()));
					subReport.setSubItems(subItems);
					subReport.setTotaltax(totalTax);
					subReport.setTotalTransaction(totalTransaction);					
					subReportDateItem.add(subReport);
				}
			}

			if (!subReportDateItem.isEmpty())
			{
  			ReportSubDate<ReportSubCategorySub> sub = new ReportSubDate<>();
  			sub.setDate(new Date(time.getTime()));
  			sub.setSubReport(subReportDateItem);
  			reportSubDates.add(sub);
			}
		}

		double totalTax = 0;
		double totalTransaction = 0;

		List<ReportSubCategorySub> transSubReport = new ArrayList<>();
		reportSubDates.forEach(r -> { transSubReport.addAll(r.getSubReport());});

		for (ReportSubCategorySub s : transSubReport)
		{
			totalTax += s.getTotaltax();
			totalTransaction += s.getTotalTransaction();
		}

		Merchant merchant = merchantService.findByMerchantCode(merchantCode);

		report.setMerchantName(merchant.getName());
		report.setMerchantAddress(merchant.getAddress());
		report.setMerchantNpwp(merchant.getNpwpperusahaan());
		report.setSubReportDate(reportSubDates);
		report.setTotalTax(totalTax);
		report.setTotalTransaction(totalTransaction);

		return report;
	}

	public byte[] byteReportPdfSales(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		Report<ReportSalesSub> report = reportSales(merchantCode, fromDate, toDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
			title.add(GeneralFunction.checkNullString(report.getMerchantName()).toUpperCase() + "\n" + "SALES DETAIL REPORT"
					+ new String(GeneralFunction.checkNullString(report.getMerchantNpwp()).equalsIgnoreCase("") ? ""
							: "\nNPWP. " +report.getMerchantNpwp()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			Paragraph date = new Paragraph();
			date.setFont(title1Font);
			date.add(dateFormat.format(fromDate) + " - " + dateFormat.format(toDate));
			date.setAlignment(Element.ALIGN_CENTER);
			date.setSpacingAfter(10);
			document.add(date);

			PdfPTable table;
			for (ReportSalesSub s : report.getSubReports())
			{
				Paragraph userInfo = new Paragraph();
				userInfo.setFont(simpleFont);
				userInfo.add("Sales : " + s.getPeopleName() + "\n" + dateFormat.format(s.getDate()));
				userInfo.setAlignment(Element.ALIGN_RIGHT);
				userInfo.setSpacingAfter(5);
				userInfo.setLeading(10);
				document.add(userInfo);

				table = new PdfPTable(7);
				table.setWidthPercentage(100);
				table.addCell(pdfCell("Product Description", colFont));
				table.addCell(pdfCell("Quantity", colFont));
				table.addCell(pdfCell("Price", colFont));
				table.addCell(pdfCell("Sub Total", colFont));
				table.addCell(pdfCell("Discount %", colFont));
				table.addCell(pdfCell("Tax", colFont));
				table.addCell(pdfCell("Total", colFont));
				for (ReportSalesSubItem p : s.getSubItems())
				{
					table.addCell(new Phrase(p.getProductName(), colFont));
					table.addCell(new Phrase(String.valueOf(p.getQty()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getPrice()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getSubTotal()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getDisc()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTax()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTotal()), colFont));
				}

				document.add(table);

				Paragraph subTotal = new Paragraph();
				subTotal.setFont(simpleFont);
				subTotal.add("Total " + s.getPeopleName() + "\nTax : " + GeneralFunction.formatCurrency(s.getTotaltax()) + " Total : "
						+ GeneralFunction.formatCurrency(s.getTotalTransaction()));
				subTotal.setSpacingAfter(20);
				subTotal.setLeading(10);
				subTotal.setAlignment(Element.ALIGN_RIGHT);
				document.add(subTotal);

			}

			Paragraph allTotal = new Paragraph();
			allTotal.setFont(simpleFont);
			allTotal.add("Total Sales\nTax : " + GeneralFunction.formatCurrency(report.getTotalTax()) + " Total : "
					+ GeneralFunction.formatCurrency(report.getTotalTransaction()));
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

	public byte[] byteReportPdfByCategory(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		Report<ReportCategorySub> report = reportByCategory(merchantCode, fromDate, toDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
			title.add(GeneralFunction.checkNullString(report.getMerchantName()).toUpperCase() + "\n"
					+ "SALES SUMMARY REPORT - BY CATEGORY"
					+ new String(GeneralFunction.checkNullString(report.getMerchantNpwp()).equalsIgnoreCase("") ? ""
							: "\nNPWP. " + report.getMerchantNpwp()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			Paragraph date = new Paragraph();
			date.setFont(title1Font);
			date.add(dateFormat.format(fromDate) + " - " + dateFormat.format(toDate));
			date.setAlignment(Element.ALIGN_CENTER);
			date.setSpacingAfter(10);
			document.add(date);

			PdfPTable table;
			for (ReportCategorySub s : report.getSubReports())
			{
				Paragraph userInfo = new Paragraph();
				userInfo.setFont(simpleFont);
				userInfo.add(dateFormat.format(s.getDate()));
				userInfo.setAlignment(Element.ALIGN_RIGHT);
				userInfo.setSpacingAfter(5);
				userInfo.setLeading(10);
				document.add(userInfo);

				table = new PdfPTable(7);
				table.setWidthPercentage(100);
				table.addCell(pdfCell("Category", colFont));
				table.addCell(pdfCell("Quantity", colFont));
				table.addCell(pdfCell("Price", colFont));
				table.addCell(pdfCell("Sub Total", colFont));
				table.addCell(pdfCell("Discount %", colFont));
				table.addCell(pdfCell("Tax", colFont));
				table.addCell(pdfCell("Total", colFont));
				for (ReportCategorySubItem p : s.getSubItems())
				{
					table.addCell(new Phrase(p.getCategoryName(), colFont));
					table.addCell(new Phrase(String.valueOf(p.getQty()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getPrice()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getSubTotal()), colFont));
					table.addCell(new Phrase(String.valueOf(p.getDisc()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTax()), colFont));
					table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTotal()), colFont));
				}

				document.add(table);

				Paragraph subTotal = new Paragraph();
				subTotal.setFont(simpleFont);
				subTotal.add("Tax : " + GeneralFunction.formatCurrency(s.getTotaltax()) + " Sub Total : "
						+ GeneralFunction.formatCurrency(s.getTotalTransaction()));
				subTotal.setSpacingAfter(20);
				subTotal.setLeading(10);
				subTotal.setAlignment(Element.ALIGN_RIGHT);
				document.add(subTotal);

			}

			Paragraph allTotal = new Paragraph();
			allTotal.setFont(simpleFont);
			allTotal.add("Total Sales\nTax : " + GeneralFunction.formatCurrency(report.getTotalTax()) + " Total : "
					+ GeneralFunction.formatCurrency(report.getTotalTransaction()));
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

	public byte[] byteReportPdfBySubCategory(String merchantCode, Timestamp fromDate, Timestamp toDate)
	{

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ReportDate<ReportSubCategorySub> report = reportBySubCategory(merchantCode, fromDate, toDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
			title.add(GeneralFunction.checkNullString(report.getMerchantName()).toUpperCase() + "\n"
					+ "SALES SUMMARY REPORT - BY CATEGORY"
					+ new String(GeneralFunction.checkNullString(report.getMerchantNpwp()).equalsIgnoreCase("") ? ""
							: "\nNPWP. "+report.getMerchantNpwp()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			Paragraph date = new Paragraph();
			date.setFont(title1Font);
			date.add(dateFormat.format(fromDate) + " - " + dateFormat.format(toDate));
			date.setAlignment(Element.ALIGN_CENTER);
			date.setSpacingAfter(10);
			document.add(date);

			report.getSubReportDate().forEach(d ->
			{
				try
				{
					Paragraph dateInfo = new Paragraph();
					dateInfo.setFont(simpleFont);
					dateInfo.add(dateFormat.format(d.getDate()));
					dateInfo.setAlignment(Element.ALIGN_RIGHT);
					dateInfo.setSpacingBefore(15);
					dateInfo.setLeading(10);
					document.add(dateInfo);

					PdfPTable table;
					for (ReportSubCategorySub s : d.getSubReport())
					{
						Paragraph categoryInfo = new Paragraph();
						categoryInfo.setFont(simpleFont);
						categoryInfo.add(s.getCategoryName() + " : " + s.getSubCategoryName());
						categoryInfo.setAlignment(Element.ALIGN_RIGHT);
						categoryInfo.setSpacingAfter(5);
						categoryInfo.setLeading(10);
						document.add(categoryInfo);

						table = new PdfPTable(7);
						table.setWidthPercentage(100);
						table.addCell(pdfCell("Product Description", colFont));
						table.addCell(pdfCell("Quantity", colFont));
						table.addCell(pdfCell("Price", colFont));
						table.addCell(pdfCell("Sub Total", colFont));
						table.addCell(pdfCell("Discount %", colFont));
						table.addCell(pdfCell("Tax", colFont));
						table.addCell(pdfCell("Total", colFont));
						for (ReportSubCategorySubItem p : s.getSubItems())
						{
							table.addCell(new Phrase(p.getProductName(), colFont));
							table.addCell(new Phrase(String.valueOf(p.getQty()), colFont));
							table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getPrice()), colFont));
							table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getSubTotal()), colFont));
							table.addCell(new Phrase(String.valueOf(p.getDisc()), colFont));
							table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTax()), colFont));
							table.addCell(new Phrase(GeneralFunction.formatCurrency(p.getTotal()), colFont));
						}

						document.add(table);

						Paragraph subTotal = new Paragraph();
						subTotal.setFont(simpleFont);
						subTotal.add("Tax : " + GeneralFunction.formatCurrency(s.getTotaltax()) + " Sub Total : "
								+ GeneralFunction.formatCurrency(s.getTotalTransaction()));
						subTotal.setSpacingAfter(10);
						subTotal.setLeading(10);
						subTotal.setAlignment(Element.ALIGN_RIGHT);
						document.add(subTotal);

					}
				} catch (DocumentException e)
				{
					e.printStackTrace();
				}

			});

			Paragraph allTotal = new Paragraph();
			allTotal.setFont(simpleFont);
			allTotal.add("Total Sales\nTax : " + GeneralFunction.formatCurrency(report.getTotalTax()) + " Total : "
					+ GeneralFunction.formatCurrency(report.getTotalTransaction()));
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

	private ReportSalesSubItem findReportSalesReportItemByProductName(List<ReportSalesSubItem> subProductReports,
			String productId)
	{
		for (ReportSalesSubItem s : subProductReports)
		{
			if (s.getProductId().equals(productId))
			{
				return s;
			}
		}
		return null;
	}

	private ReportCategorySubItem findReportCategoryReportItemByCategoryId(List<ReportCategorySubItem> subCategoryReports,
			String categoryId)
	{
		for (ReportCategorySubItem s : subCategoryReports)
		{
			if (s.getCategoryId().equals(categoryId))
			{
				return s;
			}
		}
		return null;
	}

	private ReportSubCategorySubItem findReportSubCategoryReportItemByProductId(List<ReportSubCategorySubItem> subItems,
			String productId)
	{
		for (ReportSubCategorySubItem s : subItems)
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
