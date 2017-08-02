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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * @author miftakhul
 *
 */
@Entity
@Table(name = "products")
public class Product implements Serializable
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @NotNull
  @Column(name = "id")
  private String id;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @OneToMany(mappedBy = "product")
  private Collection<SalesItem> salesItemsCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
  private Collection<StockDiary> stockdiaryCollection;
  @NotNull
  @Column(name = "reference")
  private String reference;
  @NotNull
  @Column(name = "code")
  private String code;
  @Column(name = "codetype")
  private String codetype;
  @NotNull
  @Column(name = "name")
  private String name;
  @NotNull
  @Column(name = "pricebuy")
  private double pricebuy;
  @NotNull
  @Column(name = "pricesell")
  private double pricesell;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "stockcost")
  private Double stockcost;
  @Column(name = "stockvolume")
  private Double stockvolume;
  @NotNull
  @Column(name = "iscom")
  private boolean iscom;
  @NotNull
  @Column(name = "isscale")
  private boolean isscale;
  @NotNull
  @Column(name = "iskitchen")
  private boolean iskitchen;
  @NotNull
  @Column(name = "printkb")
  private boolean printkb;
  @NotNull
  @Column(name = "sendstatus")
  private boolean sendstatus;
  @NotNull
  @Column(name = "isservice")
  private boolean isservice;
  @Column(name = "display")
  private String display;
  @NotNull
  @Column(name = "isvprice")
  private boolean isvprice;
  @NotNull
  @Column(name = "isverpatrib")
  private boolean isverpatrib;
  @Column(name = "texttip")
  private String texttip;
  @NotNull
  @Column(name = "warranty")
  private boolean warranty;
  @NotNull
  @Column(name = "stockunits")
  private double stockunits;
  @Column(name = "alias")
  private String alias;
  @NotNull
  @Column(name = "alwaysavailable")
  private boolean alwaysavailable;
  @Column(name = "discounted")
  private String discounted;
  @NotNull
  @Column(name = "candiscount")
  private boolean candiscount;
  @Column(name = "iscatalog")
  private Boolean iscatalog;
  @Column(name = "catorder")
  private Integer catorder;
  @NotNull
  @Column(name = "ispack")
  private boolean ispack;
  @Column(name = "packquantity")
  private Double packquantity;
  @Column(name = "allproducts")
  private Boolean allproducts;
  @Column(name = "managestock")
  private Boolean managestock;
  @NotNull
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributeset_id", referencedColumnName = "id")
  @ManyToOne
  private AttributeSet attributesetId;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Category category;
  @OneToMany(mappedBy = "packproduct")
  private Collection<Product> productsCollection;
  @JoinColumn(name = "packproduct", referencedColumnName = "id")
  @ManyToOne
  private Product packproduct;
  @JoinColumn(name = "promotionid", referencedColumnName = "id")
  @ManyToOne
  private Promotion promotionid;
  @JoinColumn(name = "taxcat", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private TaxCategory taxcat;
  
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public byte[] getAttributes()
  {
    return attributes;
  }
  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }
  public byte[] getImage()
  {
    return image;
  }
  public void setImage(byte[] image)
  {
    this.image = image;
  }
  public Collection<SalesItem> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }
  public void setSalesItemsCollection(Collection<SalesItem> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  public Collection<StockDiary> getStockdiaryCollection()
  {
    return stockdiaryCollection;
  }
  public void setStockdiaryCollection(Collection<StockDiary> stockdiaryCollection)
  {
    this.stockdiaryCollection = stockdiaryCollection;
  }
  public String getReference()
  {
    return reference;
  }
  public void setReference(String reference)
  {
    this.reference = reference;
  }
  public String getCode()
  {
    return code;
  }
  public void setCode(String code)
  {
    this.code = code;
  }
  public String getCodetype()
  {
    return codetype;
  }
  public void setCodetype(String codetype)
  {
    this.codetype = codetype;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public double getPricebuy()
  {
    return pricebuy;
  }
  public void setPricebuy(double pricebuy)
  {
    this.pricebuy = pricebuy;
  }
  public double getPricesell()
  {
    return pricesell;
  }
  public void setPricesell(double pricesell)
  {
    this.pricesell = pricesell;
  }
  public Double getStockcost()
  {
    return stockcost;
  }
  public void setStockcost(Double stockcost)
  {
    this.stockcost = stockcost;
  }
  public Double getStockvolume()
  {
    return stockvolume;
  }
  public void setStockvolume(Double stockvolume)
  {
    this.stockvolume = stockvolume;
  }
  public boolean isIscom()
  {
    return iscom;
  }
  public void setIscom(boolean iscom)
  {
    this.iscom = iscom;
  }
  public boolean isIsscale()
  {
    return isscale;
  }
  public void setIsscale(boolean isscale)
  {
    this.isscale = isscale;
  }
  public boolean isIskitchen()
  {
    return iskitchen;
  }
  public void setIskitchen(boolean iskitchen)
  {
    this.iskitchen = iskitchen;
  }
  public boolean isPrintkb()
  {
    return printkb;
  }
  public void setPrintkb(boolean printkb)
  {
    this.printkb = printkb;
  }
  public boolean isSendstatus()
  {
    return sendstatus;
  }
  public void setSendstatus(boolean sendstatus)
  {
    this.sendstatus = sendstatus;
  }
  public boolean isIsservice()
  {
    return isservice;
  }
  public void setIsservice(boolean isservice)
  {
    this.isservice = isservice;
  }
  public String getDisplay()
  {
    return display;
  }
  public void setDisplay(String display)
  {
    this.display = display;
  }
  public boolean isIsvprice()
  {
    return isvprice;
  }
  public void setIsvprice(boolean isvprice)
  {
    this.isvprice = isvprice;
  }
  public boolean isIsverpatrib()
  {
    return isverpatrib;
  }
  public void setIsverpatrib(boolean isverpatrib)
  {
    this.isverpatrib = isverpatrib;
  }
  public String getTexttip()
  {
    return texttip;
  }
  public void setTexttip(String texttip)
  {
    this.texttip = texttip;
  }
  public boolean isWarranty()
  {
    return warranty;
  }
  public void setWarranty(boolean warranty)
  {
    this.warranty = warranty;
  }
  public double getStockunits()
  {
    return stockunits;
  }
  public void setStockunits(double stockunits)
  {
    this.stockunits = stockunits;
  }
  public String getAlias()
  {
    return alias;
  }
  public void setAlias(String alias)
  {
    this.alias = alias;
  }
  public boolean isAlwaysavailable()
  {
    return alwaysavailable;
  }
  public void setAlwaysavailable(boolean alwaysavailable)
  {
    this.alwaysavailable = alwaysavailable;
  }
  public String getDiscounted()
  {
    return discounted;
  }
  public void setDiscounted(String discounted)
  {
    this.discounted = discounted;
  }
  public boolean isCandiscount()
  {
    return candiscount;
  }
  public void setCandiscount(boolean candiscount)
  {
    this.candiscount = candiscount;
  }
  public Boolean getIscatalog()
  {
    return iscatalog;
  }
  public void setIscatalog(Boolean iscatalog)
  {
    this.iscatalog = iscatalog;
  }
  public Integer getCatorder()
  {
    return catorder;
  }
  public void setCatorder(Integer catorder)
  {
    this.catorder = catorder;
  }
  public boolean isIspack()
  {
    return ispack;
  }
  public void setIspack(boolean ispack)
  {
    this.ispack = ispack;
  }
  public Double getPackquantity()
  {
    return packquantity;
  }
  public void setPackquantity(Double packquantity)
  {
    this.packquantity = packquantity;
  }
  public Boolean getAllproducts()
  {
    return allproducts;
  }
  public void setAllproducts(Boolean allproducts)
  {
    this.allproducts = allproducts;
  }
  public Boolean getManagestock()
  {
    return managestock;
  }
  public void setManagestock(Boolean managestock)
  {
    this.managestock = managestock;
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
  public AttributeSet getAttributesetId()
  {
    return attributesetId;
  }
  public void setAttributesetId(AttributeSet attributesetId)
  {
    this.attributesetId = attributesetId;
  }
  public Category getCategory()
  {
    return category;
  }
  public void setCategory(Category category)
  {
    this.category = category;
  }
  public Collection<Product> getProductsCollection()
  {
    return productsCollection;
  }
  public void setProductsCollection(Collection<Product> productsCollection)
  {
    this.productsCollection = productsCollection;
  }
  public Product getPackproduct()
  {
    return packproduct;
  }
  public void setPackproduct(Product packproduct)
  {
    this.packproduct = packproduct;
  }
  public Promotion getPromotionid()
  {
    return promotionid;
  }
  public void setPromotionid(Promotion promotionid)
  {
    this.promotionid = promotionid;
  }
  public TaxCategory getTaxcat()
  {
    return taxcat;
  }
  public void setTaxcat(TaxCategory taxcat)
  {
    this.taxcat = taxcat;
  }
  
  
}
