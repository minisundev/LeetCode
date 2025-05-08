class Solution {
    PriorityQueue<Integer> min = new PriorityQueue<>(
            (o1, o2) -> o1 - o2);
    PriorityQueue<Integer> max = new PriorityQueue<>(
            (o1, o2) -> o2 - o1);

    Map<Integer, Integer> minMap = new HashMap<>();
    Map<Integer, Integer> maxMap = new HashMap<>();

    public int longestSubarray(int[] nums, int limit) {
        int length = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            add(num);
            //System.out.println("index: " + i + " num: " + num);

            while (j < i && maxDiff() > limit) {
                remove(nums[j]);
                j++;
            }

            length = Math.max(i-j+1, length);

            //System.out.println(i + "," + j + " maxDiff():" + maxDiff() + " length: " + length);
        }

        return length;
    }

    int maxDiff() {
        clean(min, minMap);
        clean(max, maxMap);
        return max.peek() - min.peek();
    }

    void add(int num) {
        int minCount = minMap.getOrDefault(num, 0);
        int maxCount = maxMap.getOrDefault(num, 0);
        if (minCount == 0) {
            min.add(num);
        }
        if (maxCount == 0) {
            max.add(num);
        }
        minCount++;
        maxCount++;
        minMap.put(num, minCount);
        maxMap.put(num, maxCount);
    }

    void remove(int num) {
        int minCount = minMap.getOrDefault(num, 0);
        int maxCount = maxMap.getOrDefault(num, 0);
        minCount--;
        maxCount--;
        minMap.put(num, minCount);
        maxMap.put(num, maxCount);
    }

    void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }
}

class Element {
    public int val;
    public int index;//final index 말하는거임

    public Element(int v, int i) {
        val = v;
        index = i;
    }
}