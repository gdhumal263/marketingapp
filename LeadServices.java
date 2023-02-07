package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadServices
{
	public void saveLeadInfo(Lead lead);

	public List<Lead> getLeads();

	public void deleteLead(long id);

	public Lead updateLead(long id);

	

}
