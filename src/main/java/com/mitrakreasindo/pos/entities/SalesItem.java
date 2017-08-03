/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "sales_items")
public class SalesItem implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @JoinColumn(name = "attributesetinstance_id", referencedColumnName = "id")
  @ManyToOne
  private AttributesetInstance attributesetinstanceId;
  @JoinColumn(name = "product", referencedColumnName = "id")
  @ManyToOne
  private Product product;
  @JoinColumn(name = "taxid", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Tax taxid;
  @NotNull
  @Column(name = "line")
  private int line;
  @NotNull
  @Column(name = "units")
  private double units;
  @NotNull
  @Column(name = "price")
  private double price;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "refundqty")
  private Double refundqty;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "salesId", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Sale salesId;
  
  public Integer getId()
  {
    return id;
  }
  public void setId(Integer id)
  {
    this.id = id;
  }
  public byte[] getAttributes()
  {
    return attributes;
  }
  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }
  public AttributesetInstance getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }
  public void setAttributesetinstanceId(AttributesetInstance attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }
  public Product getProduct()
  {
    return product;
  }
  public void setProduct(Product product)
  {
    this.product = product;
  }
  public Tax getTaxid()
  {
    return taxid;
  }
  public void setTaxid(Tax taxid)
  {
    this.taxid = taxid;
  }
  public int getLine()
  {
    return line;
  }
  public void setLine(int line)
  {
    this.line = line;
  }
  public double getUnits()
  {
    return units;
  }
  public void setUnits(double units)
  {
    this.units = units;
  }
  public double getPrice()
  {
    return price;
  }
  public void setPrice(double price)
  {
    this.price = price;
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
  public Sale getSalesId()
  {
    return salesId;
  }
  public void setSalesId(Sale salesId)
  {
    this.salesId = salesId;
  }
    
}
