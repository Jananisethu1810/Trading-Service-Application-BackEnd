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
@Table(name = "INVESTOR")
public class Investor {

	@ApiModelProperty(notes = "Id of the Investor", name="investorId", required=true, value="Investor Id")
	@Id
	@Column(name = "INVESTOR_ID", nullable = false)
	private int investorId;

	@ApiModelProperty(notes = "Name of the Investor", name="investorName", required=true, value="Investor Name")
	@Column(name = "INVESTOR_NAME", nullable = false)
	private String investorName;

	@ApiModelProperty(notes = "PanNum of the Investor", name="investorPanNum", required=true, value="Investor PanNum")
	@Column(name = "INVESTOR_PAN_NUMBER", nullable = false)
	private String investorPanNum;

	@ApiModelProperty(notes = "Email of the Investor", name="investorEmailId", required=true, value="Investor Email")
	@Column(name = "INVESTOR_EMAIL", nullable = false)
	private String investorEmailId;

	@ApiModelProperty(notes = "Phone number of the Investor", name="investorPhone", required=true, value="Investor Phone Number")
	@Column(name = "INVESTOR_PHONE_NUMBER", nullable = false)
	private String investorPhone;

	@ApiModelProperty(notes = "No Of Stocks", name="numOfStocks", required=true, value="No Of Stocks Bought")
	@Column(name = "NUMBER_OF_STOCKS_BOUGHT", nullable = false)
	private int noOfStocks;

	@ApiModelProperty(notes = "Total Investment", name="investorInvestment", required=true, value="Total Investment")
	@Column(name = "TOTAL_INVESTMENT", nullable = false)
	private int investorsInvestment;

	public Investor() {

	}

	public Investor(int investorId, String investorName, String investorPanNum, String investorEmailId,
			String investorPhone, int noOfStocks, int investorsInvestment) {
		super();
		this.investorId = investorId;
		this.investorName = investorName;
		this.investorPanNum = investorPanNum;
		this.investorEmailId = investorEmailId;
		this.investorPhone = investorPhone;
		this.noOfStocks = noOfStocks;
		this.investorsInvestment = investorsInvestment;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getInvestorPanNum() {
		return investorPanNum;
	}

	public void setInvestorPanNum(String investorPanNum) {
		this.investorPanNum = investorPanNum;
	}

	public String getInvestorEmailId() {
		return investorEmailId;
	}

	public void setInvestorEmailId(String investorEmailId) {
		this.investorEmailId = investorEmailId;
	}

	public String getInvestorPhone() {
		return investorPhone;
	}

	public void setInvestorPhone(String investorPhone) {
		this.investorPhone = investorPhone;
	}

	public int getNoOfStocks() {
		return noOfStocks;
	}

	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}

	public int getInvestorsInvestment() {
		return investorsInvestment;
	}

	public void setInvestorsInvestment(int investorsInvestment) {
		this.investorsInvestment = investorsInvestment;
	}

}
