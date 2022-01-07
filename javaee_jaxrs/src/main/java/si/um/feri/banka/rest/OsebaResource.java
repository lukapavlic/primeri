package si.um.feri.banka.rest;

import si.um.feri.banka.dao.InMemoryDao;
import si.um.feri.banka.dto.OsebaExtended;
import si.um.feri.banka.vao.Oseba;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/osebe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebaResource {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/info")
	public String info() {
		return "OsebaResource";
	}

	@GET
	@Path("/")
	public Collection<Oseba> getVseOsebe() {
		return InMemoryDao.getInstance().vrniVseOsebe();
	}

	@GET
	@Path("/{email}")
	public Oseba getOseba(@PathParam("email") String email) {
		return InMemoryDao.getInstance().najdiOsebo(email);
	}

	@GET
	@Path("/ext/{email}")
	public OsebaExtended getOsebaExtended(@PathParam("email") String email) {
		return new OsebaExtended(InMemoryDao.getInstance().najdiOsebo(email),InMemoryDao.getInstance().najdiBancniRacunLastnika(email));
	}

	@POST
	@Path("/")
	public Oseba dodajOsebo(Oseba o) throws Exception {
		return InMemoryDao.getInstance().shrani(o);
	}

	@PUT
	@Path("/{email}")
	public Oseba spremeniOsebo(Oseba o,@PathParam("email") String email) throws Exception {
		if (InMemoryDao.getInstance().najdiOsebo(email)==null)
			throw new Exception("Oseba še ne obstaja.");
		return InMemoryDao.getInstance().shrani(o);
	}

}
