package com.codingfactory.course_management.Service;

import com.codingfactory.course_management.entity.Teacher;
import com.codingfactory.course_management.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // ✅ Add a new teacher
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // ✅ Fetch a teacher by `teacher_id`
    public Teacher getTeacherById(Long teacher_id) {
        return teacherRepository.findById(teacher_id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
}
