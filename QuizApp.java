import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer; // 1-based index (1,2,3,4)

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
            "Which language is known as the father of programming languages?",
            new String[]{"Python", "Java", "C", "Fortran"},
            4
        ));
        quiz.add(new Question(
            "What does JVM stand for?",
            new String[]{"Java Virtual Machine", "Java Visual Manager", "Java Value Method", "Joint Virtual Module"},
            1
        ));
        quiz.add(new Question(
            "Which keyword is used to create a subclass in Java?",
            new String[]{"this", "extends", "implements", "super"},
            2
        ));
        quiz.add(new Question(
            "Which data structure uses FIFO (First-In-First-Out) principle?",
            new String[]{"Stack", "Queue", "Tree", "Graph"},
            2 // Queue
        ));

        quiz.add(new Question(
            "Which keyword is used to define a constant variable in Java?",
            new String[]{"final", "static", "const", "define"},
            1 // final
        ));


        int score = 0;

        System.out.println("Welcome to the Online Quiz!");
        System.out.println("----------------------------");

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            int userAnswer = 0;
            while (true) {
                System.out.print("Your answer (1-4): ");
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (userAnswer == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is option " + q.correctAnswer + ".");
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + " out of " + quiz.size());

        scanner.close();
    }
}
