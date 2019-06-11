package br.senac.resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senac.model.Erro;
import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;
import br.senac.service.ItemPedidoService;

public class ItemPedidoResource {

	ItemPedidoService service = new ItemPedidoService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("itemPedido") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			ItemPedido itemPedido = service.getItemPedido(id);
			return Response.ok().entity(itemPedido).build();
		}
	}


	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(ItemPedido itemPedido){
		if (itemPedido == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			ItemPedido itemPedidoSalvo= service.save(itemPedido);
			return Response.ok().entity(itemPedidoSalvo).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@QueryParam("id") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			if (service.remove(id)) {
				return Response.accepted().build();
			} else {
				return Response.noContent().build();
			}
		}
	}


}









