public class Solution {
    public static int ninjaAndLadoos(int arr1[], int arr2[], int m, int n, int k) {
         if(arr1.length>arr2.length){
            int temp[]=arr1;
            arr1=arr2;
            arr2=temp;
        }
        int start=Math.max(0,k-m);
        int end=Math.min(k,n);
        
        while(start<=end){
            int al=start+(end-start)/2;
            int bl=(k)-al;
            
           int aleft=al==0?Integer.MIN_VALUE:arr1[al-1];
           int aright=al==arr1.length?Integer.MAX_VALUE:arr1[al];
           int bleft=bl==0?Integer.MIN_VALUE:arr2[bl-1];
           int bright=bl==arr2.length?Integer.MAX_VALUE:arr2[bl];
           
           if(aleft<=bright&&bleft<=aright){
               return Math.max(aleft,bleft);
           }
           
           else if(aleft>bright) end=al-1;
           
           else start=al+1;
        }
        return 0;
    }
}
