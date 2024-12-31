public class SequenceB {
    public static void main(String [] args){
        int previous_val = 0;
        for(int i = 1; i<=5; i++){
            System.out.print(previous_val*10+i + " ,");
            previous_val = previous_val*10+i;
        }
    }
}
