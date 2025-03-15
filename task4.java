import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class task4 {
    static class Question {
        String question;
        String[] options;
        int correctAnswerIndex;

        Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        boolean checkAnswer(int answerIndex) {
            return answerIndex == correctAnswerIndex;
        }
    }

    static class QuestionTimer extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time's up! Moving to the next question.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question[] quiz = {
            new Question("Who developed java?", new String[]{"James Gosling ", "Guido van Rossum", "Dennis  M Ritchie ", " Brendan Eich"}, 0),
            new Question("Which of the following is a Java programming language feature?", new String[]{"Object-Oriented", "Platform-dependent", "Interpreted", "None of the above"}, 0),
            new Question("In which year java was developed", new String[]{"1991", "1993", "1997", "1999"}, 2)
        };

        int score = 0;
        int timeLimit = 10; // time limit in seconds
        for (int i = 0; i < quiz.length; i++) {
            Question q = quiz[i];
            System.out.println("\nQuestion " + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }
            Timer timer = new Timer();
            timer.schedule(new QuestionTimer(), timeLimit * 1000); 

            System.out.print("Enter the option number (1-4): ");
            long startTime = System.currentTimeMillis();
            int userAnswer = -1; 

            while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt() - 1; 
                    break;
                }
            }

   
            if (userAnswer == -1) {
                System.out.println("Time's up! You didn't answer.");
            } else {
                if (q.checkAnswer(userAnswer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timer.cancel();
        }


        System.out.println("\nQuiz finished! Your final score is: " + score + "/" + quiz.length);
        scanner.close();
    }
}
