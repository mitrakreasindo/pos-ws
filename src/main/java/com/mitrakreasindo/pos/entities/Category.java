package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "categories")
public class Category implements Serializable 
{
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @NotNull
  @Column(name = "name")
  private String name;
  @Column(name = "texttip")
  private String textTip;
  @NotNull
  @Column(name = "catshowname")
  private boolean catShowName;
  @Column(name = "colour")
  private String colour;
  @Column(name = "catorder")
  private Integer catOrder;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Collection<Category> categoriesCollection;
  @JoinColumn(name = "parentId", referencedColumnName = "id", nullable = true)
  @ManyToOne(optional = true)
  private Category parentId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private Collection<Product> productsCollection;
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public byte[] getImage()
  {
    return image;
  }
  public void setImage(byte[] image)
  {
    this.image = image;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getTextTip()
  {
    return textTip;
  }
  public void setTextTip(String textTip)
  {
    this.textTip = textTip;
  }
  public boolean isCatShowName()
  {
    return catShowName;
  }
  public void setCatShowName(boolean catShowName)
  {
    this.catShowName = catShowName;
  }
  public String getColour()
  {
    return colour;
  }
  public void setColour(String colour)
  {
    this.colour = colour;
  }
  public Integer getCatOrder()
  {
    return catOrder;
  }
  public void setCatOrder(Integer catOrder)
  {
    this.catOrder = catOrder;
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
  public Collection<Category> getCategoriesCollection()
  {
    return categoriesCollection;
  }
  public void setCategoriesCollection(Collection<Category> categoriesCollection)
  {
    this.categoriesCollection = categoriesCollection;
  }
  public Category getParentId()
  {
    return parentId;
  }
  public void setParentId(Category parentId)
  {
    this.parentId = parentId;
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
