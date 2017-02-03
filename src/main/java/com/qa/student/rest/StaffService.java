package com.qa.student.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.qa.student.model.Person;
import com.qa.student.model.Staff;

@Path("/staff")
@RequestScoped
public class StaffService {

	private static final Logger STAFFLOGGER = Logger.getLogger( StaffService.class.getName() );
	
	@Inject
	EntityManager em;
	
	@Inject
	Gson gs;
	
	public void addStaff(Staff staff) // add via object
	{
		Staff existingCheck = em.find(Staff.class, staff);
		if(staff != null && existingCheck == null)
		{
			em.persist(staff);			
			STAFFLOGGER.info("Staff Added - from com.qa.student.rest/StaffService/addStaff");
		}
		else
			STAFFLOGGER.info("Staff Added - from com.qa.student.rest/StaffService/addStaff");
	}
	
	public void addStaff(String json){ //add via json string
		this.addStaff(gs.fromJson(json, Staff.class));
	}
		
	public void addStaff(String role, Person pers){ // add via object
		this.addStaff(new Staff(role, pers));
	}
		
	public String getStaff(int id){	
		Staff staff = em.find(Staff.class, id);
		if(staff!=null){
			STAFFLOGGER.info("Staff returned - from com.qa.student.rest/StaffService/getStaff(int id)");
			return gs.toJson(staff);
		}
		else{
			STAFFLOGGER.info("ERRORS: Staff NOT returned - from com.qa.student.rest/StaffServiceStaffService/getStaff(int id)");
			return "";
		}
	}
	
	public Staff getStaffObj(int id){	
		Staff staff = em.find(Staff.class, id);
		if(staff!=null){
			STAFFLOGGER.info("Staff returned - from com.qa.student.rest/StaffService/getStaff(int id)");
			return staff;
		}
		else{
			STAFFLOGGER.info("ERRORS: Staff NOT returned - from com.qa.student.rest/StaffServiceStaffService/getStaff(int id)");
			return null;
		}
	}
	
	
	public String getAllStaffStr(){
		Query dbQ = em.createQuery("SELECT s FROM Staff s");
		String jsonStaff = gs.toJson(dbQ.getResultList());
		if(jsonStaff!=null){
			STAFFLOGGER.info("ALL Staff returned - from com.qa.student.rest/StaffServiceStaffService/getAllStaffStr(int id)");
			return jsonStaff;		
		}
		else{
			STAFFLOGGER.info("ERRORS: ALL Staff NOT returned - from com.qa.student.rest/StaffServiceStaffService/getAllStaffStr(int id)");
			return "";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Staff> getAllStaffList(){
		List<Staff> staffList = em.createQuery("SELECT s FROM Staff s").getResultList();
		return staffList;
	}

	public void updateStaff(Staff staff)
	{
		Staff checkExists = em.find(Staff.class, staff.getIdStaff());
		if(checkExists != null){
			em.merge(staff);
			STAFFLOGGER.info("Existing staff updated - from com.qa.student.rest/StaffService/updateStaff");
		}
		else
			STAFFLOGGER.info("Staff doesnt exist in database - from com.qa.student.rest/StaffService/updateStaff");
			
	
	}
	
	public void updateStaff(int id, String role)
	{
		this.updateStaff(new Staff(id, role));
	}
	
	public void deleteStaff(Staff staff)
	{
		Staff existingCheck = em.find(Staff.class, staff);
		if(staff != null && existingCheck == null)
		{
			em.remove(staff);			
			STAFFLOGGER.info("Staff Deleted - from com.qa.student.rest/StaffService/deleteStaff");
		}
		else
			STAFFLOGGER.info("Staff NOT Deleted - from com.qa.student.rest/StaffService/deleteStaff");
	}

	public void deleteStaff(String js)
	{
		Staff stff = gs.fromJson(js, Staff.class);
		this.updateStaff(stff);
	}
}
