import java.util.Scanner;
public class PrimeAndComposite {
    public static void main(String [] args){
        int number , total_factor = 0;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        if(number==1){
            System.out.println("The number is neither prime nor composite");
        }else{
            for(int i = 1; i<=number; i++){
                if(number%i==0){
                    total_factor++;
                }
            }
        }

        if(total_factor>2){
            System.out.println("The number is Composite");
        }else{
            System.out.println("The number is prime");
        }
    }
}
