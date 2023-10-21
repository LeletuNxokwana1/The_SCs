/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelcentralflightmanagementsystem;

import java.util.Objects;

/**
 *
 * @author the_scs
 */
public class User {

    private int userID;
    private String userFirstName;
    private String userLastName;
    private String userEmailAddress;
    private String userPhoneNumber;
    private int userAge;
    private String userPassword;
    private UserStatus userStatus;
    private String userRetrievalQuestion;
    private String userRetrievalAnswer;

    public enum UserStatus {
        ACTIVE, DEACTIVATED
    }

    public User() {

    }

    public User(int userID, String firstName, String lastName, String emailAddress,
            String phoneNumber, String password, UserStatus status,
            String retrievalQuestion, String retrievalAnswer) {
        this.userID = userID;
        this.userFirstName = firstName;
        this.userLastName = lastName;
        this.userEmailAddress = emailAddress;
        this.userPhoneNumber = phoneNumber;
        this.userPassword = password;
        this.userStatus = status;
        this.userRetrievalQuestion = retrievalQuestion;
        this.userRetrievalAnswer = retrievalAnswer;
    }
    
    public User(int userID, String firstName, String lastName, String emailAddress,
            String phoneNumber, int age, String password, UserStatus status,
            String retrievalQuestion, String retrievalAnswer) {
        this.userID = userID;
        this.userFirstName = firstName;
        this.userLastName = lastName;
        this.userEmailAddress = emailAddress;
        this.userPhoneNumber = phoneNumber;
        this.userAge = age;
        this.userPassword = password;
        this.userStatus = status;
        this.userRetrievalQuestion = retrievalQuestion;
        this.userRetrievalAnswer = retrievalAnswer;
    }

    // Getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return userFirstName;
    }

    public void setFirstName(String firstName) {
        this.userFirstName = firstName;
    }

    public String getLastName() {
        return userLastName;
    }

    public void setLastName(String lastName) {
        this.userLastName = lastName;
    }

    public String getEmailAddress() {
        return userEmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.userEmailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return userPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.userPhoneNumber = phoneNumber;
    }
    
    public int getAge() {
        return userAge;
    }

    public void setAge(int age) {
        this.userAge = age;
    }


    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userID == user.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

    public static UserStatus getUserStatusFromString(String statusString) {
        for (UserStatus status : UserStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        // Default to ACTIVE if the string does not match any enum constant
        return UserStatus.ACTIVE;
    }

    public String getRetrievalQuestion() {
        return userRetrievalQuestion;
    }

    public void setRetrievalQuestion(String retrievalQuestion) {
        this.userRetrievalQuestion = retrievalQuestion;
    }

    public String getRetrievalAnswer() {
        return userRetrievalAnswer;
    }

    public void setRetrievalAnswer(String retrievalAnswer) {
        this.userRetrievalAnswer = retrievalAnswer;
    }

}
