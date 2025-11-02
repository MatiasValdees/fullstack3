package cl.duoc.fullstack3.ms_lab_assignment.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    PENDING(1),
    IN_PROCESS(2),
    COMPLETED(3),
    CANCELLED(4);

    private final Integer statusId;
}

