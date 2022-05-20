package tests;

import com.FactoryDesignScores.beans.CreditScore;
import com.FactoryDesignScores.factory.CreditScoreFactory;
import com.FactoryDesignScores.factory.CreditScoreType;
import org.junit.*;

import java.nio.charset.Charset;
import java.util.*;
import java.util.Random;

import static com.FactoryDesignScores.Main.*;
import static java.lang.System.in;
import static org.junit.Assert.*;


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
        //incomplete  was attempting to randomize user input in an attempt find test cases that would break program. My current logic is incorrect
    /*
    @Test
    public void testUserInput() throws Throwable{
        //makes a quick sample case of creditscores
        boolean exceptionThrown=false;
        CreditScore [] sample =test();
        for(int a=0; a<100000; a++) {
            //this creates a random user input
            byte[] array = new byte[7]; //length is bounded by 7
            new Random().nextBytes(array);
            String temp = new String(array, Charset.forName("UTF-8"));
            try {
                int number = Integer.parseInt(temp);
                if (Integer.parseInt(String.valueOf(temp)) >= 3 || Integer.parseInt(String.valueOf(temp)) < 0) {
                    System.out.println("Please enter a choice from those listed above");
                } else {
                    printScore(Integer.parseInt(String.valueOf(temp)), sample);
                }
                //this is for spacing
                System.out.println();

            } catch (NumberFormatException ex) {
                System.out.println(temp);
                exceptionThrown = true;
            }

            assertFalse(exceptionThrown);
            exceptionThrown = false;
        }

    }
    */



}
