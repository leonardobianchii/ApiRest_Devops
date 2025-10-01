package br.monitoramento.motu.controller;

import br.monitoramento.motu.dto.MotoDTO;
import br.monitoramento.motu.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @PostMapping
    public ResponseEntity<MotoDTO> criarMoto(@RequestBody MotoDTO motoDTO) {
        return ResponseEntity.ok(motoService.criarMoto(motoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> obterMoto(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.obterMoto(id));
    }

    @GetMapping
    public ResponseEntity<List<MotoDTO>> listarMotos() {
        return ResponseEntity.ok(motoService.listarMotos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> atualizarMoto(@PathVariable Long id, @RequestBody MotoDTO motoDTO) {
        return ResponseEntity.ok(motoService.atualizarMoto(id, motoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMoto(@PathVariable Long id) {
        motoService.deletarMoto(id);
        return ResponseEntity.noContent().build();
    }
}

