class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length){
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int to=nums1.length+nums2.length;
        int left=0;
        int right=nums1.length;
        
        while(left<=right){
            int al=left+(right-left)/2;
            int bl=(to+1)/2-al;
            
            int aleft=al==0?Integer.MIN_VALUE:nums1[al-1];
            int bleft=bl==0?Integer.MIN_VALUE:nums2[bl-1];
            int aright=al==nums1.length?Integer.MAX_VALUE:nums1[al];
            int bright=bl==nums2.length?Integer.MAX_VALUE:nums2[bl];
            
            if(aleft<=bright&&bleft<=aright){
                double median=0.0;
                
                if(to%2==0){
                    int n1=Math.max(aleft,bleft);
                    int n2=Math.min(aright,bright);
                    
                    median=(double)(n1+n2)/2;
                    return median;
                }
                
                else{
                    int m=Math.max(aleft,bleft);
                    median=m;
                    return median;
                }
            }
            
            else if(aleft>bright){
                right=al-1;
            }
            
            else{
                left=al+1;
            }
            
        }
        return 0.0;
    }
}
