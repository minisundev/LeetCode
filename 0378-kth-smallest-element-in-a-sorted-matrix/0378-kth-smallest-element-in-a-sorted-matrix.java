class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // -> 이거 뭐라고 해야하지
        // row를 이분탐색하면서 col을 이분탐색해서 아... 하나는 pivot을 시켜야 하지 않을까요?
        // 이분탐색을 하려면 target을 정해놔야 하지 않아?
        int n = matrix.length;
        int m = matrix[0].length;

        // lowerbound같은디...
        //int low = matrix[0][0];
        //int high = matrix[n - 1][m - 1];

       // while (low <= high) {
            //int mid = (low + high) / 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int mid = matrix[i][j];
            int count = count(matrix, mid,k);
            //System.out.println("i:"+i+" j:"+j+" mid:"+mid+" count:"+count);
            if(count==0)
                return mid;
            }
        
        }
        return matrix[0][0];
    }

    int count(int [][] arr, int target, int k){
        int lowerCount = 0;
        int upperCount = 0;
        loop:
        for(int i=0; i<arr.length; i++){
            int low = 0;
            int high = arr[0].length;

            //upperbound
            while(low<high){//같거나 작으면 올려
                int mid = (low+high)/2;

                if(arr[i][mid]<=target){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            int upperbound = low;
            low = 0;
            high = arr[0].length;

            //lowerbound
            while(low<high){//작으면 올려
                int mid = (low+high)/2;

                if(arr[i][mid]<target){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            int lowerbound = low;
        
            upperCount += upperbound;
            lowerCount += lowerbound;
        }

        //System.out.println("target: "+target+" upper:"+upperCount +" lower:" +lowerCount);
        
        if(k<=upperCount && k>lowerCount){
            return 0;
        }
        if(k>upperCount){
            return 1;
        }
        return -1;
    }
}