class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<Range> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        //merge
        if(nums.length==0) return answer;
        list.add(new Range(nums[0], nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Range range = list.get(list.size() - 1);

            if (range.start <= num && num <= range.end) {
                continue;
            } else if (range.start!=Integer.MIN_VALUE && range.start - 1 == num) {
                range.start = num;
                continue;
            } else if (range.end != Integer.MAX_VALUE && range.end + 1 == num) {
                range.end = num;
                continue;
            }

            list.add(new Range(num, num));
        }

        
        for (Range range : list) {
            if (range.start != range.end) {
                answer.add(range.start + "->" + range.end);
            }else{
                answer.add(range.start + "");
            }
        }
        return answer;
    }
}

class Range {
    int start;
    int end;

    public Range(int s, int e) {
        start = s;
        end = e;
    }
}