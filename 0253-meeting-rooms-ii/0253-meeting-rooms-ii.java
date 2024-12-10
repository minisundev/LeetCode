import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        PriorityQueue<Meeting> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.start != o2.start) {
                        return o1.start - o2.start;
                    } else {
                        return o1.end - o2.end;
                    }
                });

        for (int i = 0; i < intervals.length; i++) {
            pq.add(new Meeting(intervals[i][0], intervals[i][1]));
        }

        PriorityQueue<Meeting> temp = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.end != o2.end) {
                        return o1.end - o2.end;
                    } else {
                        return o1.start - o2.start;
                    }
                });

        int max = 0;

        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();

            while (!temp.isEmpty() && temp.peek().end <= meeting.start) {
                temp.poll();
            }
            max = Math.max(max, temp.size());

            temp.add(meeting);
        }

        return max + 1;

    }
}

class Meeting {
    public int start;
    public int end;

    public Meeting(int s, int e) {
        start = s;
        end = e;
    }
}