package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.serviceException.IdNotFoundException;
import entity.EmployeeDetails;
import entity.TrackDetail;
import service.ServiceImp;

public class Employee {
	public static void main(String[] args) throws IdNotFoundException {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		boolean condition=true;
		ServiceImp ob=new ServiceImp();
		List<EmployeeDetails> emp=new ArrayList<EmployeeDetails>();
		List<TrackDetail> list = new ArrayList<TrackDetail>();
		while(condition)
		{
			System.out.println("--------------------------------------------");
			System.out.println("1.insert data\n2.delete data\n3.update phone number\n4.get list of campus minds are in specific track");
			System.out.println("---------------------------------------------");
			System.out.println("enter choice: ");
			choice=sc.nextInt();
			switch(choice) 
			{
			case 1:
				ob.getDetails(emp);
				break;
			case 2:
				ob.delete(emp);
				break;
			case 3:
				try {
					ob.updatePhoneNum(emp);
				} catch (IdNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				ob.getList(emp, list);
				break;
			case 5:
				condition=false;
				break;
			default:
				System.out.println("invalid choice");
			}
		}
	}

}
