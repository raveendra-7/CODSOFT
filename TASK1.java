import java.util.*;

public class task1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        boolean play = true;
        while (play) {
            int randomnumber = r.nextInt(100) + 1;
            int attempts = 5; 

            System.out.println("THIS IS NUMBER GAME..!YOU NEED TO GUESS THE NUMBER CORRECTLY");
           
            System.out.println("NOTE: MAXIMUM CHANCES :"+ attempts);
             System.out.println("NOW START GUESSING....");
            
            boolean correctguess = false;
            for (int attempt = 1; attempt <= attempts; attempt++) {
               // System.out.print("CHOICE " + attempt +" : ");
                int Guess = sc.nextInt();

                if (Guess < randomnumber) {
                    System.out.println("Too low..!");
                } else if (Guess > randomnumber) {
                    System.out.println("Too high...!");
                } else {
                   
                    System.out.println("YOU WON AND THE NUMBER IS  " + randomnumber);
                    int score = attempts - (attempt - 1);
                    System.out.println("Your score is: " + score);
                    correctguess = true;
                    break; 
                }
            }

           if (!correctguess) {
                System.out.println("YOU LOST THE GAME ");
                System.out.println("THE ANSWER IS :"+ randomnumber);
                int score = 0; 
                System.out.println("Your score is: " + score);
            }

            System.out.print("PLAY AGAIN..? (yes = 1/no = 0): ");
            int answer = sc.nextInt();
            if (answer==0) {
                play = false; 
            }
            System.out.println("GAME OVER...!");   
        }
	}
}
