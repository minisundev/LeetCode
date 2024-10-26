class Solution {
    public String addBinary(String a, String b) {

        //a가 더 길다고 가정
        if(b.length()>a.length()){
            return addBinary(b,a);
        }
        char [] arr = new char[a.length()];

        int aIdx = a.length()-1;
        int increment = 0;

        for(int bIdx = b.length()-1; bIdx>=0; bIdx--){
            int number = (b.charAt(bIdx)-'0')+(a.charAt(aIdx)-'0')+increment;
            if(number>=2){
                increment = 1;
                number = number-2;
            }else{
                increment = 0;
            }
            //System.out.println(number+","+increment);
            arr[aIdx] = (char)(number+'0');
            aIdx--;
        }

        while(aIdx>=0){
            int number = (a.charAt(aIdx)-'0')+increment;
            if(number>=2){
                increment = 1;
                number = number-2;
            }else{
                increment = 0;
            }
            //System.out.println(number+","+increment);
            arr[aIdx] = (char)(number+'0');
            aIdx--;
        }

        String result = new String(arr);

        if(increment==1){
            result = increment+result;
        }

        return result;
    }
}