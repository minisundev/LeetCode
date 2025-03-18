class Solution {
    Map<Character, Integer> map = new HashMap<>();
    List<Character> list = new ArrayList<>();;
    Set<String> answer = new HashSet<>();
    boolean odd;
    String s;
    // 중복이 없는 순열!
    int[] index;
    boolean[] visit;
    char only = ' ';

    public List<String> generatePalindromes(String s) {
        this.s = s;
        index = new int[s.length() / 2];
        visit = new boolean[s.length() / 2];

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (s.length() % 2 == 0) {
            odd = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return new ArrayList(answer);
                } else {
                    for (int i = 0; i < (entry.getValue()) / 2; i++) {
                        list.add(entry.getKey());
                    }
                }
            }
        } else {
            odd = true;
            int odds = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    if (odds == 0) {
                        only = entry.getKey();
                    }
                    odds++;
                    for (int i = 0; i < (entry.getValue() - 1) / 2; i++) {
                        list.add(entry.getKey());
                    }
                } else {
                    for (int i = 0; i < (entry.getValue()) / 2; i++) {
                        list.add(entry.getKey());
                    }
                }

                if (odds > 1) {
                    return new ArrayList(answer);
                }

            }
        }

        System.out.println("only: " + only);

        set(0);

        return new ArrayList(answer);
    }

    // dfs로 구성하는거지...odd가 있으면 그것만 따로 빼야할 것 같기도 하고?even인 애들만 가져다가 만드는거지
    void set(int depth) {
        if (depth == index.length) {
            makeFull();
            return;
        }

        for (int i = 0; i < index.length; i++) {
            if (!visit[i]) {
                // System.out.println(depth+":"+i);
                visit[i] = true;
                index[depth] = i;
                set(depth + 1);
                visit[i] = false;
            }
        }

    }

    void makeFull() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            sb.append(list.get(index[i]));
        }
        if (only != ' ') {
            sb.append(only);
        }
        for (int i = index.length - 1; i >= 0; i--) {
            sb.append(list.get(index[i]));
        }
        // System.out.println(sb.toString());
        answer.add(sb.toString());
    }

}