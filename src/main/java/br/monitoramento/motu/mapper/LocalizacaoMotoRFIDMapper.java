package br.monitoramento.motu.mapper;

import br.monitoramento.motu.dto.LocalizacaoMotoRFIDDTO;
import br.monitoramento.motu.model.LocalizacaoMotoRFID;
import org.springframework.stereotype.Component;

@Component
public class LocalizacaoMotoRFIDMapper {

    public LocalizacaoMotoRFIDDTO toDTO(LocalizacaoMotoRFID localizacao) {
        LocalizacaoMotoRFIDDTO dto = new LocalizacaoMotoRFIDDTO();
        dto.setIdLocalizacao(localizacao.getIdLocalizacao());
        dto.setIdMoto(localizacao.getIdMoto());
        dto.setIdSensor(localizacao.getIdSensor());
        dto.setDtLocalizacao(localizacao.getDtLocalizacao());
        return dto;
    }

    public LocalizacaoMotoRFID toEntity(LocalizacaoMotoRFIDDTO dto) {
        LocalizacaoMotoRFID localizacao = new LocalizacaoMotoRFID();
        localizacao.setIdLocalizacao(dto.getIdLocalizacao()); // se não usar auto-inc
        localizacao.setIdMoto(dto.getIdMoto());
        localizacao.setIdSensor(dto.getIdSensor());
        localizacao.setDtLocalizacao(dto.getDtLocalizacao());
        return localizacao;
    }
}
