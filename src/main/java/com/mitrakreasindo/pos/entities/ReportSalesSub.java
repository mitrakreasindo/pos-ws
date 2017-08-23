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
public class ReportSalesSub
{

	private List<ReportSalesSubItem> subItems;
	private String peopleName;
	private Date date;
	private double totaltax;
	private double totalTransaction;
	
	public List<ReportSalesSubItem> getSubItems()
	{
		return subItems;
	}
	public void setSubItems(List<ReportSalesSubItem> subItems)
	{
		this.subItems = subItems;
	}
	public String getPeopleName()
	{
		return peopleName;
	}
	public void setPeopleName(String peopleName)
	{
		this.peopleName = peopleName;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public double getTotaltax()
	{
		return totaltax;
	}
	public void setTotaltax(double totaltax)
	{
		this.totaltax = totaltax;
	}
	public double getTotalTransaction()
	{
		return totalTransaction;
	}
	public void setTotalTransaction(double totalTransaction)
	{
		this.totalTransaction = totalTransaction;
	}
	
}
