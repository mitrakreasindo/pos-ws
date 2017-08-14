/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.util.List;

/**
 * @author miftakhul
 *
 */
public class ReportCategory
{
	
	private String merchantName;
	private String merchantAddress;
	private String merchantNpwp;
	private List<SubReportCategory> subReports;
	private double totalTax;
	private double totalTransaction;
	
	/**
	 * @return the merchantName
	 */
	public String getMerchantName()
	{
		return merchantName;
	}
	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}
	/**
	 * @return the merchantAddress
	 */
	public String getMerchantAddress()
	{
		return merchantAddress;
	}
	/**
	 * @param merchantAddress the merchantAddress to set
	 */
	public void setMerchantAddress(String merchantAddress)
	{
		this.merchantAddress = merchantAddress;
	}
	/**
	 * @return the merchantNpwp
	 */
	public String getMerchantNpwp()
	{
		return merchantNpwp;
	}
	/**
	 * @param merchantNpwp the merchantNpwp to set
	 */
	public void setMerchantNpwp(String merchantNpwp)
	{
		this.merchantNpwp = merchantNpwp;
	}
	/**
	 * @return the subReports
	 */
	public List<SubReportCategory> getSubReports()
	{
		return subReports;
	}
	/**
	 * @param subReports the subReports to set
	 */
	public void setSubReports(List<SubReportCategory> subReports)
	{
		this.subReports = subReports;
	}
	/**
	 * @return the totalTax
	 */
	public double getTotalTax()
	{
		return totalTax;
	}
	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(double totalTax)
	{
		this.totalTax = totalTax;
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
