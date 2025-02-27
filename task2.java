import java.util.*;

public class task2
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        String[] subs = {"subject1", "subject2", "subject3", "subject4", "subject5"};
        int[] marks = new int[5];
        int totalMarks = 0;
        int j = subs.length;

        for (int i = 0; i < j; i++)
        {
            System.out.print("Enter marks obtained in " + subs[i] + " (out of 100): ");
            marks[i] = sc.nextInt();

            
            while (marks[i] < 0 || marks[i] > 100) 
            {
                System.out.print("MARKS SHOULD BE IN BETWEEN 0-100 ");
                marks[i] = sc.nextInt();
            }

            totalMarks += marks[i];
        }

        float average = totalMarks / j;

        char grade;
        if (average >= 90) 
        {
            grade = 'A';
        } else if (average >= 75) 
        {
            grade = 'B';
        } else if (average >= 50) 
        {
            grade = 'C';
        } else if (average >= 35) 
        {
            grade = 'D';
        } else 
        {
            grade = 'F';
        }

        System.out.println("RESULT:");
        for (int i = 0; i < j; i++) 
        {
            System.out.println(subs[i] + ": " + marks[i]);
        }
        System.out.println("TOTAL MARKS OBTAINED: " + totalMarks);
        System.out.println("AVERAGE MARKS: " + average);
        System.out.println("GRADE OBTAINED: " + grade);

    }
}