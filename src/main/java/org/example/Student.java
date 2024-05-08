import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getAverageGrade() {
        double totalGrade = 0;
        for (Course course : courses) {
            totalGrade += course.getCourseGrade();
        }
        return totalGrade / courses.size();
    }
}