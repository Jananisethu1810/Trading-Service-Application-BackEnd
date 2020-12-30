package com.cg.trading.controller;

import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trading.exception.IDNotFoundException;
import com.cg.trading.models.CompanyManager;
import com.cg.trading.models.Investor;
import com.cg.trading.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "AdminController", description = "REST Api's related to Company Manager and Investor Entity!!!!")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("/trading")
public class AdminController {
	
	public static final Logger logger = Logger.getLogger("AdminController.class");
	
	@Autowired
	private AdminService adminService;
	
	@ApiOperation(value = "Creating specific Company Manager in the System ", response = CompanyManager.class)
	@PostMapping("/CompanyManager")
	public CompanyManager createCompanyManager(@RequestBody CompanyManager companyManager) {
		logger.info("Creating Company Manager!");
		return adminService.createCompanyManager(companyManager);
	}
	
	@ApiOperation(value = "Updating specific Company Manager in the System ", response = CompanyManager.class)
	@PutMapping("/CompanyManger/{id}")
	public ResponseEntity<CompanyManager> updateCompanyManager(@PathVariable(value="id") Integer companyManagerId,
			@RequestBody CompanyManager companyManager) throws IDNotFoundException{
		logger.info("Updating Company Manager!");
		CompanyManager companyManagerFound= adminService.updateCompanyManagerById(companyManagerId, companyManager);
		return ResponseEntity.ok(companyManagerFound);
	}
	
	@ApiOperation(value = "Delete specific Company Manager in the System ", response = CompanyManager.class)
	@DeleteMapping("/CompanyManager/{id}")	
	public ResponseEntity<String> deleteCompanyManager(@PathVariable(value="id") Integer companyManagerId) throws IDNotFoundException{
		adminService.deleteCompanyManagerById(companyManagerId);
		logger.info("Deleting Company Manager!");
		String result= "Company Manager with Id : "+companyManagerId+" Deleted Successfully!";
		return ResponseEntity.ok(result);
		   
	}  
	
	@ApiOperation(value = "Get list of Company Managers in the System ", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/CompanyManager")
	public List<CompanyManager> getAllCompanyManager() {
		logger.info("Get all company manager details");
		return adminService.getAllCompanyManager();
	} 
	
	@ApiOperation(value = "Creating specific Investor in the System ", response = Investor.class)
	@PostMapping("/Investor")
	public Investor createInvestor(@RequestBody Investor investor) {
		logger.info("Creating Investor!");
		return adminService.createInvestor(investor);
	}
	
	
	@ApiOperation(value = "Update specific Investor in the System ", response = Investor.class)
	@PutMapping("/Investor/{id}")
	public ResponseEntity<Investor> updateInvestor(@PathVariable(value="id") Integer investorId, 
			@RequestBody Investor investor) throws IDNotFoundException{
		logger.info("Updating Investor!");
		Investor investorFound= adminService.updateInvestorById(investorId, investor);
		return ResponseEntity.ok(investorFound);
	}
	
	@ApiOperation(value = "Delete specific Investor in the System ", response = Investor.class)
	@DeleteMapping("/Investor/{id}")	
	public ResponseEntity<String> deleteInvestor(@PathVariable(value="id") Integer investorId) throws IDNotFoundException{
		adminService.deleteInvestorById(investorId);
		logger.info("Deleting Investor!");
		String result= "Investor with Id : "+investorId+" Deleted Successfully!";
		return ResponseEntity.ok(result);
		
	}  
	
	@ApiOperation(value = "Get list of Investors in the System ", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/Investor")
	public List<Investor> getAllInvestor() {
		logger.info("Get all investor details");
		return adminService.getAllInvestor();
	} 
}
