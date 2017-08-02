/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "viewstockdiary")
public class ViewStockDiary implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;
  @Column(name = "reason")
  private Integer reason;
  @Column(name = "location")
  private String location;
  @Column(name = "product")
  private String product;
  @Column(name = "attributesetinstance_id")
  private String attributesetinstanceId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "units")
  private Double units;
  @Column(name = "price")
  private Double price;
  @Column(name = "appuser")
  private String appuser;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "product_name")
  private String productName;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getDatenew()
  {
    return datenew;
  }
  public void setDatenew(String datenew)
  {
    this.datenew = datenew;
  }
  public Integer getReason()
  {
    return reason;
  }
  public void setReason(Integer reason)
  {
    this.reason = reason;
  }
  public String getLocation()
  {
    return location;
  }
  public void setLocation(String location)
  {
    this.location = location;
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
  public String getAppuser()
  {
    return appuser;
  }
  public void setAppuser(String appuser)
  {
    this.appuser = appuser;
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
  
}
