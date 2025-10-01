package br.monitoramento.motu.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_CM_LOCALIZACAO_MOTO_RFID")
public class LocalizacaoMotoRFID {

    @Id
    @Column(name = "id_localizacao")
    // Se quiser autogerar, torne a coluna AUTO_INCREMENT no schema e habilite @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalizacao;

    // Mantendo FKs como IDs simples, igual fizemos em Moto
    @Column(name = "id_moto", nullable = false)
    private Long idMoto;

    @Column(name = "id_sensor", nullable = false)
    private Long idSensor;

    @Column(name = "dt_localizacao", nullable = false)
    private LocalDateTime dtLocalizacao;

    // getters/setters
    public Long getIdLocalizacao() { return idLocalizacao; }
    public void setIdLocalizacao(Long idLocalizacao) { this.idLocalizacao = idLocalizacao; }

    public Long getIdMoto() { return idMoto; }
    public void setIdMoto(Long idMoto) { this.idMoto = idMoto; }

    public Long getIdSensor() { return idSensor; }
    public void setIdSensor(Long idSensor) { this.idSensor = idSensor; }

    public LocalDateTime getDtLocalizacao() { return dtLocalizacao; }
    public void setDtLocalizacao(LocalDateTime dtLocalizacao) { this.dtLocalizacao = dtLocalizacao; }
}
