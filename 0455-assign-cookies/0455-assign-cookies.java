class Solution {
    public int findContentChildren(int[] childs, int[] cookies) {
        if(cookies.length==0) return 0;
        int count = 0;
        int child = childs.length-1;
        int cookie = cookies.length-1;

        Arrays.sort(childs);
        Arrays.sort(cookies);

        while(child>=0 && cookie>=0){
            if(cookies[cookie]>=childs[child]){
                count++;
                cookie--;
                child--;
            }else{//childs[child]<cookies[cookie]
                child--;
            }
        }

        return count;

    }
}