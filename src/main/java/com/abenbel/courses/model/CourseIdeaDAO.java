package com.abenbel.courses.model;

import java.util.List;

public interface CourseIdeaDAO {
    boolean add(CourseIdea Idea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug);
}
