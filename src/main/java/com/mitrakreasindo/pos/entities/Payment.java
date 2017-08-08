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

import org.hibernate.annotations.Type;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "payments")
public class Payment implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "returnmsg")
  private byte[] returnmsg;
  @NotNull
  @Column(name = "payment")
  private String payment;
  @NotNull
  @Column(name = "total")
  private double total;
  @Column(name = "transid")
  private String transid;
  @Column(name = "notes")
  private String notes;
  @NotNull
  @Column(name = "tendered")
  private double tendered;
  @Column(name = "cardname")
  private String cardname;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "receipt", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Receipt receipt;
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public byte[] getReturnmsg()
  {
    return returnmsg;
  }
  public void setReturnmsg(byte[] returnmsg)
  {
    this.returnmsg = returnmsg;
  }
  public String getPayment()
  {
    return payment;
  }
  public void setPayment(String payment)
  {
    this.payment = payment;
  }
  public double getTotal()
  {
    return total;
  }
  public void setTotal(double total)
  {
    this.total = total;
  }
  public String getTransid()
  {
    return transid;
  }
  public void setTransid(String transid)
  {
    this.transid = transid;
  }
  public String getNotes()
  {
    return notes;
  }
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  public double getTendered()
  {
    return tendered;
  }
  public void setTendered(double tendered)
  {
    this.tendered = tendered;
  }
  public String getCardname()
  {
    return cardname;
  }
  public void setCardname(String cardname)
  {
    this.cardname = cardname;
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
  
}
