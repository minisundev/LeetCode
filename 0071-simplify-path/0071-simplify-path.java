class Solution {
    public String simplifyPath(String path) {
       // 마지막 /들 삭제
       // . -> 생략
       // .. -> 이전것까지 생략 -> 이전 String 배열 ""로 만들기
       String [] arr = path.split("/");
       StringBuilder sb = new StringBuilder();

       for(int i=0; i<arr.length; i++){
            String str = arr[i];
            if(str.equals("")) continue;
            if(str.equals(".")){
                arr[i] = "";
            }else if(str.equals("..")){
                int prev = i-1; //이거 전역으로 저장해놨다가 쓰면 시간이 더 빠를듯
                while(arr[prev].equals("") && prev>0){
                    prev--;
                }
                arr[prev] = "";
                arr[i] = "";
            }
       }

       for(int i=0; i<arr.length; i++){
            String str = arr[i];
            if(!str.equals("")){
                sb.append("/").append(str);
            }
        }

        if(sb.length()==0){
            sb.append("/"); 
        }
        return sb.toString();

    }
}