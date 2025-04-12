package org.example.basic;

public class StudentHelper {

	/* PROBLEM 1 */	
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	private static final int GRADE_B_LOWER_LIMIT = 51;
	private static final int GRADE_B_UPPER_LIMIT = 80;
	private static final int MATHS_GRADE_OFFSET = 10;

	public boolean isGradeB(int marks, boolean isMaths) {
		return isMaths ? (marks >= GRADE_B_LOWER_LIMIT && marks <= GRADE_B_UPPER_LIMIT + MATHS_GRADE_OFFSET) : (marks >= GRADE_B_LOWER_LIMIT && marks <= GRADE_B_UPPER_LIMIT);
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	private static final int A_GRADE_LOWER_LIMIT = 91;
	private static final int A_GRADE_UPPER_LIMIT = 100;
	private static final int B_GRADE_LOWER_LIMIT = 51;
	private static final int B_GRADE_UPPER_LIMIT = 90;
	private static final int MATHS_GRADE_SHIFT = 5;

	public String getGrade(int mark, boolean isMaths) {
		if (isEligibleForGradeA(mark, isMaths)) {
			return "A";
		} else if (isEligibleForGradeB(mark, isMaths)) {
			return "B";
		} else {
			return "C";
		}
	}

	private boolean isEligibleForGradeA(int mark, boolean isMaths) {
		int lowerLimit = A_GRADE_LOWER_LIMIT + (isMaths ? MATHS_GRADE_SHIFT : 0);
		return (mark >= lowerLimit && mark <= A_GRADE_UPPER_LIMIT);
	}

	private boolean isEligibleForGradeB(int mark, boolean isMaths) {
		int lowerLimit = B_GRADE_LOWER_LIMIT + (isMaths ? MATHS_GRADE_SHIFT : 0);
		int upperLimit = B_GRADE_UPPER_LIMIT + (isMaths ? MATHS_GRADE_SHIFT : 0);
		return (mark >= lowerLimit && mark <= upperLimit);
	}

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */

	private static final int GOOD_THRESHOLD = 80;
	private static final int BAD_THRESHOLD = 20;
	private static final int MATHS_MARK_ADJUSTMENT = 5;

	public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
		int goodLimit = GOOD_THRESHOLD + (isMaths ? MATHS_MARK_ADJUSTMENT : 0);
		int badLimit = BAD_THRESHOLD + (isMaths ? MATHS_MARK_ADJUSTMENT : 0);

		if (isNotGood(marks1, badLimit) || isNotGood(marks2, badLimit)) {
			return "NO";
		}
		if (isVeryGood(marks1, goodLimit) || isVeryGood(marks2, goodLimit)) {
			return "YES";
		}
		return "MAYBE";
	}

	private boolean isNotGood(int marks, int badLimit) {
		return marks <= badLimit;
	}

	private boolean isVeryGood(int marks, int goodLimit) {
		return marks >= goodLimit;
	}
}