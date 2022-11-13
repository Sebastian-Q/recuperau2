package utez.edu.mx.examenrecuperau2.controller;

import utez.edu.mx.examenrecuperau2.model.estudiantes.BeanEstudiantes;
import utez.edu.mx.examenrecuperau2.model.estudiantes.DaoEstudiantes;
import utez.edu.mx.examenrecuperau2.util.Response;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/estudiantes")
public class EstudiantesServices {
    Map<String, Object> response = new HashMap<>();
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanEstudiantes> getAll(){
        return new DaoEstudiantes().findAll();
    }

    @POST
    @Path("/")
    @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanEstudiantes estudiantes){
        Response<BeanEstudiantes> result = new DaoEstudiantes().save(estudiantes);
        response.put("result", result);
        return response;
    }
    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Response<BeanEstudiantes> update(BeanEstudiantes estudiante){
        return new DaoEstudiantes().update(estudiante);
    }

    @GET
    @Path("/calificaciones")
    @Produces(value = {"application/json"})
    public List<BeanEstudiantes> estudCalif(){
        return new DaoEstudiantes().estudCalif();
    }



    /*@GET
    @Path("/promedio")
    @Produces(value = {"application/json"})
    */

}
