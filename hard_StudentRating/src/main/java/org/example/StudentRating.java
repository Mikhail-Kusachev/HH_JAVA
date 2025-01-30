package org.example;

import java.util.*;

public class StudentRating {
    public static void main(String[] args) {
        StudentRating sr = new StudentRating();
        System.out.println(sr.getStudentRating("Анна,Математика,85;Анна,Химия,90;Борис,Математика,75;Борис,История,80;Евгений,История,85;Евгений,Математика,95", "Математика,80"));
        System.out.println(sr.getStudentRating("Анна,Психология,8;Алексей,Психология,6", "Психология,8"));
        System.out.println(sr.getStudentRating("Мария,Математика,85;Мария,Химия,90;Петр,Математика,75;Петр,История,80;Ольга,Математика,70;Ольга,Химия,50", "Химия,40"));
    }

    private LinkedHashSet<Student> saveStudentData(String studentData) {
        LinkedHashSet<Student> studentSet = new LinkedHashSet<>();

        String[] data = studentData.split(";");
        for (String dataItem : data) {
            String[] item = dataItem.split(",");
            Student studentToAdd = new Student(item[0]);
            boolean isFound = false;
            for (Student student : studentSet) {
                if (student.equals(studentToAdd)) {
                    isFound = true;
                    student.addGrade(item[1], Integer.parseInt(item[2]));
                    break;
                }
            }
            if (!isFound) {
                studentToAdd.addGrade(item[1], Integer.parseInt(item[2]));
                studentSet.add(studentToAdd);
            }
        }

        return studentSet;
    }

    private LinkedList<Result> getCoursePassedStudent(LinkedHashSet<Student> studentSet, String courseInfo) {
        var resultList = new LinkedList<Result>();
        String[] course = courseInfo.split(",");
        for (Student student : studentSet) {
            Integer grade = student.getGrade().get(course[0]);
            if (grade != null && grade > Integer.parseInt(course[1])) {
                resultList.add(new Result(student.getName(), grade));
            }
        }
        return resultList;
    }

    private String getStudentRating(String studentData, String courseInfo) {
        LinkedHashSet<Student> studentSet = saveStudentData(studentData);
        LinkedList<Result> resultList = getCoursePassedStudent(studentSet, courseInfo);

        resultList.sort(Comparator.comparing(Result::getNum).reversed());

        StringBuilder builder = new StringBuilder();
        for (Result result : resultList) {
            builder.append(result.getName() + "," + result.getNum() + "\n");
        }

        return builder.isEmpty() ? "Никто" : builder.toString().trim();
    }
}

class Result {
    private String name;
    private Integer num;

    public Result(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() { return name; }
    public Integer getNum() { return num; }
}

class Student {
    private String name;
    private Map<String, Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public Map<String, Integer> getGrade() {
        return grades;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}