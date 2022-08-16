/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz;

/**
 *
 * @author arnol
 */
import javax.swing.JOptionPane;

public class Quiz {

    // isValid accepts a string and checks to see if it is A, B, or C
    // and returns: Boolean value of whether true or false if it matches

    private static boolean isValid(String a) {
        a = a.toLowerCase();
        if (a.equals("a") || a.equals("b") || a.equals("c")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please pick A, B, or C");
            return false;
        }
    }

    // QuestionAsked receives an array containing the question and all the
    // answers. Returning the user input as a String
    // String to hold the formatted question

    private static String QuestionAsked(String[] q) {
        String QuestionFormat = "";
        String answer = "";

        for (int i = 0; i < q.length; i++)
            QuestionFormat += q[i] + "\n";

        // This is for when user wants to end quiz prematurely
        do {
            answer = JOptionPane.showInputDialog(null, QuestionFormat);
            if (answer == null) {
                int exit = JOptionPane.showConfirmDialog(null, "Exit session?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (exit == 0)
                    return "ABORT";
                else
                    continue;
            }
        } while (answer == null || !(isValid(answer)));

        return answer;
    }

    // CheckifCorrect receives two values a (the right answer) and r (the wrong
    // answer). Returning a Boolean value if the answer is right or not
    // a = right answer, r = user response
    private static boolean CheckifCorrect(String a, String r) {
        r = r.toUpperCase();
        if (a.equals(r)) {
            JOptionPane.showMessageDialog(null, "Well Done!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Actually the right answer is: \n" + a);
            return false;
        }
    }

    // displayGrade accepts two values c (total right answers) and i (total
    // wrong answers). A message dialog is displayed stating the total
    // right, wrong, and the grade for the quiz
    public static void displayGrade(int c, int i) {
        int numberQuestions = c + i;
        String gradeFormat = "";
        int pointsPerQuestion = 100 / numberQuestions;
        int grade = c * pointsPerQuestion;

        gradeFormat += "You answered " + c + " correctly and " + i + " incorrectly";
        gradeFormat += "\nYour grade is: " + grade + "%";

        JOptionPane.showMessageDialog(null, gradeFormat);
    }

    // iterator to be used later for the QuestionAsked loop
    // correct = number of correct answers
    // incorrect = number of incorrect answers
    // response holds the answer the user inputted temporarily
    public static void main(String[] args) {
        int i = 0;
        int correct = 0;
        int incorrect = 0;
        String response = "";

        // Array to store questions
        // Array to store the right answers
        String[][] question = new String[10][4];
        String[] rightAnswer = new String[10];

        question[0][0] = "1.) Who is the greatest African general?";
        question[0][1] = "A) Shaka Zulu";
        question[0][2] = "B) Sonni Ali";
        question[0][3] = "C) Hannibal Barca";
        rightAnswer[0] = "C";

        question[1][0] = "2.) What was Elon Musk's first startup?";
        question[1][1] = "A) Tesla";
        question[1][2] = "B) Zip2";
        question[1][3] = "C) SpaceX";
        rightAnswer[1] = "B";

        question[2][0] = "3.) Who is the smartest man in history?";
        question[2][1] = "A) Albert Einstein";
        question[2][2] = "B) Stephen Hawking";
        question[2][3] = "C) Isaac Newton";
        rightAnswer[2] = "C";

        question[3][0] = "4.) What is Jordan Peele's third movie?";
        question[3][1] = "A) Get Out";
        question[3][2] = "B) Us";
        question[3][3] = "C) Nope";
        rightAnswer[3] = "C";

        question[4][0] = "5.) What is the greatest manga?";
        question[4][1] = "A) One Piece";
        question[4][2] = "B) Naruto";
        question[4][3] = "C) DragonBalls";
        rightAnswer[4] = "A";

        question[5][0] = "6.) What was the best show on Cartoon Network";
        question[5][1] = "A) Adventure Time";
        question[5][2] = "B) Steven Universe";
        question[5][3] = "C) Regular Show";
        rightAnswer[5] = "C";

        question[6][0] = "7.) What is the greatest duo?";
        question[6][1] = "A) Kanye West and Jay-Z";
        question[6][2] = "B) J.Cole and Kendrick Lamar";
        question[6][3] = "C) Drake and Jack Harlow";
        rightAnswer[6] = "A";

        question[7][0] = "8.) What is the greatest classical portrait?";
        question[7][1] = "A) Mona Lisa";
        question[7][2] = "B) Girl with a Pearl Earring";
        question[7][3] = "C) Yourself in the mirror";
        rightAnswer[7] = "B";

        question[8][0] = "9.) Who is the greatest director?";
        question[8][1] = "A) Quentin Tarantino";
        question[8][2] = "B) Denis Villenueve";
        question[8][3] = "C) Christopher Nolan";
        rightAnswer[8] = "C";

        question[9][0] = "10.) Who is the greatest conqueror in history?";
        question[9][1] = "A) Genghis Khan";
        question[9][2] = "B) Napolean Bonaparte";
        question[9][3] = "C) Julius Caesar";
        rightAnswer[9] = "B";

        // Loops through the question array
        do {
            response = QuestionAsked(question[i]);
            if (response.equals("ABORT"))
                return;
            if (CheckifCorrect(rightAnswer[i], response))
                correct += 1;
            else
                incorrect += 1;

            i++;
        } while (i < question.length);

        displayGrade(correct, incorrect);
    }
}
