import java.util.*;
class numbergame{
    public static void main(String[]args){
        Random random = new Random();
        int random_number = random.nextInt(1,100);
        //System.out.println(random_number);
        int score = 10;
        boolean bool = true;
        Scanner scan = new Scanner(System.in);
        while(bool && score > 0){
        System.out.println("Guess the positive number:");
        int num = scan.nextInt();
        if(num == random_number){
            System.out.println("CONGRATULATION ! THE GUESSED NUMBER IS CORRECT");
            System.out.println("You are score is "+score);
            bool = false;   
        }
        else if (num+50<random_number) {
            System.out.println("The guessed number is extremely low");
            score--;
        }
        else if (num-50>random_number) {
            System.out.println("The guessed number is extremely high");
            score--;
        }
        else if (num+30<random_number) {
            System.out.println("The guessed number is too low");
            score--;
        }
        else if (num-30>random_number) {
            System.out.println("The guessed number is too high");
            score--;
        }
        else if (num<random_number) {
            System.out.println("The guessed number is low");
            score--;
        }
        else if (num>random_number) {
            System.out.println("The guessed number is high");
            score--;
        }
        if(score == 0){
            System.out.println("Sorry,you are failed to guess in the limited chances.The actual number is"+random_number);

        }
    }
}
}