class Solution {
    List<String> list = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        //0 ~ 255
        //각각 . 사이에 1~3자리 가능한거임
        //0으로 시작하면 안되는거고 이상한 글자 들어가면 안되는거임
        this.s = s;
        split1();
        return list;
    }

    void split1(){
        for(int i=1;i<=3;i++){
            split2(i);
        }
    }

    void split2(int i1){
        for(int i=1;i<=3;i++){
            split3(i1,i1+i);
        }
    }

    void split3(int i1,int i2){
        for(int i=1;i<=3;i++){
            check(i1,i2,i2+i);
        }
    }

    void check(int i1, int i2, int i3){
        //System.out.println(i1+","+i2+","+i3);
        StringBuilder sb = new StringBuilder();
        if(!append(sb,0,i1)) return;
        sb.append('.');

        if(!append(sb,i1,i2)) return;
        sb.append('.');

        if(!append(sb,i2,i3)) return;
        sb.append('.');

        if(!append(sb,i3,s.length())) return;
        //System.out.println(sb.toString());
        list.add(sb.toString());
    }

    boolean append(StringBuilder sb, int from, int to){
        if(to>s.length() || from>=s.length()){
            //System.out.println("to is bigger than s legnth issue");
            return false;
        }
        if(to-from>3){
            //System.out.println("to-from is bigger than 3 issue");
            return false;
        }
        if(s.charAt(from)=='0' && to-from>1){
            //System.out.println("start is 0 and the letter is more than 1 issue");
            return false;
        }

        StringBuilder nb = new StringBuilder();
        
        for(int i=from; i<to; i++){
            nb.append(s.charAt(i));
        }

        String number = nb.toString();
        if(number.length()>0 && Integer.parseInt(number)<=255){
            sb.append(number);
            return true;
        }

        return false;
    }
}