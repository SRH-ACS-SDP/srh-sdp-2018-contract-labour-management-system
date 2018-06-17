package com.srh.clms.presentation;

import java.util.*;
import java.sql.*;
import com.srh.clms.businesslogic.*;
import com.srh.clms.exception.*;
import com.srh.clms.entities.*;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Registration {

	public static void main(String args[]) {
		try {

			Scanner sc = new Scanner(System.in);

			// Objects for all Entities
			DetailInfo info = new DetailInfo();
			Builder builder = new Builder();
			Contractor contractor = new Contractor();
			Work work = new Work();
			Labourer labor = new Labourer();
			Project project = new Project();
			Account account = new Account();
			Attendance attendace = new Attendance();
			Salary salary = new Salary();

			BusinessLogicLayer bll = new BusinessLogicLayer();
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat formatterTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			// account
			double balance;
			int mode;
			String accountNumber;
			boolean flag = false;
			boolean no_go;

			// user-detail-info

			String firstName;
			String lastName;
			String address;
			String contactNo;
			String emailId;
			String userName;
			String password;
			char gender;
			String strBirthDate = null;
			Date birthDate = null;
			Date creationDate = new Date();
			Date updationDate = new Date();
			String workPermitNo;

			// builder

			int builderType;
			String typeDescription;

			// Labourer
			int labType;
			String labWorkDesc;
			String labSkill;
			float labExperience;
			char labAvail;

			// Contractor
			int contType;
			String contTypeDesc;
			String contSkills;
			int contExperience;

			long t = updationDate.getTime();
			java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

			System.out.println("***********WELCOME TO TEAM FORCE's LABOUR MANAGEMENT SYSTEM*************");

			do {

				System.out.print("Do you want to 1.Register 2.Login");
				int select = sc.nextInt();

				switch (select) {
				case 1:

					System.out.println("How do you like to register");
					System.out.println("1.Builder");
					System.out.println("2.Contractor");
					System.out.println("3.Labourer");

					int option = sc.nextInt();

					do {
						flag = true;
						System.out.println("Enter First Name");
						firstName = sc.next();
						flag = validateString(firstName);
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Enter Last Name");
						lastName = sc.next();
						flag = validateString(lastName);
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Gender (M/F)");
						gender = sc.next().charAt(0);
						if (!(gender == 'M' || gender == 'F' || gender == 'm' || gender == 'f')) {
							System.out.println("Invalid Gender");
							flag = false;
						}
					} while (flag == false);

					System.out.println("Enter Address");
					address = sc.next();

					do {
						flag = true;
						System.out.println("Enter Contact Number");
						// sc.next();
						contactNo = sc.next();

						if (!contactNo.matches("^[0-9]{10}$")) {
							flag = false;
							System.out.println("Enter a 10 digit contact number");
						}
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Enter Email");
						emailId = sc.next();
						flag = validateEmail(emailId);
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Enter Username");
						userName = sc.next();
						flag = validateSpecialCharacter(userName);
					} while (flag == false);

					System.out.println("Enter Password");
					password = sc.next();

					do {
						flag = true;
						System.out.println("Enter BirthDate (YYYY/MM/DD) :");
						strBirthDate = sc.next();
						birthDate = formatter.parse(strBirthDate);
						flag = validateFutureDate(birthDate, creationDate);
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Enter Account Number :");
						accountNumber = sc.next();
						flag = validateSpecialCharacter(accountNumber);
					} while (flag == false);

					do {
						flag = true;
						System.out.println("Enter work permit number :");
						workPermitNo = sc.next();
						flag = validateSpecialCharacter(workPermitNo);
					} while (flag == false);

					switch (option) {
					case 1:// Registration for Builder, Contractor ,Labour
						do {
							flag = true;
							System.out.println("Builder Type: 1.Building Construction 2.Road Construction");
							builderType = sc.nextInt();

							if (!(builderType == 1 || builderType == 2)) {
								flag = false;
							}

						} while (flag == false);

						do {
							flag = true;
							System.out.println("Describe your type:");
							typeDescription = sc.next();
							flag = flag = validateSpecialCharacter(accountNumber);
						} while (flag == false);

						builder.setFirstName(firstName);
						builder.setLastName(lastName);
						builder.setAddress(address);
						builder.setGender(gender);
						builder.setEmail(emailId);
						builder.setContact(contactNo);
						builder.setUsername(userName);
						builder.setPassword(password);
						builder.setBirthDate(birthDate);
						builder.setTypeDescription(typeDescription);
						builder.setAccountNumber(accountNumber);
						builder.setDateOfUpdation(sqlTimestamp);
						builder.setBalance(5000);
						builder.setMode("NA");
						builder.setCreationDate(sqlTimestamp);
						builder.setUserType("Builder");
						builder.setBuildType(builderType);

						flag = bll.addBuilder(builder);

						if (flag = true) {
							System.out.print("Builder Added Successfully");
						} else {
							System.out.println("Registration fails");
						}
						break;

					case 2:
						do {
							flag = true;
							System.out.print("Contractor Type:  1.Electrical 2.Civil 3.Painter 4.Mechanical");
							contType = sc.nextInt();

							if (!(contType == 1 || contType == 2 || contType == 3 || contType == 4)) {
								flag = false;
							}

						} while (flag == false);

						System.out.println("Describe your work");
						contTypeDesc = sc.next();

						System.out.println("Enter your skills");
						contSkills = sc.next();

						System.out.println("Enter your Experience");
						contExperience = sc.nextInt();

						contractor.setFirstName(firstName);
						contractor.setLastName(lastName);
						contractor.setAddress(address);
						contractor.setGender(gender);
						contractor.setEmail(emailId);
						contractor.setContact(contactNo);
						contractor.setUsername(userName);
						contractor.setPassword(password);
						contractor.setBirthDate(birthDate);
						contractor.setAccountNumber(accountNumber);
						contractor.setDateOfUpdation(sqlTimestamp);
						contractor.setBalance(5000);
						contractor.setMode("NA");
						contractor.setCreationDate(sqlTimestamp);
						contractor.setUserType("Contractor");
						contractor.setContType(contType);
						contractor.setTypeDesc(contTypeDesc);
						contractor.setSkill(contSkills);
						contractor.setExperience(contExperience);

						flag = bll.addContractor(contractor);

						if (flag == true) {
							System.out.print("Contractor Added Successfully");
						} else {
							System.out.println("Registration fails");
						}

						break;
					case 3:

						do {
							flag = true;
							System.out.println("Labour Type: 1.Electrical 2.Civil 3.Painter 4.Mechanical");
							labType = sc.nextInt();

							if (labType != 1 || labType != 2 || labType != 3 || labType != 4) {
								flag = false;
							}
						} while (false);

						System.out.println("Describe your work");
						labWorkDesc = sc.next();

						System.out.println("Describe your skills");
						labSkill = sc.next();

						System.out.println("Enter your experience in this field ");
						labExperience = sc.nextInt();

						labAvail = 'Y';

						labor.setFirstName(firstName);
						labor.setLastName(lastName);
						labor.setAddress(address);
						labor.setGender(gender);
						labor.setEmail(emailId);
						labor.setContact(contactNo);
						labor.setUsername(userName);
						labor.setPassword(password);
						labor.setBirthDate(birthDate);
						labor.setAccountNumber(accountNumber);
						labor.setDateOfUpdation(sqlTimestamp);
						labor.setBalance(5000);
						labor.setMode("NA");
						labor.setCreationDate(sqlTimestamp);
						labor.setUserType("Labour");
						labor.setLabourType(labType);
						labor.setWorkDescp(labWorkDesc);
						labor.setSkill(labSkill);
						labor.setExperience(labExperience);
						labor.setAvailable(labAvail);
						flag = bll.addLabour(labor);

						if (flag == true) {
							System.out.print("Labor Added Successfully");
						} else {
							System.out.println("Registration fails");
						}
						break;

					default:
						break;
					}
					flag = true;
					break;
				case 2:

					Login userlogin = new Login();
					info = userlogin.userLogin();

					switch (info.getUserType()) {
					case "Builder":

						System.out.println("Do you want to 1.Add Project 2. Add Work  3.Show all works 4.Logout");
						int choice = sc.nextInt();

						System.out.print("In Builder case");
						switch (choice) {
						case 1: // Create new project
							AddProject projectobj = new AddProject();
							projectobj.addProject(info);
							break;
						case 2:// Create new work in perticular project
							AddWork workobj = new AddWork();
							EstimateLabours estLabour = new EstimateLabours();
							System.out.println("************Showing all projects**************");

							bll.displayAllProjectsBLL();
							System.out.println("Select a project in which you want to add work");
							int projid = sc.nextInt();

							System.out.println("***********Estimate labors for your work*********");
							estLabour.labourCount();
							project.setProjectId(projid);
							workobj.addWork(project);

							break;
						case 3: // Display all works in all projects
							System.out.print("********Showing works in all projects**************");
							bll.displayAllWorkBLL();
							break;

						case 4:
							System.out.println("You are logged out ");
							break;

						default:
							System.out.println("Invalid choice");
							break;

						}
						break;

					case "Contractor":
						System.out.print("In Contractor case");

						System.out.print("Do you want to 1.Apply for work 2.Make Payments 3.Logout");
						choice = sc.nextInt();

						switch (choice) {
						case 1:
							System.out.println("******************Showing all works of your type***************");
							bll.displayWorkContractorBLL(contractor.getContType());
							System.out.println("Enter the work id to apply");
							choice = sc.nextInt();
							work.setWorkId(choice);

							work = bll.getWorkByIdBLL(choice);

							bll.applyWorkContractorBLL(work, contractor);

						case 2:
							System.out.println("******************List of Labours with unpaid Salaries**********");
							System.out.println("Press 1.Make Payment 2.Cancel");
							choice = sc.nextInt();

							switch (choice) {
							case 1:
								salary.setRecieveDate(sqlTimestamp);
								bll.displaySalaryBLL(contractor.getInfoId(), salary);
								break;
							case 2:
								break;
							}

						case 3:
							System.out.println("You are logged out ");
							break;
						}

						System.out.println("Select a Work ID to apply for ");

						break;
					case "Labour":
						System.out.print("In Labor case");

						System.out.println("**************Showing all works of your type****************");

						labor = bll.getLabourDetailsBLL(info.getInfoId());

						if (labor.getAvailable() == 'Y') {
							bll.displayWorkLaborBLL(labor.getLabourType());
							System.out.println("Enter the work id to apply");
							choice = sc.nextInt();
							work = bll.getWorkByIdBLL(choice);
							boolean assign = bll.assignWorkLabourBLL(labor, work);
							System.out.println("Labourer updated with work successfully!!");
						} else {
							System.out.println("Enter your attendence for your assigned work(Y/N)");
							char opt = sc.next().charAt(0);
							if (opt == 'y' || opt == 'Y') {

								attendace.setInTime(sqlTimestamp);
								Calendar cal = Calendar.getInstance();
								cal.setTime(sqlTimestamp);
								cal.add(Calendar.HOUR_OF_DAY, 8);
								sqlTimestamp = new java.sql.Timestamp(cal.getTime().getTime());
								attendace.setOutTime(sqlTimestamp);
								attendace.setStatus("Fulltime");

								attendace.setCardId(labor.getCardId());
								attendace.setLabour(labor);
								System.out.println("What payment mode you want 1.Online 2.Cash");
								option = sc.nextInt();

								if (option == 1) {
									salary.setSalaryMode(1);
								} else {
									salary.setSalaryMode(2);
								}
								salary.setStatus("Pending");
								int idWork = labor.getWork().getWorkId();
								float amount = labor.getWork().getLabourRate();
								amount = amount * 8;
								salary.setAmount(amount);
								work = bll.getWorkByIdBLL(idWork);
								contractor = bll.getContractorByWork(work.getContractor().getInfoId());
								account = bll.getAccountDetail(labor.getInfoId());

								boolean save = bll.saveAttendance(labor, attendace, salary, contractor, account);
								System.out.println(save);
								if (save == true) {
									System.out.println("Attendence and Salary Updated");
								} else {
									System.exit(0);
								}
							}

							break;
						}
					}

				}
				while (flag == true)
					;

			} while (flag == true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Function to validate string contains only alphabets
	public static boolean validateString(String input) {
		boolean flag = true;
		if (!input.matches("^[^0-9]+$")) {
			System.out.println("Input should not contain numbers");
			flag = false;
		}

		return flag;
	}

	// Function to validate contact number
	public static boolean validateContactNumber(String contact) {
		boolean flag = true;
		if (!(!contact.matches("^[^0-9]+$") && contact.length() == 10)) {
			System.out.println("Contact No. should be 10 Digit numbers ");
			flag = false;
		}
		return flag;
	}

	// Function to find numbers in string
	public static boolean validateNumber(String number) {
		boolean flag = true;
		if (!(!number.matches("^[^0-9]+$"))) {
			System.out.println("Input should be numbers ");
			flag = false;
		}
		return flag;
	}

	// Function to validate special character in string

	public static boolean validateSpecialCharacter(String value) {
		boolean flag = true;
		if (!(!value.matches("[^\\w\\*]"))) {
			System.out.println("Input should be not contain special characters ");
			flag = false;
		}
		return flag;
	}

	// Validate Email id
	public static boolean validateEmail(String Email) {
		// referred from http://emailregex.com/
		boolean flag = true;
		if (!Email.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			System.out.println("Email should be someone@company.com ");
			flag = false;
		}
		return flag;
	}

	// Validate Date for future date

	public static boolean validateFutureDate(Date inputDate, Date creationDate) {
		boolean flag = true;

		if (inputDate.compareTo(creationDate) > 0) {
			System.out.println("Entered date should not be future date");
		}
		return flag;
	}
}
