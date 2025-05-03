class Solution {
    ArrayDeque<Element> q = new ArrayDeque<>();
    int[] arr;
    int k;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        arr = nums;
        this.k = k;

        for (int i = 0; i < nums.length; i++) {
            add(i, nums[i]);
            if (i >= k - 1) {
                answer[i - k + 1] = q.peekFirst().num;
            }
        }

        return answer;
    }

    void add(int i, int n) {
        // 범위 밖 요소 제거
        while (!q.isEmpty() && q.peekFirst().index <= i - k) {
            q.removeFirst();
        }
        // 새 값보다 작거나 같은 애들 제거 (뒤에서)
        while (!q.isEmpty() && q.peekLast().num <= n) {
            q.removeLast();
        }
        // 새 값 추가
        q.addLast(new Element(i, n));
    }
}

class Element {
    public int num;
    public int index;

    public Element(int i, int n) {
        index = i;
        num = n;
    }
}
