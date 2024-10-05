package kg.atractor.control9.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReturnStatus {
    EXPECTED("ОЖИДАЕТСЯ"),
    RETURNED("ВОЗВРАЩЕНО"),
    EXPIRED("ПРОСРОЧЕНО");

    private final String value;
}