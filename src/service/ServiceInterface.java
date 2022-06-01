package service;

import java.util.List;

import Exception.serviceException.IdNotFoundException;
import entity.EmployeeDetails;
import entity.TrackDetail;

public interface ServiceInterface {
	public void getDetails(List<EmployeeDetails> emp);
	public void delete(List<EmployeeDetails> emp) throws IdNotFoundException;
	public void updatePhoneNum(List<EmployeeDetails> emp) throws IdNotFoundException;
	public void getList(List<EmployeeDetails> emp,List<TrackDetail> list);

}
