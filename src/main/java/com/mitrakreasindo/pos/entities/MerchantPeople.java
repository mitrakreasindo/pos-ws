/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "merchant_people")
public class MerchantPeople implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "person_id")
  private String personId;
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
  public String getPersonId()
  {
    return personId;
  }
  public void setPersonId(String personId)
  {
    this.personId = personId;
  }
  
  
  
}
