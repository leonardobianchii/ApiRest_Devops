package br.monitoramento.motu.controller;

import br.monitoramento.motu.dto.FilialDepartamentoDTO;
import br.monitoramento.motu.service.FilialDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filiais")
public class FilialDepartamentoController {

    @Autowired
    private FilialDepartamentoService filialDepartamentoService;

    @PostMapping
    public ResponseEntity<FilialDepartamentoDTO> criarFilialDepartamento(@RequestBody FilialDepartamentoDTO dto) {
        return ResponseEntity.ok(filialDepartamentoService.criarFilialDepartamento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialDepartamentoDTO> obterFilialDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(filialDepartamentoService.obterFilialDepartamento(id));
    }

    @GetMapping
    public ResponseEntity<List<FilialDepartamentoDTO>> listarFiliais() {
        return ResponseEntity.ok(filialDepartamentoService.listarFiliais());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilialDepartamentoDTO> atualizarFilialDepartamento(@PathVariable Long id, @RequestBody FilialDepartamentoDTO dto) {
        return ResponseEntity.ok(filialDepartamentoService.atualizarFilialDepartamento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilialDepartamento(@PathVariable Long id) {
        filialDepartamentoService.deletarFilialDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}

