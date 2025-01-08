class Solution {
    String answer = new String();

    public String multiply(String num1, String num2) {
        
        //곱하기의 원리를 물어보는 문제네...
        //123*45를
        //123*40 + 123*5로 쪼개가지고 값을 더해주면... 40이니까 0 민 자릿수만큼.... 하면 될 것 같은데
        //곱한게 음수가 나오면 오버플로우가 일어났다는 뜻이니까 음수가 안 나올때까지 n을 쪼개가면서 나눠가지고 곱해와서 n번 더하기를 돌리세요
        int i1 = Integer.parseInt(num1);
        int i2 = Integer.parseInt(num2);

        if(i1*i2>=0){
            return i1*i2+"";
        }
        else{
            int n=1;
            while((i1/n)*i2<0){
                n++;
            }
            System.out.println("n"+n);
            int multiply = (i1/n)*i2;
            for(int i=0; i<n; i++){
                plus(multiply);
            }
        }

        return answer;
    }

    void plus(int number){
        int increment = 0;
        String result = "";
        String num = number+"";
        int index = answer.length()-1;

        for(int i=num.length()-1; i>=0; i--){

            char c1 = index<0?0:answer.charAt(index--);
            int sum = (c1-'0'+num.charAt(i)-'0');
            if(sum+increment>=10){
                increment = 1;
                sum = sum-10;
            }else{
                increment = 0;
            }
            result = sum + result;
        }

        if(index>=0){
            for(int i=index; i>=0; i--){
                result = (answer.charAt(i)-'0') + result;//dlseprtm answp qkftodgka
            }
        }

        answer = result;
    }


}