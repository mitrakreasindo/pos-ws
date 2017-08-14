/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.util.Date;
import java.util.List;

/**
 * @author miftakhul
 *
 */
public class SubReportCategory
{

	private List<SubCategoryReport> subCategoryReports;
	private Date date;
	private double totaltax;
	private double totalTransaction;
	
	/**
	 * @return the subCategoryReports
	 */
	public List<SubCategoryReport> getSubCategoryReports()
	{
		return subCategoryReports;
	}
	/**
	 * @param subCategoryReports the subCategoryReports to set
	 */
	public void setSubCategoryReports(List<SubCategoryReport> subCategoryReports)
	{
		this.subCategoryReports = subCategoryReports;
	}
	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}
	/**
	 * @return the totaltax
	 */
	public double getTotaltax()
	{
		return totaltax;
	}
	/**
	 * @param totaltax the totaltax to set
	 */
	public void setTotaltax(double totaltax)
	{
		this.totaltax = totaltax;
	}
	/**
	 * @return the totalTransaction
	 */
	public double getTotalTransaction()
	{
		return totalTransaction;
	}
	/**
	 * @param totalTransaction the totalTransaction to set
	 */
	public void setTotalTransaction(double totalTransaction)
	{
		this.totalTransaction = totalTransaction;
	}
	
}
