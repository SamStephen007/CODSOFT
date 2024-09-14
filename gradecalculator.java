import java.util.*;
public class gradecalculator {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int subject = scan.nextInt();
        int mark[] = new int[subject];
        int sum  = 0;
        for(int i=0;i<subject;i++){
            System.out.println("Enter the mark of subject"+(i+1));
            mark[i] = scan.nextInt();
            sum = sum + mark[i];
        }
        char grade=' ';
        double avg = sum/subject;
        if(avg<=100 && avg>=90){
            grade = 'O';
        }else if(avg<90 && avg>=80){
            grade = 'A';
        }
        else if(avg<80 && avg>=70){
            grade =  'B';
        }
        else if(avg<70 && avg>=60){
            grade = 'C';
        }else if(avg<60 && avg>=50){
            grade = 'D';
        }
        else if(avg<50 && avg>=40){
            grade =  'E';
        }else if(avg<40){
            grade = 'F';
        }else{
            System.out.println("You gave invalid marks.Please re-enter the mark correctly");
            sum = -1;
            avg = -1;
        }
        System.out.println("The total mark is "+sum);
        System.out.println("The average percentage is "+avg+"%");
        System.out.println("Grade :"+  grade);
        
    }
}
