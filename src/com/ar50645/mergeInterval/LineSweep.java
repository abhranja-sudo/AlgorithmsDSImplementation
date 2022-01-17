package com.ar50645.mergeInterval;

import java.nio.channels.Pipe;
import java.util.*;

public class LineSweep {

    //     Given a list of time intervals, find if any of them overlap.
    public static boolean hasOverlap(Interval[] intervals) {
        List<Point> points = new ArrayList<>();

        for(Interval interval: intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }

        Collections.sort(points, (a,b) -> a.time - b.time);

        int count = 0;
        for(Point point: points) {
            if(point.isStart)
                count++;

            else
                count--;

            if(count > 1)
                return true;
        }

        return false;
    }

    /**
     * Merge Intervals - Given a list of intervals, merge all overlapping intervals.
     * At the end of the merge, there should be no overlapping intervals.
     * For example,Input = (1,3), (3,5), (6,8), (7,9)  Output = (1,5), (6,9)
     **/

    public static List<Interval> mergeInterval(Interval[] intervals) {

        List<Point> points = new ArrayList<>();
        for (Interval interval: intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }

        Collections.sort(points);

        List<Interval> output = new ArrayList<>();
        int count = 0;

        int start = -1;
        for(Point point: points) {
            if(point.isStart) {
                count++;
                if (count == 1)
                    start = point.time;
            }
            else {
                count--;
                if(count == 0)
                    output.add(new Interval(start, point.time));
            }
        }
        return output;
    }

    static private class Point implements Comparable<Point>{
        int time;
        boolean isStart;

        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        public int getTime() {
            return time;
        }

        public boolean isStart() {
            return isStart;
        }

        public int compareTo(Point that) {
            if(this.time == that.time){
                if(this.isStart == that.isStart)
                    return 0;
                return this.isStart ? -1 : 1;
            }
            return this.time > that.time ? 1: -1;
        }
    }

    static private class Interval {
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int start;
        private int end;
    }


}
