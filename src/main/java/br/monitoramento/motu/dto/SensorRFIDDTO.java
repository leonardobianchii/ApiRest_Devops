package br.monitoramento.motu.dto;

public class SensorRFIDDTO {

    private Long idSensor;
    private String nomeSensor;
    private Long idFilialDepartamento;
    private String localizacao;

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public String getNomeSensor() {
        return nomeSensor;
    }

    public void setNomeSensor(String nomeSensor) {
        this.nomeSensor = nomeSensor;
    }

    public Long getIdFilialDepartamento() {
        return idFilialDepartamento;
    }

    public void setIdFilialDepartamento(Long idFilialDepartamento) {
        this.idFilialDepartamento = idFilialDepartamento;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
