package br.monitoramento.motu.service;

import br.monitoramento.motu.dto.MotoDTO;
import br.monitoramento.motu.exception.ResourceNotFoundException;
import br.monitoramento.motu.mapper.MotoMapper;
import br.monitoramento.motu.model.Moto;
import br.monitoramento.motu.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private MotoMapper motoMapper;

    public MotoDTO criarMoto(MotoDTO motoDTO) {
        Moto moto = motoMapper.toEntity(motoDTO);
        moto = motoRepository.save(moto);
        return motoMapper.toDTO(moto);
    }

    public MotoDTO obterMoto(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id " + id));
        return motoMapper.toDTO(moto);
    }

    public List<MotoDTO> listarMotos() {
        return motoRepository.findAll().stream()
                .map(motoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MotoDTO atualizarMoto(Long id, MotoDTO motoDTO) {
        Moto motoExistente = motoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id " + id));

        motoExistente.setPlaca(motoDTO.getPlaca());
        motoExistente.setStatusMoto(motoDTO.getStatusMoto());
        motoExistente.setKmRodado(motoDTO.getKmRodado());
        // Atualize outras propriedades se necessário

        motoExistente = motoRepository.save(motoExistente);
        return motoMapper.toDTO(motoExistente);
    }

    public void deletarMoto(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id " + id));
        motoRepository.delete(moto);
    }
}
