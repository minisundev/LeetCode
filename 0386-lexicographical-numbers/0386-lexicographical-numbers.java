import java.util.*;

public class Solution {
    
    public List<Integer> lexicalOrder(int limit) {
        List<Integer> result = new ArrayList<>(limit); 
        for (int i = 1; i <= 9; i++) { 
            generateLexicalNumbers(i, limit, result);
        }
        return result;
    }

    private void generateLexicalNumbers(int currentNumber, int limit, List<Integer> result) {
        if (currentNumber > limit) return;
        result.add(currentNumber);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            
            if (nextNumber > limit) break;
            
            generateLexicalNumbers(nextNumber, limit, result);
        }
    }
}
