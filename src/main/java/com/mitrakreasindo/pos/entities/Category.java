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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  private String texttip;
  @NotNull
  @Column(name = "catshowname")
  private boolean catshowName;
  @Column(name = "colour")
  private String colour;
  @Column(name = "catorder")
  private Integer catorder;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JsonIgnore
  @OneToMany(mappedBy = "parentid", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private Collection<Category> categoriesCollection;
  @JoinColumn(name = "parentid", referencedColumnName = "id", nullable = true)
  @ManyToOne(optional = true)
  private Category parentid;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
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
  public String getTexttip()
  {
    return texttip;
  }
  public void setTexttip(String textTip)
  {
    this.texttip = textTip;
  }
  public boolean isCatshowname()
  {
    return catshowName;
  }
  public void setCatshowname(boolean catShowName)
  {
    this.catshowName = catShowName;
  }
  public String getColour()
  {
    return colour;
  }
  public void setColour(String colour)
  {
    this.colour = colour;
  }
  public Integer getCatorder()
  {
    return catorder;
  }
  public void setCatorder(Integer catOrder)
  {
    this.catorder = catOrder;
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
  public Category getParentid()
  {
    return parentid;
  }
  public void setParentid(Category parentId)
  {
    this.parentid = parentId;
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
