/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.io.Serializable;

/**
 * @author miftakhul
 *
 */
public class MerchantRegistration implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  private Merchant merchant;
  private People people;
  
  public Merchant getMerchant()
  {
    return merchant;
  }
  public void setMerchant(Merchant merchant)
  {
    this.merchant = merchant;
  }
  public People getPeople()
  {
    return people;
  }
  public void setPeople(People people)
  {
    this.people = people;
  }  
  
}
