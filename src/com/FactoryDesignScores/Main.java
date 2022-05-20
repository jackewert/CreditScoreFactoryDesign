package com.FactoryDesignScores;

import com.FactoryDesignScores.beans.CreditScore;
import com.FactoryDesignScores.factory.CreditScoreFactory;
import com.FactoryDesignScores.factory.CreditScoreType;

/*
    Runs the program in command line to match the example photo emailed to me
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public void readout() {

    }
    public void readIn(){

    }

    public void test(){
        CreditScore equifax = CreditScoreFactory.createCreditScore(CreditScoreType.Equifax, 650);
        CreditScore experian = CreditScoreFactory.createCreditScore(CreditScoreType.Experian, 700);
        CreditScore transUnion = CreditScoreFactory.createCreditScore(CreditScoreType.TransUnion, 700);
    }

}
