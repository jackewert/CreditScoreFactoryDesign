package com.FactoryDesignScores.beans;

/*
Equifax is a sample credit score class. As an API is not required it is not included.
 */
public class Equifax implements CreditScore {
    private Integer Score;

    public Equifax(Integer score){
        this.Score=score;
    }

    /*As an API is not required it's not included in this mock up.
     However the true processs of retrieving these values would be included in this function for each respective credit score*/
    @Override
    public Integer getScore(){
        return this.Score;
    }
}
