package com.FactoryDesignScores;

import com.FactoryDesignScores.beans.CreditScore;
import com.FactoryDesignScores.factory.CreditScoreFactory;
import com.FactoryDesignScores.factory.CreditScoreType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    Runs the program in command line to match the example photo emailed to me
    The goal to my understanding is to make this mockup a good foundation or system for growth of the program
 */
public class Main {

    public static void main(String[] args)
            throws IOException
    {
	//test writes sample values.
        //currently this will act as a person's collection of scores. I believe a class for each client would be better, but
        // for the scope of the assesment wasn't sure if this was necessary
     CreditScore [] test = test();


        //exit is how main loop exits
     boolean exit = false;

        //temp will act as the character the program will use to choose which score to readout or to exit the loop.
        //the limits of using a character will affect number of credit score options to 10, can be adjusted later
     String temp;

     //useful for tracking number of Credit Score types in CreditScoreType dynamically
        int numberOfCredits= CreditScoreType.values().length;

        //this is the main loop the program will be in if it's running in command line
     while(exit!=true){
         //introduction will repeat the printout statement replicating the sample assesment
        introduction();

        //readIn will ask for an input and convert it into a character
        temp= readIn();

        //exit clause of the while loop/program
         if(temp.charAt(0) == 'q'){
             exit= true;
         }
         else {
             //this try statement was to catch as many program breaking inputs as I could find
             try{
                 int number = Integer.parseInt(temp);
                 if (Integer.parseInt(String.valueOf(temp))>=numberOfCredits || Integer.parseInt(String.valueOf(temp))<0 ){
                     System.out.println("Please enter a choice from those listed above");
                 }
                 else{
                     printScore(Integer.parseInt(String.valueOf(temp)), test);
                 }
                 //this is for spacing
                 System.out.println();

             }
             catch(NumberFormatException ex){
                 System.out.println("Please enter a choice from those listed above");
             }
         }
     }

    }



    /*
    readOut will replicate the printout shown in the example for the assessment while scaling to more credit score types added
    */
    public static void introduction() {
        System.out.println("Welcome to the Credit Score CLI");
        CreditScoreType creditScoreTypes[] = CreditScoreType.values();
        System.out.print("What Service to pull from? ");
        int count= 0;
        //loop through CreditScoreType enum
        for(CreditScoreType creditScoreType: creditScoreTypes){
            System.out.print(" " + count + "=" + creditScoreType + ",");
            count++;
        }
        //q is not part of count
        System.out.print(" " + "q" + "="+ "quit" + "," + "\n");
    }

    public static String readIn()
            throws IOException
    {
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String value = reader.readLine();

        return value;
    }


    public static void printScore(Integer choice, CreditScore [] credits){
        if(choice<credits.length && choice>=0){
            System.out.println("The score was " + credits[choice].getScore());
        }
        System.out.println();
    }

    //this test does not scale with new CreditScore types
    public static CreditScore [] test(){
        CreditScore [] sample = new CreditScore[3];
        CreditScore equifax = CreditScoreFactory.createCreditScore(CreditScoreType.Equifax, 650);
        CreditScore experian = CreditScoreFactory.createCreditScore(CreditScoreType.Experian, 700);
        CreditScore transUnion = CreditScoreFactory.createCreditScore(CreditScoreType.TransUnion, 700);

        sample[0] = equifax;
        sample[1] = experian;
        sample[2] = transUnion;

        return sample;
    }

}
