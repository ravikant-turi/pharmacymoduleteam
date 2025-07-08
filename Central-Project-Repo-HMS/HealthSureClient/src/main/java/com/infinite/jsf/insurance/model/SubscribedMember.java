package com.infinite.jsf.insurance.model;

public class SubscribedMember {
    private String memberId;
    private Subscribe subscribe;  // Many-to-One with Subscribe
    private String fullName;
    private Integer age;
    private String gender;
    private String relationWithProposer;
    private String aadharNo;

    // Constructors
    public SubscribedMember() {}

    public SubscribedMember(String memberId, Subscribe subscribe, String fullName, 
                          Integer age, String gender, String relationWithProposer, 
                          String aadharNo) {
        this.memberId = memberId;
        this.subscribe = subscribe;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.relationWithProposer = relationWithProposer;
        this.aadharNo = aadharNo;
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Subscribe subscribe) {
        this.subscribe = subscribe;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationWithProposer() {
        return relationWithProposer;
    }

    public void setRelationWithProposer(String relationWithProposer) {
        this.relationWithProposer = relationWithProposer;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    @Override
    public String toString() {
        return "SubscribedMember{" +
               "memberId='" + memberId + '\'' +
               ", subscribe=" + subscribe.getSubscribeId() +
               ", fullName='" + fullName + '\'' +
               ", age=" + age +
               ", gender='" + gender + '\'' +
               ", relationWithProposer='" + relationWithProposer + '\'' +
               ", aadharNo='" + aadharNo + '\'' +
               '}';
    }
}