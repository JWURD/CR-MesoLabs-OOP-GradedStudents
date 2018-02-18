package io.zipcoder;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public class Classroom {
    private Student[] students;

    private int numberOfEnrolledStudents;

    public Classroom() {
        this(30);
        numberOfEnrolledStudents = 0;
    }

    public Classroom(int maxStudents) {
        students = new Student[maxStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    /**
     * @return
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * Adds a student to the class, and returns true.
     * If you cannot add any more students, then return false and print an error statement.
     *
     * @param student
     * @return
     */
    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                students[i] = student;
                numberOfEnrolledStudents++;
                break;
            }
        }
    }


    /**
     * @param firstName
     * @param lastName
     * @return
     */
    public boolean removeStudent(String firstName, String lastName) {

        for (int i = 0; i < students.length; i++) {
            if ((students[i].getFirstName().equals(firstName)) && (students[i].getLastName().equals(lastName))) {
                students[i] = null;
                return true;
            }
        }
        Arrays.sort(students);
        return false;
    }


    /**
     * Define a getter which returns the sum of all exams divded by the number of students.
     *
     * @return
     */
    public double getClassAverage() {
        double numberOfStudents = 0.0;
        double sumOfAllTestScores = 0.0;
        double averageScore;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            } else {
                sumOfAllTestScores += students[i].getAverage();
                numberOfStudents++;
            }
        }
        averageScore = Math.round(sumOfAllTestScores / numberOfStudents);
        return averageScore;
    }


    /**
     * @return
     */

    public Student[] getClassScores() {
        Arrays.sort(this.students, compareByAvgScoreThenByName);
        return this.students;
    }


    /**
     * Sorts the Students array from highest average to lowest, and ties are broken alphabetically.
     */
    /*public void sortStudentsByScore() {

    }*/

    /**
     * CHALLENGE METHOD: Don't stress on this.  It's just a little something to challenge you.
     * Must return a string like in `getClassScore`, except it should look like this:
     * Grades:
     * Lisa Simpson -> A
     * Milhouse Van Houten -> B
     * Bart Simpson -> C
     * Homer Simpson -> F
     * <p>
     * And if there are no student's, just return No students.
     * <p>
     * The way the grading is done is by a bell curve where, ideally, the grades should be distributed like this:
     * 10% get A
     * 25% get B
     * 30% get C
     * 25% get D
     * 10% get F
     * <p>
     * Don't stress too much on the grading, but show that you can separate students into those
     * sections and then print that out.
     *
     * @return
     */


    public String gradeGradeBookToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry gradeBookToString : getGradeBook().entrySet()) {
            if (gradeBookToString.getValue() == null) {
                break;
            }
            sb.append(gradeBookToString.getKey() + ":" + gradeBookToString.getValue() + "\n");
        }
        return sb.toString();
    }

    public HashMap<Student, Character> getGradeBook() {
        Student[] students = getClassScores();
        HashMap<Student, Character> mapOfStudentsWithLetterGrade = new HashMap<Student, Character>();
        for (Student s : students) {
            if (s == null) {
                break;
            }
            mapOfStudentsWithLetterGrade.put(s, getStudentGrade(s));
        }
        return mapOfStudentsWithLetterGrade;
    }

    /**
     *
     * @param averages
     * @param percentile
     * @return
     */
    public double percentileThreshold(double[] averages, double percentile) {
        int index = (int) Math.ceil(percentile * (double) numberOfEnrolledStudents);
        double result = (averages[numberOfEnrolledStudents - index] + averages[numberOfEnrolledStudents - (index + 1)]) / 2;
        return result;
    }

    /**
     *
     * @return
     */
    public double[] getAllStudentsAvgExamSores() {
        double[] studentsAvgScores = new double[getStudents().length];
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }
            studentsAvgScores[i] = students[i].getAverage();
        }
        return studentsAvgScores;
    }

    /**
     *
     * @param student
     * @return
     */
    public Character getStudentGrade(Student student) {
       getClassScores();
       double[] studentAvgScore = getAllStudentsAvgExamSores();
        if (student.getAverage() >= percentileThreshold(studentAvgScore,.9)) {
            return 'A';
        } else if (student.getAverage() >= percentileThreshold(studentAvgScore,.71)) {
            return 'B';
        } else if (student.getAverage() >= percentileThreshold(studentAvgScore,.5)) {
            return 'C';
        } else if (student.getAverage() >= percentileThreshold(studentAvgScore,.11)) {
            return 'D';
        }
        return 'F';
    }

    public static Comparator<Student> compareByAvgScoreThenByName = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            if (student1 == null || student2 == null) {
                return 0;
            }
            if (student1.getAverage() < student2.getAverage()) {
                return 1;
            } else if (student1.getAverage() > student2.getAverage()) {
                return -1;
            } else {
                if (student1.getLastName().equals(student2.getLastName())) {
                    return sortByFirstName(student1, student2);
                }
            }
            return sortByLastName(student1, student2);
        }
    };

    public static int sortByFirstName(Student student1, Student student2) {
        if (student1.getFirstName().compareToIgnoreCase(student2.getFirstName()) < 0) {
            return -1;
        } else if (student1.getFirstName().compareToIgnoreCase(student2.getFirstName()) > 1) {
            return 1;
        }
        return 0;
    }

    public static int sortByLastName(Student student1, Student student2) {
        if (student1.getLastName().compareToIgnoreCase(student2.getLastName()) < 0) {
            return -1;
        } else if (student1.getLastName().compareToIgnoreCase(student2.getLastName()) > 0) {
            return 1;
        }
        return 0;
    }

}

