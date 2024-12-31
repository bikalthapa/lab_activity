import java.util.Scanner;
class ReverseNumber {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        
        num = input.nextInt();
        
        int dup = num;
        int rev = 0, digit;
        while(dup!=0){
            digit = dup%10;
            rev = rev*10+digit;
            dup = dup/10;
        }
        
        System.out.println("The reverse of "+num+" is " +rev);
    }
}