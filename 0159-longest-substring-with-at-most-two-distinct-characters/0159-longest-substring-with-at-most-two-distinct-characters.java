class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //sliding window 어떻게 풀더라
        //지금 포함되는 글자가 두개인지 판별해서 두개면 max를 업데이트하기,,
        //는 처음 두개가 달라야 적용되고 그냥 queue나 list를 쓰는게 낫겠어요 ㅎㅎ...

        int max = 0;
        List<Node> list = new ArrayList<>();
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(list.size()<2){
                if(!list.isEmpty() && list.get(0).c==c){
                    list.get(0).count = list.get(0).count+1;
                    count++;
                    max = Math.max(max,count);
                    continue;
                }
                list.add(new Node(c,1));
                count++;
                max = Math.max(max,count);
                continue;
            }

            if(list.get(0).c==c || list.get(1).c==c){
                count++;
                if(list.get(1).c==c){
                    list.get(1).count = list.get(1).count+1;
                    list.get(0).count = 0;
                }else{
                    list.add(list.get(0));
                    list.get(0).count = 1;
                    list.get(1).count = 0;
                    list.remove(0);
                }
                max = Math.max(max,count);
               //System.out.println("char :"+c+" max:"+max+" count :"+count);
                //print(list);
                continue;
            }else{
                list.remove(0);
                list.add(new Node(c,1));
                count = list.get(0).count+1;
                //System.out.println("added :"+c+" count :"+count);
            }

           // System.out.println("char :"+c+" max:"+max+" count :"+count);
            //print(list);
        }

        return max;
    }

    void print(List<Node> list){
        for(Node n : list){
            System.out.print(n.c+" ");
            System.out.print(n.count);
        }
        System.out.println();
    }
}

class Node{
    public char c;
    public int count;
    public Node(char c, int count){
        this.c = c;
        this.count = count;
    }
}