package br.monitoramento.motu.service;

import br.monitoramento.motu.dto.LocalizacaoMotoRFIDDTO;
import br.monitoramento.motu.exception.ResourceNotFoundException;
import br.monitoramento.motu.mapper.LocalizacaoMotoRFIDMapper;
import br.monitoramento.motu.model.LocalizacaoMotoRFID;
import br.monitoramento.motu.repository.LocalizacaoMotoRFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocalizacaoMotoRFIDService {

    @Autowired
    private LocalizacaoMotoRFIDRepository localizacaoMotoRFIDRepository;

    @Autowired
    private LocalizacaoMotoRFIDMapper localizacaoMotoRFIDMapper;

    public LocalizacaoMotoRFIDDTO adicionarLocalizacao(LocalizacaoMotoRFIDDTO dto) {
        // Mapper já seta: idLocalizacao (se vier), idMoto, idSensor, dtLocalizacao
        LocalizacaoMotoRFID localizacao = localizacaoMotoRFIDMapper.toEntity(dto);
        localizacao = localizacaoMotoRFIDRepository.save(localizacao);
        return localizacaoMotoRFIDMapper.toDTO(localizacao);
    }

    @Transactional(readOnly = true)
    public LocalizacaoMotoRFIDDTO obterLocalizacao(Long id) {
        LocalizacaoMotoRFID localizacao = localizacaoMotoRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada com id " + id));
        return localizacaoMotoRFIDMapper.toDTO(localizacao);
    }

    @Transactional(readOnly = true)
    public List<LocalizacaoMotoRFIDDTO> listarLocalizacoes() {
        return localizacaoMotoRFIDRepository.findAll().stream()
                .map(localizacaoMotoRFIDMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocalizacaoMotoRFIDDTO atualizarLocalizacao(Long id, LocalizacaoMotoRFIDDTO dto) {
        LocalizacaoMotoRFID localizacaoExistente = localizacaoMotoRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada com id " + id));

        // Atualiza campos existentes na tabela
        localizacaoExistente.setIdMoto(dto.getIdMoto());
        localizacaoExistente.setIdSensor(dto.getIdSensor());
        localizacaoExistente.setDtLocalizacao(dto.getDtLocalizacao());

        localizacaoExistente = localizacaoMotoRFIDRepository.save(localizacaoExistente);
        return localizacaoMotoRFIDMapper.toDTO(localizacaoExistente);
    }

    public void deletarLocalizacao(Long id) {
        LocalizacaoMotoRFID localizacao = localizacaoMotoRFIDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada com id " + id));
        localizacaoMotoRFIDRepository.delete(localizacao);
    }
}
