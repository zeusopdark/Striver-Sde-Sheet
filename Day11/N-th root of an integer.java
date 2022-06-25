public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	double low=1;
        double high=m;
        double epsilon=1e-6;
        while(high-low>epsilon){
            double mid=(high+low)/2.0;
            if(Math.pow(mid,n)>m){
                high=mid;
            }
            else if(Math.pow(mid,n)<m){
                low=mid;
            }
        }
        return low;
    }
}
