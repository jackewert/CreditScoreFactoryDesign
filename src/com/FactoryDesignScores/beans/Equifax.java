package com.FactoryDesignScores.beans;

public class Equifax implements CreditScore {
    private Integer Score;

    public Equifax(Integer score){
        this.Score=score;
    }

    @Override
    public Integer getScore(){
        return this.Score;
    }
}
