package com.example.cell.platform.entity;

import com.example.cell.platform.domain.crop.CellType;
import com.example.cell.platform.domain.submission.Submission;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "submissions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubmissionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private CropEntity crop;

    @Column(nullable = false)
    private String studentId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CellType studentLabel;

    @Builder
    private SubmissionEntity(Long id, CropEntity crop, String studentId, CellType studentLabel) {
        this.id = id;
        this.crop = crop;
        this.studentId = studentId;
        this.studentLabel = studentLabel;
    }

    public static SubmissionEntity of(Submission submission, CropEntity cropEntity) {
        return SubmissionEntity.builder()
                .id(submission.getId())
                .crop(cropEntity)
                .studentId(submission.getStudentId())
                .studentLabel(submission.getStudentLabel())
                .build();
    }
}
