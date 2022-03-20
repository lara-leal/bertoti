package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.google.gson.Gson;

import java.util.List;


@Path("")
public class GreetingResource {

	Model model = new Model();
	
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
    

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Banda/{banda}")
   
    public Response buscarNome(@PathParam String banda) {	
		Banda BandasEncontrados = model.buscarNome(banda);	
		String json = new Gson().toJson(BandasEncontrados);
    	return Response.status(200).entity(json).build();
    }

    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Banda/{bestSong}/{numMembers}/{vocalist}/")
   
    public Response bandas2(@PathParam String bestSong, @PathParam String numMembers, @PathParam String vocalist) {	
		List<Banda> BandasEncontrados = model.buscarEspecificacao(new Especificacao(bestSong, numMembers, vocalist));	
		String json = new Gson().toJson(BandasEncontrados);
    	return Response.status(200).entity(json).build();
}
    }