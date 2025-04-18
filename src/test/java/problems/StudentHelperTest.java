package problems;

import org.example.basic.StudentHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentHelperTest {

	StudentHelper helper = new StudentHelper();

	// Test GradeB Component
	@Test
	public void shouldReturnFalseForGradeB_WhenScoreIs50OrLess_RegardlessOfMaths() {
		assertEquals(false, helper.isGradeB(30, false));
		assertEquals(false, helper.isGradeB(50, false));
		assertEquals(false, helper.isGradeB(30, true));
		assertEquals(false, helper.isGradeB(50, true));
	}

	@Test
	public void shouldReturnTrueForGradeB_WhenScoreBetween51And80_WithoutMaths() {
		assertEquals(true, helper.isGradeB(51, false));
		assertEquals(true, helper.isGradeB(80, false));
	}

	@Test
	public void shouldReturnFalseForGradeB_WhenScoreAbove80_WithoutMaths() {
		assertEquals(false, helper.isGradeB(81, false));
	}

	@Test
	public void shouldReturnTrueForGradeB_WhenScoreBetween51And90_WithMaths() {
		assertEquals(true, helper.isGradeB(51, true));
		assertEquals(true, helper.isGradeB(80, true));
		assertEquals(true, helper.isGradeB(81, true));
		assertEquals(true, helper.isGradeB(89, true));
		assertEquals(true, helper.isGradeB(90, true));
	}

	@Test
	public void shouldReturnFalseForGradeB_WhenScoreAbove90_WithMaths() {
		assertEquals(false, helper.isGradeB(91, true));
	}


	// Test Grade Component
	@Test
	public void shouldReturnCorrectGrade_WithoutMaths() {
		assertEquals("A", helper.getGrade(99, false));
		assertEquals("A", helper.getGrade(91, false));
		assertEquals("B", helper.getGrade(85, false));
		assertEquals("B", helper.getGrade(51, false));
		assertEquals("C", helper.getGrade(50, false));
		assertEquals("C", helper.getGrade(45, false));
		assertEquals("B", helper.getGrade(90, false));
	}

	@Test
	public void shouldReturnCorrectGrade_WithMaths() {
		assertEquals("A", helper.getGrade(99, true));
		assertEquals("A", helper.getGrade(96, true));
		assertEquals("B", helper.getGrade(89, true));
		assertEquals("B", helper.getGrade(56, true));
		assertEquals("C", helper.getGrade(55, true));
		assertEquals("C", helper.getGrade(50, true));
		assertEquals("C", helper.getGrade(45, true));
		assertEquals("B", helper.getGrade(95, true));
	}

	// Test For Qualify Component
	@Test
	public void shouldReturnNo_WhenScoresBelowThreshold() {
		assertEquals("NO", helper.willQualifyForQuiz(15, 25, false));
		assertEquals("NO", helper.willQualifyForQuiz(20, 20, false));
		assertEquals("NO", helper.willQualifyForQuiz(15, 25, true));
		assertEquals("NO", helper.willQualifyForQuiz(20, 20, true));
		assertEquals("NO", helper.willQualifyForQuiz(21, 21, true));
		assertEquals("NO", helper.willQualifyForQuiz(25, 25, true));
	}

	@Test
	public void shouldReturnMaybe_WhenScoresInMidRange() {
		assertEquals("MAYBE", helper.willQualifyForQuiz(21, 21, false));
		assertEquals("MAYBE", helper.willQualifyForQuiz(25, 25, false));
		assertEquals("MAYBE", helper.willQualifyForQuiz(79, 79, false));
		assertEquals("MAYBE", helper.willQualifyForQuiz(27, 34, true));
		assertEquals("MAYBE", helper.willQualifyForQuiz(79, 79, true));
		assertEquals("MAYBE", helper.willQualifyForQuiz(80, 30, true));
		assertEquals("MAYBE", helper.willQualifyForQuiz(80, 84, true));
	}

	@Test
	public void shouldReturnYes_WhenScoresAboveThreshold() {
		assertEquals("YES", helper.willQualifyForQuiz(80, 30, false));
		assertEquals("YES", helper.willQualifyForQuiz(85, 30, false));
		assertEquals("YES", helper.willQualifyForQuiz(30, 90, false));
		assertEquals("YES", helper.willQualifyForQuiz(85, 30, true));
		assertEquals("YES", helper.willQualifyForQuiz(30, 90, true));
	}
}
