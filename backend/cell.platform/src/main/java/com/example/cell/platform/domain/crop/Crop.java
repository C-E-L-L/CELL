package com.example.cell.platform.domain.crop;

import com.example.cell.platform.entity.CropEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Crop {

    private Long id;
    private Long taskId;
    private String cropFilename;
    private String bbox;
    private CellType aiPrediction;
    private Double aiConfidence;
    private CellType finalLabel;

    @Builder
    public Crop(Long id, Long taskId, String cropFilename, String bbox, CellType aiPrediction, Double aiConfidence, CellType finalLabel) {
        this.id = id;
        this.taskId = taskId;
        this.cropFilename = cropFilename;
        this.bbox = bbox;
        this.aiPrediction = aiPrediction;
        this.aiConfidence = aiConfidence;
        this.finalLabel = finalLabel;
    }

    public static Crop create(String cropFilename, String bbox, CellType aiPrediction, Double aiConfidence) {
        return Crop.builder()
                .cropFilename(cropFilename)
                .bbox(bbox)
                .aiPrediction(aiPrediction)
                .aiConfidence(aiConfidence)
                .build();
    }

    public static Crop of(CropEntity entity) {
        return Crop.builder()
                .id(entity.getId())
                .taskId(entity.getTaskId())
                .cropFilename(entity.getCropFilename())
                .bbox(entity.getBbox())
                .aiPrediction(entity.getAiPrediction())
                .aiConfidence(entity.getAiConfidence())
                .finalLabel(entity.getFinalLabel())
                .build();
    }
}
