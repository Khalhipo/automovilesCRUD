/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automovilescrud;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Automoviles;
import modelo.AutomovilesCRUD;

/**
 * REST Web Service
 *
 * @author Bueno
 */
@Path("rest")
public class AutomovilesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AutomovilesResource
     */
    public AutomovilesResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.automovilescrud.AutomovilesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/auto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Automoviles getAuto(@PathParam("id") int id) {
        Automoviles miAuto = AutomovilesCRUD.getAutomovil(id);
        return miAuto;
    }
    
    @GET
    @Path("/autos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Automoviles> getAutos() {
        List<Automoviles> misAutos = AutomovilesCRUD.getAutomoviles();
        return misAutos;
    }
    
    @POST
    @Path("/auto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void setAuto(Automoviles auto) {
        AutomovilesCRUD.insertaAutomovil(auto);
    }
    
    @PUT
    @Path("/auto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Automoviles updateAuto(Automoviles auto) {
        AutomovilesCRUD.actualizaAutomovil(auto);
        return auto;
    }
    
    @DELETE
    @Path("/auto/{id}")
    public void deleteAuto(@PathParam("id") int id) {
        AutomovilesCRUD.destroyAutomovil(id);
    }
}
