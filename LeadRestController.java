package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.repositries.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController
{
	@Autowired
	private LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> getAllLead()
	{
		List<Lead> leads=leadRepo.findAll();
		
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead)
	{
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead)
	{
		leadRepo.save(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delteOneLead(@PathVariable("id")long id)
	{
		leadRepo.deleteById(id);
	}
	
}
