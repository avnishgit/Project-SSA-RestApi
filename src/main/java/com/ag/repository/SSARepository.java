package com.ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ag.entity.SSAEntity;


@Repository
public interface SSARepository extends JpaRepository<SSAEntity, Integer> {

	@Query("select state from SSAEntity where ssn =:ssno")
	public String getStateBySSANo(Integer ssno);
}
