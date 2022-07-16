package utils;

import dao.BinaryQuestionDao;
import dao.MultichoiceQuestionDao;
import dao.PlayerDao;
import players.QuizPlayer;
import questions.GenericQuestion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManualTesting {

    public static void main(String[] args) {

        PlayerDao playerDao = null;
        BinaryQuestionDao binaryQuestionDao = null;
        MultichoiceQuestionDao multichoiceQuestionDao = null;

        try {
            playerDao = new PlayerDao();
            binaryQuestionDao = new BinaryQuestionDao();
            multichoiceQuestionDao = new MultichoiceQuestionDao();
            System.out.println("All DAOs instantiated");
        } catch (IOException exception) {
            System.out.println("DAO instantiation failed");
            exception.printStackTrace();
            System.exit(1);
        }

        try {
            ArrayList<QuizPlayer> players = playerDao.retrieveAll();
            System.out.println("Players retrieved from DB");
        } catch (SQLException exception) {
            System.out.println("Player retrieval failed");
            exception.printStackTrace();
            System.exit(1);
        }

        try {
            ArrayList<GenericQuestion> binQuestions = binaryQuestionDao.retrieveAll();
            System.out.println("Binary questions retrieved from DB");
        } catch (SQLException exception) {
            System.out.println("Binary question retrieval failed");
            exception.printStackTrace();
            System.exit(1);
        }

        try {
            ArrayList<GenericQuestion> mcqQuestions = multichoiceQuestionDao.retrieveAll();
            System.out.println("Multichoice questions retrieved from DB");
        } catch (SQLException exception) {
            System.out.println("Multichoice question retrieval failed");
            exception.printStackTrace();
            System.exit(1);
        }


    }
}
