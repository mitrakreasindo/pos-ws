/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.util.List;

/**
 * @author miftakhul
 *
 */
public class SubReport
{

	private List<SubProductReport> subProductReports;
	private String peopleName;
	private double totaltax;
	private double totalTransaction;
	
	/**
	 * @return the subProductReports
	 */
	public List<SubProductReport> getSubProductReports()
	{
		return subProductReports;
	}
	/**
	 * @param subProductReports the subProductReports to set
	 */
	public void setSubProductReports(List<SubProductReport> subProductReports)
	{
		this.subProductReports = subProductReports;
	}
	/**
	 * @return the peopleName
	 */
	public String getPeopleName()
	{
		return peopleName;
	}
	/**
	 * @param peopleName the peopleName to set
	 */
	public void setPeopleName(String peopleName)
	{
		this.peopleName = peopleName;
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
