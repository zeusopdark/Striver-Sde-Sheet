class Solution {
     static List<List<String>>ans=new ArrayList<>();
    public static List<List<String>> partition(String s) {
        ArrayList<String>list=new ArrayList();
        palindromic(s,list);
        return ans;
    }
    public static void palindromic(String s,ArrayList<String>list){
        if(s.length()==0){
            ans.add(new ArrayList<>(list));
        }
        for(int i=0;i<s.length();i++){
            String a=s.substring(0,i+1);
            if(isPalindrome(a)){
                list.add(a);
                String ss=s.substring(i+1);
                palindromic(ss,list);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        if(s.length()==1)return true;
        int a=0,b=s.length()-1;
        while(a<b){
            if(s.charAt(a)==s.charAt(b)){
                a++;
                b--;
            }
            else return false;
        }
        return true;
    }
}
