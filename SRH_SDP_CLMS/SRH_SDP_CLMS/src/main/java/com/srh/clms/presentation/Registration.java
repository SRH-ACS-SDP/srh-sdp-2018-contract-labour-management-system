package com.srh.clms.presentation;
import com.srh.clms.businesslogic.*;
import com.srh.clms.exception.*;
import com.srh.clms.entities.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Registration {
	
	
	public static void main(String args[])
	{
		double balance;
		int mode;
		double accountNumber;
		boolean flag=true;
		boolean no_go = false;
		//user details
		String firstName;
		String lastName;
		String address;
		String contactNo;
		String emailId;
		String userName;
		String password;
		String cindate;
		//contractor
		
		Scanner sc=new Scanner(System.in);
		DetailInfo detailInfo=new DetailInfo();
		System.out.println("How do you like to register");
		System.out.println("1.Builder");
		System.out.println("2.Contractor");
		System.out.println("3.Labourer");
		int option = sc.nextInt();   
		
		System.out.println("Enter your first name ");
		 firstName = sc.next();
	
		System.out.println("Enter your last name");
		 lastName = sc.next();
	
		System.out.println("Enter your Address ");
	     address = sc.next();
	     
		System.out.println("Enter your Contact No ");
		 contactNo = sc.next();
		
		System.out.println("Enter your Email id ");
		  emailId = sc.next();
		  
		  		
		System.out.println("Enter your User name ");
	         userName = sc.next();
	         
		System.out.println("Enter your password ");
		 password = sc.next();
		
		/*System.out.println("Enter your Date of Birth in (dd/mm/yy)");
		 try {
		        cindate = sc.next();
		        detailInfo.setBirthDate(cindate);
		        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		        java.util.Date date1 = myFormat.parse(cindate);
		        String indate = myFormat.format(date1);
		        
		    } catch(Exception e)
		 {
		    	e.printStackTrace();
		 }*/
		    System.out.println("Enter your gender ");
			char gender = sc.next().charAt(0); 
			
			 System.out.println("Enter path for user image ");
			 //userImage = sc.nextLine();
			 System.out.println("Enter path for user Type ");
			 String userType = sc.next();
			 
			 System.out.println("Enter proferating  ");
		      int rating = sc.nextInt();
		      
		
		Contractor contractor=new Contractor();
		BusinessLogicLayer bll = new BusinessLogicLayer();
		do {
			switch (option) {
			case 1 :
				//no_go = register_builder();
				break;
			case 2 :
				int contractorType;
				String typeDesc;
				String skill;
				int experience;
				contractor.setFirstName(firstName);
				contractor.setLastName(lastName);
				contractor.setAddress(address);
				contractor.setContact(contactNo);
				contractor.setEmail(emailId);
				contractor.setUsername(userName);
				contractor.setPassword(password);
				contractor.setGender(gender);
				contractor.setUserType(userType);
				contractor.setRating(rating);
				System.out.println("Enter the type:");
				contractorType=sc.nextInt();
				contractor.setContractorType(contractorType);
				System.out.println("Please describe your work:");
				typeDesc=sc.next();
				contractor.setTypeDesc(typeDesc);
				System.out.println("Please describe your skills:");
				skill=sc.next();
				contractor.setSkill(skill);
				System.out.println("Please describe your experience:");
				experience=sc.nextInt();
				contractor.setExperience(experience);
				flag = bll.addContractor(contractor);
				break;
			case 3 :
				//no_go = register_labourer();
				break;
			 default :
				 no_go = false;
				break;
			}
			}while(no_go = false);
		
		
		
       
		

	
}


}
