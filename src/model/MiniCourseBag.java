package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MiniCourseBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2938707032935322937L;
	private MiniCourse[] miniCourseArray;
	private int nElems;
	
	public MiniCourseBag(int maxSize) {
		miniCourseArray= new MiniCourse[maxSize];
		nElems=0;
	}
	
	public MiniCourseBag(MiniCourse[] template) {
		miniCourseArray= new MiniCourse[template.length];
		for (int i=0; i<template.length;i++) {
		miniCourseArray[i]=template[i];	
		}
		nElems=template.length;
	}
	
	public MiniCourse get(int i) {
		return miniCourseArray[i];
	}
	
	public int getNElems(){
		return nElems;
	}
	
	public MiniCourse removeByCourseNumber(String courseNumber) {
		int i=0;
		for (i=0;i<nElems;i++) {
			if (miniCourseArray[i].getMiniCourseNumber().contentEquals(courseNumber)) {
				break;
			}
		}
		
		if (i==nElems) {
			return null;
		}
		else {
			MiniCourse temp= miniCourseArray[i];
			for (int j=i;j<nElems-1;j++) {
				miniCourseArray[j]=miniCourseArray[j+1];
			}
			nElems--;
			return temp;
		}
	}
	
	

	public MiniCourse[] getMiniCourseArray(){
		return miniCourseArray;
	}
	
	public void insert(MiniCourse course) {
		miniCourseArray[nElems++]=course;
	}
	
	public ArrayList<MiniCourse> display() {
		ArrayList<MiniCourse> miniCourse=new ArrayList<>();
		for (int i=0; i < nElems;i++) {
			miniCourse.add(miniCourseArray[i]);
		}
		return miniCourse;
	}
	
	public MiniCourse Find(String courseNumber) {
		int i;
		for (i=0;i<nElems;i++) {
			if(miniCourseArray[i].getMiniCourseNumber().contentEquals(courseNumber)) {
				return miniCourseArray[i];
			}
		}
		System.out.println("This isnt a course");
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<nElems;i++){
			MiniCourse m = miniCourseArray[i];
			sb.append(String.format("%s", m));
			
		}
		String s = sb.toString();
		System.out.println(s);
		return s;
	}
	
	public String toStringExport() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<nElems;i++) {
			MiniCourse m= miniCourseArray[i];
			sb.append(String.format("%s", m.toStringExport()));
		}
		String s= sb.toString();
		return s;
	}
}
