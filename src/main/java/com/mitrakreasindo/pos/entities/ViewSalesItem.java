/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "viewsalesitems")
public class ViewSalesItem implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Column(name = "id")
  @Id
  private Integer id;
  @Column(name = "salesId")
  private String salesId;
  @Column(name = "line")
  private Integer line;
  @Column(name = "product")
  private String product;
  @Column(name = "attributesetinstance_id")
  private String attributesetinstanceId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "units")
  private Double units;
  @Column(name = "price")
  private Double price;
  @Column(name = "taxid")
  private String taxid;
  @Lob
  @Column(name = "attributes")
  private byte[] attributes;
  @Column(name = "refundqty")
  private Double refundqty;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "product_name")
  private String productName;
  @Column(name = "tax_name")
  private String taxName;
  @Column(name = "rate")
  private Double rate;
  
  public Integer getId()
  {
    return id;
  }
  public void setId(Integer id)
  {
    this.id = id;
  }
  public String getSalesId()
  {
    return salesId;
  }
  public void setSalesId(String salesId)
  {
    this.salesId = salesId;
  }
  public Integer getLine()
  {
    return line;
  }
  public void setLine(Integer line)
  {
    this.line = line;
  }
  public String getProduct()
  {
    return product;
  }
  public void setProduct(String product)
  {
    this.product = product;
  }
  public String getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }
  public void setAttributesetinstanceId(String attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }
  public Double getUnits()
  {
    return units;
  }
  public void setUnits(Double units)
  {
    this.units = units;
  }
  public Double getPrice()
  {
    return price;
  }
  public void setPrice(Double price)
  {
    this.price = price;
  }
  public String getTaxid()
  {
    return taxid;
  }
  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }
  public byte[] getAttributes()
  {
    return attributes;
  }
  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }
  public Double getRefundqty()
  {
    return refundqty;
  }
  public void setRefundqty(Double refundqty)
  {
    this.refundqty = refundqty;
  }
  public String getSiteguid()
  {
    return siteguid;
  }
  public void setSiteguid(String siteguid)
  {
    this.siteguid = siteguid;
  }
  public Boolean getSflag()
  {
    return sflag;
  }
  public void setSflag(Boolean sflag)
  {
    this.sflag = sflag;
  }
  public String getProductName()
  {
    return productName;
  }
  public void setProductName(String productName)
  {
    this.productName = productName;
  }
  public String getTaxName()
  {
    return taxName;
  }
  public void setTaxName(String taxName)
  {
    this.taxName = taxName;
  }
  public Double getRate()
  {
    return rate;
  }
  public void setRate(Double rate)
  {
    this.rate = rate;
  }

}
