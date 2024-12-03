class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        for(int i=citations.length-1; i>=0; i--){
            //이것 포함 출판한 논문의 개수가 무엇인가요 -> citations.length-i
            //그것과 citations[i] 중에 작은 것...
            h = Math.max(h,Math.min(citations.length-i,citations[i]));
        }
        return h;
    }
}