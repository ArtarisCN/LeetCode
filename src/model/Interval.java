package model;

/**
 * model
 * LeetCode
 * 2019.04.03.18:00
 *
 * @author : artairs
 */
public class Interval {

    public int start;

    public int end;

    public Interval() {
        start = 0; end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
