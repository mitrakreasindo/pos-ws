package com.mitrakreasindo.pos.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "people")
public class People implements Serializable 
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
  private Collection<Sale> salesCollection;
  @Column(name = "name")
  private String name;
  @Column(name = "apppassword")
  private String apppassword;
  @Transient
  private String oldPassword;
  @Column(name = "card")
  private String card;
  @NotNull
  @Column(name = "visible")
  private boolean visible;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Column(name = "email")
  private String email;
  @Column(name = "fullname")
  private String fullname;
  @Column(name = "personal_id_type")
  private String personalIdType;
  @Column(name = "personal_id")
  private String personalId;
  @Column(name = "npwp_pribadi")
  private String npwpPribadi;
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "gender")
  private String gender;
  @Column(name = "birthdate")
  @Temporal(TemporalType.DATE)
  private Date birthdate;
  @JoinColumn(name = "role", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Role role;
  
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
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getApppassword()
  {
    return apppassword;
  }
  public void setApppassword(String apppassword)
  {
    this.apppassword = apppassword;
  }
	public String getOldPassword()
	{
		return oldPassword;
	}
	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}
	public String getCard()
  {
    return card;
  }
  public void setCard(String card)
  {
    this.card = card;
  }
  public boolean isVisible()
  {
    return visible;
  }
  public void setVisible(boolean visible)
  {
    this.visible = visible;
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
  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getFullname()
  {
    return fullname;
  }
  public void setFullname(String fullname)
  {
    this.fullname = fullname;
  }
  public String getPersonalIdType()
  {
    return personalIdType;
  }
  public void setPersonalIdType(String personalIdType)
  {
    this.personalIdType = personalIdType;
  }
  public String getPersonalId()
  {
    return personalId;
  }
  public void setPersonalId(String personalId)
  {
    this.personalId = personalId;
  }
  public String getNpwpPribadi()
  {
    return npwpPribadi;
  }
  public void setNpwpPribadi(String npwpPribadi)
  {
    this.npwpPribadi = npwpPribadi;
  }
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
  public String getGender()
  {
    return gender;
  }
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  public Date getBirthdate()
  {
    return birthdate;
  }
  public void setBirthdate(Date birthdate)
  {
    this.birthdate = birthdate;
  }
  public Role getRole()
  {
    return role;
  }
  public void setRole(Role role)
  {
    this.role = role;
  }
  
  
	
}
