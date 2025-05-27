package model;

public class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
package service;

import model.Question;
import java.util.Scanner;

public class QuizService {
    private Question[] questions;
    private int score = 0;

    public QuizService() {
        loadQuestions();
    }

    private void loadQuestions() {
        questions = new Question[] {
            new Question("What is the capital of India?",
                         new String[]{"Mumbai", "Delhi", "Bangalore", "Chennai"}, 1),
            new Question("Which company developed Java?",
                         new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"}, 2),
            new Question("Which keyword is used to inherit a class in Java?",
                         new String[]{"implement", "extends", "inherits", "super"}, 1)
        };
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Q" + (i + 1) + ": " + q.getQuestionText());

            String[] opts = q.getOptions();
            for (int j = 0; j < opts.length; j++) {
                System.out.println((j + 1) + ". " + opts[j]);
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer - 1 == q.getCorrectOptionIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " +
                    opts[q.getCorrectOptionIndex()] + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.length);
        scanner.close();
    }
}

package app;

import service.QuizService;

public class QuizApp {
    public static void main(String[] args) {
        QuizService quiz = new QuizService();
        quiz.startQuiz();
    }
}
