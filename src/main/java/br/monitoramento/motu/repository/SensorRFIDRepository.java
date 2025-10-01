package br.monitoramento.motu.repository;

import br.monitoramento.motu.model.SensorRFID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRFIDRepository extends JpaRepository<SensorRFID, Long> {
}
