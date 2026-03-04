package com.example.cell.platform.domain;

import com.example.cell.platform.domain.crop.CellType;
import com.example.cell.platform.domain.submission.Submission;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubmissionTest {

    @Nested
    class Submission은 {

        @Test
        void 정상적인_인자가_들어오면_객체가_생성된다() {
            // given
            Long cropId = 1L;
            String studentId = "student";
            CellType studentLabel = CellType.Lymphocyte;

            // when
            Submission submission = Submission.create(cropId, studentId, studentLabel);

            // then
            assertThat(submission.getCropId()).isEqualTo(cropId);
            assertThat(submission.getStudentId()).isEqualTo(studentId);
            assertThat(submission.getStudentLabel()).isEqualTo(studentLabel);
            assertThat(submission.getId()).isNull();
            assertThat(submission.getSubmittedAt()).isNull();
        }

    }
}
