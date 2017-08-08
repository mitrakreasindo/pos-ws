package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "customers")
public class Customer implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @OneToMany(mappedBy = "customer")
  private Collection<Sale> salesCollection;
  @NotNull
  @Column(name = "searchkey")
  private String searchkey;
  @Column(name = "taxid")
  private String taxid;
  @NotNull
  @Column(name = "name")
  private String name;
  @Column(name = "card")
  private String card;
  @NotNull
  @Column(name = "maxdebt")
  private double maxdebt;
  @Column(name = "address")
  private String address;
  @Column(name = "address2")
  private String address2;
  @Column(name = "postal")
  private String postal;
  @Column(name = "city")
  private String city;
  @Column(name = "region")
  private String region;
  @Column(name = "country")
  private String country;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Column(name = "email")
  private String email;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Column(name = "phone")
  private String phone;
  @Column(name = "phone2")
  private String phone2;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Column(name = "fax")
  private String fax;
  @Column(name = "notes")
  private String notes;
  @NotNull
  @Column(name = "visible")
  private boolean visible;
  @Column(name = "curdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date curdate;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "curdebt")
  private Double curdebt;
  @Column(name = "discount")
  private Double discount;
  @Column(name = "dob")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dob;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "taxcategory", referencedColumnName = "id")
  @ManyToOne
  private TaxCustCategory taxcategory;
  
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
  public Collection<Sale> getSalesCollection()
  {
    return salesCollection;
  }
  public void setSalesCollection(Collection<Sale> salesCollection)
  {
    this.salesCollection = salesCollection;
  }
  public String getSearchkey()
  {
    return searchkey;
  }
  public void setSearchkey(String searchkey)
  {
    this.searchkey = searchkey;
  }
  public String getTaxid()
  {
    return taxid;
  }
  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getCard()
  {
    return card;
  }
  public void setCard(String card)
  {
    this.card = card;
  }
  public double getMaxdebt()
  {
    return maxdebt;
  }
  public void setMaxdebt(double maxdebt)
  {
    this.maxdebt = maxdebt;
  }
  public String getAddress()
  {
    return address;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public String getAddress2()
  {
    return address2;
  }
  public void setAddress2(String address2)
  {
    this.address2 = address2;
  }
  public String getPostal()
  {
    return postal;
  }
  public void setPostal(String postal)
  {
    this.postal = postal;
  }
  public String getCity()
  {
    return city;
  }
  public void setCity(String city)
  {
    this.city = city;
  }
  public String getRegion()
  {
    return region;
  }
  public void setRegion(String region)
  {
    this.region = region;
  }
  public String getCountry()
  {
    return country;
  }
  public void setCountry(String country)
  {
    this.country = country;
  }
  public String getFirstname()
  {
    return firstname;
  }
  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }
  public String getLastname()
  {
    return lastname;
  }
  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }
  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getPhone()
  {
    return phone;
  }
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  public String getPhone2()
  {
    return phone2;
  }
  public void setPhone2(String phone2)
  {
    this.phone2 = phone2;
  }
  public String getFax()
  {
    return fax;
  }
  public void setFax(String fax)
  {
    this.fax = fax;
  }
  public String getNotes()
  {
    return notes;
  }
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  public boolean isVisible()
  {
    return visible;
  }
  public void setVisible(boolean visible)
  {
    this.visible = visible;
  }
  public Date getCurdate()
  {
    return curdate;
  }
  public void setCurdate(Date curdate)
  {
    this.curdate = curdate;
  }
  public Double getCurdebt()
  {
    return curdebt;
  }
  public void setCurdebt(Double curdebt)
  {
    this.curdebt = curdebt;
  }
  public Double getDiscount()
  {
    return discount;
  }
  public void setDiscount(Double discount)
  {
    this.discount = discount;
  }
  public Date getDob()
  {
    return dob;
  }
  public void setDob(Date dob)
  {
    this.dob = dob;
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
  public TaxCustCategory getTaxcategory()
  {
    return taxcategory;
  }
  public void setTaxcategory(TaxCustCategory taxcategory)
  {
    this.taxcategory = taxcategory;
  }
  
  
}
