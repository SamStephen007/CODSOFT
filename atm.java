import java.util.*;
public class atm {
    public static void main(String[]args){
        System.out.println("Welcome!!!");
        Scanner scan = new Scanner(System.in);
        account acc = new account();
        boolean bool = true,temp = true;
        int attempt = 3;
        
        while (attempt>0 && temp) {
            System.out.println("Enter your pin");
             int spin = scan.nextInt();
                if(spin!=acc.pin){
                    System.out.println("Invalid pin");
                    attempt--;
                    System.out.println(attempt + "attempts left");
                    if(attempt==0){
                        System.out.println("YOU REACHED THE LIMIT");
                    }
                }else{
                    while(bool){
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.checkbalance");
        System.out.println("4.exit");
        System.out.println("Enter the option:");
        int choice = scan.nextInt();
            
            switch (choice) {
                case 1:
                    
                    System.out.println("Enter the Withdrawal amount:");
                    double Withdraw = scan.nextDouble();
                    if(Withdraw > acc.balance - 1000){
                        System.out.println("Minimum balance required!!");
                    }else{
                        acc.balance = acc.balance - Withdraw;
                        System.out.println("The balance after withdraw is "+ acc.balance);
                    }
                    break;
                case 2:
                    System.out.println("Enter the deposit amount");
                    double deposit = scan.nextInt();
                    acc.balance = acc.balance + deposit;
                    System.out.println("The balance after deposit is"+acc.balance);
                    break;
                case 3:
                    System.out.println("The current balance is"+acc.balance);
                    break;
                case 4:
                    System.out.println("Thank you for visiting!!");
                    bool = false;
                    break;
            
                default:
                    System.out.println("Invalid number,Enter the correct number");
                    break;
            }

        }
        temp = false;
        }
        
    }
}
}
class account{
    int pin = 1234;
    double balance = 2000;

}