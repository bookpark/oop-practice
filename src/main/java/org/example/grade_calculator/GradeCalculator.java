package org.example.grade_calculator;

import org.example.Course;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
