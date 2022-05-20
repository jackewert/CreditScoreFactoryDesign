package tests;

import com.FactoryDesignScores.beans.CreditScore;
import com.FactoryDesignScores.factory.CreditScoreFactory;
import com.FactoryDesignScores.factory.CreditScoreType;
import org.junit.*;
import java.util.*;

import static com.FactoryDesignScores.Main.readIn;
import static java.lang.System.in;
import static org.junit.Assert.assertEquals;


public class FirstTest {
    @Test
    public void testConstructorGetFunction() throws Throwable{
        //loop basic test ensuring constructor performs properly
        for(int a=0; a<10000; a++){
            //Given
            CreditScore[] sample = new CreditScore[3];

            //When
            Integer[] randomInts = new Integer[3];
            for (int i = 0; i < randomInts.length; i++) {
                //using real credit score range
                randomInts[i] = (int) (Math.random() * (850 - 350 + 1) + 350);
            }
            CreditScore equifax = CreditScoreFactory.createCreditScore(CreditScoreType.Equifax, randomInts[0]);
            CreditScore experian = CreditScoreFactory.createCreditScore(CreditScoreType.Experian, randomInts[1]);
            CreditScore transUnion = CreditScoreFactory.createCreditScore(CreditScoreType.TransUnion, randomInts[2]);

            sample[0] = equifax;
            sample[1] = experian;
            sample[2] = transUnion;

            //Then
        //Equifax constructor and get score
            assertEquals(randomInts[0], sample[0].getScore(), randomInts[0]);
            assertEquals("com.FactoryDesignScores.beans.Equifax", sample[0].getClass().getName());
        //Experian constructor and get score
            assertEquals(randomInts[1], sample[1].getScore(), randomInts[1]);
            assertEquals("com.FactoryDesignScores.beans.Experian", sample[1].getClass().getName());
        //Transunion constructor and get score
            assertEquals(randomInts[2], sample[2].getScore(), randomInts[2]);
            assertEquals("com.FactoryDesignScores.beans.TransUnion", sample[2].getClass().getName());
        }
    }

    @Test
    public void testUserInput() throws Throwable{
        //Given
        Scanner keyboard= new Scanner(in);
        readIn();
        //When

        //Then
        //assertEquals(176.0d, 12 , 0.0);
    }



}
