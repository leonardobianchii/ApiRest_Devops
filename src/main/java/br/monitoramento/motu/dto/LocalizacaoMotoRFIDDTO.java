package br.monitoramento.motu.dto;

import java.time.LocalDateTime;

public class LocalizacaoMotoRFIDDTO {
    private Long idLocalizacao;          // opcional, se você não gerar no banco
    private Long idMoto;
    private Long idSensor;
    private LocalDateTime dtLocalizacao;

    public Long getIdLocalizacao() { return idLocalizacao; }
    public void setIdLocalizacao(Long idLocalizacao) { this.idLocalizacao = idLocalizacao; }

    public Long getIdMoto() { return idMoto; }
    public void setIdMoto(Long idMoto) { this.idMoto = idMoto; }

    public Long getIdSensor() { return idSensor; }
    public void setIdSensor(Long idSensor) { this.idSensor = idSensor; }

    public LocalDateTime getDtLocalizacao() { return dtLocalizacao; }
    public void setDtLocalizacao(LocalDateTime dtLocalizacao) { this.dtLocalizacao = dtLocalizacao; }
}
