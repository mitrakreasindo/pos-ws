package com.mitrakreasindo.pos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
import com.mitrakreasindo.pos.entities.Sale;
import com.mitrakreasindo.pos.entities.SalesPack;
import com.mitrakreasindo.pos.util.GeneralFunction;

@Service
public class SalesServiceImpl extends BaseServiceImpl<SalesPack> implements SalesService
{

	public SalesServiceImpl()
	{
		super(SalesPack.class);
	}

	@Override
	public HashMap<Integer, String> post(SalesPack salesPack)
	{
    String receiptsJson = GeneralFunction.convert2Json(salesPack.getReceipts());
    String salesJson = GeneralFunction.convert2Json(salesPack.getSales());
    String salesItemsJson = GeneralFunction.convert2Json(salesPack.getSalesItems());
    String stockDiaryJson = GeneralFunction.convert2Json(salesPack.getStockdiary());
    String paymentsJson = GeneralFunction.convert2Json(salesPack.getPayments());
    String taxlinesJson = GeneralFunction.convert2Json(salesPack.getTaxlines());

    MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("receipts_json", receiptsJson);
		param.addValue("sales_json", salesJson);
		param.addValue("sales_items_json", salesItemsJson);
		param.addValue("stockdiary_json", stockDiaryJson);
		param.addValue("payments_json", paymentsJson);
		param.addValue("taxline_json", taxlinesJson);
		
		return executeProcedure("insert_sales_new", param);
		
    //Use native query to execute sp with json input
//    Query q = entityManager.createNativeQuery("SELECT * FROM insert_sales_new"
//            + "("
//            + "'"+receiptsJson+"',"
//            + "'"+salesJson+"',"
//            + "'"+salesItemsJson+"',"
//            + "'"+stockDiaryJson+"',"
//            + "'"+paymentsJson+"',"
//            + "'"+taxlinesJson+"'"
//            + ")");
//    
//    
//
//    try
//    {
//      //q.getSingleResult().getClass();
//      Object[] obj = (Object[]) q.getSingleResult();
//      
//      
//      //List obj = q.getResultList();
//      System.out.println(obj[0]);
//      System.out.println(obj[1]);
//     
//      
//      result.put((Integer)obj[0], obj[1].toString());
//      return result;
//    }
//    catch (Exception e)
//    {
//      result.put(1, "Transaksi sales gagal "+e.getMessage());
//      return result;
//    }
    
	}
	
	@Override
	public List<Sale> findSalesByPeopleId(String peopleId)
	{
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM sales as s WHERE s.person = '" + peopleId + "'", Sale.class);
		return query.getResultList();
	}

}
