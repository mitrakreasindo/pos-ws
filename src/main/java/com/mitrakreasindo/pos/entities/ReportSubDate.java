/**
 * 
 */
package com.mitrakreasindo.pos.entities;

import java.util.Date;
import java.util.List;

/**
 * @author mitradev
 *
 */
public class ReportSubDate<T>
{

	private Date date;	
	private List<T> subReport;
	
	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}
	/**
	 * @return the subReport
	 */
	public List<T> getSubReport()
	{
		return subReport;
	}
	/**
	 * @param subReport the subReport to set
	 */
	public void setSubReport(List<T> subReport)
	{
		this.subReport = subReport;
	}
		
}
