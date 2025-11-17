package com.lvnr.demo.micro.auto.service;

import java.util.List;

import com.lvnr.demo.micro.auto.dto.AutoDto;

public interface AutoService {

	public AutoDto crearAuto(AutoDto autoDto);

	public List<AutoDto> consultarAutos();

	public AutoDto actualizarAuto(AutoDto AutoDto, Integer id);
	
	public String eliminarAuto(Integer id);
}
