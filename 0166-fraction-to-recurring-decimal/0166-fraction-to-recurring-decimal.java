import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; //0 나누기 예외 처리
        
        StringBuilder result = new StringBuilder();

        //음수 처리
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        //정수 부분
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return result.toString(); //나머지가 없으면 정수 반환
        }
        
        result.append("."); //소수점 추가
        
        //소수 부분 계산
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        while (remainder != 0) {
            //반복되는 나머지 검사
            if (remainderIndexMap.containsKey(remainder)) {
                int index = remainderIndexMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            
            //현재 나머지 위치 저장
            remainderIndexMap.put(remainder, result.length());
            
            remainder *= 10;
            result.append(remainder / den); //몫 추가
            remainder %= den; //새로운 나머지 계산
        }
        
        return result.toString();
    }
}
