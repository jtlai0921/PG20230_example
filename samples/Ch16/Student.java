// Student.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是簡化過的 Student 類別版本, 配合各個 JListDemo 使用

public class Student {
        private String name;
        private String ssn;
        
        public Student(String ssn, String name) {
                this.setSsn(ssn);
                this.setName(name);
        }
        
        public String getName() {
                return name;
        }

        public void setName(String n) {
                name = n;
        }

        public String getSsn() {
                return ssn;
        }

        public void setSsn(String s) {
                ssn = s;
        }

        public String toString() {
                return name + " (" + ssn + ")"; 
        }
}
