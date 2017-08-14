/**
 * 
 */
package com.mitrakreasindo.pos.entities;

/**
 * @author miftakhul
 *
 */
public class SubCategoryReport
{
	
	private String categoryId;
	private String categoryName;
	private double qty;
	private double price;
	private double subTotal;
	private double disc;
	private double tax;
	private double total;
	
	/**
	 * @return the categoryId
	 */
	public String getCategoryId()
	{
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
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
	 * @return the qty
	 */
	public double getQty()
	{
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(double qty)
	{
		this.qty = qty;
	}
	/**
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	/**
	 * @return the subTotal
	 */
	public double getSubTotal()
	{
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal)
	{
		this.subTotal = subTotal;
	}
	/**
	 * @return the disc
	 */
	public double getDisc()
	{
		return disc;
	}
	/**
	 * @param disc the disc to set
	 */
	public void setDisc(double disc)
	{
		this.disc = disc;
	}
	/**
	 * @return the tax
	 */
	public double getTax()
	{
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax)
	{
		this.tax = tax;
	}
	/**
	 * @return the total
	 */
	public double getTotal()
	{
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total)
	{
		this.total = total;
	}
	
}
