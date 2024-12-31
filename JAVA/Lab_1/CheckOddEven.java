import java.util.Scanner;
public class CheckOddEven {
    public static void main(String [] args){
        int number ;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        if(number%2==0){
            System.out.println("The number is even");
        }else{
            System.out.println("The number is odd");
        }
    }
    
}
