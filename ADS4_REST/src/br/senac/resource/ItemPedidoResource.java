package br.senac.resource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.omg.CORBA.Environment;

import br.senac.dao.ItemDAO;
import br.senac.model.Erro;
import br.senac.model.Item;
import br.senac.model.ItemPedido;
import br.senac.model.Pedido;
import br.senac.model.Usuario;
import br.senac.service.ItemPedidoService;
import br.senac.service.UsuarioService;
import ch.qos.logback.core.net.SyslogOutputStream;

@Path("carrinho")
public class ItemPedidoResource {
	
	ItemPedidoService service = new ItemPedidoService();
	ItemDAO itemDAO = new ItemDAO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(ItemPedido itemPedido){
//		itemPedido.setItem(itemDAO.getItem(itemPedido.getItem().getId()));
		itemPedido = service.addItem(itemPedido);
		if (itemPedido == null ) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().entity(itemPedido).build();

//		} catch (IllegalAccessException | NoSuchAlgorithmException | IOException e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity(new Error(Erro.SEM_PERMISSAO)).build();
//		}
	}
}













