package com.srh.clms.dataaccess;
import com.srh.clms.businesslogic.*;
import com.srh.clms.entities.Accounts;
import com.srh.clms.entities.Contractor;
import com.srh.clms.exception.*;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DataAccessLayer {

	boolean flag= true;

	protected static SessionFactory sessionfactory;

	protected void setup() 
	{
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings from hibernate.cfg.xml

		try 
		{
			sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} 
		catch (Exception e) 
		{
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	protected void exit() 
	{
		sessionfactory.close();
	}
	
	
	public boolean addContractorDLL(Contractor contractor)
	{
		flag=true;
		DataAccessLayer dataAccess= new DataAccessLayer();
		dataAccess.setup();		
		org.hibernate.Session session = sessionfactory.openSession();
	    session.beginTransaction();
	    session.save(contractor);
	    session.getTransaction().commit();
	    session.close();
	    dataAccess.exit();
		
		return flag;
	}
	public boolean addAccountDLL(Accounts account)
	{
		flag=true;
		DataAccessLayer dataAccess= new DataAccessLayer();
		dataAccess.setup();		
		org.hibernate.Session session = sessionfactory.openSession();
	    session.beginTransaction();
	    session.save(account);
	    session.getTransaction().commit();
	    session.close();
	    dataAccess.exit();
		
		return flag;
	}
	
}

