package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.FeedbackForm;
import com.innopolis.toysshop.models.Feedback;
import com.innopolis.toysshop.repositories.FeedbacksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FeedbacksServiceImpl implements FeedbacksService {

    private final FeedbacksRepository feedbacksRepository;


    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbacksRepository.findAll();
    }

    @Override
    public Feedback getFeedback(Integer feedbackId) {
        return feedbacksRepository.getById(feedbackId);
    }

    @Override
    public Feedback addFeedback(FeedbackForm form) {
        Feedback feedback = Feedback.builder()
                .feedback(form.getFeedback())
                .build();

        return feedbacksRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Integer feedbackId) {
        feedbacksRepository.deleteById(feedbackId);
    }

    @Override
    public Feedback updateFeedback(FeedbackForm form, Integer feedbackId) {
        Feedback feedback = Feedback.builder()
                .id(feedbackId)
                .feedback(form.getFeedback())
                .build();

        return feedbacksRepository.save(feedback);
    }
}
