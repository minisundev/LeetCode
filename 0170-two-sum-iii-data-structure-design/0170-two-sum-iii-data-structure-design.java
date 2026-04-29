import java.util.HashMap;
import java.util.Map;

class TwoSum {
    private Map<Long, Integer> map;//숫자 개수 저장

    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        long num = (long) number;
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    //두 수의 합이 value인것 찾기
    public boolean find(int value) {
        for (long num1 : map.keySet()) {
            long target = (long) value - num1;
            
            if (map.containsKey(target)) {
                // target이 num1과 다른 숫자라면 그냥 존재하기만 하면 됨
                if (num1 != target) return true;
                // target이 num1과 같다면 해당 숫자가 2개 이상 있어야 함
                if (map.get(target) > 1) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */