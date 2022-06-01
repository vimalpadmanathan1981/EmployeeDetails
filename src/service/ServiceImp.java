package service;

import java.util.List;
import java.util.Scanner;

import Exception.serviceException.IdNotFoundException;
import dao.DaoImp;
import entity.EmployeeDetails;
import entity.TrackDetail;

public class ServiceImp implements ServiceInterface {
	Scanner sc=new Scanner(System.in);
	DaoImp ob=new DaoImp();
	
	
	public void getDetails(List<EmployeeDetails> emp) {
		System.out.println("enter id: ");
		int id=ValidateInputs.intValidate();
		System.out.println("enter name: ");
		String name=sc.next();
		name=ValidateInputs.stringValidate(name);
		System.out.println("enter track: ");
		String track=sc.next();
		track=ValidateInputs.stringValidate(track);
		int noOfMinds=ob.retrieveValue(track);
		System.out.println("enter phone number: ");
		int mobile=ValidateInputs.intValidate();
		System.out.println("enter role: ");
		String role=sc.next();
		role=ValidateInputs.stringValidate(role);
		emp.add(new EmployeeDetails(id,name,new TrackDetail(track,0),mobile,role));
		
		ob.insertDb(id,name,track,mobile,role);
	}
	
	
	public void delete(List<EmployeeDetails> emp) throws IdNotFoundException{
		try {
		System.out.println("enter the id of employee u wanna delete: ");
		int id=ValidateInputs.intValidate();
		emp.removeIf(n-> (n.getId()==id));
		ob.deleteDb(id);
		}catch(Exception e) {
			throw new IdNotFoundException("id not found");
			//System.out.println("id not found");
		}
	}
	
	
	public void updatePhoneNum(List<EmployeeDetails> emp) throws IdNotFoundException {
		try {
		System.out.println("enter the id of employee: ");
		int id=ValidateInputs.intValidate();
		System.out.println("enter updated mobile number: ");
		int num=ValidateInputs.intValidate();
		for(EmployeeDetails list:emp) {
			if(list.getId()==id) {
				list.setPhoneNumber(num);
				System.out.println("updated");
			}
		}
		ob.update(id,num);
		}catch(Exception e) {
			throw new IdNotFoundException("id not found");
		}
	}

	
	public void getList(List<EmployeeDetails> emp,List<TrackDetail> l) {
	    int count = 0;
		System.out.println("enter the track name: ");
		String track=sc.next();
		track=ValidateInputs.stringValidate(track);
		for(EmployeeDetails list:emp) {
			if(list.getTrack().equals(track)) {
				count++;
			}
		}
		ob.getTrack(track,  l);
	}

}
