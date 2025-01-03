package com.spring.test;

import com.spring.test.models.CollegeStudent;
import com.spring.test.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestApplication.class)
class TestApplicationTests {

	private static int count = 0;

	@Value("${info.app.name}")
	private String appName;

	@Value("${info.app.description}")
	private String appDescription;

	@Value("${info.app.version}")
	private String appVersion;

	@Value("${info.school.name}")
	private String schoolName;

	//Inject
	@Autowired
	CollegeStudent collegeStudent;

	//Inject
	@Autowired
	StudentGrades studentGrades;

	//Inject
	@Autowired
	ApplicationContext context;


	@BeforeEach
	public void beforeEach(){
		count += 1;
		System.out.println("Testing " + appName + " which is " + appDescription + "  Version: " + appVersion + " .Execution of Test method " + schoolName + " " + count);
		collegeStudent.setFirstname( "John" );
		collegeStudent.setLastname("Smith");
		collegeStudent.setEmailAddress("johnsmith@gmail.com");
		studentGrades.setMathGradeResults(new ArrayList<>(
				Arrays.asList(
						100.0, 90.0, 80.0
				)
		));
		collegeStudent.setStudentGrades(studentGrades);
	}


    @DisplayName("Add grade result for a student grades")
	@Test
	public void addGradeResultsForStudentGrades() {
		double resultExpected = 100.0 + 90.0 + 80.0;
		assertEquals(resultExpected, studentGrades.addGradeResultsForSingleClass(
				collegeStudent.getStudentGrades().getMathGradeResults()
		));
	}

	@DisplayName("Add grade result for a student grades not equals")
	@Test
	public void addGradeResultsForStudentGradesNotEquals() {
		double resultExpected = 100.0 + 90.0 + 80.0 + 100.0;
		assertNotEquals(resultExpected, studentGrades.addGradeResultsForSingleClass(
				collegeStudent.getStudentGrades().getMathGradeResults()
		));
	}

	@DisplayName("Is grade greater")
	@Test
	public void isGradeGreaterStudentGrades(){
		assertTrue(studentGrades.isGradeGreater(100.0 , 90.0),"failure - should be true");
	}

	@DisplayName("Is grade greater false")
	@Test
	public void isGradeGreaterStudentGradesFalse(){
		assertFalse(studentGrades.isGradeGreater(100.0 , 150.0),"failure - should be false");
	}

	@DisplayName("Check Null for student grades")
	@Test
	public void checkNullForStudentGrades(){
		assertNotNull(studentGrades.checkNull(
				collegeStudent.getStudentGrades().getMathGradeResults()),
				"Object should not be null"
		);
	}

	@DisplayName("Create student without grade init")
	@Test
	public void createStudentWithoutGradeInit(){
		CollegeStudent collegeStudent2 = context.getBean("collegeStudent", CollegeStudent.class);
		collegeStudent2.setFirstname( "Micheal" );
		collegeStudent2.setLastname("KingKong");
		collegeStudent2.setEmailAddress("MichealKingKong@gmail.com");
		assertNotNull(collegeStudent2.getFirstname());
		assertNotNull(collegeStudent2.getLastname());
		assertNotNull(collegeStudent2.getEmailAddress());

		assertNull(studentGrades.checkNull(collegeStudent2.getStudentGrades()));
	}

	@DisplayName("Verify students are prototypes")
	@Test
	public void verifyStudentsArePrototypes(){
		CollegeStudent collegeStudent2 = context.getBean("collegeStudent", CollegeStudent.class);
		assertNotSame(collegeStudent, collegeStudent2);
	}

	@DisplayName("Find Grade Point Average")
	@Test
	public void findGradePointAverage(){
		double resultTotalExpected = 100.0 + 90.0 + 80.0;
		double resultAverageExpected = resultTotalExpected / 3;
		assertAll("Testing all AssertEquals",
				() -> assertEquals(resultTotalExpected, studentGrades.addGradeResultsForSingleClass(
						collegeStudent.getStudentGrades().getMathGradeResults())),
				() -> assertEquals(resultAverageExpected, studentGrades.findGradePointAverage(
									collegeStudent.getStudentGrades().getMathGradeResults()))
		);
	}
}

