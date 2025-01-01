class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                count[c1 - '0']++;
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if (c1 != c2) {
                if (count[c2 - '0'] > 0) {
                    cows++;
                    count[c2 - '0']--;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}