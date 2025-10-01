package br.monitoramento.motu.service;

import br.monitoramento.motu.dto.FilialDepartamentoDTO;
import br.monitoramento.motu.exception.ResourceNotFoundException;
import br.monitoramento.motu.mapper.FilialDepartamentoMapper;
import br.monitoramento.motu.model.FilialDepartamento;
import br.monitoramento.motu.repository.FilialDepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilialDepartamentoService {

    @Autowired
    private FilialDepartamentoRepository filialDepartamentoRepository;

    @Autowired
    private FilialDepartamentoMapper filialDepartamentoMapper;

    public FilialDepartamentoDTO criarFilialDepartamento(FilialDepartamentoDTO dto) {
        FilialDepartamento entity = filialDepartamentoMapper.toEntity(dto);
        entity = filialDepartamentoRepository.save(entity);
        return filialDepartamentoMapper.toDTO(entity);
    }

    public FilialDepartamentoDTO obterFilialDepartamento(Long id) {
        FilialDepartamento entity = filialDepartamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filial/Departamento não encontrado com id " + id));
        return filialDepartamentoMapper.toDTO(entity);
    }

    public List<FilialDepartamentoDTO> listarFiliais() {
        return filialDepartamentoRepository.findAll().stream()
                .map(filialDepartamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FilialDepartamentoDTO atualizarFilialDepartamento(Long id, FilialDepartamentoDTO dto) {
        FilialDepartamento existente = filialDepartamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filial/Departamento não encontrado com id " + id));

        existente.setNomeFilialDepartamento(dto.getNomeFilialDepartamento());

        existente = filialDepartamentoRepository.save(existente);
        return filialDepartamentoMapper.toDTO(existente);
    }

    public void deletarFilialDepartamento(Long id) {
        FilialDepartamento existente = filialDepartamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filial/Departamento não encontrado com id " + id));
        filialDepartamentoRepository.delete(existente);
    }
}

