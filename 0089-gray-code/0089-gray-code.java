class Solution {
   List<Integer> list = new ArrayList<>();
   Set<Integer> set = new HashSet<>();
   int max;

   public List<Integer> grayCode(int n) {
       max = 1 << n;
       list.add(0);
       set.add(0);
       
       if (search(0, 1)) {
           return list;
       }
       return list;
   }

   boolean search(int current, int count) {
       if (count == max) {
           return verifyOneDiff(current, 0);
       }

       for (int i = 0; i < max; i++) {
           int next = current ^ (1 << i);
           if (!set.contains(next)) {
               list.add(next);
               set.add(next);
               if (search(next, count + 1)) {
                   return true;
               }
               list.remove(list.size() - 1);
               set.remove(next);
           }
       }
       return false;
   }

   boolean verifyOneDiff(int i1, int i2) {
       int diff = i1 ^ i2;
       return Integer.bitCount(diff) == 1;
   }
}