package edu.cs.birzeit.android_short_cv_assignment2.Models.POJO;

public class CV_Content {


    private String FullName="";
    private String Email="";
    private String PhoneNumber="";
    private String Objective="";
    private String Gender="";
    private String Country="";

    private String Education="";
    private String Experience="";
    private String Projects="";
    private String Skills="";


    public CV_Content(){

    }
    //arg-constructor to initialize fields
    public CV_Content(String fullName, String email, String number, String objective, String gender, String country, String education, String experience, String project, String skills) {
        this.FullName = fullName;
        this.Email = email;
        this.PhoneNumber= number;
        this.Objective=objective;
        this.Gender=gender;
        this.Country=country;
        this.Education=education;
        this.Experience=experience;
        this.Projects=project;
        this.Skills=skills;

    }

    public String getFullName() {
        return FullName;
    }
    public void setFullName(String fullName) {
        this.FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
    public String getObjective() {
        return Objective;
    }
    public void setObjective(String objective) {
        this.Objective = objective;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        this.Gender = gender;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        this.Country = country;
    }
    public String getEducation() {
        return Education;
    }
    public void setEducation(String education) {
        this.Education = education;
    }
    public String getExperience() {
        return Experience;
    }
    public void setExperience(String experience) {
        this.Experience = experience;
    }
    public String getProjects() {
        return Projects;
    }
    public void setProjects(String projects) {
        this.Projects = projects;
    }
    public String getSkills() {
        return Skills;
    }
    public void setSkills(String skills) {
        this.Skills = skills;
    }

}
