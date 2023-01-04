package com.example.hospital.dto;

public class patientCheck {

    private String name;

    private Integer age;

    private String sex;

    private String checkName;

    public patientCheck(String name, Integer age, String sex, String checkName) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.checkName = checkName;
    }

    public patientCheck() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    @Override
    public String toString() {
        return "patientCheck{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", checkName='" + checkName + '\'' +
                '}';
    }
}
