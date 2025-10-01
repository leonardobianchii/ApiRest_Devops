package br.monitoramento.motu.service;

import br.monitoramento.motu.dto.SensorRFIDDTO;
import br.monitoramento.motu.exception.ResourceNotFoundException;
import br.monitoramento.motu.mapper.SensorRFIDMapper;
import br.monitoramento.motu.model.SensorRFID;
import br.monitoramento.motu.repository.SensorRFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SensorRFIDService {

    @Autowired
    private SensorRFIDRepository sensorRFIDRepository;

    @Autowired
    private SensorRFIDMapper sensorRFIDMapper;

    public SensorRFIDDTO criarSensor(SensorRFIDDTO sensorRFIDDTO) {
        SensorRFID sensor = sensorRFIDMapper.toEntity(sensorRFIDDTO);
        sensor = sensorRFIDRepository.save(sensor);
        return sensorRFIDMapper.toDTO(sensor);
    }

    public SensorRFIDDTO obterSensor(Long id) {
        SensorRFID sensor = sensorRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado com id " + id));
        return sensorRFIDMapper.toDTO(sensor);
    }

    public List<SensorRFIDDTO> listarSensores() {
        return sensorRFIDRepository.findAll().stream()
                .map(sensorRFIDMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SensorRFIDDTO atualizarSensor(Long id, SensorRFIDDTO sensorRFIDDTO) {
        SensorRFID sensorExistente = sensorRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado com id " + id));

        sensorExistente.setNomeSensor(sensorRFIDDTO.getNomeSensor());
        sensorExistente.setLocalizacao(sensorRFIDDTO.getLocalizacao());

        sensorExistente = sensorRFIDRepository.save(sensorExistente);
        return sensorRFIDMapper.toDTO(sensorExistente);
    }

    public void deletarSensor(Long id) {
        SensorRFID sensor = sensorRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado com id " + id));
        sensorRFIDRepository.delete(sensor);
    }
}

