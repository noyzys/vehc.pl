package pl.vehc.developers.fcode.timerank.impl;

import pl.vehc.developers.fcode.timerank.impl.objects.Timming;

public class TimmingImpl implements Timming {

    private long startTime;
    private long endTime;
    private long nanoStartTime;
    private long nanoEndTime;
    private final String name;

    public TimmingImpl(final String name) {
        this.name = name;
    }

    @Override
    public Timming start() {
        this.startTime = System.currentTimeMillis();
        this.nanoStartTime = System.nanoTime();

        return this;
    }

    @Override
    public Timming stop() {
        this.endTime = System.currentTimeMillis();
        this.nanoEndTime = System.nanoTime();

        return this;
    }

    @Override
    public long getExecutingTime() {
        if (this.startTime == 0L || this.endTime == 0L) return 0L;

        return this.endTime - this.startTime;
    }


    @Override
    public long getExecutingNanoTime() {
        if (this.nanoStartTime == 0L || this.nanoEndTime == 0L) return 0L;

        return this.nanoEndTime - this.nanoStartTime;
    }

    @Override
    public String toString() {
        return this.name + " executing time: " + this.getExecutingTime() + "ms (" + this.getExecutingNanoTime() + "ns)";
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public long getEndTime() {
        return this.endTime;
    }

    @Override
    public long getNanoStartTime() {
        return this.nanoStartTime;
    }

    @Override
    public long getNanoEndTime() {
        return this.nanoEndTime;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
