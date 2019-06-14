package br.senac.resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpParser.ResponseHandler;

import br.senac.model.Erro;
import br.senac.model.Usuario;
import br.senac.service.UsuarioService;
import javassist.expr.NewArray;



@Path("/usuario")
public class UsuarioResource {

	private static UsuarioService service = new UsuarioService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(Usuario usuario){
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			String key = service.getKey(usuario);
			return Response.ok().entity("{ \"key\": \""+key+"\"}").build();
		}
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@QueryParam("key") String key, Usuario usuario){
		if (usuario == null || usuario.getId() <1) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Usuário inexistente.").build();
		} else {
			Usuario usuarioSalvo = service.updateUser(usuario);
			if (usuarioSalvo != null) {
				System.out.println(usuarioSalvo);
				return Response.ok().entity(usuarioSalvo).build();
			} 
			return Response.status(Response.Status.BAD_REQUEST).entity(new Erro("Não foi possivel atualizar.")).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@QueryParam("key") String key, @QueryParam("id") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.accepted().build();
		}
	}


}










