package com.ag.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.entity.SSAEntity;
import com.ag.model.PersonDetails;
import com.ag.repository.SSARepository;
import com.ag.repository.StateRepository;

/**
 * This class is used to perform B. operation
 * 
 * @author AVNISH SINGH
 * @version 2.2
 */
@Service
public class SSAServiceImpl implements SSAService {

	@Autowired
	SSARepository ssaRepo;
	@Autowired
	private StateRepository stateRepo;

	/**
	 * This method is used to save person Details
	 */
	@Override
	public PersonDetails saveDetails(PersonDetails person) {

		SSAEntity entity = new SSAEntity();
		person.setSsn(randomSSNO());
		BeanUtils.copyProperties(person, entity);
		SSAEntity Save = ssaRepo.save(entity);
		BeanUtils.copyProperties(Save, person);
		return person;
	}

	/**
	 * This method is used to get all state details
	 */

	public List<String> getState() {
		return stateRepo.findAllState();
	}

	/**
	 * This method return random number
	 * 
	 * @return
	 */
	public Integer randomSSNO() {
		String randomNumeric = RandomStringUtils.randomNumeric(9);
		int number = Integer.parseInt(randomNumeric);
		return number;
	}

	/**
	 * This method is used to get state name
	 */
	@Override
	public String getSsaNoById(Integer id) {
		return ssaRepo.getStateBySSANo(id);

	}
}
