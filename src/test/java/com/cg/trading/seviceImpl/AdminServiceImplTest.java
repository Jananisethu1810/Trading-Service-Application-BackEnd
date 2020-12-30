package com.cg.trading.seviceImpl;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.trading.models.CompanyManager;
import com.cg.trading.models.Investor;
import com.cg.trading.repository.CompanyManagerRepository;
import com.cg.trading.repository.InvestorRepository;
import com.cg.trading.service.AdminService;

/**
 * The AdminServiceTest class provides testing of AdminService layer
 * 
 * @author Bhavani's
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

	@MockBean
	private CompanyManagerRepository companyManagerRepository;

	@MockBean
	private InvestorRepository investorRepository;

	@Autowired
	private AdminService adminService;

	@Test
	public void testCreateCompanyManager() throws Exception {
		CompanyManager companymanager = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		Mockito.when(companyManagerRepository.save(companymanager)).thenReturn(companymanager);
		assertThat(adminService.createCompanyManager(companymanager)).isEqualTo(companymanager);
	}

	@Test
	public void testDeleteCompanyManagerById() throws Exception {
		CompanyManager companymanager = new CompanyManager(101, "Janani", "janani@gmail.com", "8512518301");
		companyManagerRepository.deleteById(companymanager.getCompanyManagerId());
		System.out.println(companyManagerRepository.findById(101));
		Assert.assertTrue(companyManagerRepository.findById(101).isEmpty());
	}

	@Test
	public void testUpdateCompanyManagerById() throws Exception {
		CompanyManager companymanager = new CompanyManager(101, "Janani", "janani@gmail.com", "8512518301");
		Mockito.when(companyManagerRepository.save(companymanager)).thenReturn(companymanager);
		companymanager.setCompanyManagerName("Nivya");
		companymanager.setCompanyManagerEmailId("nivya@gmail.com");
		System.out.println(companymanager.getCompanyManagerName());
		System.out.println(companymanager.getCompanyManagerEmailId());
		Assert.assertTrue((companyManagerRepository.findById(101).isEmpty()));
	}

	@Test
	public void testGetAllCompanyManager() throws Exception {
		CompanyManager companymanager1 = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		CompanyManager companymanager2 = new CompanyManager(102, "Nivi", "nivi@gmal.com", "8512036587");
		List<CompanyManager> companymanagerlist = new ArrayList<>();
		companymanagerlist.add(companymanager1);
		companymanagerlist.add(companymanager2);

		Mockito.when(companyManagerRepository.findAll()).thenReturn(companymanagerlist);
		assertThat(adminService.getAllCompanyManager()).isEqualTo(companymanagerlist);

	}

	@Test
	public void testCreateInvestor() throws Exception {
		Investor investor = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Mockito.when(investorRepository.save(investor)).thenReturn(investor);
		assertThat(adminService.createInvestor(investor)).isEqualTo(investor);
	}

	@Test
	public void testUpdateInvestorById() throws Exception {
		Investor investor = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Mockito.when(investorRepository.save(investor)).thenReturn(investor);

		investor.setInvestorEmailId("shivani.s@gmail.com");
		Mockito.when(investorRepository.save(investor)).thenReturn(investor);
		System.out.println(investor.getInvestorEmailId());

		Assert.assertTrue(investorRepository.findById(3).isEmpty());

	}

	@Test
	public void testDeleteInvestorById() throws Exception {

		Investor investor = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		investorRepository.deleteById(investor.getInvestorId());
		System.out.println(investorRepository.findById(3));
		Assert.assertTrue(investorRepository.findById(3).isEmpty());
	}

	@Test
	public void testGetAllInvestors() throws Exception {
		Investor investor1 = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Investor investor2 = new Investor(1, "Bhavya", "KOM190", "bhavya@gmail.com", "9550355847", 30, 60000);
		List<Investor> investorlist = new ArrayList<>();
		investorlist.add(investor1);
		investorlist.add(investor2);

		Mockito.when(investorRepository.findAll()).thenReturn(investorlist);
		assertThat(adminService.getAllInvestor()).isEqualTo(investorlist);
	}
}
