import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i));
            }

            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            if (question.isCorrect(userAnswer)) {
                score++;
            }
        }

        System.out.println("Quiz finished! Your score is: " + score + "/" + questions.size());
        sc.close();
    }
    public static void main(String[] args) {
        // Create a new Quiz instance
        Quiz quiz = new Quiz();
    
        // Create some sample questions
        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C++");
        options1.add("JavaScript");
    
        List<String> options2 = new ArrayList<>();
        options2.add("OOP");
        options2.add("Functional");
        options2.add("Procedural");
        options2.add("Logic");
    
        // Add questions to the quiz
        quiz.addQuestion(new Question("Which programming language is known as platform-independent?", options1, "Java"));
        quiz.addQuestion(new Question("What programming paradigm does Java primarily follow?", options2, "OOP"));
    
        // Start the quiz
        quiz.start();
    }
}