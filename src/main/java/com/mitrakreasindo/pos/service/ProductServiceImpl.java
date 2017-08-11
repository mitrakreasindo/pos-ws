package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Product;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService
{

	public ProductServiceImpl()
	{
		super(Product.class);
	}

	@Override
	public HashMap<Integer, String> post(String merchantCode, Product t)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		String validator = "";
		param.addValue("product_id", GeneralFunction.checkNullString(t.getId()));
		param.addValue("product_reference", GeneralFunction.checkNullString(t.getReference()));
		param.addValue("product_code", GeneralFunction.checkNullString(t.getCode()));
		param.addValue("product_codetype", GeneralFunction.checkNullString(t.getCodetype()));
		param.addValue("product_name", GeneralFunction.checkNullString(t.getName()));
		param.addValue("price_buy", t.getPricebuy());
		param.addValue("price_sell", t.getPricesell());

		validator = "";
		if (t.getCategory() != null)
			validator = t.getCategory().getId();
		param.addValue("product_category", validator);

		validator = "";
		if (t.getTaxcat() != null)
			validator = t.getTaxcat().getId();
		param.addValue("tax_category", validator);

		validator = "";
		if (t.getAttributesetId() != null)
			validator = t.getAttributesetId().getId();
		param.addValue("product_attributeset_id", validator);

		param.addValue("stock_cost", t.getStockcost());
		param.addValue("stock_volume", t.getStockvolume());
		param.addValue("is_com", t.isIscom());
		param.addValue("is_scale", t.isIsscale());
		param.addValue("is_kitchen", t.isIskitchen());
		param.addValue("print_kb", t.isPrintkb());
		param.addValue("send_status", t.isSendstatus());
		param.addValue("is_service", t.isIsservice());
		param.addValue("product_display", t.getDisplay());
		param.addValue("product_attributes", GeneralFunction.checkNullByte(t.getAttributes()));
		param.addValue("is_vprice", t.isIsvprice());
		param.addValue("is_verpatrib", t.isIsverpatrib());
		param.addValue("text_tip", GeneralFunction.checkNullString(t.getTexttip()));
		param.addValue("product_warranty", t.isWarranty());
		param.addValue("product_image", GeneralFunction.checkNullByte(t.getImage()));
		param.addValue("stock_units", t.getStockunits());
		param.addValue("product_alias", GeneralFunction.checkNullString(t.getAlias()));
		param.addValue("always_available", t.isAlwaysavailable());
		param.addValue("product_discounted", GeneralFunction.checkNullString(t.getDiscounted()));
		param.addValue("can_discount", t.isCandiscount());
		param.addValue("is_catalog", t.getIscatalog());
		param.addValue("cat_order", t.getCatorder());
		param.addValue("is_pack", t.isIspack());
		param.addValue("pack_quantity", t.getPackquantity());

		validator = "";
		if (t.getPackproduct() != null)
			validator = t.getPackproduct().getId();
		param.addValue("pack_product", validator);

		validator = "";
		if (t.getPromotionid() != null)
			validator = t.getPromotionid().getId();
		param.addValue("promotion_id", validator);
		param.addValue("all_products", t.getAllproducts());
		param.addValue("manage_stock", t.getManagestock());
		return executeProcedure("insert_product", merchantCode, param);
	}

	@Override
	public HashMap<Integer, String> put(String merchantCode, String id, Product t)
	{
  	MapSqlParameterSource param = new MapSqlParameterSource();
  	String validator = "";
  	param.addValue("product_id", GeneralFunction.checkNullString(t.getId()));
  	param.addValue("product_reference", GeneralFunction.checkNullString(t.getReference()));
  	param.addValue("product_code", GeneralFunction.checkNullString(t.getCode()));
  	param.addValue("product_codetype", GeneralFunction.checkNullString(t.getCodetype()));
  	param.addValue("product_name", GeneralFunction.checkNullString(t.getName()));
  	param.addValue("price_buy", t.getPricebuy());
  	param.addValue("price_sell", t.getPricesell());
    
    validator = "";
    if(t.getCategory() != null) validator = t.getCategory().getId();
    param.addValue("product_category", validator);
    
    validator = "";
    if(t.getTaxcat() != null) validator = t.getTaxcat().getId();
    param.addValue("tax_category", validator);
    
    validator = "";
    if(t.getAttributesetId() != null) validator = t.getAttributesetId().getId();
    param.addValue("product_attributeset_id", validator);
    
    param.addValue("stock_cost", t.getStockcost());
    param.addValue("stock_volume", t.getStockvolume());
    param.addValue("is_com", t.isIscom());
    param.addValue("is_scale", t.isIsscale());
    param.addValue("is_kitchen", t.isIskitchen());
    param.addValue("print_kb", t.isPrintkb());
    param.addValue("send_status", t.isSendstatus());
    param.addValue("is_service", t.isIsservice());
    param.addValue("product_display", t.getDisplay());
    param.addValue("product_attributes", GeneralFunction.checkNullByte(t.getAttributes()));
    param.addValue("is_vprice", t.isIsvprice());
    param.addValue("is_verpatrib", t.isIsverpatrib());
    param.addValue("text_tip", GeneralFunction.checkNullString(t.getTexttip()));
    param.addValue("product_warranty", t.isWarranty());
    param.addValue("product_image", GeneralFunction.checkNullByte(t.getImage()));
    param.addValue("stock_units", t.getStockunits());
    param.addValue("product_alias", GeneralFunction.checkNullString(t.getAlias()));
    param.addValue("always_available", t.isAlwaysavailable());
    param.addValue("product_discounted", GeneralFunction.checkNullString(t.getDiscounted()));
    param.addValue("can_discount", t.isCandiscount());
    param.addValue("is_catalog", t.getIscatalog());
    param.addValue("cat_order", t.getCatorder());
    param.addValue("is_pack", t.isIspack());
    param.addValue("pack_quantity", t.getPackquantity());
    
    validator = "";
    if(t.getPackproduct() != null) validator = t.getPackproduct().getId();
    param.addValue("pack_product", validator);
    
    validator = "";
    if(t.getPromotionid() != null) validator = t.getPromotionid().getId();
    param.addValue("promotion_id", validator);
    param.addValue("all_products", t.getAllproducts());
    param.addValue("manage_stock", t.getManagestock());
  	return executeProcedure("update_product", merchantCode, param);
	}

	@Override
	public HashMap<Integer, String> delete(String merchantCode, String id)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id", id);
		return executeProcedure("delete_product", merchantCode, param);
	}

}
