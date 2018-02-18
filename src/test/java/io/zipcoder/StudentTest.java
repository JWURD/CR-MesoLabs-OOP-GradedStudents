package io.zipcoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collection;

public class StudentTest {
    private String firstNameTest;
    private String firstNameTest1;
    private String lastNameTest;
    private String lastNameTest1;

    private Double[] testScore;
    private Double[] testScore1;

    private ArrayList<Double> listOfTestScores;

    Student studentTest;
    Student studentTest1;
    public final static double DELTA = 0.001;

    @Before
    public void setUp() throws Exception {
        firstNameTest = "John";
        firstNameTest1 = "Lady";

        lastNameTest = "Smith";
        lastNameTest1 = "Wom";
        listOfTestScores = new ArrayList<Double>();
        testScore = new Double[]{95.4, 95.5, 75.5};


        studentTest = new Student(firstNameTest, lastNameTest, testScore);
        studentTest1 = new Student(firstNameTest1, lastNameTest1, testScore);


    }

    @Test
    public void setFirstNameTest() {
        studentTest.setFirstName(firstNameTest1);
        Assert.assertEquals(firstNameTest, studentTest.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        studentTest.setLastName(firstNameTest1);
        Assert.assertEquals(firstNameTest1, studentTest.getLastName());
    }

    /*@Test
    public void setTotalExamsTest() {
        studentTest.setTotalExams();
        Assert.assertEquals(totalNumberExamsTest1, studentWithExamNumberTest.getTotalExams());
    }*/
    @Test
    public void addExamScoreTest() {
        double testScore = 5.0;
        studentTest.addExamScore(testScore);
        Assert.assertEquals(true, studentTest.addExamScore(testScore));
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        int expected = 3;
        int actual = studentTest.getNumberOfExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest() {
        String expected = "Exam 1 -> 95.4\n"
                + "Exam 2 -> 95.5\n"
                + "Exam 3 -> 75.5\n";

        Assert.assertEquals(expected, studentTest.getExamScores());
    }
    @Test
    public void setExamScoreTest(){
        String expected = "Exam 1 -> 95.4\n"
                + "Exam 2 -> 95.5\n"
                + "Exam 3 -> 0.0\n";
        int index = 2;
        double setScore = 0.0;
        studentTest.setExamScore(index,setScore);

       // studentTest.getScore(index);
        Assert.assertEquals(expected, studentTest.getExamScores());
    }

    @Test
    public void getAverageTest() {
    double  expected = 89.0;
    Assert.assertEquals(expected,  studentTest.getAverage(),DELTA );
    }

    @Test
    public void toStringTest(){
        String expected = "Student Name: John Smith\n"
        +"Average Score:  89.0\n"
        +"Exam 1 -> 95.4\n"
        +"Exam 2 -> 95.5\n"
        +"Exam 3 -> 75.5\n";

        Assert.assertEquals("should return a string of values)", expected, studentTest.toString());
    }
}