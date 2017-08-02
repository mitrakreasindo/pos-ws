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
@Table(name = "viewreceipts")
public class ViewReceipt implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "money")
  private String money;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;
  @Column(name = "person")
  private String person;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "host")
  private String host;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getMoney()
  {
    return money;
  }
  public void setMoney(String money)
  {
    this.money = money;
  }
  public String getDatenew()
  {
    return datenew;
  }
  public void setDatenew(String datenew)
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
  public byte[] getAttributes()
  {
    return attributes;
  }
  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
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
  public String getHost()
  {
    return host;
  }
  public void setHost(String host)
  {
    this.host = host;
  }
  
}
