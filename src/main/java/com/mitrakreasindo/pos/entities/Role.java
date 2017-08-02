/**
 * 
 */
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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "permissions")
  private byte[] permissions;
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "rightslevel")
  private int rightslevel;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
  private Collection<People> peopleCollection;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public byte[] getPermissions()
  {
    return permissions;
  }
  public void setPermissions(byte[] permissions)
  {
    this.permissions = permissions;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public int getRightslevel()
  {
    return rightslevel;
  }
  public void setRightslevel(int rightslevel)
  {
    this.rightslevel = rightslevel;
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
  public Collection<People> getPeopleCollection()
  {
    return peopleCollection;
  }
  public void setPeopleCollection(Collection<People> peopleCollection)
  {
    this.peopleCollection = peopleCollection;
  }
  
}
