class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        // 등고선이라고 생각해봐
        // 모노토닉 스택 문제일 수도 있어
        // 아래처럼 풀면 작 -> 크 들은 다 멀쩡하게 되는데 크 -> 작 들은 몇으로 해야하는지 모르는거야...
        // 커지면 필요한만큼 - 를 때려버리고
        // 나중에 최종값은 모든 값을 +로 만들 수 있는 기본값*ratings.length 해서 더해서 돌아가면? 되지 않나?
        candy[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            int current = ratings[i];
            // 왼쪽과 비교~~~
            // 왼작 인 경우
            int next = 1;
            if (ratings[i - 1] < current) {// 왼쪽이 나보다 더 작은 경우
                next = candy[i - 1] + 1;
            }

            // if (current < ratings[i - 1]) {// 왼쪽이 나보다 더 큰 경우
            //     next = candy[i - 1] - 1;
            // }

            if (current == ratings[i - 1]) {// 왼쪽이 나랑 같은 경우 1로 내려버리면 최솟값일듯...
                next = 1;
            }

            candy[i] = next;
        }

        if(candy[ratings.length-1]==0){
            candy[ratings.length-1] = 1;
        }

        for (int i = ratings.length-2; i >=0; i--) {
            int current = ratings[i];
            // 오작 인 경우
            int next = 1;
            if (ratings[i + 1] < current) {// 오른쪽이 나보다 더 작은 경우
                next = candy[i + 1] + 1;
            }

            candy[i] = Math.max(candy[i],next);
        }

        int candies = 0;

        for(int c : candy){
            candies += c;
        }
        return candies;
    }
}