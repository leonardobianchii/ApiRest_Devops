package br.monitoramento.motu.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "T_CM_SENSOR_RFID")
public class SensorRFID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSensor;

    @NotBlank
    @Column(name = "nm_sensor", nullable = false)
    private String nomeSensor;

    @ManyToOne
    @JoinColumn(name = "id_filial_departamento", nullable = false)
    private FilialDepartamento filialDepartamento;

    @Column(name = "nm_localizacao")
    private String localizacao;

    public String getNomeSensor() {
        return nomeSensor;
    }

    public void setNomeSensor(String nomeSensor) {
        this.nomeSensor = nomeSensor;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public FilialDepartamento getFilialDepartamento() {
        return filialDepartamento;
    }

    public void setFilialDepartamento(FilialDepartamento filialDepartamento) {
        this.filialDepartamento = filialDepartamento;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}