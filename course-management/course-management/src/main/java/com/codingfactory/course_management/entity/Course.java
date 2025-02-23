package com.codingfactory.course_management.entity;

import com.codingfactory.course_management.Enumeration.courselvl;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(nullable = false)
    private String course_title;

    @Column(nullable = false)
    private String course_category;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false) // ✅ Ensure column name matches
    private Teacher teacher;


    @Column(nullable = false, updatable = false)
    private LocalDateTime course_createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime course_updatedAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String course_description;

    @Column(nullable = false)
    private boolean course_paid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private courselvl level;

    @Column(columnDefinition = "LONGTEXT") // ✅ Allows large images stored as Base64
    private String course_image;

    @Column(nullable = false) // ✅ Added the missing price field
    private double course_price;

    // Default constructor
    public Course() {}

    // Constructor with parameters (including new field course_price)
    public Course(Long course_id, String course_title, String course_category, Teacher teacher,
                  LocalDateTime course_createdAt, LocalDateTime course_updatedAt, String course_description,
                  boolean course_paid, courselvl level, String course_image, double course_price) {
        this.course_id = course_id;
        this.course_title = course_title;
        this.course_category = course_category;
        this.teacher = teacher;
        this.course_createdAt = course_createdAt;
        this.course_updatedAt = course_updatedAt;
        this.course_description = course_description;
        this.course_paid = course_paid;
        this.level = level;
        this.course_image = course_image;
        this.course_price = course_price;  // ✅ Added the missing price field
    }

    // Getters and Setters
    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_category() {
        return course_category;
    }

    public void setCourse_category(String course_category) {
        this.course_category = course_category;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDateTime getCourse_createdAt() {
        return course_createdAt;
    }

    public void setCourse_createdAt(LocalDateTime course_createdAt) {
        this.course_createdAt = course_createdAt;
    }

    public LocalDateTime getCourse_updatedAt() {
        return course_updatedAt;
    }

    public void setCourse_updatedAt(LocalDateTime course_updatedAt) {
        this.course_updatedAt = course_updatedAt;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public boolean isCourse_paid() {
        return course_paid;
    }

    public void setCourse_paid(boolean course_paid) {
        this.course_paid = course_paid;
    }

    public courselvl getLevel() {
        return level;
    }

    public void setLevel(courselvl level) {
        this.level = level;
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    @PreUpdate
    public void preUpdate() {
        this.course_updatedAt = LocalDateTime.now();
    }
}
