package com.mitrakreasindo.pos.service;

import java.util.HashMap;

import javax.persistence.Query;
import org.springframework.stereotype.Service;

import com.mitrakreasindo.pos.core.BaseServiceImpl;
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
	public HashMap<Integer, String> post(String merchantCode, SalesPack salesPack)
	{
		HashMap<Integer, String> result = new HashMap<>();
    String receiptsJson = GeneralFunction.convert2Json(salesPack.getReceipts());
    String salesJson = GeneralFunction.convert2Json(salesPack.getSales());
    String salesItemsJson = GeneralFunction.convert2Json(salesPack.getSalesItems());
    String stockDiaryJson = GeneralFunction.convert2Json(salesPack.getStockdiary());
    String paymentsJson = GeneralFunction.convert2Json(salesPack.getPayments());
    String taxlinesJson = GeneralFunction.convert2Json(salesPack.getTaxlines());
    
    //Use native query to execute sp with json input
    Query q = entityManager.createNativeQuery("SELECT * FROM public.insert_sales_new"
            + "("
            + "'"+receiptsJson+"',"
            + "'"+salesJson+"',"
            + "'"+salesItemsJson+"',"
            + "'"+stockDiaryJson+"',"
            + "'"+paymentsJson+"',"
            + "'"+taxlinesJson+"'"
            + ")");
    
    try
    {
      //q.getSingleResult().getClass();
      Object[] obj = (Object[]) q.getSingleResult();
      
      
      //List obj = q.getResultList();
      System.out.println(obj[0]);
      System.out.println(obj[1]);
     
      
      result.put((Integer)obj[0], obj[1].toString());
      return result;
    }
    catch (Exception e)
    {
      result.put(1, "Transaksi sales gagal");
      return result;
    }
	}

}
