package com.cg.trading.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.trading.exception.IDNotFoundException;
import com.cg.trading.models.CompanyManager;
import com.cg.trading.models.Investor;
import com.cg.trading.repository.CompanyManagerRepository;
import com.cg.trading.repository.InvestorRepository;
import com.cg.trading.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CompanyManagerRepository companyManagerRepository;

	@Autowired
	private InvestorRepository investorRepository;

	public CompanyManager createCompanyManager(@RequestBody CompanyManager companyManager) {
		return companyManagerRepository.save(companyManager);
	}

	public CompanyManager updateCompanyManagerById(@PathVariable Integer companyManagerId,
			@RequestBody CompanyManager companyManager) throws IDNotFoundException{
		CompanyManager companyManagerFound = companyManagerRepository.findById(companyManagerId)
					.orElseThrow(() -> new IDNotFoundException(
							"CompanyManagerIdentifier : " + companyManagerId + " not available!!!"));
		
		companyManagerFound.setCompanyManagerId(companyManager.getCompanyManagerId());
		companyManagerFound.setCompanyManagerName(companyManager.getCompanyManagerName());
		companyManagerFound.setCompanyManagerEmailId(companyManager.getCompanyManagerEmailId());
		companyManagerFound.setCompanyManagerPhone(companyManager.getCompanyManagerPhone());

		return companyManagerRepository.save(companyManagerFound);
	}

	public boolean deleteCompanyManagerById(@PathVariable Integer companyManagerId) throws IDNotFoundException{
		CompanyManager companyManager = companyManagerRepository.findById(companyManagerId)
					.orElseThrow(() -> new IDNotFoundException(
							"CompanyManagerIdentifier : " + companyManagerId + " not available!!!"));
		companyManagerRepository.delete(companyManager);
		return true;
	}

	public List<CompanyManager> getAllCompanyManager() {
		return (List<CompanyManager>) companyManagerRepository.findAll();
	}

	public Investor createInvestor(Investor investor) {
		return investorRepository.save(investor);
	}

	public Investor updateInvestorById(@PathVariable Integer investorId, @RequestBody Investor investor) throws IDNotFoundException{
		Investor investorFound = investorRepository.findById(investorId).orElseThrow(
					() -> new IDNotFoundException("InvestorIdentifier : " + investorId + " not available!!!"));
		
		investorFound.setInvestorId(investor.getInvestorId());
		investorFound.setInvestorName(investor.getInvestorName());
		investorFound.setInvestorPanNum(investor.getInvestorPanNum());
		investorFound.setInvestorEmailId(investor.getInvestorEmailId());
		investorFound.setInvestorPhone(investor.getInvestorPhone());
		investorFound.setNoOfStocks(investor.getNoOfStocks());
		investorFound.setInvestorsInvestment(investor.getInvestorsInvestment());
		return investorRepository.save(investorFound);
	}

	public boolean deleteInvestorById(@PathVariable Integer investorId) throws IDNotFoundException{
		Investor investor = investorRepository.findById(investorId).orElseThrow(
					() -> new IDNotFoundException("InvestorIdentifier : " + investorId + " not available!!!"));
		investorRepository.delete(investor);
		return true;
	}

	public List<Investor> getAllInvestor() {
		return (List<Investor>) investorRepository.findAll();
	}

}
