class Solution {
    public void reverseWords(char[] s) {

        //간단한 풀이를 생각해봄
        //일단 무조건 배열 전체 앞뒤를 싹 뒤집다가 ' '를 만나는 순간 앞의 공백이나 ' '부터 거기까지 다시 뒤집음
        
        int left = 0;
        int right = s.length;

        reverse(s, 0, s.length-1);

        for (int i = 0; i < right; i++) {
            if (s[i] == ' ' || i == right-1) {
                if(i==right-1){
                    reverse(s, left, i);
                }else{
                    reverse(s, left, i-1);
                }
                left = i+1;
            }
        }
    }

    void reverse(char [] arr, int start, int end){
        int left = start;
        int right = end;

        while(left<right){
            swap(arr,left++,right--);
        }
    }

    void swap(char [] arr, int i1, int i2){
        char temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}