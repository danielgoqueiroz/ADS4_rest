package br.senac.resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senac.model.Erro;
import br.senac.model.Usuario;
import br.senac.service.UsuarioService;



@Path("/usuario")
public class UsuarioResource {

	private static UsuarioService service = new UsuarioService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("usuario") String userName){
		if (userName == null || userName.isEmpty() ) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			Usuario usuario = service.getUser(userName);
			return Response.ok().entity(usuario).build();
		}
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario){

		Usuario usuarioLogado = null;
		try {
			usuarioLogado = service.login(usuario);
		} catch (IllegalAccessException | NoSuchAlgorithmException | IOException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Erro(Erro.SEM_PERMISSAO)).build();
		}
		if (usuarioLogado == null) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Erro(Erro.SEM_PERMISSAO)).build();
		}
		return Response.ok().entity(usuarioLogado).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Usuario usuario){
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
	public Response remove(@QueryParam("id") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.accepted().build();
		}
	}


}










