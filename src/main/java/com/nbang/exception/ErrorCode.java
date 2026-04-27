package com.nbang.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE("잘못된 입력값입니다."),
    EXPENSE_NOT_FOUND("지출 내역을 찾을 수 없습니다."),
    FORBIDDEN("권한이 없습니다."),
    RATIO_SUM_INVALID("비율의 합이 100이 아닙니다."),
    CUSTOM_AMOUNT_MISMATCH("금액 합계가 일치하지 않습니다."),
    INVALID_TITLE("제목이 너무 짧거나 깁니다."),
    INVALID_AMOUNT("금액은 0보다 커야 합니다."),
    MEMBER_REQUIRED("멤버 지정이 필요합니다.");

    private final String message;
}