package com.lvnr.demo.micro.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping
	public ResponseEntity<List<AutoDto>> consultarAutos() {
		return ResponseEntity.ok(autoService.consultarAutos());
	}

	@PutMapping("/{id}")
	public ResponseEntity<AutoDto> actualizarAuto(@RequestBody AutoDto autoDto, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autoService.actualizarAuto(autoDto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarFruta(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autoService.eliminarAuto(id));
	}
}
