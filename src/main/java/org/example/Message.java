package org.example;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    // PassengerId,Survived,Pclass,Name,Sex,
    // Age,SibSp,Parch,Ticket,
    // Fare,Cabin,Embarked
    int passengerId;
    int survived;
    int pClass;
    String name;
    String sex;
    double age;
    int sibSp;
    int parch;
    String ticket;
    double fare;
    String cabin;
    String eMarked;

}
