package br.monitoramento.motu.controller;

import br.monitoramento.motu.dto.LocalizacaoMotoRFIDDTO;
import br.monitoramento.motu.service.LocalizacaoMotoRFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localizacoes")
public class LocalizacaoMotoRFIDController {

    @Autowired
    private LocalizacaoMotoRFIDService localizacaoMotoService;

    @PostMapping
    public ResponseEntity<LocalizacaoMotoRFIDDTO> adicionarLocalizacao(@RequestBody LocalizacaoMotoRFIDDTO dto) {
        return ResponseEntity.ok(localizacaoMotoService.adicionarLocalizacao(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoMotoRFIDDTO> obterLocalizacao(@PathVariable Long id) {
        return ResponseEntity.ok(localizacaoMotoService.obterLocalizacao(id));
    }

    @GetMapping
    public ResponseEntity<List<LocalizacaoMotoRFIDDTO>> listarLocalizacoes() {
        return ResponseEntity.ok(localizacaoMotoService.listarLocalizacoes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoMotoRFIDDTO> atualizarLocalizacao(@PathVariable Long id, @RequestBody LocalizacaoMotoRFIDDTO dto) {
        return ResponseEntity.ok(localizacaoMotoService.atualizarLocalizacao(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalizacao(@PathVariable Long id) {
        localizacaoMotoService.deletarLocalizacao(id);
        return ResponseEntity.noContent().build();
    }
}

