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

    public ArrayList<String> dataToSpinner(){
        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < getCoursesList().size(); i++) {
            Course object = (Course) getCoursesList().get(i);
            data.add(object.getCourseName());
        }

        return data;
    }


}
