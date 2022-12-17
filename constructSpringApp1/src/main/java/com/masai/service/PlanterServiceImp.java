package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterException;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.CustomerCurrentUserSession;
import com.masai.model.Planter;
import com.masai.repository.AdminSessionRepo;
import com.masai.repository.CustomerSessionRepo;
import com.masai.repository.PlanterRepo;

@Service
public class PlanterServiceImp implements PlanterService{

	@Autowired
	private PlanterRepo planterDao;
	
	@Autowired
	private AdminSessionRepo loginDao;
	
	@Autowired
	private CustomerSessionRepo customerLogin;

	@Override
	public Planter addPlanter(String uuid, Planter planter) throws PlanterException, AdminException{
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Planter saved = planterDao.save(planter);
		if(saved==null) {
			throw new PlanterException("Not able to add planter please check details");
		}return saved;
	}

	@Override
	public Planter updatePlanter(String uuid, Planter planter) throws PlanterException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Planter> opt = planterDao.findById(planter.getPlanterId());
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			updated=planter;
			return planterDao.save(updated);
		}else {
			throw new PlanterException("Planter not found with id : "+planter.getPlanterId());
		}
	}

	@Override
	public Planter deletePlanter(String uuid, Integer planterId) throws PlanterException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Planter> opt = planterDao.findById(planterId);
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			planterDao.delete(updated);
			return updated;
		}else {
			throw new PlanterException("Planter not found with id : "+planterId);
		}
	}
	
	@Override
	public Planter viewPlanter(String uuid, Integer planterId) throws PlanterException ,CustomerException{
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			if(customer==null) {
				throw new CustomerException("Nor Logged in as Customer or Admin");
			}
		}
		Optional<Planter> opt =planterDao.findById(planterId);
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			return updated;
		}else {
			throw new PlanterException("Planter not found with Id : "+planterId);
		}
	}
	
	@Override
	public Planter viewPlanterByShape(String uuid, String planterShape) throws PlanterException,CustomerException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			if(customer==null) {
				throw new CustomerException("Nor Logged in as Customer or Admin");
			}
		}
		Optional<Planter> opt =planterDao.findByPlanterShape(planterShape);
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			return updated;
		}else {
			throw new PlanterException("Planter not found with shape : "+planterShape);
		}
		
	}

	@Override
	public List<Planter> viewAllPlanters(String uuid) throws PlanterException ,CustomerException{
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			if(customer==null) {
				throw new CustomerException("Nor Logged in as Customer or Admin");
			}
		}
		List<Planter> list = planterDao.findAll();
		if(list.size()==0) {
			throw new PlanterException("There are no planters available");
		}
		return list;
	}

	@Override
	public List<Planter> viewAllPlanters(String uuid,Double minCost, Double maxCost) throws PlanterException,CustomerException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			if(customer==null) {
				throw new CustomerException("Nor Logged in as Customer or Admin");
			}
		}
		List<Planter> list = planterDao.findByPlanterBetweenMinAndMax(minCost,maxCost);
		if(list.size()==0) {
			throw new PlanterException("There are no planters available");
		}
		return list;
	}

	
}
