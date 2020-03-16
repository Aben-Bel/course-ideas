package com.abenbel.courses.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.*;

public class CourseIdea {
    public String getSlug() {
        return slug;
    }

    private String slug;
    private String title;
    private String creator;
    private Set<String> voters;

    public CourseIdea(String title, String creator) {
        voters = new HashSet<>();
        this.title = title;
        this.creator = creator;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addVoter(String voterUsername){
        return voters.add(voterUsername);
    }

    public int getVoteCount(){
        return voters.size();
    }

    public List<String> getVoters() {
        return new ArrayList<>(voters);
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseIdea that = (CourseIdea) o;
        return title.equals(that.title) &&
                creator.equals(that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, creator);
    }
}
