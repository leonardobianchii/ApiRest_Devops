package br.monitoramento.motu.mapper;

import br.monitoramento.motu.dto.MotoDTO;
import br.monitoramento.motu.model.Moto;
import org.springframework.stereotype.Component;

@Component
public class MotoMapper {

    public MotoDTO toDTO(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setIdMoto(moto.getIdMoto());
        dto.setIdModelo(moto.getIdModelo());
        dto.setIdFilialDepartamento(moto.getIdFilialDepartamento());
        dto.setPlaca(moto.getPlaca());
        dto.setStatusMoto(moto.getStatusMoto());
        dto.setKmRodado(moto.getKmRodado());
        return dto;
    }

    public Moto toEntity(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setIdMoto(dto.getIdMoto()); // ver observação sobre ID acima
        moto.setIdModelo(dto.getIdModelo());
        moto.setIdFilialDepartamento(dto.getIdFilialDepartamento());
        moto.setPlaca(dto.getPlaca());
        moto.setStatusMoto(dto.getStatusMoto());
        moto.setKmRodado(dto.getKmRodado());
        return moto;
    }
}
