package com.innopolis.toysshop.services;

import com.innopolis.toysshop.ToysShopApplicationTests;
import com.innopolis.toysshop.forms.FeedbackForm;
import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Feedback;
import com.innopolis.toysshop.models.Storage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeedbacksServiceImplTest extends ToysShopApplicationTests {

    @Autowired
    private FeedbacksServiceImpl feedbacksService;

    FeedbackForm feedbackForm = FeedbackForm.builder()
            .feedback("i like the toys shop")
            .build();

    @Test
    void testGetAllFeedbacks() {
        List<Feedback> feedbackList = feedbacksService.getAllFeedbacks();
        assertNotNull(feedbackList);
    }

    @Test
    void testGetFeedback() {

        Feedback createdFeedback = feedbacksService.addFeedback(feedbackForm);
        Feedback feedback = feedbacksService.getFeedback(createdFeedback.getId());

        assertNotNull(feedback);
        assertEquals(feedback.getId(), createdFeedback.getId());
        assertEquals(feedback.getFeedback(), createdFeedback.getFeedback());
    }

    @Test
    void testAddFeedback() {
        Feedback createFeedback = feedbacksService.addFeedback(feedbackForm);

        assertNotNull(createFeedback.getId());
        assertEquals(feedbackForm.getFeedback(), createFeedback.getFeedback());
    }

    @Test
    void testUpdateFeedback() {
        FeedbackForm feedbackFormUpdate = FeedbackForm.builder()
                .feedback("i like")
                .build();
        Feedback oldFeedback = feedbacksService.addFeedback(feedbackForm);
        Feedback newFeedback = feedbacksService.updateFeedback(feedbackFormUpdate, oldFeedback.getId());

        assertEquals(oldFeedback.getId(), newFeedback.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldFeedback.getFeedback(), newFeedback.getFeedback());
    }

    @Test
    void testDeleteFeedback() {
        Feedback createdFeedback = feedbacksService.addFeedback(feedbackForm);
        feedbacksService.deleteFeedback(createdFeedback.getId());
    }

}