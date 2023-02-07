package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadServices;
import com.marketing.util.EmailServices;

@Controller
public class LeadController 
{
	@Autowired
	private LeadServices leadServices;
	
	@Autowired
	private EmailServices  emailServices;
	
	//Handler method
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewLeadOnePage()
	{
		return "create_lead";
	}
	
	//@ModelAttribute
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead")Lead lead,ModelMap model)
	{
		leadServices.saveLeadInfo(lead);
		emailServices.sendEmail(lead.getEmail(), "welcome to psa", "Test Email from spring boot");
		model.addAttribute("msg", "record is save..!");
		return "create_lead";
	}
	
	
//	//@RequestParam
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
//			                   @RequestParam("email") String email,@RequestParam("mobile") String mobile,ModelMap model)
//	{
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadServices.saveLeadInfo(lead);
//		model.addAttribute("msg", "record is save..!");
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData leadData,ModelMap model)
//	{
//
//		Lead lead=new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		
//		leadServices.saveLeadInfo(lead);
//		model.addAttribute("msg", "record is save..!");
//		return "create_lead";
//	}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model model)
	{
		List<Lead> leads = leadServices.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,Model model)
	{
		leadServices.deleteLead(id);
		
		List<Lead> leads = leadServices.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
		
	}
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id")long id,Model model)
	{
		Lead lead=leadServices.updateLead(id);
		model.addAttribute("lead", lead);
		return "update_lead2";
	}
	
	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadData data,Model model)
	{
		Lead l=new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadServices.saveLeadInfo(l);
		
		
		List<Lead> leads = leadServices.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
		
	}
}
