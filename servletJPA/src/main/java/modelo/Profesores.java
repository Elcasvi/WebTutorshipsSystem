package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
//@NamedQuery(name = "Profesores.findByNombreProfesor", query = "Select p from Profesores p where p.nombreProfesor = :nombreProfesor")
public class Profesores {
    @Id
    @Column(name = "id_profesor", nullable = false)
    private String id_profesor;
    @Column(name = "nombreProfesor", nullable = false)
    private String nombreProfesor;
    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }


    @Override
    public String toString() {
        return "Profesores{" +
                ", id_profesor='" + id_profesor + '\'' +
                ", profesor='" + nombreProfesor + '\'' +
                '}';
    }

}