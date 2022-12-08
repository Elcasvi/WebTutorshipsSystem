package entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.Alumnos;
import modelo.Profesores;
import modelo.Tutorias;

import java.util.List;

public class EntityManagerJPA {

    public EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    public EntityManager entityManager=entityManagerFactory.createEntityManager();

    public void persist(Object incoming) {
        entityManager.getTransaction().begin();
        entityManager.persist(incoming);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void delete(Tutorias incoming)
    {
        try
        {
            Tutorias tutoria=entityManager.find(Tutorias.class, incoming.getId_tutoria());
            entityManager.getTransaction().begin();//Inicia la transaccion
            entityManager.remove(entityManager.merge(tutoria));
            entityManager.getTransaction().commit();//Inserta la transaccion
            entityManagerFactory.close();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }
    public void update(Tutorias incoming)
    {try
        {
            entityManager.getTransaction().begin();//Inicia la transaccion
            entityManager.merge(incoming);
            entityManager.getTransaction().commit();//Inserta la transaccion
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Profesores> consultarIdProfesor(String nombreProfesor)
    {
        //entityManager.createNamedQuery("Profesores.findByNombreProfesor").setParameter("nombreProfesor",nombreProfesor).getResultList()
        return entityManager.createQuery("Select p from Profesores p where p.nombreProfesor = :nombreProfesor").setParameter("nombreProfesor", nombreProfesor).getResultList();
    }
    public List<Profesores> consultarNombreProfesor(String id_profesor)
    {
        //entityManager.createNamedQuery("Profesores.findByNombreProfesor").setParameter("nombreProfesor",nombreProfesor).getResultList()
        return entityManager.createQuery("Select p from Profesores p where p.id_profesor = :id_profesor").setParameter("id_profesor", id_profesor).getResultList();
    }

    public List<Alumnos> consultarNombreAlumnos(String id_alumno)
    {
        return entityManager.createQuery("Select a from Alumnos a where a.id_alumno = :id_alumno").setParameter("id_alumno", id_alumno).getResultList();
    }

    public List<Tutorias> getAllTutorias() {
        Query query=entityManager.createQuery("SELECT t FROM Tutorias t");
        return query.getResultList();
    }


}
