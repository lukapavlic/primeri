package si.um.feri.banka.rest;

import si.um.feri.banka.dao.InMemoryDao;
import si.um.feri.banka.dto.BancniRacun;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/racuni")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BancniRacunResource {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/info")
	public String info() {
		return "BancniRacunResource";
	}

	@GET
	@Path("/")
	public List<BancniRacun> getVseRacune() {
		List<BancniRacun> ret= new ArrayList<>();
		for (si.um.feri.banka.vao.BancniRacun br : InMemoryDao.getInstance().vrniVseRacune())
			ret.add(new BancniRacun(br));
		return ret;
	}

	@GET
	@Path("/{iban}")
	public BancniRacun getRacun(@PathParam("iban") String iban) {
		return new BancniRacun(InMemoryDao.getInstance().najdiBancniRacun(iban));
	}

	@POST
	@Path("/")
	public void dodajBancniRacun(BancniRacun br) throws Exception {
		InMemoryDao.getInstance().shrani(br.asVao());
	}

	@PUT
	@Path("/{iban}")
	public void spremeniBancniRacun(BancniRacun br,@PathParam("iban") String iban) throws Exception {
		if (InMemoryDao.getInstance().najdiBancniRacun(iban)==null)
			throw new Exception("Bančni račun še ne obstaja.");
		InMemoryDao.getInstance().shrani(br.asVao());
	}

}
