package model;

import app.App;
import javafx.scene.control.SeparatorMenuItem;

public class MajorTemplate {
	private MiniCourseBag[] miniCourseTemplateArray;
	private int nElems;//number of majors

	public MajorTemplate() {
		this.miniCourseTemplateArray=null;
		this.nElems=0;
	}

	public MiniCourseBag getMiniCourseBag(Major major) {
		MiniCourseBag theBag= new MiniCourseBag(1000);
		Course[] arr=App.getCollege().getMasterCourseBag().getCourseArray();
		String courseNumber;
		if (major==Major.CSE) {
			for (int i=0;i<App.getCollege().getMasterCourseBag().getNElems();i++) {
				if (arr[i].getCourseNumber().charAt(0)=='C'&&arr[i].getCourseNumber().charAt(1)=='S'&&arr[i].getCourseNumber().charAt(2)=='E') {
					courseNumber=arr[i].getCourseNumber();
					MiniCourse miniCourse= new MiniCourse(courseNumber,CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE);
					theBag.insert(miniCourse);
				}
			}
			theBag.insert(new MiniCourse("MAT141",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT142",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT205",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT210",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("ENG101",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("ENG102",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PHY130",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PHY132",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("HIS101",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("HIS103",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PED124",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PED146",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			
		}
		if (major==Major.CST) {
			for (int i=0;i<App.getCollege().getMasterCourseBag().getNElems();i++) {
				if (arr[i].getCourseNumber().charAt(0)=='C'&&arr[i].getCourseNumber().charAt(1)=='S'&&arr[i].getCourseNumber().charAt(2)=='T') {
					courseNumber=arr[i].getCourseNumber();
					MiniCourse miniCourse= new MiniCourse(courseNumber,CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE);
					theBag.insert(miniCourse);
				}	
			}
			theBag.insert(new MiniCourse("MAT141",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT142",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT205",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("MAT210",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("ENG101",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("ENG102",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PHY130",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PHY132",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("HIS101",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("HIS103",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PED124",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
			theBag.insert(new MiniCourse("PED146",CourseType.NEED_TO_TAKE,CourseGrade.NO_GRADE));
		}
		return theBag;
	}

}
