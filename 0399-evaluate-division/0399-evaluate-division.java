class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // ab + bc = ac 이런식으로 합쳐서 쓸 수 있겠다
        // 그럼 앞에 합쳐지는게 몇개인지 다 따져봐야 하는..? 걸까? 그게 있는지도....
        // 끝 -> 검색이 가능해야 함 끝으로 시작 인덱스랑 값이 나와줘야 함
        double[] answer = new double[queries.size()];
        Map<String, List<Value>> starts = new HashMap<>();
        Map<String, List<Value>> ends = new HashMap<>();

        // map에다가 equations 값 등록
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            List<Value> list = starts.getOrDefault(equation.get(0), new ArrayList());
            list.add(new Value(equation.get(1), values[i]));
            starts.put(equation.get(0), list);

            List<Value> list2 = starts.getOrDefault(equation.get(1), new ArrayList());
            list2.add(new Value(equation.get(0), 1 / values[i]));
            starts.put(equation.get(1), list2);
        }

        // 꺼내서 계산하기
        loop: for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            // end 로 타고타고 검색해서 값 찾아보고 없으면...-1 나가야 하는데...무한반복하면 어쩌지 visit이라도 만들어야 하나...
            // 그냥 시작한 end가 start가 되는것만 차단하면 될 것 같은데
            String start = query.get(0);
            String end = query.get(1);

            if (start.equals(end)) {
                if (starts.containsKey(start) || ends.containsKey(start)) {
                    answer[i] = 1;
                    continue loop;
                } else {
                    answer[i] = -1;
                    continue loop;
                }
            }

            // init
            Set<String> visit = new HashSet<>();
            List<Value> list = starts.get(start);
            List<Value> list2 = ends.get(start);
            if (list2 != null) {
                for (Value v : list2) {
                    list.add(v);
                }
            }
            visit.add(start);

            if (list == null) {
                System.out.println();
                answer[i] = -1.0;
                continue loop;
            }

            Queue<Value> queue = new LinkedList<>();

            for (Value value : list) {
                if (value.next.equals(end)) {
                    answer[i] = value.value;
                    continue loop;
                }

                if (!visit.contains(value.next)) {
                    queue.add(new Value(value.next, value.value));
                }
            }

            while (!queue.isEmpty()) {
                Value value = queue.poll();

                if (value.next.equals(end)) {
                    answer[i] = value.value;
                    continue loop;
                }

                list = starts.get(value.next);
                visit.add(value.next);

                if (list == null) {
                    answer[i] = -1.0;
                    continue loop;
                }

                for (Value v : list) {
                    if (v.next != start && !visit.contains(v.next)) {
                        queue.add(new Value(v.next, value.value * v.value));
                    }
                }
            }

            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}

class Value {
    public String next;
    public double value;

    public Value(String e, double v) {
        next = e;
        value = v;
    }
}