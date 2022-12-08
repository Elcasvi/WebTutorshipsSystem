package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorias")
public class Tutorias
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutoria", nullable = false)
    private Integer id_tutoria;

    @Column(name = "id_alumno", nullable = false)
    private String id_alumno;

    @Column(name = "id_profesor", nullable = false)
    private String id_profesor;
    @Column(name = "dia",nullable = false)
    private String dia;

    @Column(name = "hora",nullable = false)
    private String hora;

    @Column(name = "asunto",nullable = false)
    private String asunto;


    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public Integer getId_tutoria() {
        return id_tutoria;
    }

    public void setId_tutoria(Integer id_tutoria) {
        this.id_tutoria = id_tutoria;
    }
    @Override
    public String toString() {
        return "Tutorias{" +
                "id_tutoria=" + id_tutoria +
                ", id_profesor=" + id_profesor +
                ", id_alumno=" + id_alumno +
                ", dia=" + dia +
                ", hora=" + hora +
                ", asunto=" + asunto +
                '}';
    }

}