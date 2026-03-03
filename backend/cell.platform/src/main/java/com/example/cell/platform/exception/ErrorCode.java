package com.example.cell.platform.exception;

public enum ErrorCode {

    // Global
    G000("필수 필드의 값이 NULL 또는 빈 값인 경우"),
    G001("파일 처리 실패"),
    G002("디렉토리 생성 실패"),

    // 서버 예외
    SERVER_ERROR("서버에서 예외가 발생한 경우");

    private final String description;

    ErrorCode(String description) { this.description = description; }

    public String getDescription() { return description; }
}
