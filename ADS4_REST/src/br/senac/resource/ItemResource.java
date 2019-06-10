package br.senac.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.senac.dao.ItemDAO;
import br.senac.model.Filtro;
import br.senac.model.Item;
import br.senac.service.ItemService;

@Path("item")
public class ItemResource {

	ItemDAO dao = new ItemDAO();
	Gson gson = new Gson();
	private static ItemService service = new ItemService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("item") String id, @QueryParam("descricao") String descricao){
		//O sistema deve listar todos os itens que estejam a venda em sua tela inicial, ordenados
		//pelos mais vendidos
		
		if (descricao == null) {
			descricao = "";
		}

		List<Item> items  = service.getItems(descricao);
		return Response.ok().entity(gson.toJson(items)).build();
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Item item){
		if (item == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			Item itemSalvo= service.save(item);
			return Response.ok().entity(itemSalvo).build();
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
