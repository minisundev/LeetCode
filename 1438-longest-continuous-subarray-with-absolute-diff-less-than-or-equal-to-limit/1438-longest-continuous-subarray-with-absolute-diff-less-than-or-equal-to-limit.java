class Solution {
    ArrayDeque<Integer> min = new ArrayDeque<>();
    ArrayDeque<Integer> max = new ArrayDeque<>();
    int [] arr;
    int k;

    public int longestSubarray(int[] nums, int limit) {
        arr = nums;
        k = limit;

        int length = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            insertMin(i);
            insertMax(i);

            while(j<i && arr[max.peekFirst()]-arr[min.peekFirst()]>limit){
                j++;
                cleanMin(j);
                cleanMax(j);
            }
            
            //System.out.println("i:"+i+" j:"+j+" min:"+arr[min.peekFirst()] + " max:"+arr[max.peekFirst()]);

            cleanMin(j);
            cleanMax(j);
            
            length = Math.max(i-j+1, length);
        }

        return length;
    }

    void insertMin(int index){
        int num = arr[index];
        while(!min.isEmpty() && arr[min.peekLast()]>num){
            min.removeLast();
        }
        min.addLast(index);
    }

    void insertMax(int index){
        int num = arr[index];
        while(!max.isEmpty() && arr[max.peekLast()]<num){
            max.removeLast();
        }
        max.addLast(index);
    }

    void cleanMin(int index){
        while(!min.isEmpty() && min.peekFirst()<index){
            min.removeFirst();
        }
    }

    void cleanMax(int index){
        while(!max.isEmpty() && max.peekFirst()<index){
            max.removeFirst();
        }
    }
}