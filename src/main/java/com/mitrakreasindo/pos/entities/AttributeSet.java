package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attributeset")
public class AttributeSet implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributesetId")
  private Collection<AttributesetInstance> attributesetinstanceCollection;
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(mappedBy = "attributesetId")
  private Collection<Product> productsCollection;
  
  
  public Collection<AttributesetInstance> getAttributesetinstanceCollection()
  {
    return attributesetinstanceCollection;
  }
  public void setAttributesetinstanceCollection(Collection<AttributesetInstance> attributesetinstanceCollection)
  {
    this.attributesetinstanceCollection = attributesetinstanceCollection;
  }
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
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
  public Collection<Product> getProductsCollection()
  {
    return productsCollection;
  }
  public void setProductsCollection(Collection<Product> productsCollection)
  {
    this.productsCollection = productsCollection;
  }
  
  
  
}
