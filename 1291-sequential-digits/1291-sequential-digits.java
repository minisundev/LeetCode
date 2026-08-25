class Solution {
    int leftIdx;
    int rightIdx;
    int [] arr = {1,2,3,4,5,6,7,8,9};

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        String str = low+"";
        int digits = str.length();

        leftIdx = (str.charAt(0)-'0')-1;
        rightIdx = leftIdx + digits - 1;

        for(int i=1; i<str.length(); i++){
            int n = str.charAt(i)-'0';
            if(leftIdx+i>=arr.length) break;
            if(n>arr[leftIdx+i]){
                nextIdx();
                break;
            }else if(n<arr[leftIdx+i]){
                break;
            }
            //System.out.println("leftIdx:"+leftIdx+" i:"+i+" number:"+getNumber());
        }

        int last = getNumber();
        //System.out.println("last:"+last);

        while(last<=high){
            if(last!=-1){
                list.add(last);
            }
            nextIdx();
            last = getNumber();
            if(last==-1){
                return list;
            }
        }

        return list;
    }

    int getNumber(){
        if(rightIdx>=arr.length){
            return -1;
        }
        int number = arr[rightIdx];
        int d = 10;
        for(int i=rightIdx-1; i>=leftIdx; i--){
            number += arr[i]*d;
            d *= 10;
        }
        return number;
    }

    void nextIdx(){
        leftIdx++;
        rightIdx++;
        if(rightIdx>=arr.length){
            int diff = rightIdx - leftIdx;
            leftIdx = 0;
            rightIdx = leftIdx + diff + 1;
        }
    }
}
//응응 메모리 리밋 초과해버림~ 메모리 리밋이 왜 넘어가는지 전혀모르겠음... 안 끝나서?