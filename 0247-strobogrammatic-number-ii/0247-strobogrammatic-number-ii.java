class Solution {
    char [] arr; 
    //int left;
    //int right;
    List<String> list = new ArrayList<>();
    List<Strobo> one= new ArrayList<>();
    List<Strobo> two= new ArrayList<>();
    

    public List<String> findStrobogrammatic(int n) {
        
        arr = new char[n];
        //left = 0;
        //right = n-1;
        
        two.add(new Strobo('6','9'));
        two.add(new Strobo('9','6'));

        one.add(new Strobo('0','0'));
        one.add(new Strobo('8','8'));
        one.add(new Strobo('1','1'));

        search(0,n-1);

        return list;
    }

    public void search(int left, int right){
        if(left>right){
            list.add(charToString(arr));
            return;
        }else if(left==right){
            for(int i=0; i<one.size(); i++){
                Strobo strobo = one.get(i);
                arr[left] = strobo.origin;
                list.add(charToString(arr));
            }
            return;
        }

        for(int i=0; i<one.size(); i++){
            Strobo strobo = one.get(i);
            if(strobo.origin=='0' && left==0){
                continue;
            }
            arr[left] = strobo.origin;
            arr[right] = strobo.pair;
            search(left+1, right-1);
        }
        for(int i=0; i<two.size(); i++){
            Strobo strobo = two.get(i);
            arr[left] = strobo.origin;
            arr[right] = strobo.pair;
            search(left+1, right-1);
        }
    }

    String charToString(char [] arr){
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
}

class Strobo {
    public char origin;
    public char pair;
    public Strobo(char o, char p){
        origin = o;
        pair = p;
    }
}