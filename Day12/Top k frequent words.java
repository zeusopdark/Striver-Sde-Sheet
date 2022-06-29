class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String>list=new ArrayList();
        HashMap<String,Integer>map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<String>q=new PriorityQueue<>((a,b)->{
            
            if(map.get(a)==map.get(b)){
                return a.compareTo(b);
            }
            return map.get(b)-map.get(a);
        });
        for(String sp:map.keySet()){
            q.add(sp);
        }
        while(q.size()>0&&k-->0){
            list.add(q.peek());
            q.remove();
        }
        return list;
    }
      //  Below is the reverse implementation and it is done in such a way that the 
         //   priority queue will have only k elements not more than that  time complexity O(n-k)
    
    
//      Map<String, Integer> countMap = new HashMap<>();
//         for (String word : words) {
//             countMap.put(word, countMap.getOrDefault(word, 0) + 1);
//         }

//         PriorityQueue<String> pq = new PriorityQueue<String>((word1, word2) -> {
//             if (countMap.get(word1) == countMap.get(word2)) {
//                 return word2.compareTo(word1);
//             }
//             return countMap.get(word1) - countMap.get(word2);
//         });

//         for (String word : countMap.keySet()) {
//             pq.offer(word);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         List<String> ans = new ArrayList<>();
//         while (!pq.isEmpty()) {
//             ans.add(pq.poll());
//         }
//         Collections.reverse(ans);
//         return ans;
// }
}
