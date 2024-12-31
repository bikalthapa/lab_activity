public class SequenceD{
    public static void main(String [] args){
        int a = 1, b = 1,temp = 0;
        for(int i = 0; i<15; i++){
            System.out.print(a*2 + " ,");
            temp = a;
            a = b;
            b = temp+b;
        }
    }    
}
