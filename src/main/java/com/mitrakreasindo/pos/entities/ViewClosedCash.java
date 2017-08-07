/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "viewclosedcash")
public class ViewClosedCash implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "receipt_id")
	private String receiptId;
	private String money;
	@Column(name = "total_all_payment")
	private Float totalAllPayment;
	@Column(name = "total_cash_payment")
	private Float totalCashPayment;
	@Column(name = "total_sold_units")
	private Float totalSoldUnits;
	@Column(name = "date_start")
	private Date dateStart;
	private String host;
	
	/**
	 * @return the receiptId
	 */
	public String getReceiptId()
	{
		return receiptId;
	}
	/**
	 * @param receiptId the receiptId to set
	 */
	public void setReceiptId(String receiptId)
	{
		this.receiptId = receiptId;
	}
	/**
	 * @return the money
	 */
	public String getMoney()
	{
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(String money)
	{
		this.money = money;
	}
	/**
	 * @return the totalAllPayment
	 */
	public Float getTotalAllPayment()
	{
		return totalAllPayment;
	}
	/**
	 * @param totalAllPayment the totalAllPayment to set
	 */
	public void setTotalAllPayment(Float totalAllPayment)
	{
		this.totalAllPayment = totalAllPayment;
	}
	/**
	 * @return the totalCashPayment
	 */
	public Float getTotalCashPayment()
	{
		return totalCashPayment;
	}
	/**
	 * @param totalCashPayment the totalCashPayment to set
	 */
	public void setTotalCashPayment(Float totalCashPayment)
	{
		this.totalCashPayment = totalCashPayment;
	}
	/**
	 * @return the soldUnits
	 */
	public Float getTotalSoldUnits()
	{
		return totalSoldUnits;
	}
	/**
	 * @param totalSoldUnits the soldUnits to set
	 */
	public void setTotalSoldUnits(Float totalSoldUnits)
	{
		this.totalSoldUnits = totalSoldUnits;
	}
	/**
	 * @return the dateStart
	 */
	public Date getDateStart()
	{
		return dateStart;
	}
	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart)
	{
		this.dateStart = dateStart;
	}
	/**
	 * @return the host
	 */
	public String getHost()
	{
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host)
	{
		this.host = host;
	}
	
	
	
}
