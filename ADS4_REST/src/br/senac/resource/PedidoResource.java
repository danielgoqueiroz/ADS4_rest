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
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("pedido") String id){
		if (id.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			Pedido pedido= service.getPedido(id);
			return Response.ok().entity(pedido).build();
		}
    }
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response addItem(Usuario usuario, ItemPedido itemPedido, Pedido pedido){
//		
//		
//		return Response.ok().entity(pedido).build();
//	}

//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response save(Pedido pedido){
//		if (pedido == null) {
//			return Response.status(Response.Status.BAD_REQUEST).build();
//		} else {
//			Pedido pedidoSalvo = service.savePedio(pedido);
//			return Response.ok().entity(pedidoSalvo).build();
//		}
//    }
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelar(@QueryParam("id") String id, Usuario usuario){
		//valida usuario com pedido 
		
		service.cancelarPedido(id);		
		
			return Response.accepted().build();
    }
	
}
