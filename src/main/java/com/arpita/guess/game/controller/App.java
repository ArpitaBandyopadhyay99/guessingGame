package com.arpita.guess.game.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Game where you have to guess the State's Capital Name
 * State and its Capital details are present in StateCapitalList.txt
 * If your answer is correct then you will get one point.
 */
public class App 
{
    static Map<Integer,String> stateMap = new HashMap<>();
    static Map<Integer,String> capitalMap = new HashMap<>();
    static int score = 1;

    public static void main( String[] args )
    {
        readFile();
        displayHeader();
        displayQuestionAndAnswer();

    }

    private static void displayHeader() {
        System.out.println("**********************************************************************");
        System.out.println("*****************  WELCOME TO GUESSING GAME   ************************");
        System.out.println("**********************************************************************");
        System.out.println("*****************  NAME ITS CAPITAL, TO QUIT PRESS Q? ********************");
    }

    private static void displayQuestionAndAnswer() {
        String input = "";
        while(!input.equalsIgnoreCase("Q")){
            Random random = new Random();
            int pickQuestion = random.nextInt(28);
            System.out.print(stateMap.get(pickQuestion)+" :::: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.next().trim();
            checkValidAnswer(pickQuestion, input);
        }
        System.out.println("Bye Bye !!");
    }


    private static void checkValidAnswer(int pickQuestion, String input) {
        if(input.equalsIgnoreCase(capitalMap.get(pickQuestion))){
            System.out.println("Congrats! That's Correct, Your Score: "+score);
            score++;
        }else if(!input.equalsIgnoreCase("Q")){
            System.out.println("Oops! That's Incorrect!!");
        }
    }

    private static void readFile() {
        try(
                BufferedReader br = new BufferedReader(new FileReader("StateCapitalList"));
        ){
            String line = null;
            int i=0;
            while( (line = br.readLine()) != null){
                String[] temp = line.split(", ");
                stateMap.put(i,temp[0]);
                capitalMap.put(i,temp[1]);
                i++;
            }
            //System.out.println(stateMap);
            //System.out.println(capitalMap);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
