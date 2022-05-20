package com.FactoryDesignScores.factory;

import com.FactoryDesignScores.beans.CreditScore;
import com.FactoryDesignScores.beans.Equifax;
import com.FactoryDesignScores.beans.Experian;
import com.FactoryDesignScores.beans.TransUnion;
/*
CreditScoreFactory - factory
 */
public class CreditScoreFactory {
    public static CreditScore createCreditScore(CreditScoreType type, Integer score){
        CreditScore temp = null;
        switch(type) {
            case Equifax:
                temp = new Equifax(score);
                break;
            case Experian:
                temp = new Experian(score);
                break;
            case TransUnion:
                temp = new TransUnion(score);
                break;
        }
        return temp;
    }
}
