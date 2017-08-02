/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "merchants")
public class Merchant implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "code")
  private String code;
  @NotNull
  @Column(name = "name")
  private String name;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @NotNull
  @Column(name = "email")
  private String email;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @NotNull
  @Column(name = "phone")
  private String phone;
  @NotNull
  @Column(name = "address")
  private String address;
  @Column(name = "npwpperusahaan")
  private String npwpperusahaan;
  @NotNull
  @Column(name = "sflag")
  private boolean sflag;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne
  private MerchantCategory category;
  
  public String getCode()
  {
    return code;
  }
  public void setCode(String code)
  {
    this.code = code;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
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
  public String getAddress()
  {
    return address;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public String getNpwpperusahaan()
  {
    return npwpperusahaan;
  }
  public void setNpwpperusahaan(String npwpperusahaan)
  {
    this.npwpperusahaan = npwpperusahaan;
  }
  public boolean isSflag()
  {
    return sflag;
  }
  public void setSflag(boolean sflag)
  {
    this.sflag = sflag;
  }
  public MerchantCategory getCategory()
  {
    return category;
  }
  public void setCategory(MerchantCategory category)
  {
    this.category = category;
  }
  
  
  
}
