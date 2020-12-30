/**
 * Desc -  Stock Management System which is used by investors to buy stocks/shares of a company.
 * Admin Module
 * @author Janani S
 */
package com.cg.trading.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "COMPANY_MANAGER")
public class CompanyManager {

	@ApiModelProperty(notes = "Id of the Company Manager", name="companyManagerId", required=true, value="Company Manager Id")
	@Id
	@Column(name = "company_manager_id", nullable = false)
	private int companyManagerId;	
	
	@ApiModelProperty(notes = "Name of the Company Manager", name="companyManagerName", required=true, value="Company Manager Name")
	@Column(name = "company_manager_name", nullable = false)
	private String companyManagerName;
	
	@ApiModelProperty(notes = "Email Id of the Company Manager", name="companyManagerEmailId", required=true, value="Company Manager Email")
	@Column(name = "company_manager_email", nullable = false)
	private String companyManagerEmailId;
	
	@ApiModelProperty(notes = "Phone Number of the Company Manager", name="companyManagerPhone", required=true, value="Company Manager Phone Number")
	@Column(name = "company_manager_phone", nullable = false)
	private String companyManagerPhone;
	
	

	public CompanyManager() {
		
	}

	
	public CompanyManager(int companyManagerId, String companyManagerName, String companyManagerEmailId,
			String companyManagerPhone) {
		super();
		this.companyManagerId = companyManagerId;
		this.companyManagerName = companyManagerName;
		this.companyManagerEmailId = companyManagerEmailId;
		this.companyManagerPhone = companyManagerPhone;
	}


	public int getCompanyManagerId() {
		return companyManagerId;
	}

	public void setCompanyManagerId(int companyManagerId) {
		this.companyManagerId = companyManagerId;
	}

	public String getCompanyManagerName() {
		return companyManagerName;
	}

	public void setCompanyManagerName(String companyManagerName) {
		this.companyManagerName = companyManagerName;
	}

	public String getCompanyManagerEmailId() {
		return companyManagerEmailId;
	}

	public void setCompanyManagerEmailId(String companyManagerEmailId) {
		this.companyManagerEmailId = companyManagerEmailId;
	}

	public String getCompanyManagerPhone() {
		return companyManagerPhone;
	}

	public void setCompanyManagerPhone(String companyManagerPhone) {
		this.companyManagerPhone = companyManagerPhone;
	}

}
