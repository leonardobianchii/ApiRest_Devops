package br.monitoramento.motu.dto;

public class MotoDTO {

    private Long idMoto;
    private Long idModelo;
    private Long idFilialDepartamento;
    private String placa;
    private String statusMoto;
    private Integer kmRodado;

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public Long getIdFilialDepartamento() {
        return idFilialDepartamento;
    }

    public void setIdFilialDepartamento(Long idFilialDepartamento) {
        this.idFilialDepartamento = idFilialDepartamento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getStatusMoto() {
        return statusMoto;
    }

    public void setStatusMoto(String statusMoto) {
        this.statusMoto = statusMoto;
    }

    public Integer getKmRodado() {
        return kmRodado;
    }

    public void setKmRodado(Integer kmRodado) {
        this.kmRodado = kmRodado;
    }
}