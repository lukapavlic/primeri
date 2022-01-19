import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/surveys")
public class SurveyController {

	private static final Logger log = Logger.getLogger(SurveyController.class.toString());

	public SurveyController(SurveyRepository dao,OptionRepository optDao) {
		this.dao = dao;
		this.optDao=optDao;
	}

	private SurveyRepository dao;

	private OptionRepository optDao;

	@DeleteMapping("/{id}/options/{optId}")
	public ResponseEntity<Survey> deleteOption(@PathVariable("id") int id,@PathVariable("optId") int optId) {
		//validate
		Optional<Survey> val=dao.findById(id);
		if (val.isEmpty()) {
			log.info("/surveys/"+id+"; Survey not found!");
			return new ResponseEntity("survey-not-found", HttpStatus.NOT_ACCEPTABLE);
		}
		Optional<Option> valOpt=optDao.findById(optId);
		if (val.isEmpty()) {
			log.info("/surveys/"+id+"/options; Option not found!");
			return new ResponseEntity("option-not-found", HttpStatus.NOT_ACCEPTABLE);
		}
		//security
		SecurityFacade.User user=SecurityFacade.getInstance().getCurrentUser();
		if (!val.get().getOwner().equals(user.getEmail())) {
			log.info("/surveys/"+id+" ; Security violation!");
			return new ResponseEntity("not-allowed", HttpStatus.FORBIDDEN);
		}
		//delete
		val.get().removeOptionWithId(valOpt.get().getId());
		val.get().setModifiedNow();
		dao.save(val.get());
		optDao.delete(valOpt.get());
		return ResponseEntity.ok(val.get());
	}

}