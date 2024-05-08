import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Student> students = readStudentsFromJson("/Users/mac/Documents/PWR/Programowanie/students.json");
        double highestAverageGrade = 0;
        Student highestScoringStudent = null;

        for (Student student : students) {
            double averageGrade = student.getAverageGrade();
            System.out.println(student.getName() + "'s average grade: " + averageGrade);
            if (averageGrade > highestAverageGrade) {
                highestAverageGrade = averageGrade;
                highestScoringStudent = student;
            }
        }

        if (highestScoringStudent != null) {
            System.out.println("\nStudent with the highest average grade: " + highestScoringStudent.getName());
        }
    }

    private static List<Student> readStudentsFromJson(String filePath) {
        List<Student> students = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type studentListType = new TypeToken<ArrayList<Student>>(){}.getType();
            students = gson.fromJson(reader, studentListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
