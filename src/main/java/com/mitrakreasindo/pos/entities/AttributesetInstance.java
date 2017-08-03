package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

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

@Entity
@Table(name ="attributesetinstance")
public class AttributesetInstance implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Column(name = "description")
  private String description;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributeset_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private AttributeSet attributesetId;
  @JsonIgnore
  @OneToMany(mappedBy = "attributesetinstanceId", fetch = FetchType.LAZY)
  private Collection<SalesItem> salesItemsCollection;
  @JsonIgnore
  @OneToMany(mappedBy = "attributesetinstanceId", fetch = FetchType.LAZY)
  private Collection<StockDiary> stockdiaryCollection;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String description)
  {
    this.description = description;
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
  public AttributeSet getAttributesetId()
  {
    return attributesetId;
  }
  public void setAttributesetId(AttributeSet attributesetId)
  {
    this.attributesetId = attributesetId;
  }
  public Collection<SalesItem> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }
  public void setSalesItemsCollection(Collection<SalesItem> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  public Collection<StockDiary> getStockdiaryCollection()
  {
    return stockdiaryCollection;
  }
  public void setStockdiaryCollection(Collection<StockDiary> stockdiaryCollection)
  {
    this.stockdiaryCollection = stockdiaryCollection;
  }
  
}
