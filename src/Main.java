import menu.MainMenu;
import menu.QuizMenu;
import menu.SimpleMenu;
import quiz.AbstractQuestion;
import quiz.BinaryQuestion;
import quiz.GenericQuestion;
import utils.MenuFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MainMenu sup = MenuFactory.generateFullMenu();

        Scanner consoleScanner = new Scanner(System.in);

        while (sup.isRunning) {
            sup.printMenuToConsole();
            sup.chooseMenuOption(consoleScanner);
        }

        System.out.println("We hope to see you again!!!");


//        HashSet-greier
//        HashSet<GenericQuestion> testSet = new HashSet<>();
//
//        BinaryQuestion bin1 = new BinaryQuestion(1, "Yes or no?", true);
//        BinaryQuestion bin2 = new BinaryQuestion(2, "Yes or no?", false);
//
//        testSet.add(bin1);
//        testSet.add(bin2);
//
//        System.out.println(testSet.size());


//        HashMap-greier
//        HashMap<String, GenericQuestion> testMap = new HashMap<>();
//
//        BinaryQuestion bin1 = new BinaryQuestion(1, "Yes or no?", true);
//        BinaryQuestion bin2 = new BinaryQuestion(2, "No or yes?", false);
//
//        AbstractQuestion<Boolean> testAbs = new BinaryQuestion(3, "This or that?", true);
//
//        BinaryQuestion convAbs = (BinaryQuestion) testAbs;
//        System.out.println(convAbs.type);
//
//        testMap.put("en", bin1);
//        testMap.put("to", bin2);
//
//        AbstractQuestion<Boolean> castedQuestion = (AbstractQuestion<Boolean>) testMap.get("en");
//        System.out.println(castedQuestion.getQuestion());
//
//        testMap.put("en", bin2);
//
//        castedQuestion = (AbstractQuestion<Boolean>) testMap.get("en");
//        System.out.println(castedQuestion.getQuestion());
//
//        System.out.println(testMap.size());


//        private/public-greier
//        QuizMenu menu = new QuizMenu("test", null);
//        menu.retrieveRandomQuestion(); // virker IKKE pga private
//        menu.printMenuToConsole(); // virker pga public
    }
}
