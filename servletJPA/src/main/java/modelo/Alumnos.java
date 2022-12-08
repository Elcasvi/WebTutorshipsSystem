package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumnos
{
    @Id
    @Column(name = "id_alumno", nullable = false)
    private String id_alumno;

    @Column(name = "nombreAlumno", nullable = false)
    private String nombreAlumno;

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumnos) {
        this.id_alumno = id_alumnos;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String alumno) {
        this.nombreAlumno = alumno;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "id_alumno=" + id_alumno +
                ", alumno='" + nombreAlumno + '\'' +
                '}';
    }
}