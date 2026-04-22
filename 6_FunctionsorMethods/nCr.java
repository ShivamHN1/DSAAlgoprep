public class nCr {
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans = 1;
        for(int i = 1; i <= n; i++){
            ans *= i;
        }
        return ans;
    }
    public static int Com(int n, int r){
        if(r==0 || n==r){
            return 1;
        }
        int nfact = fact(n);
        int rfact = fact(r);
        int nmrfact = fact(n-r);
        return nfact / (rfact * nmrfact);
    }
    public static void main(String[] args){
        int n = 5;
        int r = 2;
        int Combination = Com(n, r);
        System.out.println(Combination);
    }
}
