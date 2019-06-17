package br.senac.resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Generated;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;

import br.senac.model.Erro;
import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;
import br.senac.service.ItemPedidoService;
import br.senac.service.PedidoService;
import br.senac.service.UsuarioService;


@Path("/pedido")
public class PedidoResource {

	PedidoService service = new PedidoService();
	static UsuarioService uService = new UsuarioService();
	Gson gson = new Gson();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pedido(@QueryParam("key") String key, List<ItemPedido> itemsPedidos){
		Usuario usuario = uService.getUser(key);
		if (usuario == null) {
			Response.status(Response.Status.UNAUTHORIZED).build();
		}
		if (itemsPedidos.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity(new Erro("Carrinho vazio.")).build();
		}

		Pedido pedido = service.realizaPedido(itemsPedidos);

		return Response.status(Response.Status.ACCEPTED).entity("{ \"pedido\" : " + pedido.getId() + " }").build(); 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("key") String key){
		Usuario usuario = uService.getUser(key);
		if (usuario == null) {
			Response.status(Response.Status.UNAUTHORIZED).build();
		}
		
		List<Pedido> pedidos = service.getAll(usuario);
		return Response.status(Response.Status.ACCEPTED).entity(gson.toJson(pedidos)).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelar(@QueryParam("key") String key, @QueryParam("id") int id){
		//valida usuario com pedido 

		service.cancelarPedido(id);		

		return Response.accepted().build();
	}

}
