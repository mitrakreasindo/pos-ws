/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "sales")
public class Sale implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @JoinColumn(name = "customer", referencedColumnName = "id")
  @ManyToOne
  private Customer customer;
  @JoinColumn(name = "person", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private People person;
  @JoinColumn(name = "id", referencedColumnName = "id")
  @OneToOne(optional = false)
  private Receipt receipts;
  @NotNull
  @Column(name = "salestype")
  private int salestype;
  @NotNull
  @Column(name = "salesnum")
  private int salesnum;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesid", fetch = FetchType.LAZY)
  private Collection<SalesItem> salesItemsCollection;
  @NotNull
  @Column(name = "status")
  private int status;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public Customer getCustomer()
  {
    return customer;
  }
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }
  public People getPerson()
  {
    return person;
  }
  public void setPerson(People person)
  {
    this.person = person;
  }
  public Receipt getReceipts()
  {
    return receipts;
  }
  public void setReceipts(Receipt receipts)
  {
    this.receipts = receipts;
  }
  public int getSalestype()
  {
    return salestype;
  }
  public void setSalestype(int salestype)
  {
    this.salestype = salestype;
  }
  public int getSalesnum()
  {
    return salesnum;
  }
  public void setSalesnum(int salesnum)
  {
    this.salesnum = salesnum;
  }
  public Collection<SalesItem> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }
  public void setSalesItemsCollection(Collection<SalesItem> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  public int getStatus()
  {
    return status;
  }
  public void setStatus(int status)
  {
    this.status = status;
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
  
}
