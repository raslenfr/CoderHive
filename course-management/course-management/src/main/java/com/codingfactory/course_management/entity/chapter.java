package com.codingfactory.course_management.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class chapter {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long chapter_id;

        @ManyToOne
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

        @Column(nullable = false)
        private String title;

        @Column(columnDefinition = "TEXT")
        private String chapter_description;

        @Column(nullable = false)
        private Integer chapter_order;

        @Column(columnDefinition = "TEXT")
        private String chapter_content;

        @Column(nullable = false, updatable = false)
        private LocalDateTime chapter_createdAt = LocalDateTime.now();

        @Column(nullable = false)
        private LocalDateTime chapter_updatedAt = LocalDateTime.now();

        @ManyToOne
        @JoinColumn(name = "quiz_id", nullable = true)
        private Quiz quiz;

        @Column(nullable = false)
        private boolean isLocked = false;

        private String authorNotes;

        @PreUpdate
        public void preUpdate() {
            this.chapter_updatedAt = LocalDateTime.now();
        }

        public Long getChapter_id() {
                return chapter_id;
        }

        public void setChapter_id(Long chapter_id) {
                this.chapter_id = chapter_id;
        }

        public Course getCourse() {
                return course;
        }

        public void setCourse(Course course) {
                this.course = course;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getChapter_description() {
                return chapter_description;
        }

        public void setChapter_description(String chapter_description) {
                this.chapter_description = chapter_description;
        }

        public Integer getChapter_order() {
                return chapter_order;
        }

        public void setChapter_order(Integer chapter_order) {
                this.chapter_order = chapter_order;
        }

        public String getChapter_content() {
                return chapter_content;
        }

        public void setChapter_content(String chapter_content) {
                this.chapter_content = chapter_content;
        }

        public LocalDateTime getChapter_createdAt() {
                return chapter_createdAt;
        }

        public void setChapter_createdAt(LocalDateTime chapter_createdAt) {
                this.chapter_createdAt = chapter_createdAt;
        }

        public LocalDateTime getChapter_updatedAt() {
                return chapter_updatedAt;
        }

        public void setChapter_updatedAt(LocalDateTime chapter_updatedAt) {
                this.chapter_updatedAt = chapter_updatedAt;
        }

        public Quiz getQuiz() {
                return quiz;
        }

        public void setQuiz(Quiz quiz) {
                this.quiz = quiz;
        }

        public boolean isLocked() {
                return isLocked;
        }

        public void setLocked(boolean locked) {
                isLocked = locked;
        }

        public String getAuthorNotes() {
                return authorNotes;
        }

        public void setAuthorNotes(String authorNotes) {
                this.authorNotes = authorNotes;
        }
}

