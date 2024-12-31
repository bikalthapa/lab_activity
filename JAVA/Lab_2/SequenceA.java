public class SequenceA{
    public static void main(String [] args){
        int prev_val = 0;
        for(int i = 0; i<5; i++){
            System.out.print(prev_val*10+1 + ", ");
            prev_val = prev_val*10+1;
        }
    }
}
