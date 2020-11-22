package model;

import java.io.Serializable;

public class College implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4201396559895248024L;
	private MasterCourseBag masterCourseBag;
	private PersonBag personBag;
	private TextbookBag textbookBag;
	
	public College(int maxCourses,int maxPersons, int maxBooks) {
		masterCourseBag = new MasterCourseBag(maxCourses);
		personBag = new PersonBag(maxPersons);
		textbookBag = new TextbookBag(maxBooks);
	}
	
	public College(PersonBag personBag,MasterCourseBag masterCourseBag,TextbookBag textbookBag) {
		this.masterCourseBag = masterCourseBag;
		this.personBag = personBag;
		this.textbookBag = textbookBag;
	}

	public MasterCourseBag getMasterCourseBag() {
		return masterCourseBag;
	}

	public void setMasterCourseBag(MasterCourseBag masterCourseBag) {
		this.masterCourseBag = masterCourseBag;
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}
	
}
