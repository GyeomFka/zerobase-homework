package com.example.zerobase.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ZerobaseCourse {
    private Long id;

    private String name;

    private String logo;

    private CourseStatus status;

    private LocalDate startAt;

    private LocalDate endAt;

    private boolean hidden;

    @Builder
    public ZerobaseCourse(Long id, String name, String status, LocalDate startAt, LocalDate endAt,
        boolean hidden) {

        this.id = id;
        this.name = name;
        this.status = compareWithEnum(status);
        this.startAt = startAt;
        this.endAt = endAt;
        this.hidden = hidden;
    }

    private CourseStatus compareWithEnum(String status) {
        return CourseStatus.valueOf(status);
    }
}
