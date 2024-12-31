public class Sequence{
    public static void main(String [] args){
        
        int previous_number = 1;
        for(int i = 1; i<=15; i++){
            System.out.print(previous_number+i + " ,");
            previous_number = previous_number + i;
        }
    }
}