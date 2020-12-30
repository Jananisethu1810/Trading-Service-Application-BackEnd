package com.cg.trading.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.trading.models.CompanyManager;
import com.cg.trading.models.Investor;
import com.cg.trading.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	AdminService adminService;

	@Test
	public void testCreateCompanyManager() throws Exception {

		CompanyManager companymanager = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		String jsonInput = this.converttoJson(companymanager);

		Mockito.when(adminService.createCompanyManager(Mockito.any(CompanyManager.class))).thenReturn(companymanager);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/trading/companymanager/add")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}


	@Test
	public void testUpdateCompanyManager() throws Exception {
		CompanyManager companymanager = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		String jsonInput = this.converttoJson(companymanager);

		Mockito.when(adminService.updateCompanyManagerById(Mockito.any(), Mockito.any(CompanyManager.class)))
				.thenReturn(companymanager);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put("/trading/companymanager/update/{id}", 106)
						.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}
	
	@Test
	public void testDeleteCompanyManager() throws Exception {
		//String URI = "/trading/companymanager/delete/{id}";
		CompanyManager companymanager = new CompanyManager(107, "saran", "saran@gmal.com", "9634562456");
		adminService.deleteCompanyManagerById(companymanager.getCompanyManagerId());
		assertThat(adminService.deleteCompanyManagerById(107)).isFalse();
	}

	@Test
	public void testGetAllCompanyManagers() throws Exception {

		CompanyManager companymanager1 = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		CompanyManager companymanager2 = new CompanyManager(102, "Nivi", "nivi@gmal.com", "8512036587");

		List<CompanyManager> companymanagerlist = new ArrayList<>();
		companymanagerlist.add(companymanager1);
		companymanagerlist.add(companymanager2);

		String jsonInput = this.converttoJson(companymanagerlist);
		Mockito.when(adminService.getAllCompanyManager()).thenReturn(companymanagerlist);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/trading/companymanager/all")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	public void testCreateInvestor() throws Exception {
		Investor investor = new Investor(4, "Kumar", "KHF487", "kumar@gmail.com", "9701531212", 25, 52000);
		String jsonInput = this.converttoJson(investor);
		Mockito.when(adminService.createInvestor(Mockito.any(Investor.class))).thenReturn(investor);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/trading/investor/add")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	public void testDeleteInvestorById() throws Exception {
		//String URI = "/trading/Investor/delete/{id}";
		Investor investor = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		adminService.deleteInvestorById(investor.getInvestorId());
		assertThat(adminService.deleteInvestorById(3)).isFalse();
	}

	@Test
	public void testUpdateInvestor() throws Exception {
		Investor investor = new Investor(4, "Kumar", "KHF487", "kumar@gmail.com", "9701531212", 25, 52000);
		String jsonInput = this.converttoJson(investor);
		Mockito.when(adminService.updateInvestorById(Mockito.any(), Mockito.any(Investor.class))).thenReturn(investor);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put("/trading/investor/update/{id}", 4)
						.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	public void testGetAllInvestors() throws Exception {

		Investor investor1 = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Investor investor2 = new Investor(1, "Bhavya", "KOM190", "bhavya@gmail.com", "9550355847", 30, 60000);
		List<Investor> investorlist = new ArrayList<>();
		investorlist.add(investor1);
		investorlist.add(investor2);
		String jsonInput = this.converttoJson(investorlist);

		Mockito.when(adminService.getAllInvestor()).thenReturn(investorlist);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/trading/investor/all").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	private String converttoJson(Object companymanager) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(companymanager);
	}
}
