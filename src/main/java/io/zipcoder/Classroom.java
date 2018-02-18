package io.zipcoder;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {
    private Student[] students;
    // Helper fields
    private int studentsEnrolled;

    public Classroom() {
        this(30);
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
        //ArrayList<Student> classRoomList = new ArrayList<Student>();
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
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
            if (students[i] != null) {
                sumOfAllTestScores += students[i].getAverage();
                numberOfStudents++;
            }
        }
        averageScore = Math.round(sumOfAllTestScores / numberOfStudents);
        return averageScore;
    }


    /**
     * Return a string of student names and their averages, like.
     * <p>
     * Students:
     * Bart Simpson -> 72.4
     * Homer Simpson -> 0.1
     * Lisa Simpson -> 100.0
     * Milhouse Van Houten -> 87.6
     * <p>
     * If there are no students in the array, return No Students.
     *
     * @return
     */


    public Student[] getClassScores() {

        Student temp;
// bubble sort
        for (int i = 0; i < students.length -1; i++) {
            if (students[i] == null) {
                break;
            }
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getAverage() < students[j + 1].getAverage() ||) {
                    boolean swapped = false;
                    temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }

            }
            return students;
        }


            /**
             * Sorts the Students array from highest average to lowest, and ties are broken alphabetically.
             */
            public void sortStudentsByScore () {

            }

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
            public String gradeClass () {
                return null;
            }
        }
