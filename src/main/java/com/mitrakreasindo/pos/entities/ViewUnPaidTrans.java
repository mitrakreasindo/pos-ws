/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "viewunpaidtrans")
public class ViewUnPaidTrans
{
	@Id
	@Column(name = "receipt_id")
  private String receiptId;
	@Column(name = "transaction_time")
  private String transactionTime;
  private String host;
  @Column(name = "receipt_total")
  private float receiptTotal;
  private String customer;
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
	 * @return the transactionTime
	 */
	public String getTransactionTime()
	{
		return transactionTime;
	}
	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(String transactionTime)
	{
		this.transactionTime = transactionTime;
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
	/**
	 * @return the receiptTotal
	 */
	public float getReceiptTotal()
	{
		return receiptTotal;
	}
	/**
	 * @param receiptTotal the receiptTotal to set
	 */
	public void setReceiptTotal(float receiptTotal)
	{
		this.receiptTotal = receiptTotal;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer()
	{
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer)
	{
		this.customer = customer;
	}
  
}
