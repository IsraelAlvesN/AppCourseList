package devandroid.israel.appcourselist.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.israel.appcourselist.model.Course;

public class CourseController {

    private List coursesList;

    public List getCoursesList(){
        coursesList = new ArrayList<Course>();

        coursesList.add(new Course("java"));
        coursesList.add(new Course("python"));
        coursesList.add(new Course("c#"));
        coursesList.add(new Course("javascript"));
        coursesList.add(new Course("kotlin"));
        coursesList.add(new Course("c++"));

        return coursesList;
    }

}
