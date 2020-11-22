package model;

import java.io.Serializable;

public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3036427044941933352L;
	private double gpa;
	private Major major;
	private MiniCourseBag miniCourseBag;
	private MajorTemplate template;

	public Student(Name name, Major major, MiniCourseBag miniCourseBag,String phoneNumber) {
		super(name,phoneNumber);
		this.major = major;
		this.miniCourseBag=miniCourseBag;
	}

	

	public double getGpa(College college) {
		MiniCourse[] gpaArray = getMiniCourseBag().getMiniCourseArray();
		double runningTempGpaTop;
		double runningGpaTop = 0;
		double runningGpaBot;
		double creditTotal = 0;
		for (int i = 0; i < miniCourseBag.getNElems(); i++) {
			CourseType typeActual = gpaArray[i].getCourseType();
			CourseGrade actualGrade = gpaArray[i].getCourseGrade();
			String courseNum = gpaArray[i].getMiniCourseNumber();
			Course course = college.getMasterCourseBag().findByCourseNumber(courseNum);
			double numCredits = course.getNumberOfCredits();
			
			if (typeActual.equals(CourseType.TAKEN)) {
				creditTotal +=numCredits;
				if (actualGrade.equals(CourseGrade.A)) {
					runningTempGpaTop = 4.0 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.B_PLUS)) {
					runningTempGpaTop = 3.5 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.B)) {
					runningTempGpaTop = 3.0 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.C_PLUS)) {
					runningTempGpaTop = 2.5 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.C)) {
					runningTempGpaTop = 2 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.D_PLUS)) {
					runningTempGpaTop = 1.5 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				} else if (actualGrade.equals(CourseGrade.D)) {
					runningTempGpaTop = 1.0 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				}
				
				else if (actualGrade.equals(CourseGrade.F)) {
					runningTempGpaTop = 0.0 * numCredits;
					runningGpaTop +=runningTempGpaTop;
					gpa = runningGpaTop / creditTotal;
				}

			}

		}

		return gpa;
	}
	
	public double getGpaExport() {
		return gpa;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public MiniCourseBag getMiniCourseBag() {
		return miniCourseBag;
	}

	public void setMiniCourseBag(MiniCourseBag miniCourseBag) {
		this.miniCourseBag = miniCourseBag;
	}
}
