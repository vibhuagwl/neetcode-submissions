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
    public Event(int time, int delta)
    {
        this.time = time;
        this.delta = delta;
    }
}
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<Event> event = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            event.add(new Event(intervals.get(i).start, +1));
            event.add(new Event(intervals.get(i).end, -1));
        }
        Collections.sort(event, (a, b) -> {
            if (a.time == b.time) {
                return Integer.compare(a.delta, b.delta);
            }
            else {
                return Integer.compare(a.time, b.time);
            }
        });
        int meeting = 0;
        for (Event e : event) {
            meeting += e.delta;
            if (meeting > 1) {
                return false;
            }
        }
        return true;
    }
}
