package com.lvnr.demo.micro.auto.service.impl;

import java.util.ArrayList;
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
		List<AutoDto> autosDto = new ArrayList<>();
		List<AutoEntity> autosEntity = autoRepository.findAll();

		for (AutoEntity autoEntity : autosEntity) {
			AutoDto autoDto = new AutoDto();
			autoDto.setId(autoEntity.getId());
			autoDto.setMarca(autoEntity.getMarca());
			autoDto.setModelo(autoEntity.getModelo());
			autoDto.setAnioMatriculacion(autoEntity.getAnioMatriculacion());

			autosDto.add(autoDto);

		}

		return autosDto;
	}

	@Override
	public AutoDto actualizarAuto(AutoDto autoDto, Integer id) {
		AutoEntity autoEntity = this.autoRepository.findById(id).get();
		autoEntity.setMarca(autoDto.getMarca());
		autoEntity.setModelo(autoDto.getModelo());
		autoEntity.setAnioMatriculacion(autoDto.getAnioMatriculacion());
		this.autoRepository.save(autoEntity);
		autoDto.setId(autoEntity.getId());
		return autoDto;
	}

	@Override
	public String eliminarAuto(Integer id) {
		if(this.autoRepository.existsById(id)) {
			this.autoRepository.deleteById(id);
			return "El auto ha sido eliminado" + id;
		}
		return "El auto no existe" + id;

	}

}
