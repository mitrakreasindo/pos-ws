/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "merchantcategories")
public class MerchantCategory implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "subcategory")
  private String subcategory;
  @NotNull
  @Column(name = "sflag")
  private boolean sflag;
  @OneToMany(mappedBy = "category")
  private Collection<Merchant> merchantsCollection;
  
  public Integer getId()
  {
    return id;
  }
  public void setId(Integer id)
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
  public String getSubcategory()
  {
    return subcategory;
  }
  public void setSubcategory(String subcategory)
  {
    this.subcategory = subcategory;
  }
  public boolean isSflag()
  {
    return sflag;
  }
  public void setSflag(boolean sflag)
  {
    this.sflag = sflag;
  }
  public Collection<Merchant> getMerchantsCollection()
  {
    return merchantsCollection;
  }
  public void setMerchantsCollection(Collection<Merchant> merchantsCollection)
  {
    this.merchantsCollection = merchantsCollection;
  }
  
  
}
