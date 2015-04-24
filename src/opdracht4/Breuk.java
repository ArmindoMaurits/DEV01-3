package opdracht4;

/**
 * Created by Wouter on 4/20/2015.
 */
public class Breuk {
    public static int[] mutiply(int num1,int denum1,int num2,int denum2){
        double tempnum = (double)num2/(double)denum1*(double)num1;
        return simplify((int)(tempnum*100),(denum2*100));
    }
    public static int[] divide(int num1,int denum1,int num2,int denum2){
        double tempnum = (double)denum2/(double)denum1*(double)num1;
        return simplify((int)(tempnum*100),(num2*100));
    }
    public static int[] extract(int num1,int denum1,int num2,int denum2){
        int tempnum1 = num1*denum2;
        int tempnum2 = num2*denum1;
        int tempdenum = denum1*denum2;
        int tempnum3 = tempnum1-tempnum2;
        return simplify(tempnum3,tempdenum);
    }
    public static int[] add(int num1,int denum1,int num2,int denum2){
        int tempnum1 = num1*denum2;
        int tempnum2 = num2*denum1;
        int tempdenum = denum1*denum2;
        int tempnum3 = tempnum1+tempnum2;
        return simplify(tempnum3,tempdenum);
    }
    private static int[] simplify(int num, int denum){
        int[] ints = new int[3];
        int tempnum = num % denum;
        int heel = num/denum;
        ints[0] = tempnum;
        ints[1] = denum;
        ints[2] = heel;
        for(int i = denum;i > 1; i--){
            if(tempnum%i == 0 && denum%i == 0 ){
                ints[0] = tempnum/i;
                ints[1] = denum/i;
                break;
            }
        }
        if(ints[0] != tempnum || ints[1] != denum){
            simplify(ints[0]*heel,ints[1]);
        }
        return ints;
    }

}
