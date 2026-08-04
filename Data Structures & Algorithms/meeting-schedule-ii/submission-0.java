/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Event {
    int time;
    int delta;
    public Event(int time, int delta) {
        this.time = time;
        this.delta = delta;
    }
}
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Event> l = new ArrayList();
        for (int i = 0; i < intervals.size(); i++) {
            l.add(new Event(intervals.get(i).start, 1));
            l.add(new Event(intervals.get(i).end, -1));
        }
        Collections.sort(l, (a, b) -> {
            if (a.time == b.time) {
                return Integer.compare(a.delta, b.delta);
            } else {
                return Integer.compare(a.time, b.time);
            }
        });
        int meetings = 0;
        int maxMeeting =0;
        for (Event e : l) {
            meetings += e.delta;
            maxMeeting = Math.max(maxMeeting, meetings);
        }
        return maxMeeting;
    }
}
