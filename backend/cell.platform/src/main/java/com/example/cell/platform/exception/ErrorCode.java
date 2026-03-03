package com.example.cell.platform.exception;

public enum ErrorCode {

    // User 관련
    U000("회원가입 시, 이미 존재하는 아이디로 가입을 시도한 경우"),
    U001("로그인 시, 아이디 또는 비밀번호가 일치하지 않는 경우"),
    U002("회원가입 시, 유효하지 않은 역할(Role)을 입력한 경우"),
    U003("회원가입 시, 이름이 빈칸 또는 공백인 경우"),
    U004("회원가입 시, 비밀번호가 빈칸 또는 공백인 경우"),

    // Crop
    C000("크롭 조회 시, 크롭을 찾을 수 없는 경우"),
    C001("정답 확정 시, 유효하지 않은 셀 타입을 입력한 경우"),

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
