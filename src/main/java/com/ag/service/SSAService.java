package com.ag.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ag.model.PersonDetails;

@Service
public interface SSAService {

	public PersonDetails saveDetails(PersonDetails person);
	public List<String> getState();
	public String getSsaNoById(Integer id);
}
