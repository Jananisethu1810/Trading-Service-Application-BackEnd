package com.cg.trading.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.trading.models.Investor;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class InvestorRepositoryTest {

	@Autowired
	private InvestorRepository investorRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewInvestor() throws Exception {
		Investor investor = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Investor saveInDb = testEntityManager.persist(investor);
		Investor getFromInDb = investorRepository.findById(saveInDb.getInvestorId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testDeleteInvestorById() throws Exception {
		Investor investor1 = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Investor investor2 = new Investor(1, "Bhavya", "KOM190", "bhavya@gmail.com", "9550355847", 30, 60000);
		Investor investor = testEntityManager.persist(investor1);
		testEntityManager.persist(investor2);
		testEntityManager.remove(investor);
		List<Investor> investors = (List<Investor>) investorRepository.findAll();
		Assert.assertEquals(1, investors.size());

	}

	@Test
	public void testUpdateInvestorById() {

		Investor investor2 = new Investor(1, "Bhavya", "KOM190", "bhavya@gmail.com", "9550355847", 30, 60000);
		testEntityManager.persist(investor2);
		Investor getFromDb = investorRepository.findById(1).get();
		getFromDb.setInvestorId(2);
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getInvestorId()).isEqualTo(2);
	}

	@Test
	public void testGetAllInvestors() throws Exception {
		Investor investor1 = new Investor(3, "shivani", "MOS190", "shivani@gmail.com", "9550355319", 12, 25000);
		Investor investor2 = new Investor(1, "Bhavya", "KOM190", "bhavya@gmail.com", "9550355847", 30, 60000);
		testEntityManager.persist(investor1);
		testEntityManager.persist(investor2);
		List<Investor> investorlist = (List<Investor>) investorRepository.findAll();
		Assert.assertEquals(2, investorlist.size());
	}

}
