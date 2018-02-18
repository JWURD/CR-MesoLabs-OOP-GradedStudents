package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomTest {
    private int maxStudents;
    //private Classroom maximumNumberOfStudents;
    private final static double ROUND_DELTA = .001;
    private Student student;
    private Student student1;
    private Student student2;
    private Student[] students;
    private Classroom myClassRoom;

    @Before
    public void setUp() throws Exception {


        student = new Student ("James", "Will", new Double[]{95.4, 95.5, 75.5});
        student1 = new Student ("Jamei", "Will", new Double[]{95.4, 95.5, 75.5});
        student2 = new Student ("Girl", "Nextdoor", new Double[]{100.0, 95.5, 85.5});

         myClassRoom = new Classroom();
         myClassRoom.addStudent(student);
         myClassRoom.addStudent(student1);
         myClassRoom.addStudent(student2);

    }

    @Test
    public void addStudent() {
    Student student3 = new Student("Bo", "Rapper", new Double[]{20.5, 45.7, 67.5});
        myClassRoom.addStudent(student3);
        Student[] expected = new Student[30];
        expected [0] = student;
        expected[1] = student1;
        expected[2] = student2;
        expected[3] = student3;
        Assert.assertArrayEquals(expected, myClassRoom.getStudents());
    }

    @Test
    public void removeStudentTest(){
        boolean expected = true;
        boolean actual = myClassRoom.removeStudent("James", "Will");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getClassAverageTest() {
        Double expected = 89.0;
        Double actual = myClassRoom.getClassAverage();
      Assert.assertEquals(expected, actual, ROUND_DELTA );
    }


    @Test
    public void getClassScoresTest() {
     Student[] expected = new Student[30];
     expected[0] = student2;
     expected[1] = student1;
     expected[2] = student;
     Student[] actual = myClassRoom.getClassScores();

     assertArrayEquals(expected, actual);
    }

    @Test
    public void percentileThreshold(){
        double a = .10;
        myClassRoom.getAllStudentsAvgExamSores();
       double actual = myClassRoom.percentileThreshold( myClassRoom.getAllStudentsAvgExamSores(), a);

        Assert.assertEquals(91.5,  actual, ROUND_DELTA);
    }

    @Test
    public void getGradeBookTest(){
        Student student3 = new Student ("Dan", "Will", new Double[]{100.0, 95.5, 60.0});
        Student student4 = new Student ("Chris", "Will", new Double[]{13.0, 95.5, 12.0});
        Student student5 = new Student ("Some", "Nextdoor", new Double[]{100.0, 95.5, 85.5});
        Student  student6 = new Student ("House", "Will", new Double[]{95.4, 95.5, 75.5});
        Student student7 = new Student ("Sam", "Will", new Double[]{95.4, 95.5, 15.0});
        Student student8 = new Student ("Girl", "Nextdoor", new Double[]{100.0, 95.5, 85.5});
        Student student9= new Student ("James", "Will", new Double[]{100.0, 100.0, 100.0});
        myClassRoom.addStudent(student3);
        myClassRoom.addStudent(student4);
        myClassRoom.addStudent(student5);
        myClassRoom.addStudent(student6);
        myClassRoom.addStudent(student7);
        myClassRoom.addStudent(student8);
        myClassRoom.addStudent(student9);

        String expected = "";
        String actual =  myClassRoom.gradeGradeBookToString();
        Assert.assertEquals(expected, actual);
    }

}