package com.lvnr.demo.micro.auto.service;

import java.util.List;

import com.lvnr.demo.micro.auto.dto.AutoDto;

public interface AutoService {

	public AutoDto crearAuto(AutoDto autoDto);

	public List<AutoDto> consultarAutos();

	public AutoDto consultarAutoPorMatricula(String matricula);

	public AutoDto actualizarAuto(AutoDto AutoDto, String matricula);

	public String eliminarAuto(String matricula);
}
