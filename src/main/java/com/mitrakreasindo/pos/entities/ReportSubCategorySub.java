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
public class ReportSubCategorySub
{

	private List<ReportSubCategorySubItem> subItems;
	private String categoryName;
	private String subCategoryName;
	private Date date;
	private double totaltax;
	private double totalTransaction;
	/**
	 * @return the subItems
	 */
	public List<ReportSubCategorySubItem> getSubItems()
	{
		return subItems;
	}
	/**
	 * @param subItems the subItems to set
	 */
	public void setSubItems(List<ReportSubCategorySubItem> subItems)
	{
		this.subItems = subItems;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName()
	{
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName()
	{
		return subCategoryName;
	}
	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName)
	{
		this.subCategoryName = subCategoryName;
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
