package utez.edu.mx.examenrecuperau2.model;

import utez.edu.mx.examenrecuperau2.model.estudiantes.BeanEstudiantes;
import utez.edu.mx.examenrecuperau2.model.evaluacion.BeanEvaluacion;
import utez.edu.mx.examenrecuperau2.util.Response;

import java.util.List;
public interface Repository <T>{
    List<T> findAll();
    Response save(T object);
    Response update (T object);

    Response calificacion(BeanEvaluacion object);

    List<T> estudCalif ();

    Response promedio (T object);

}
