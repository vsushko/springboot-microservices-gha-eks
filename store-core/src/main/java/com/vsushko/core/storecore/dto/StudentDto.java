package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Student Dto.
 *
 * @author vsushko
 */
@Schema(description = "StudentDto Model Information")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Schema(description = "Student id")
    private Long id;

    @Schema(description = "Student Name")
    @NotBlank(message = "Student.name must be present")
    private String name;

    @Schema(description = "Student grade")
    @NotNull(message = "Student.grade must be present")
    @Positive(message = "student.grade must be a positive value")
    private Integer grade;

    @Schema(description = "Student mobile number")
    @NotNull(message = "student.mobileNumber must be present")
    private String mobileNumber;

    @Schema(description = "Student school name")
    @NotEmpty(message = "Student.schoolName must be present")
    private String schoolName;

    @Schema(description = "Student study model")
    @NotEmpty(message = "Student.studyType must be present")
    private String studyType;
}
