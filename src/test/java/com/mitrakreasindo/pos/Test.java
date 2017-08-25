/**
 * 
 */
package com.mitrakreasindo.pos;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author mitradev
 *
 */
public class Test
{

	@org.junit.Test
	public void test()
	{
		DecimalFormatSymbols decimalFormatSymbol = new DecimalFormatSymbols();

		decimalFormatSymbol.setCurrencySymbol("Rp. ");
		decimalFormatSymbol.setGroupingSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("#,###", decimalFormatSymbol);
		double m = 5000000;
		System.out.println(decimalFormat.format(m));
	}

}
