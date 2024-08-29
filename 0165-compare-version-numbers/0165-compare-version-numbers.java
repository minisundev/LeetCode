import java.lang.Math;

class Solution {
    public int compareVersion(String version1, String version2) {
        String [] arr1 = version1.split("\\.");
        String [] arr2 = version2.split("\\.");

        int max = Math.min(arr1.length,arr2.length);
        int index = 0;
         System.out.println("max:"+max);

        while(index<max){
            int i1 = Integer.parseInt(arr1[index]);
            int i2 = Integer.parseInt(arr2[index]);

            System.out.println(index+":"+i1+","+i2);

            if(i1<i2){
                return -1;
            }else if(i1>i2){
                return 1;
            }

            index++;
        }

        if(arr1.length==arr2.length){
            return 0;
        }
        
        if(arr1.length>arr2.length){
            return 1;
        }else if(arr1.length<arr2.length){
            return -1;
        }
        return 0;
    }
}