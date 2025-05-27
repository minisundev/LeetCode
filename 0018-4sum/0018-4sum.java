class Solution {
    //새로운 아이디어 => 역시 이분탐색이 답인거같으..
    //일단 정렬 => 0이하에서 페어 만들어서 0 이상의 페어를 만들고 둘의 쌍을 찾아보는것임?
    //아니면 세개 고르고 나머지 이분탐색 ㅜㅜ
    //일단 세개 고르고 나머지 이분탐색 해봄...
    // 3sum 까지는 이분탐색이었는데 이건 투포인터래.... 또 투포인터야? 저것도 사실 이분탐색으로 안 풀고 투포인터로 풀었었냐?? 어케 잘풀고살았지 ㅜㅜ
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i1 = 0; i1 < nums.length - 3;) {

            for (int i2 = i1 + 1; i2 < nums.length - 2;) {

                int s = i2 + 1;
                int e = nums.length - 1;

                while (s < e) {

                    //System.out.println(nums[i1] + " " + nums[i2] + " " + nums[s] + " " + nums[e]);
                    long sum = (long)nums[i1] + nums[i2] + nums[s] + nums[e];
                    if (sum < target) {
                        while (nums[s] == nums[s + 1] && s + 1 < e) {
                            s++;
                        }
                        s++;
                    } else if (sum > target) {
                        while (nums[e] == nums[e - 1] && e - 1 > s) {
                            e--;
                        }
                        e--;
                    } else {
                        add(nums[i1], nums[i2], nums[s], nums[e]);
                        while (nums[e] == nums[e - 1] && e - 1 > s) {
                            e--;
                        }
                        e--;
                    }
                }

                while (nums[i2] == nums[i2 + 1] && i2 + 1 < nums.length - 2) {
                    i2++;
                }
                i2++;
            }
            while (nums[i1] == nums[i1 + 1] && i1 + 1 < nums.length - 3) {
                i1++;
            }
            i1++;
        }

        return answer;
    }

    void add(int i1, int i2, int i3, int i4) {
        List<Integer> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        answer.add(list);
    }
}