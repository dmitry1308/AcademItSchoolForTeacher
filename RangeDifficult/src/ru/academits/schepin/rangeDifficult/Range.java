package ru.academits.schepin.rangeDifficult;


public class Range {

    private double from;
    private double to;


    public Range(double first, double second) {
        if (first > second) {
            throw new WrongIntervalException("Конец интервала меньше начала");
        }
        this.from = first;
        this.to = second;
    }


    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        if (from > to) {
            throw new IllegalStateException("Конец интервала меньше начала");
        }
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        if (to < from) {
            throw new IllegalStateException("Конец интервала меньше начала");
        }
        this.to = to;
    }

    public boolean isNotIntersection(Range r1) {
        return r1.to <= this.from || this.to <= r1.from;
    }


    public Range intersection(Range r1) {
        if (isNotIntersection(r1)) {
            return null;
        }

        // r1 inside this
        if (r1.from > this.from && r1.to < this.to) {
            return new Range(r1.from, r1.to);
        }

        // this inside r1
        if (this.from > r1.from && this.to < r1.to) {
            return new Range(this.from, this.to);
        }

        // [r1.from    [this.from    r1.to]    this.to]
        if (this.from < r1.to && this.from > r1.from) {
            return new Range(this.from, r1.to);
        }

        // [this.from    [r1.from    this.to]    r1.to]
        else {
            //   (r1.from < this.to)
            return new Range(r1.from, this.to);
        }
    }


    public Range[] union(Range r1) {
        if (isNotIntersection(r1)) {
            Range r1Copy = new Range(r1.from, r1.to);
            Range thisCopy = new Range(this.from, this.to);
            return new Range[]{r1Copy, thisCopy};
        }

        // r1 inside this
        if (r1.from > this.from && r1.to < this.to) {
            Range thisCopy = new Range(this.from, this.to);
            return new Range[]{thisCopy};
        }

        // this inside r1
        if (this.from > r1.from && this.to < r1.to) {
            Range r1Copy = new Range(r1.from, r1.to);
            return new Range[]{r1Copy};
        }

        // [r1.from    [this.from    r1.to]    this.to]
        if (this.from < r1.to && this.from > r1.from) {
            Range a = new Range(r1.from, this.to);
            return new Range[]{a};

        } else {
            Range a = new Range(this.from, r1.to);
            return new Range[]{a};
        }
    }

    public Range[] subtract(Range r1) {
        if (isNotIntersection(r1)) {
            Range a = new Range(this.from, this.to);
            return new Range[]{a};
        }

        // r1 inside this
        if (r1.from > this.from && r1.to < this.to) {
            Range a1 = new Range(this.from, r1.from);
            Range a2 = new Range(r1.to, this.to);
            return new Range[]{a1, a2};
        }

        // this inside r1 или [r1.from=this.from   this.to] r1.to] или
        // [r1.from [this.from   this.to= r1.to] или [r1.from=this.from   this.to= r1.to]
        if (this.from >= r1.from && this.to <= r1.to) {
            return new Range[0];
        }

        //[r1.from=this.from        this.to] r1.to]
        if (r1.from == this.from && r1.to > this.to) {
            Range a = new Range(r1.from, this.to);
            return new Range[]{a};
        }


        // [r1.from    [this.from    r1.to]    this.to]
        if (this.from <= r1.to && this.from >= r1.from) {
            Range a = new Range(r1.to, this.to);
            return new Range[]{a};
        } else {
            Range a = new Range(this.from, r1.from);
            return new Range[]{a};
        }
    }

   public void print() {
        System.out.format("[%.2f; %.2f]", from, to);
    }
}











































































