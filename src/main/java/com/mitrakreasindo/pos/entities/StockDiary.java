/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "stockdiary")
public class StockDiary implements Serializable
{
  
  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @NotNull
  @Column(name = "datenew")
  //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Temporal(TemporalType.TIMESTAMP)
  private Date datenew;
  @NotNull
  @Column(name = "reason")
  private int reason;
  @NotNull
  @Column(name = "units")
  private double units;
  @NotNull
  @Column(name = "price")
  private double price;
  @Column(name = "appuser")
  private String appuser;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributesetinstance_id", referencedColumnName = "id")
  @ManyToOne
  private AttributesetInstance attributesetinstanceId;
  @JoinColumn(name = "location", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Location location;
  @JoinColumn(name = "product", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Product product;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public Date getDatenew()
  {
    return datenew;
  }
  public void setDatenew(Date datenew)
  {
    this.datenew = datenew;
  }
  public int getReason()
  {
    return reason;
  }
  public void setReason(int reason)
  {
    this.reason = reason;
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
  public AttributesetInstance getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }
  public void setAttributesetinstanceId(AttributesetInstance attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }
  public Location getLocation()
  {
    return location;
  }
  public void setLocation(Location location)
  {
    this.location = location;
  }
  public Product getProduct()
  {
    return product;
  }
  public void setProduct(Product product)
  {
    this.product = product;
  }

}
