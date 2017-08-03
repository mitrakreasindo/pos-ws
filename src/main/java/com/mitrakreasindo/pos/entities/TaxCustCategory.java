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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "taxcustcategories")
public class TaxCustCategory implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JsonIgnore
  @OneToMany(mappedBy = "custcategory", fetch = FetchType.LAZY)
  private Collection<Tax> taxesCollection;
  @JsonIgnore
  @OneToMany(mappedBy = "taxcategory", fetch = FetchType.LAZY)
  private Collection<Customer> customersCollection;
  
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
  public Collection<Tax> getTaxesCollection()
  {
    return taxesCollection;
  }
  public void setTaxesCollection(Collection<Tax> taxesCollection)
  {
    this.taxesCollection = taxesCollection;
  }
  public Collection<Customer> getCustomersCollection()
  {
    return customersCollection;
  }
  public void setCustomersCollection(Collection<Customer> customersCollection)
  {
    this.customersCollection = customersCollection;
  }
  
}
