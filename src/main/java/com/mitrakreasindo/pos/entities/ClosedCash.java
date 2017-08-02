package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "closedcash")
public class ClosedCash implements Serializable
{
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "money")
  private String money;
  @NotNull
  @Column(name = "host")
  private String host;
  @NotNull
  @Column(name = "hostsequence")
  private int hostsequence;
  @NotNull
  @Column(name = "datestart")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datestart;
  @Column(name = "dateend")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateend;
  @NotNull
  @Column(name = "nosales")
  private int nosales;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  //@OneToMany(cascade = CascadeType.ALL, mappedBy = "money")
  //private Collection<Receipts> receiptsCollection;
  
  public String getMoney()
  {
    return money;
  }
  public void setMoney(String money)
  {
    this.money = money;
  }
  public String getHost()
  {
    return host;
  }
  public void setHost(String host)
  {
    this.host = host;
  }
  public int getHostsequence()
  {
    return hostsequence;
  }
  public void setHostsequence(int hostsequence)
  {
    this.hostsequence = hostsequence;
  }
  public Date getDatestart()
  {
    return datestart;
  }
  public void setDatestart(Date datestart)
  {
    this.datestart = datestart;
  }
  public Date getDateend()
  {
    return dateend;
  }
  public void setDateend(Date dateend)
  {
    this.dateend = dateend;
  }
  public int getNosales()
  {
    return nosales;
  }
  public void setNosales(int nosales)
  {
    this.nosales = nosales;
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
