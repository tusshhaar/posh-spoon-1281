package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminLoginException;
import com.masai.exception.SeedException;
import com.masai.model.AdminCurrentUserSession;
import com.masai.model.CustomerCurrentUserSession;
import com.masai.model.Seed;
import com.masai.repository.AdminSessionRepo;
import com.masai.repository.CustomerSessionRepo;
import com.masai.repository.SeedRepo;


@Service
public class SeedServiceImpl implements SeedServices{
	@Autowired
    private AdminSessionRepo adminrepo;
	
	@Autowired
	private SeedRepo seedDao;
	
	@Autowired
	private CustomerSessionRepo customer;
	
	@Override
	public Seed addSeed(Seed seed,String key) throws SeedException,AdminLoginException{
		// TODO Auto-generated method stub
		
		AdminCurrentUserSession adminuser=adminrepo.findByAdminUuid(key);
		
		if(adminuser==null) {
			
			throw new AdminLoginException("please login first");
		}
		else {
			
			Seed saved =seedDao.save(seed);
			
			return saved;
		}
			
	}

	@Override
	public Seed updateSeed(Seed seed,String key) throws SeedException,AdminLoginException{

		AdminCurrentUserSession adminUser=adminrepo.findByAdminUuid(key);
		
		if(adminUser==null) {
			
			throw new AdminLoginException("admin details not matched");
		}
		else {
			
			Optional<Seed> opt=seedDao.findById(seed.getSeedId());
			
			if(opt.isPresent()) {
				
				return seedDao.save(seed);
				
			}else {
				
				throw new SeedException("invalid seed details");
			}
		}
		
		
	}
	@Override
	public Seed deleteSeed(Integer id,String key)throws SeedException,AdminLoginException{
		
		AdminCurrentUserSession adminuser=adminrepo.findByAdminUuid(key);
		
		if(adminuser==null) {
			
			throw new AdminLoginException("admin not found");
			
		}
		else {
			
			Optional<Seed> opt=seedDao.findById(id);
			
			if(opt.isPresent()) {
				
				Seed seedAvailable=opt.get();
				seedDao.delete(seedAvailable);
				return seedAvailable;
				
			}
			else
				
			throw new SeedException("student not found that exception : "+id);
		}
		

	}

	@Override
	public Seed viewSeed(Integer id,String Key) throws SeedException,AdminLoginException{
		
		CustomerCurrentUserSession c1=customer.findByCustomerUuid(Key);
		if(c1==null) {
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(Key);
			if(admin1==null) {
				throw new AdminLoginException("user not found ");
			}
		}
			Optional<Seed> opt=seedDao.findById(id);
			if(opt.isPresent()) {
				Seed seed=opt.get();
				return seed;
			}	
			throw new SeedException("seed not found by that "+id);
		}

	@Override
	public Seed viewSeed(String commanName,String key) throws SeedException, AdminLoginException {
		
		CustomerCurrentUserSession c1=customer.findByCustomerUuid(key);
		if(c1==null) {
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			if(admin1==null) {
				throw new AdminLoginException("user not found ");
			}
		}
		Seed seed=seedDao.findByCommanName(commanName);
		
		if(seed==null) {
			throw new SeedException("Please enter valid seed name");
		}
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds(String key) throws SeedException,AdminLoginException {
		
		CustomerCurrentUserSession c1=customer.findByCustomerUuid(key);
		if(c1==null) {
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			if(admin1==null) {
				throw new AdminLoginException("user not found ");
			}
		}
		
		
		List<Seed> seed=seedDao.findAll();
		if(seed.size()==0) {
			throw new SeedException("no seed available");
		}
		else
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds(String TypeOfSeed, String key) throws SeedException, AdminLoginException{
		
		
		CustomerCurrentUserSession c1=customer.findByCustomerUuid(key);
		
		if(c1==null) {
			
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			
			if(admin1==null) {
				
				throw new AdminLoginException("user not found ");
			}
		}
		
		List<Seed> seed=seedDao.findByTypeOfSeed(TypeOfSeed);
		
		if(seed!=null) {
			
			return seed;
		}
		else 
			
		throw new SeedException("no seed available by that name type");	
		
	}

}
