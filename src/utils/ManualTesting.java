package utils;

import database.DatabaseConnector;
import players.QuizPlayer;
import questions.BinaryQuestion;
import questions.GenericQuestion;
import questions.MultichoiceQuestion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class ManualTesting {

    public static void main(String[] args) {

        try {
            ArrayList<QuizPlayer> players = DatabaseConnector.retrieveAllPlayers();
            System.out.println("Players retrieved from DB");
        } catch (SQLException exception) {
            System.out.println("Player retrieval failed");
            exception.printStackTrace();
        }

        try {
            HashSet<GenericQuestion> binQuestions = DatabaseConnector.retrieveAllBinaryQuestions();
            System.out.println("Binary questions retrieved from DB");
        } catch (SQLException exception) {
            System.out.println("Binary question retrieval failed");
            exception.printStackTrace();
        }


        HashSet<GenericQuestion> mcqQuestions = DatabaseConnector.retrieveAllMultichoiceQuestions();
        if (mcqQuestions != null) {
            System.out.println("Multichoice questions retrieved from DB");
        }
    }
}
