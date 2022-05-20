package com.FactoryDesignScores.beans;

public class TransUnion implements CreditScore {
    private Integer Score;

    public TransUnion(Integer score){
        this.Score=score;
    }

    @Override
    public Integer getScore(){
        return this.Score;
    }
}
