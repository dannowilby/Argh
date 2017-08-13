package lib.manual;

import java.util.ArrayList;

public class ArghManual 
{
	
	private static ArghManual manual = new ArghManual();
	
	private ArrayList<IManualPage> pages;
	
	public ArghManual()
	{
		pages = new ArrayList<IManualPage>();
	}
	
	public static ArghManual getInstance()
	{
		return manual;
	}
	
	public void addPage(IManualPage page)
	{
		pages.add(page);
	}
	
	public int getPageCount()
	{
		return pages.size();
	}
	
	public IManualPage getPageAt(int i)
	{
		return pages.get(i);
	}
	
	public ArrayList<IManualPage> getPageList()
	{
		return pages;
	}
	
}
