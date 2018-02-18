package io.zipcoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Student {
    private String firstName;
    private String lastName;
    private Double[] testScores;

    private int totalExams;
    private int examsTaken;
    private ArrayList<Double> examScores;

    /**
     * @param firstName
     * @param lastName
     * @param testScores
     */
    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>();
        this.testScores = testScores;

        Collections.addAll(examScores, testScores);

    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalExams() {
        return totalExams;
    }

    /**
     * @param totalExams
     */
    public void setTotalExams(int totalExams) {
        this.totalExams = totalExams;
    }

    /**
     * @return
     */
    public int getNumberOfExamsTaken() {

        return examScores.size();
    }

    /**
     * @return
     */
    public String getExamScores() {
        StringBuilder scoresToCleanString = new StringBuilder();
        int examNumebr = 1;
        for (double examScores : examScores) {
            scoresToCleanString.append("Exam " + examNumebr + " -> " + examScores + "\n");
            examNumebr++;
        }
        return scoresToCleanString.toString();
    }

    /**
     * @param examScore
     * @return
     */
    public boolean addExamScore(double examScore) {

        return examScores.add(examScore);
    }

    /**
     * @param examNumber
     * @param newScore
     */
    public void setExamScore(int examNumber, double newScore) {
        if ((examNumber >= 0.0) && (examNumber <= 100.0)) {
            examScores.set(examNumber, newScore);
        }

    }

    /**
     * This function should add the grade in the correct position in the testScores array.
     * Make sure the score is between 0 and 100, and that the student isn't taking more tests than they're supposed to.
     * If there is a problem, print an error message and return false.
     * Otherwise, return true and put the score in the right spot.
     *
     * @param score
     * @return A boolean based on if the operation worked or not.
     */
    public boolean takeExam(int score) {
        return false;
    }



    /**
     * Return the average for all of the exams that the student has taken.
     * If they haven't taken any, be nice and give them 100.0.
     *
     * @return The average for all the exams a student has taken.
     */
    public double getAverage() {
        double sumOfExamScores = 0.0;
        for (double examScore : examScores) {
            sumOfExamScores += examScore;
        }
        double avgExamScore = Math.round(sumOfExamScores / examScores.size());

        return avgExamScore;
    }

    @Override
    public String toString() {
    StringBuilder formatedStudenToString = new StringBuilder();
        formatedStudenToString.append("Student Name: " + getFirstName() + " " +getLastName() +"\n");
        formatedStudenToString.append(("Average Score:  " + getAverage() + "\n"));
        formatedStudenToString.append(getExamScores());
        return formatedStudenToString.toString();
    }
}
