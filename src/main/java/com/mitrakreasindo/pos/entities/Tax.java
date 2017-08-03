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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "taxes")
public class Tax implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @NotNull
  @Id
  @Column(name = "id")
  private String id;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxid", fetch = FetchType.LAZY)
  private Collection<SalesItem> salesItemsCollection;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxid", fetch = FetchType.LAZY)
  private Collection<TaxLine> taxlinesCollection;
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "rate")
  private double rate;
  @NotNull
  @Column(name = "ratecascade")
  private boolean ratecascade;
  @Column(name = "rateorder")
  private Integer rateorder;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private TaxCategory category;
  @JoinColumn(name = "custcategory", referencedColumnName = "id")
  @ManyToOne
  private TaxCustCategory custcategory;
  @OneToMany(mappedBy = "parentid", fetch = FetchType.LAZY)
  private Collection<Tax> taxesCollection;
  @JoinColumn(name = "parentid", referencedColumnName = "id")
  @ManyToOne
  private Tax parentid;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public Collection<SalesItem> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }
  public void setSalesItemsCollection(Collection<SalesItem> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  public Collection<TaxLine> getTaxlinesCollection()
  {
    return taxlinesCollection;
  }
  public void setTaxlinesCollection(Collection<TaxLine> taxlinesCollection)
  {
    this.taxlinesCollection = taxlinesCollection;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public double getRate()
  {
    return rate;
  }
  public void setRate(double rate)
  {
    this.rate = rate;
  }
  public boolean isRatecascade()
  {
    return ratecascade;
  }
  public void setRatecascade(boolean ratecascade)
  {
    this.ratecascade = ratecascade;
  }
  public Integer getRateorder()
  {
    return rateorder;
  }
  public void setRateorder(Integer rateorder)
  {
    this.rateorder = rateorder;
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
  public TaxCategory getCategory()
  {
    return category;
  }
  public void setCategory(TaxCategory category)
  {
    this.category = category;
  }
  public TaxCustCategory getCustcategory()
  {
    return custcategory;
  }
  public void setCustcategory(TaxCustCategory custcategory)
  {
    this.custcategory = custcategory;
  }
  public Collection<Tax> getTaxesCollection()
  {
    return taxesCollection;
  }
  public void setTaxesCollection(Collection<Tax> taxesCollection)
  {
    this.taxesCollection = taxesCollection;
  }
  public Tax getParentid()
  {
    return parentid;
  }
  public void setParentid(Tax parentid)
  {
    this.parentid = parentid;
  }
  
}
