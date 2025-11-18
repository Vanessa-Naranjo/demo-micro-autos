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
		autoEntity.setMatricula(autoDto.getMatricula());
		if (!autoRepository.existsByMatricula(autoDto.getMatricula())) {
			autoRepository.save(autoEntity);
		} else {
			throw new IllegalArgumentException("La placa ya existe" + autoDto.getMatricula());
		}

		return autoDto;
	}

	@Override
	public List<AutoDto> consultarAutos() {
		List<AutoDto> autosDto = new ArrayList<>();
		List<AutoEntity> autosEntity = autoRepository.findAll();

		for (AutoEntity autoEntity : autosEntity) {
			AutoDto autoDto = new AutoDto();
			autoDto.setMarca(autoEntity.getMarca());
			autoDto.setModelo(autoEntity.getModelo());
			autoDto.setAnioMatriculacion(autoEntity.getAnioMatriculacion());
			autoDto.setMatricula(autoEntity.getMatricula());

			autosDto.add(autoDto);

		}

		return autosDto;
	}

	@Override
	public AutoDto actualizarAuto(AutoDto autoDto, String matricula) {
		AutoEntity autoEntity = this.autoRepository.findByMatricula(matricula);
		autoEntity.setMarca(autoDto.getMarca());
		autoEntity.setModelo(autoDto.getModelo());
		autoEntity.setAnioMatriculacion(autoDto.getAnioMatriculacion());
		autoEntity.setMatricula(autoDto.getMatricula());
		this.autoRepository.save(autoEntity);
		return autoDto;
	}

	@Override
	public String eliminarAuto(String matricula) {
		if (this.autoRepository.existsByMatricula(matricula)) {
			this.autoRepository.deleteByMatricula(matricula);
			return "El auto ha sido eliminado" + matricula;
		}
		return "El auto no existe" + matricula;

	}

	@Override
	public AutoDto consultarAutoPorMatricula(String matricula) {
		AutoEntity autoEntity = this.autoRepository.findByMatricula(matricula);
		AutoDto autoDto = new AutoDto();
		autoDto.setMarca(autoEntity.getMarca());
		autoDto.setModelo(autoEntity.getModelo());
		autoDto.setAnioMatriculacion(autoEntity.getAnioMatriculacion());
		autoDto.setMatricula(autoEntity.getMatricula());

		return autoDto;

	}

}
