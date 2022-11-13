package utez.edu.mx.examenrecuperau2.controller;

import utez.edu.mx.examenrecuperau2.model.docentes.BeanDocentes;
import utez.edu.mx.examenrecuperau2.model.docentes.DaoDocentes;
import utez.edu.mx.examenrecuperau2.model.evaluacion.BeanEvaluacion;
import utez.edu.mx.examenrecuperau2.util.Response;


import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/docentes")
public class DocentesServices {
    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanDocentes> getAll(){
        return new DaoDocentes().findAll();
    }

    @POST
    @Path("/")
    @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanDocentes docent){
        Response<BeanDocentes> result = new DaoDocentes().save(docent);
        response.put("result", result);
        return response;
    }

    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Response<BeanDocentes> update(BeanDocentes docent){
        return new DaoDocentes().update(docent);
    }

    @POST
    @Path("/calificacion/")
    @Produces(value = {"application/json"})
    public Map<String, Object> calificacion(BeanEvaluacion evaluacion){
        Response<BeanEvaluacion> result = new DaoDocentes().calificacion(evaluacion);
        response.put("result", result);
        return response;
    }
}