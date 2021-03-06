/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
  @Column(name = "sales_id")
  private String sales_id;
  @Column(name = "line")
  private Integer line;
  @Column(name = "product")
  private String product;
  @Column(name = "attributesetinstance_id")
  private String attributesetinstanceId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "units")
  private Float units;
  @Column(name = "price")
  private Float price;
  @Column(name = "taxid")
  private String taxid;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @Column(name = "refundqty")
  private Float refundqty;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "product_name")
  private String productName;
  @Column(name = "tax_name")
  private String taxName;
  @Column(name = "rate")
  private Float rate;
  
  public Integer getId()
  {
    return id;
  }
  public void setId(Integer id)
  {
    this.id = id;
  }
  public String getSales_id()
  {
    return sales_id;
  }
  public void setSales_id(String salesId)
  {
    this.sales_id = salesId;
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
  public Float getUnits()
  {
    return units;
  }
  public void setUnits(Float units)
  {
    this.units = units;
  }
  public Float getPrice()
  {
    return price;
  }
  public void setPrice(Float price)
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
  public Float getRefundqty()
  {
    return refundqty;
  }
  public void setRefundqty(Float refundqty)
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
  public Float getRate()
  {
    return rate;
  }
  public void setRate(Float rate)
  {
    this.rate = rate;
  }

}
