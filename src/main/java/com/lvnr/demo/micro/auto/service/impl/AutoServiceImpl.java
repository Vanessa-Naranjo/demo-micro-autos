package com.lvnr.demo.micro.auto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.auto.dto.AutoDto;
import com.lvnr.demo.micro.auto.entity.AutoEntity;
import com.lvnr.demo.micro.auto.repository.AutoRepository;
import com.lvnr.demo.micro.auto.service.AutoService;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private AutoRepository autoRepository;

	@Override
	public AutoDto crearAuto(AutoDto autoDto) {
		AutoEntity autoEntity = new AutoEntity();
		autoEntity.setMarca(autoDto.getMarca());
		autoEntity.setModelo(autoDto.getModelo());
		autoEntity.setAnioMatriculacion(autoDto.getAnioMatriculacion());
		autoRepository.save(autoEntity);
		autoDto.setId(autoEntity.getId());
		return autoDto;
	}

	@Override
	public List<AutoDto> consultarAutos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutoDto actualizarAuto(AutoDto AutoDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAuto(Integer id) {
		// TODO Auto-generated method stub

	}

}
