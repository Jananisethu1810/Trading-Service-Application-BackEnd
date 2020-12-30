package com.cg.trading.service;

import java.util.List;

import com.cg.trading.exception.IDNotFoundException;
import com.cg.trading.models.CompanyManager;
import com.cg.trading.models.Investor;

public interface AdminService {
	
	CompanyManager createCompanyManager(CompanyManager companymanager);
	CompanyManager updateCompanyManagerById(Integer companyManagerId, CompanyManager companymanagerDetails) throws IDNotFoundException;
	boolean deleteCompanyManagerById(Integer companyManagerId) throws IDNotFoundException;
	List<CompanyManager> getAllCompanyManager();

	
	Investor createInvestor(Investor investor);
    Investor updateInvestorById(Integer investorId, Investor investorDetails) throws IDNotFoundException;
	boolean deleteInvestorById(Integer investorId) throws IDNotFoundException;
	List<Investor> getAllInvestor();

}
