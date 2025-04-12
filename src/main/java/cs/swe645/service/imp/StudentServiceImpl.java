package cs.swe645.service.imp;

import cs.swe645.service.*;
import cs.swe645.model.Survey;
import cs.swe645.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Studentrepo surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
    	survey.setId(null);
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found for id: " + id));
    }

    @Override
    public Survey updateSurvey(Long id, Survey surveyDetails) {
        Survey existingSurvey = getSurveyById(id);

        existingSurvey.setFirstName(surveyDetails.getFirstName());
        existingSurvey.setLastName(surveyDetails.getLastName());
        existingSurvey.setAddress(surveyDetails.getAddress());
        existingSurvey.setCity(surveyDetails.getCity());
        existingSurvey.setState(surveyDetails.getState());
        existingSurvey.setZip(surveyDetails.getZip());
        existingSurvey.setPhone(surveyDetails.getPhone());
        existingSurvey.setEmail(surveyDetails.getEmail());
        existingSurvey.setDateOfSurvey(surveyDetails.getDateOfSurvey());
        existingSurvey.setLikedMost(surveyDetails.getLikedMost());
        existingSurvey.setInterestSource(surveyDetails.getInterestSource());
        existingSurvey.setRecommendationLikelihood(surveyDetails.getRecommendationLikelihood());

        return surveyRepository.save(existingSurvey);
    }

    @Override
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}
