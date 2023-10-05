package exercise1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class Test {

    private static final String[] feedbackRightAnswer = {"Excellent!", "Good!", "Keep up the good work!", "Nice work!",
            "Great Job!", "You got it!", "That's right", "Bravo! ",
            "Spot on!", "Fantastic! You've been studying"};
    private static final String[] feedbackWrongAnswer = {"Maybe next time.", "No. Keep trying.", "Not quite there.",
            "Almost there!", "No, but you're getting warmer!",
            "Don't give up!", "Not the right answer.", "Close, keep going!",
            "No, but good try!", "No, but you're making progress."};
    private int countRightAnswer = 0;
    private int countWrongAnswer = 0;

    private List<Question> getQuestions() {

        Question question1 = new Question();
        question1.setHeader("What is the smallest planet in our solar system?");
        List<String> optionsQ1 = new ArrayList<>();
        optionsQ1.add("Earth");
        optionsQ1.add("Mars");
        optionsQ1.add("Venus");
        optionsQ1.add("Mercury");
        Collections.shuffle(optionsQ1);
        question1.setOptions(optionsQ1);
        question1.setAnswer("Mercury");

        Question question2 = new Question();
        question2.setHeader("What philosophical principle is summarized by the statement, 'I think, therefore I am'?");
        List<String> optionsQ2 = new ArrayList<>();
        optionsQ2.add("Hedonism");
        optionsQ2.add("Rationalism");
        optionsQ2.add("Dualism");
        optionsQ2.add("Empiricism");
        Collections.shuffle(optionsQ2);
        question2.setOptions(optionsQ2);
        question2.setAnswer("Rationalism");

        Question question3 = new Question();
        question3.setHeader("What is the chemical symbol for the element gold?");
        List<String> optionsQ3 = new ArrayList<>();
        optionsQ3.add("Go");
        optionsQ3.add("Ag");
        optionsQ3.add("Au");
        optionsQ3.add("Ge");
        Collections.shuffle(optionsQ3);
        question3.setOptions(optionsQ3);
        question3.setAnswer("Au");

        Question question4 = new Question();
        question4.setHeader("What is the tallest mountain in the world?");
        List<String> optionsQ4 = new ArrayList<>();
        optionsQ4.add("Mount Kilimanjaro");
        optionsQ4.add("Mount Fuji");
        optionsQ4.add("Mount McKinley");
        optionsQ4.add("Mount Everest");
        Collections.shuffle(optionsQ4);
        question4.setOptions(optionsQ4);
        question4.setAnswer("Mount Everest");

        Question question5 = new Question();
        question5.setHeader("What is the largest mammal on Earth?");
        List<String> optionsQ5 = new ArrayList<>();
        optionsQ5.add("Elephant");
        optionsQ5.add("Blue whale");
        optionsQ5.add("Giraffe");
        optionsQ5.add("Hippopotamus");
        Collections.shuffle(optionsQ5);
        question5.setOptions(optionsQ5);
        question5.setAnswer("Blue whale");

        Question question6 = new Question();
        question6.setHeader("In which year did Christopher Columbus first voyage to the Americas?");
        List<String> optionsQ6 = new ArrayList<>();
        optionsQ6.add("1492");
        optionsQ6.add("1520");
        optionsQ6.add("1607");
        optionsQ6.add("1776");
        Collections.shuffle(optionsQ6);
        question6.setOptions(optionsQ6);
        question6.setAnswer("1492");

        Question question7 = new Question();
        question7.setHeader("What is the largest ocean in the world?");
        List<String> optionsQ7 = new ArrayList<>();
        optionsQ7.add("Atlantic Ocean");
        optionsQ7.add("Pacific Ocean");
        optionsQ7.add("Indian Ocean");
        optionsQ7.add("Arctic Ocean");
        Collections.shuffle(optionsQ7);
        question7.setOptions(optionsQ7);
        question7.setAnswer("Pacific Ocean");

        Question question8 = new Question();
        question8.setHeader("Which gas do fireflies use to create their characteristic glow?");
        List<String> optionsQ8 = new ArrayList<>();
        optionsQ8.add("Oxygen");
        optionsQ8.add("Carbon dioxide");
        optionsQ8.add("Methane");
        optionsQ8.add("Nitrogen");
        Collections.shuffle(optionsQ8);
        question8.setOptions(optionsQ8);
        question8.setAnswer("Oxygen");

        Question question9 = new Question();
        question9.setHeader("What is the world's longest river?");
        List<String> optionsQ9 = new ArrayList<>();
        optionsQ9.add("Nile");
        optionsQ9.add("Amazon");
        optionsQ9.add("Mississippi");
        optionsQ9.add("Yangtze");
        Collections.shuffle(optionsQ9);
        question9.setOptions(optionsQ9);
        question9.setAnswer("Amazon");

        Question question10 = new Question();
        question10.setHeader("Who is the author of the book 'The Theory of Relativity'?");
        List<String> optionsQ10 = new ArrayList<>();
        optionsQ10.add("Isaac Newton");
        optionsQ10.add("Stephen Hawking");
        optionsQ10.add("Albert Einstein");
        optionsQ10.add("Galileo Galilei");
        Collections.shuffle(optionsQ10);
        question10.setOptions(optionsQ10);
        question10.setAnswer("Albert Einstein");

        //add generated questions into a list
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);

        // randomly mix the questions
        Collections.shuffle(questions);

        return questions;
    }

    //create a method to simulate the questions – simulateQuestion
    public void simulateQuestion() {

        // get the list of mixed questions
        List<Question> questions = getQuestions();

        int count = 0;

        // Use a loop to show all the questions.
        while (count < questions.size()) {

            //Display the questions using methods of JOptionPane class.
            String userAnswer = JOptionPane.showInputDialog(null, questions.get(count).getHeader() + "\n" +
                    questions.get(count).showOptions(), "Question", JOptionPane.QUESTION_MESSAGE);

            checkAnswer(userAnswer, questions.get(count));

            count++;
        }

        int totalQuestions = 10;
        int totalPercentage = 100;

        JOptionPane.showMessageDialog(null, "Number of right answers: " + countRightAnswer + "\n" +
                        "Number of wrong answers: " + countWrongAnswer + "\n" +
                        "Your score is: " + (countRightAnswer * totalPercentage) / totalQuestions + "%",
                "FeedBack", JOptionPane.INFORMATION_MESSAGE);
    }

    //create a method to check the answer – checkAnswer
    public void checkAnswer(String userAnswer, Question question) {
        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            generateMessage("correct");
            countRightAnswer++;
        } else {
            generateMessage("wrong");
            countWrongAnswer++;
        }
    }

    //create a method to display a random message for the user – generateMessage
    public void generateMessage(String feedback) {

        //create random number to choose the feedback message
        Random random = new Random();
        int randomNum = random.nextInt(feedbackRightAnswer.length);

        //Display feedback message according to the response
        if (feedback.equals("correct")) {
            JOptionPane.showMessageDialog(null, feedbackRightAnswer[randomNum], "FeedBack",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, feedbackWrongAnswer[randomNum], "FeedBack",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //create a method to interact with the user - inputAnswer
    public void inputAnswer() {

        String userName = JOptionPane.showInputDialog(null, "Please enter your name: ",
                "Question", JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Hello, " + userName + "! Welcome to the Quiz. " +
                "Your test is about to start. Good Luck!", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        //call method that displays the questions randomly
        simulateQuestion();
    }
}
