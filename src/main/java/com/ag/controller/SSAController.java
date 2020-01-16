package com.ag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ag.model.PersonDetails;
import com.ag.service.SSAService;

@Controller
public class SSAController {

	@Autowired
	private SSAService ssaService;
	
	@RequestMapping("/")
	public String displayForm(Model model) {
		PersonDetails personDetails = new PersonDetails();
		model.addAttribute("personBean", personDetails);
		List<String> listState = ssaService.getState();
		model.addAttribute("listState", listState);
		return "SSARegistration";
	}
	@PostMapping("/save")
	public String submitBtn(@ModelAttribute("personBean") PersonDetails person,Model model) {
		PersonDetails details = ssaService.saveDetails(person);
		if(details != null) {
			model.addAttribute("success", "Your Enrollment is Successfull..");
			Integer ssn = details.getSsn();
			String s1 = String.valueOf(ssn);
			StringBuffer sb = new StringBuffer(s1);
			sb.insert(2, "-");
			sb.insert(6, "-");
			//String ssa = new String(sb);

			model.addAttribute("SSNo", "Your SSA Number: "+sb);
		}
		else {
			model.addAttribute("failMsg", "Your Enrollment is Failed");
		}
		return "success";
	}
}
