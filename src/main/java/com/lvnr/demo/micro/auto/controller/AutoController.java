package com.lvnr.demo.micro.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.auto.dto.AutoDto;
import com.lvnr.demo.micro.auto.service.AutoService;

@RestController
public class AutoController {

	@Autowired
	private AutoService autoService;

	@PostMapping
	public ResponseEntity<AutoDto> crearAuto(@RequestBody AutoDto autoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autoService.crearAuto(autoDto));
	}

}
