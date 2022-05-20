package com.FactoryDesignScores.beans;

public class Experian implements CreditScore {
    private Integer Score;

    public Experian(Integer score){
        this.Score=score;
    }

    @Override
    public Integer getScore(){
        return this.Score;
    }
}
