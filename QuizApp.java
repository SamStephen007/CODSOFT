import java.util.*;
public class QuizApp{
    static int score = 0;
    static boolean timeOut = false;
    public static void main(String[] args) {
        
        Question[] question = new Question[3];
        question[0] = new Question("What is the square root of 25",new String[]{"1)12","2)6","3)4","4)5"},4);
        question[1] = new Question("What is the captial of india",new String[]{"1)Mumbai","2)New Delhi","3)kolkata","4)chennai"},2);
        question[2] = new Question("Who is the current president of america",new String[]{"1)Donald Trump","2)Abraham Lincoln","3)Joe biden","4)George Washington"},3);
    
        starttimer(question, 20000);
    }
        public static void starttimer(Question[]question,int time){
            Timer timer = new Timer();
            timeOut = false;
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! The quiz has ended.");
                    timeOut = true;
                    displayResult(question.length);
                    timer.cancel();
                }
            }, time);
            for (int i = 0; i < question.length; i++) {
                if (timeOut) {
                    break;
                }
                askquestion(question[i]);
            }
            if (!timeOut) {
                displayResult(question.length);
            }
        }
    
        
        public static void askquestion(Question q){
            System.out.println(q.question);
            for(int i=0;i<q.option.length;i++){
                System.out.println(q.option[i]);
            }
            int answer = userInput();
            if(!timeOut && answer == q.answer){
                System.out.println("Correct answer");
                score++;
            }
            else if(!timeOut && answer != q.answer){
                System.out.println("Wrong answer");
            }
        }
        public static int userInput()
        {
            System.out.println("Enter the options from 1-4");
            Scanner scan = new Scanner(System.in);
            while(!timeOut){
            int user = scan.nextInt();
            if(user>0 &&  user<=4){
                return user; 
            }
            else{
                System.out.println("Invalid option,Enter a valid option!!");
            }
            
        }
        return -1;
        }

        public static void displayResult(int totalQuestions) {
            System.out.println("Quiz Over!");
            System.out.println("Your Score: " + score + "/" + totalQuestions);
            System.out.println("Thank you for playing!");
        }
    }
class Question{
    String question;
    String[] option;
    int answer;
    public Question(String question,String[] option,int answer){
        this.question = question;
        this.option = option;
        this.answer = answer;
    }
}
