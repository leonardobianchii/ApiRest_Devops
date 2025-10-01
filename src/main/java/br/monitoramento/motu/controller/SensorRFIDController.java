package br.monitoramento.motu.controller;

import br.monitoramento.motu.dto.SensorRFIDDTO;
import br.monitoramento.motu.service.SensorRFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorRFIDController {

    @Autowired
    private SensorRFIDService sensorRFIDService;

    @PostMapping
    public ResponseEntity<SensorRFIDDTO> criarSensor(@RequestBody SensorRFIDDTO sensorRFIDDTO) {
        return ResponseEntity.ok(sensorRFIDService.criarSensor(sensorRFIDDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorRFIDDTO> obterSensor(@PathVariable Long id) {
        return ResponseEntity.ok(sensorRFIDService.obterSensor(id));
    }

    @GetMapping
    public ResponseEntity<List<SensorRFIDDTO>> listarSensores() {
        return ResponseEntity.ok(sensorRFIDService.listarSensores());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorRFIDDTO> atualizarSensor(@PathVariable Long id, @RequestBody SensorRFIDDTO sensorRFIDDTO) {
        return ResponseEntity.ok(sensorRFIDService.atualizarSensor(id, sensorRFIDDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSensor(@PathVariable Long id) {
        sensorRFIDService.deletarSensor(id);
        return ResponseEntity.noContent().build();
    }
}
