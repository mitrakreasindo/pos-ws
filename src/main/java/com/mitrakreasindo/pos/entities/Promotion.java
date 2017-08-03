/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "promotions")
public class Promotion implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Lob
  @Column(name = "criteria")
  private byte[] criteria;
  @NotNull
  @Lob
  @Column(name = "script")
  private byte[] script;
  @NotNull
  @Column(name = "name")
  private String name;
  @Column(name = "allproducts")
  private Boolean allproducts;
  @Column(name = "isenabled")
  private Boolean isenabled;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JsonIgnore
  @OneToMany(mappedBy = "promotionid", fetch = FetchType.LAZY)
  private Collection<Product> productsCollection;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public byte[] getCriteria()
  {
    return criteria;
  }
  public void setCriteria(byte[] criteria)
  {
    this.criteria = criteria;
  }
  public byte[] getScript()
  {
    return script;
  }
  public void setScript(byte[] script)
  {
    this.script = script;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public Boolean getAllproducts()
  {
    return allproducts;
  }
  public void setAllproducts(Boolean allproducts)
  {
    this.allproducts = allproducts;
  }
  public Boolean getIsenabled()
  {
    return isenabled;
  }
  public void setIsenabled(Boolean isenabled)
  {
    this.isenabled = isenabled;
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
