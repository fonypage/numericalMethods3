public class Main{

    public static double f(double x){
        return x*x*x - 2*x - 5;
    }

    public static Double steffensen(double a,double b, double epsil, int maxInter){
        double x = (a+b) / 2;
        for (int i = 0; i < maxInter; i++) {
            double fx = f(x);
            if(Math.abs(fx) < epsil)
                return x;
            double xNext = x - (fx * fx)/(f(x+fx)-fx);
            if(Math.abs(xNext-x) < epsil)
                return xNext;
            x = xNext;
        }
        return null;
    }

    public static void main(String[] args) {
        double a = 1;
        double b = 3;
        double epsil = 1e-6;
        int maxInter = 1000;
        Double ans = steffensen(a,b,epsil,maxInter);
        if(ans != null){
            System.out.println(ans);
        }
        else System.out.println("No ans");
    }
}