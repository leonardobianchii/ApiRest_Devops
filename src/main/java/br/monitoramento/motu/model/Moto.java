package br.monitoramento.motu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "T_CM_MOTO")
public class Moto {

    @Id
    @Column(name = "id_moto")
    // Se quiser gerar automaticamente, mude o schema para IDENTITY.
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMoto;

    @Column(name = "id_modelo", nullable = false)
    private Long idModelo;

    @Column(name = "id_filial_departamento", nullable = false)
    private Long idFilialDepartamento;

    @NotBlank
    @Column(name = "nm_placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "st_moto")
    private String statusMoto;

    @Column(name = "km_rodado")
    private Integer kmRodado;

    // getters/setters
    public Long getIdMoto() { return idMoto; }
    public void setIdMoto(Long idMoto) { this.idMoto = idMoto; }

    public Long getIdModelo() { return idModelo; }
    public void setIdModelo(Long idModelo) { this.idModelo = idModelo; }

    public Long getIdFilialDepartamento() { return idFilialDepartamento; }
    public void setIdFilialDepartamento(Long idFilialDepartamento) { this.idFilialDepartamento = idFilialDepartamento; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getStatusMoto() { return statusMoto; }
    public void setStatusMoto(String statusMoto) { this.statusMoto = statusMoto; }

    public Integer getKmRodado() { return kmRodado; }
    public void setKmRodado(Integer kmRodado) { this.kmRodado = kmRodado; }
}
