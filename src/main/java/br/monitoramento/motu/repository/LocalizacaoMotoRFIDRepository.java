package br.monitoramento.motu.repository;

import br.monitoramento.motu.model.LocalizacaoMotoRFID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoMotoRFIDRepository extends JpaRepository<LocalizacaoMotoRFID, Long> {

}

