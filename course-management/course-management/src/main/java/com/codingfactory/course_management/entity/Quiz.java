package com.codingfactory.course_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "quizzes")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Quiz {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "chapter_id", nullable = false)
        private chapter chapter;  // Foreign Key to the Chapter entity

        @Column(nullable = false)
        private String title;  // Title of the quiz

        @Column(columnDefinition = "TEXT")
        private String description;  // Description of what the quiz is about

        @Column(nullable = false, updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();  // Timestamp for quiz creation

        @Column(nullable = false)
        private LocalDateTime updatedAt = LocalDateTime.now();  // Timestamp for last update

        @Column(nullable = true)
        private Integer timeLimit;  // Time limit for the quiz (in minutes)

        @Column(nullable = true)
        private Integer passingScore;  // Required score to pass the quiz (e.g., 80%)

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private QuizStatus status = QuizStatus.NOT_STARTED;  // Status of the quiz: NOT_STARTED, IN_PROGRESS, COMPLETED

        @PreUpdate
        public void preUpdate() {
            this.updatedAt = LocalDateTime.now();  // Auto-update the `updatedAt` field when the quiz is updated
        }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChapter(chapter chapter) {
        this.chapter = chapter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setPassingScore(Integer passingScore) {
        this.passingScore = passingScore;
    }

    public void setStatus(QuizStatus status) {
        this.status = status;
    }

    public enum QuizStatus {
            NOT_STARTED, IN_PROGRESS, COMPLETED
        }
    }

