package com.first.java.interview;

public class Student implements Comparable {

	String name;

	int no;

	public String getName() {

		return name;

	}

	public int getNo() {

		return no;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setNo(int no) {

		this.no = no;

	}

	@Override

	public String toString() {

		return "Student{" +

				"name='" + name + '\'' +

				", no=" + no +

				'}';

	}

	@Override

	public int compareTo(Object o) {

		return this.getName().compareTo(((Student) o).getName());

	}

}
