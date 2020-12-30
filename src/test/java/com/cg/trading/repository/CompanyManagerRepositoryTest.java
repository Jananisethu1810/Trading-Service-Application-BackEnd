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

import com.cg.trading.models.CompanyManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CompanyManagerRepositoryTest {

	@Autowired
	private CompanyManagerRepository companyManagerRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewCompanyManager() throws Exception {
		CompanyManager companymanager = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		CompanyManager saveInDb = testEntityManager.persist(companymanager);
		CompanyManager getFromInDb = companyManagerRepository.findById(saveInDb.getCompanyManagerId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testDeleteCompanyManagerById() throws Exception {
		CompanyManager companymanager1 = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		CompanyManager companymanager2 = new CompanyManager(102, "Nivi", "nivi@gmail.com", "8512036587");
		CompanyManager companymanager = testEntityManager.persist(companymanager1);
		testEntityManager.persist(companymanager2);
		testEntityManager.remove(companymanager);
		List<CompanyManager> companymanagers = (List<CompanyManager>) companyManagerRepository.findAll();
		Assert.assertEquals(1, companymanagers.size());

	}

	@Test
	public void testUpdateCompanyManagerById() {

		CompanyManager companymanager = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		testEntityManager.persist(companymanager);
		CompanyManager getFromDb = companyManagerRepository.findById(106).get();
		getFromDb.setCompanyManagerId(107);
		testEntityManager.persist(getFromDb);

		assertThat(getFromDb.getCompanyManagerId()).isEqualTo(107);
	}

	@Test
	public void testGetAllCompanyManagers() throws Exception {
		CompanyManager companymanager1 = new CompanyManager(106, "Janani", "janani@gmail.com", "8512518301");
		CompanyManager companymanager2 = new CompanyManager(102, "Nivi", "nivi@gmail.com", "8512036587");
		CompanyManager companymanager3 = new CompanyManager(107, "Athin", "athin@gmal.com", "7823584951");
		testEntityManager.persist(companymanager1);
		testEntityManager.persist(companymanager2);
		testEntityManager.persist(companymanager3);
		List<CompanyManager> companymanagerlist = (List<CompanyManager>) companyManagerRepository.findAll();
		Assert.assertEquals(3, companymanagerlist.size());
	}
}
