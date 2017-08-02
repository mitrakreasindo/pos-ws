/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "receipts")
public class Receipt implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
  private Collection<Payment> paymentsCollection;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "receipts")
  private Sale sales;
  @NotNull
  @Column(name = "datenew")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datenew;
  @Column(name = "person")
  private String person;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "money", referencedColumnName = "money")
  @ManyToOne(optional = false)
  private ClosedCash money;
  public String getId()
  {
    return id;
  }
  public void setId(String id)
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
  public Collection<Payment> getPaymentsCollection()
  {
    return paymentsCollection;
  }
  public void setPaymentsCollection(Collection<Payment> paymentsCollection)
  {
    this.paymentsCollection = paymentsCollection;
  }
  public Sale getSales()
  {
    return sales;
  }
  public void setSales(Sale sales)
  {
    this.sales = sales;
  }
  public Date getDatenew()
  {
    return datenew;
  }
  public void setDatenew(Date datenew)
  {
    this.datenew = datenew;
  }
  public String getPerson()
  {
    return person;
  }
  public void setPerson(String person)
  {
    this.person = person;
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
  public ClosedCash getMoney()
  {
    return money;
  }
  public void setMoney(ClosedCash money)
  {
    this.money = money;
  }
    
}
