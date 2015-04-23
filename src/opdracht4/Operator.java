package opdracht4;

/**
 * Created by Wouter on 4/20/2015.
 */
public class Operator {
    public static int[] mutiply(int num1,int denum1,int num2,int denum2){
        int[] ints = new int[3];
        return ints;
    }
    public static int[] divide(int num1,int denum1,int num2,int denum2){
        int[] ints = new int[3];

        return ints;
    }
    public static int[] extract(int num1,int denum1,int num2,int denum2){
        int[] ints = new int[3];
        int tempnum1 = num1*denum2;
        int tempnum2 = num2*denum1;
        int tempdenum = denum1*denum2;
        int shared = tempdenum/((tempnum1-tempnum2)%tempdenum);
        int tempnum = ((tempnum1-tempnum2)%tempdenum)/shared;
        ints[0] = tempnum<0 ? -tempnum :tempnum;
        ints[1] = tempdenum/shared < 0 ? -tempdenum/shared : tempdenum/shared;
        ints[2] = (tempnum1-tempnum2)/tempdenum;
        return ints;
    }
    public static int[] add(int num1,int denum1,int num2,int denum2){
        int[] ints = new int[3];
        int tempnum1 = num1*denum2;
        int tempnum2 = num2*denum1;
        int tempdenum = denum1*denum2;
        int shared = tempdenum/((tempnum1+tempnum2)%tempdenum);
        ints[0] = ((tempnum1+tempnum2)%tempdenum)/shared;
        ints[1] = tempdenum/shared;
        ints[2] = (tempnum1+tempnum2)/tempdenum;
        return ints;
    }

}
