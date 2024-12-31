import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String [] args){
        int number;
        Scanner sc = new  Scanner(System.in);

        number = sc.nextInt();

        int dup = number, arm = 0, digit;
        while(dup!=0){
            digit = dup%10;
            arm = digit*digit*digit+arm;
            dup /= 10; 
        }
        if(arm==number){
            System.out.println("The number is armstrong");
        }else{
            System.out.println("The number is not armstrong");
        }
    }
    
}
