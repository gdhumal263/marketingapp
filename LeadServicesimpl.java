package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entities.Lead;
import com.marketing.repositries.LeadRepository;
@Service
public class LeadServicesimpl implements LeadServices 
{
	@Autowired
	private LeadRepository leadRepo;
	@Override
	public void saveLeadInfo(Lead lead) 
	{
		leadRepo.save(lead);

	}
	@Override
	public List<Lead> getLeads() 
	{
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
	@Override
	public void deleteLead(long id) 
	{
		leadRepo.deleteById(14L);
		
	}
	@Override
	public Lead updateLead(long id)
	{
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
	
}
