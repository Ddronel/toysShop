package com.innopolis.toysshop.repositories;

import com.innopolis.toysshop.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbacksRepository extends JpaRepository<Feedback, Integer> {
}
