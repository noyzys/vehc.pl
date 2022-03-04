package pl.vehc.developers.fcode.timerank.impl.objects;

public interface Timming {

    Timming start();

    Timming stop();

    long getExecutingTime();

    long getExecutingNanoTime();

    String toString();

    long getStartTime();

    long getEndTime();

    long getNanoStartTime();

    long getNanoEndTime();

    String getName();
}
