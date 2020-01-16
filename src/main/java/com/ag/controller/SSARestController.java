package com.ag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ag.exception.SSNoNotFounException;
import com.ag.service.SSAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("This Api is deal with SSA number")
public class SSARestController {

	@Autowired
	private SSAService ssaService;

	@ApiResponses({

			@ApiResponse(code = 200, message = "Success"),

			@ApiResponse(code = 400, message = "Bad Request"),

			@ApiResponse(code = 500, message = "Server Problem") })

	@ApiOperation(value = "This operation is used to provide person details")

	@GetMapping(value = "/get/{ssaNo}", produces = { "application/json" }

	)
	public ResponseEntity<String> getResponceById(
			@ApiParam(value = "This Represent person SSA No.") @PathVariable("ssaNo") Integer ssaNo) {
		System.out.println(ssaNo);
		String stateName = ssaService.getSsaNoById(ssaNo);
		if (stateName == null) {
			throw new SSNoNotFounException();
		}

		return new ResponseEntity<String> (stateName,HttpStatus.OK);

	}

}
