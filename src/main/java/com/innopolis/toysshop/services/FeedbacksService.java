package com.innopolis.toysshop.services;

import com.innopolis.toysshop.forms.FeedbackForm;
import com.innopolis.toysshop.models.Feedback;

import java.util.List;

public interface FeedbacksService {
    List<Feedback> getAllFeedbacks();

    Feedback getFeedback(Integer feedbackId);

    Feedback addFeedback(FeedbackForm form);

    void deleteFeedback(Integer feedbackId);

    Feedback updateFeedback(FeedbackForm form, Integer feedbackId);
}
