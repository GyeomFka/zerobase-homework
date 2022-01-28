package com.example.zerobase;

import com.example.zerobase.domain.ZerobaseCourse;
import com.example.zerobase.domain.ZerobaseCourseRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Homework {
    private final ZerobaseCourseRepository repository;

    // TODO: 테스트가 통과할 수 있도록 아래 메서드 들을 작성하세요.

    public Optional<ZerobaseCourse> getZerobaseCourse(Long id) {
        // TODO: id 가 일치하며, hidden = false 인 강의만 조회되어야 함
        Optional<ZerobaseCourse> optionalCourse = repository.findAll().stream()
            .filter(course -> course.getId() == id)
            .filter(course -> course.isHidden() == false)
            .findAny();

        return optionalCourse;
    }

    public List<ZerobaseCourse> getZerobaseCourse(String status) {
        // TODO: status가 일치하고, hidden = false 인 강의들이 조회되어야 함
        List<ZerobaseCourse> courseList = repository.findAll().stream()
            .filter(course -> course.getStatus().equals(status))
            .filter(course -> course.isHidden() == false)
            .collect(Collectors.toList());

        return courseList;
    }

    public List<ZerobaseCourse> getOpenZerobaseCourse(LocalDate targetDt) {
        // TODO: status = "OPEN" 이고, hidden = false 이며,
        //  startAt <= targetDt && targetDt <= endAt 인 강의만 조회되어야함.
        List<ZerobaseCourse> courseList = repository.findAll().stream()
            .filter(course -> course.getStatus().equals("OPEN"))
            .filter(course -> course.getStartAt().isBefore(targetDt))
            .filter(course -> course.getEndAt().isAfter(targetDt))
            .filter(course -> course.isHidden() == false)
            .collect(Collectors.toList());

        return courseList;
    }
}
