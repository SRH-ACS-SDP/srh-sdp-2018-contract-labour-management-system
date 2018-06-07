package com.srh.clms.businesslogic;
import com.srh.clms.dataaccess.*;
import com.srh.clms.entities.Contractor;
import com.srh.clms.entities.DetailInfo;
import com.srh.clms.exception.*;

public class BusinessLogicLayer {
	boolean flag =true;
	DataAccessLayer dll = new DataAccessLayer();
	public boolean addContractor(Contractor contractor)
	{    
		
		
		flag=dll.addContractorDLL(contractor);
		return flag;
		
	}
	public boolean addDetailinfo(DetailInfo detailInfo)
	{
		return flag;
	}
}
