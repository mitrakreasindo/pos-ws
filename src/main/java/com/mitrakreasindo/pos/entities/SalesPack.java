/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author miftakhul
 *
 */
public class SalesPack implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  ViewSale sales;
  ViewReceipt receipts;
  Collection<ViewSalesItem> salesItems;
  Collection<ViewPayment> payments;
  Collection<ViewStockDiary> stockdiary;
  Collection<ViewTaxLine> taxlines;
  
  public ViewSale getSales()
  {
    return sales;
  }
  public void setSales(ViewSale sales)
  {
    this.sales = sales;
  }
  public ViewReceipt getReceipts()
  {
    return receipts;
  }
  public void setReceipts(ViewReceipt receipts)
  {
    this.receipts = receipts;
  }
  public Collection<ViewSalesItem> getSalesItems()
  {
    return salesItems;
  }
  public void setSalesItems(Collection<ViewSalesItem> salesItems)
  {
    this.salesItems = salesItems;
  }
  public Collection<ViewPayment> getPayments()
  {
    return payments;
  }
  public void setPayments(Collection<ViewPayment> payments)
  {
    this.payments = payments;
  }
  public Collection<ViewStockDiary> getStockdiary()
  {
    return stockdiary;
  }
  public void setStockdiary(Collection<ViewStockDiary> stockdiary)
  {
    this.stockdiary = stockdiary;
  }
  public Collection<ViewTaxLine> getTaxlines()
  {
    return taxlines;
  }
  public void setTaxlines(Collection<ViewTaxLine> taxlines)
  {
    this.taxlines = taxlines;
  }
  
}
