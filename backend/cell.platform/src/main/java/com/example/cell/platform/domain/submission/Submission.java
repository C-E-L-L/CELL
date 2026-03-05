package com.example.cell.platform.domain.submission;

import com.example.cell.platform.domain.crop.CellType;
import com.example.cell.platform.entity.SubmissionEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Submission {

    private Long id;
    private Long cropId;
    private String studentId;
    private CellType studentLabel;
    private LocalDateTime submittedAt;

    @Builder
    public Submission(Long id, Long cropId, String studentId, CellType studentLabel, LocalDateTime submittedAt) {
        this.id = id;
        this.cropId = cropId;
        this.studentId = studentId;
        this.studentLabel = studentLabel;
        this.submittedAt = submittedAt;
    }

    public static Submission create(Long cropId, String studentId, CellType studentLabel) {
        return Submission.builder()
                .cropId(cropId)
                .studentId(studentId)
                .studentLabel(studentLabel)
                .build();
    }

    public static Submission of(SubmissionEntity entity) {
        return Submission.builder()
                .id(entity.getId())
                .cropId(entity.getCrop().getId())
                .studentId(entity.getStudentId())
                .studentLabel(entity.getStudentLabel())
                .submittedAt(entity.getCreatedAt())
                .build();
    }
}
