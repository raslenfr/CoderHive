package com.codingfactory.course_management.Service;

import com.codingfactory.course_management.entity.Course;
import com.codingfactory.course_management.Repository.CourseRepository;
import com.codingfactory.course_management.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // ✅ Create a new course
    public Course createCourse(Course course) {
        course.setCourse_createdAt(LocalDateTime.now());
        course.setCourse_updatedAt(LocalDateTime.now());

        // ✅ Ensure the teacher is correctly mapped
        if (course.getTeacher() == null) {
            Teacher teacher = new Teacher();
            teacher.setTeacher_id(1L); // ✅ Assign default teacher ID
            course.setTeacher(teacher);
        }
        if (course.getCourse_image() == null || course.getCourse_image().isEmpty()) {
            course.setCourse_image("/uploads/default-course.png"); // ✅ Set a default image (change format if needed)
        }
        return courseRepository.save(course);
    }

    // ✅ Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // ✅ Get a Course by its ID
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    // ✅ Update an existing Course (Renamed to match Controller)
    public Course updateCourseById(Long courseId, Course courseDetails) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setCourse_title(courseDetails.getCourse_title());
        existingCourse.setCourse_category(courseDetails.getCourse_category());
        existingCourse.setCourse_description(courseDetails.getCourse_description());
        existingCourse.setLevel(courseDetails.getLevel());
        existingCourse.setCourse_paid(courseDetails.isCourse_paid());
        existingCourse.setCourse_image(courseDetails.getCourse_image()); // ✅ Ensure the updated image is set
        existingCourse.setCourse_price(courseDetails.getCourse_price()); // ✅ Added course_price update
        existingCourse.setCourse_updatedAt(LocalDateTime.now());

        return courseRepository.save(existingCourse);
    }

    // ✅ Delete a Course
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }
}
