import java.util.Scanner; 

public class factorial{
    public static int Fact(int n){
       int ans = 1;
        for(int i = 1; i<=n; i++){
            ans = ans * i;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int Factorial = Fact(num);
        System.out.println(Factorial);
        scn.close();
    }
}