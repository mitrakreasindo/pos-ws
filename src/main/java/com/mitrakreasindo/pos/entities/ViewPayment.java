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
@Table(name = "viewpayments")
public class ViewPayment implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "receipt")
  private String receipt;
  @Column(name = "payment")
  private String payment;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "total")
  private Double total;
  @Column(name = "transid")
  private String transid;
  @Column(name = "notes")
  private String notes;
  @Column(name = "tendered")
  private Double tendered;
  @Column(name = "cardname")
  private String cardname;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "returnmsg")
  private byte[] returnmsg;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;
  
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
  public String getPayment()
  {
    return payment;
  }
  public void setPayment(String payment)
  {
    this.payment = payment;
  }
  public Double getTotal()
  {
    return total;
  }
  public void setTotal(Double total)
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
  public Double getTendered()
  {
    return tendered;
  }
  public void setTendered(Double tendered)
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
  public byte[] getReturnmsg()
  {
    return returnmsg;
  }
  public void setReturnmsg(byte[] returnmsg)
  {
    this.returnmsg = returnmsg;
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
  public String getDatenew()
  {
    return datenew;
  }
  public void setDatenew(String datenew)
  {
    this.datenew = datenew;
  }
  
}
