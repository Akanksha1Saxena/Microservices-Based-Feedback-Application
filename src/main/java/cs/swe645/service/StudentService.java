package cs.swe645.service;
import cs.swe645.model.Survey;
import java.util.List;

public interface StudentService {
	
	Survey createSurvey(Survey survey);
	List<Survey> getAllSurveys();
	Survey getSurveyById(Long id);
	Survey updateSurvey(Long id, Survey surveyDetails);
	void deleteSurvey(Long id);
	}


