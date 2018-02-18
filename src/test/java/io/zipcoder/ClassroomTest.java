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
        student1 = new Student ("So", "What", new Double[]{95.4, 95.5, 75.5});
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
        Double expected = 91.0;
        Double actual = myClassRoom.getClassAverage();
      Assert.assertEquals(expected, actual, ROUND_DELTA );
    }

    @Test
    public void getClassScoresTest() {
     Student[] expected = new Student[30];
     Student[] actual = new Student[30];
     actual = myClassRoom.getClassScores();

     assertArrayEquals(expected, actual);
    }

    @Test
    public void sortStudentsByScore() {
    }

    @Test
    public void gradeClass() {
    }
}