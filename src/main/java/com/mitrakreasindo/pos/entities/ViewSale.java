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
@Table(name = "viewsales")
public class ViewSale implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "salestype")
  private Integer salestype;
  @Column(name = "salesnum")
  private Integer salesnum;
  @Column(name = "person")
  private String person;
  @Column(name = "customer")
  private String customer;
  @Column(name = "status")
  private Integer status;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "customer_name")
  private String customerName;
  @Column(name = "person_name")
  private String personName;
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
  public Integer getSalestype()
  {
    return salestype;
  }
  public void setSalestype(Integer salestype)
  {
    this.salestype = salestype;
  }
  public Integer getSalesnum()
  {
    return salesnum;
  }
  public void setSalesnum(Integer salesnum)
  {
    this.salesnum = salesnum;
  }
  public String getPerson()
  {
    return person;
  }
  public void setPerson(String person)
  {
    this.person = person;
  }
  public String getCustomer()
  {
    return customer;
  }
  public void setCustomer(String customer)
  {
    this.customer = customer;
  }
  public Integer getStatus()
  {
    return status;
  }
  public void setStatus(Integer status)
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
  public String getCustomerName()
  {
    return customerName;
  }
  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }
  public String getPersonName()
  {
    return personName;
  }
  public void setPersonName(String personName)
  {
    this.personName = personName;
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
