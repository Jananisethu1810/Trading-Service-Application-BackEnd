package com.cg.trading.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.trading.models.Investor;

public interface InvestorRepository extends CrudRepository<Investor, Integer>{

}
