class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact*=i;       
            list.add(i);
        }
        list.add(n);
        String ans="";
        k=k-1;
        while(true){
            ans+=list.get(k/fact);  
            list.remove(k/fact);    
            
            if(list.size()==0)
                break;
            k=k%fact;       
            fact=fact/list.size();
        }
        return ans;
    }
}
/*for ex: you have n = 4
then there will be 4! permutations and k=17
then if we are using 0 based index then we have to find 16th index
Now as it is lexicographically sorted
then first digit 1 , other digits {2,3,4} permutations then
first digit 2 , other digits {1,3,4} perm then
first digit 3 , other digits{1,2,4}+ {}
first digit 4 , other digits{1,2,3}
Now for {1,3,4} there will be 3! = 6 perm
and so on for other 3
so if we have to find 16 it will start from 3 as 0-5 start from 1
6-11 start from 2 12-17 start from 3 and 18-23 from 4
Now as we fixed first place as 3,___,__,___
We will find second place digit which will be
1 {2,4} perms + 2{1,4} perms + 4{1,2} perms
Now {2,4} will be 2! perms i.e 2 so first two will start from 1 next two from 2 and last two from 4 we have to find 16-12 ->4th term which will start from 4 because 0based indexing(0,1,2,3,4)
so Now 3,4,, two digits left to find
1{2} and 2{1} NOw 12 + 4 16 gone 17th term is 1{2}
so 3,4,1,2
Simple formula if n=4 start from 3! ,2!,1!
k=17 first index will be k/3!
and next k will be k%3!
Now you can see from code you will understand it easily:*/


// EX : n = 4, k = 17
// fact = 6 , ans = [1,2,3,4], k = 16
// Run 1 : 
// res = 16/6 = 2 = ans.get(2) = 3 , res = "3", ans.remove(2) = [1,2,4]
// ans.size() == 0 == false;
// ans = [1,2,4] , k = 16%6 = 4 , fact = 6/3 = 2
   
// Run 2 : 
// res = 4/2 = 2 = ans.get(2) = 4 ,res = "34" , ans.remove(2) = 4
// ans.size() == 0 == false;
// ans = [1,2] , k = 4%2 = 0 , fact = 2/2 = 1
  
// Run 3 : 
// res = 0/1 = 0 = ans.get(0) = 2 ,res = "342" , ans.remove(0) = 2
// ans.size() == 0 == false;
// ans = [1] , k = 0%1 = 0 , fact = 1/1 = 1
    
// Run 4 : 
// res = 0/1 = 0 = ans.get(0) = 1 ,res = "3421" , ans.remove(0) = 1
// ans.size() == 0 == true == break;

// TC : O(n) , SC : O(n)
