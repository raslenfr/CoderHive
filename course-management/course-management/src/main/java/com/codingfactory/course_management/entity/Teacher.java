package com.codingfactory.course_management.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teacher_id") // ✅ Ensures correct column mapping in DB
        private Long teacher_id;

        @Column(nullable = false)
        @NotBlank(message = "Name cannot be empty")
        @JsonProperty("name") // 🔹 Ensures JSON correctly maps this field
        private String name;

        @Column(nullable = false)
        @NotBlank(message = "Speciality cannot be empty")
        @JsonProperty("speciality") // 🔹 Ensures JSON correctly maps this field
        private String speciality;

        // ✅ Updated Getters and Setters
        public Long getTeacher_id() {
                return teacher_id;
        }

        public void setTeacher_id(Long teacher_id) {
                this.teacher_id = teacher_id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSpeciality() {
                return speciality;
        }

        public void setSpeciality(String speciality) {
                this.speciality = speciality;
        }
}
