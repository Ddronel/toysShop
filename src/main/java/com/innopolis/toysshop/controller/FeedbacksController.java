package com.innopolis.toysshop.controller;

import com.innopolis.toysshop.forms.FeedbackForm;
import com.innopolis.toysshop.forms.StorageForm;
import com.innopolis.toysshop.models.Feedback;
import com.innopolis.toysshop.models.Storage;
import com.innopolis.toysshop.services.FeedbacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FeedbacksController {

    private final FeedbacksService feedbacksService;

    @Autowired
    public FeedbacksController(FeedbacksService feedbacksService) {
        this.feedbacksService = feedbacksService;
    }

    @GetMapping("/feedbacks")
    public String getFeedbacksPage(Model model) {
        List<Feedback> feedbacks = feedbacksService.getAllFeedbacks();
        model.addAttribute("feedbacks", feedbacks);
        return "/feedbacks";
    }

    @GetMapping("/feedbacks/{feedback-id}")
    public String getFeedbackPage(Model model, @PathVariable("feedback-id") Integer feedbackId) {
        Feedback feedback = feedbacksService.getFeedback(feedbackId);
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

    @PostMapping("/feedbacks")
    public String addFeedback(FeedbackForm form) {
        feedbacksService.addFeedback(form);
        return "redirect:/feedbacks";
    }

    @PostMapping("/feedbacks/{feedback-id}/delete")
    public String deleteFeedback(@PathVariable("feedback-id") Integer feedbackId) {
        feedbacksService.deleteFeedback(feedbackId);
        return "redirect:/feedbacks";
    }

    @PostMapping("/feedbacks/{feedback-id}/update")
    public String UpdateFeedback(FeedbackForm form, @PathVariable("feedback-id") Integer feedbackId) {
        feedbacksService.updateFeedback(form, feedbackId);
        return "redirect:/feedbacks";
    }
}
