/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "taxlines")
public class TaxLine implements Serializable
{
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @NotNull
  @Column(name = "base")
  private double base;
  @NotNull
  @Column(name = "amount")
  private double amount;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "receipt", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Receipt receipt;
  @JoinColumn(name = "taxid", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Tax taxid;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public double getBase()
  {
    return base;
  }
  public void setBase(double base)
  {
    this.base = base;
  }
  public double getAmount()
  {
    return amount;
  }
  public void setAmount(double amount)
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
  public Receipt getReceipt()
  {
    return receipt;
  }
  public void setReceipt(Receipt receipt)
  {
    this.receipt = receipt;
  }
  public Tax getTaxid()
  {
    return taxid;
  }
  public void setTaxid(Tax taxid)
  {
    this.taxid = taxid;
  }
  
}
