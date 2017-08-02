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
@Table(name = "viewtaxlines")
public class ViewTaxLine implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "receipt")
  private String receipt;
  @Column(name = "taxid")
  private String taxid;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "base")
  private Double base;
  @Column(name = "amount")
  private Double amount;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "tax_name")
  private String taxName;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getReceipt()
  {
    return receipt;
  }
  public void setReceipt(String receipt)
  {
    this.receipt = receipt;
  }
  public String getTaxid()
  {
    return taxid;
  }
  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }
  public Double getBase()
  {
    return base;
  }
  public void setBase(Double base)
  {
    this.base = base;
  }
  public Double getAmount()
  {
    return amount;
  }
  public void setAmount(Double amount)
  {
    this.amount = amount;
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
  public String getTaxName()
  {
    return taxName;
  }
  public void setTaxName(String taxName)
  {
    this.taxName = taxName;
  }
  
}
