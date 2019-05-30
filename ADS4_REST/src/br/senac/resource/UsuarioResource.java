package br.senac.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senac.model.Usuario;
import br.senac.service.UsuarioService;



@Path("/usuario")
public class UsuarioResource {

	private static UsuarioService service = new UsuarioService();

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("usuario") String userName){
		if (userName.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			Usuario usuario = service.getUser(userName);
			return Response.ok().entity(usuario).build();
		}
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Usuario usuario){
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			Usuario usuarioSalvo = service.saveUser(usuario);
			return Response.ok().entity(usuarioSalvo).build();
		}
    }
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@QueryParam("id") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.accepted().build();
		}
    }
	
	
}










