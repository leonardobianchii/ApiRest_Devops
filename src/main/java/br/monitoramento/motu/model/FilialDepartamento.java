package br.monitoramento.motu.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "T_CM_FILIAL_DEPARTAMENTO")
public class FilialDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilialDepartamento;

    @NotBlank
    @Column(name = "nm_filial_departamento", nullable = false)
    private String nomeFilialDepartamento;

    public String getNomeFilialDepartamento() {
        return nomeFilialDepartamento;
    }

    public void setNomeFilialDepartamento(String nomeFilialDepartamento) {
        this.nomeFilialDepartamento = nomeFilialDepartamento;
    }

    public Long getIdFilialDepartamento() {
        return idFilialDepartamento;
    }

    public void setIdFilialDepartamento(Long idFilialDepartamento) {
        this.idFilialDepartamento = idFilialDepartamento;
    }
}
