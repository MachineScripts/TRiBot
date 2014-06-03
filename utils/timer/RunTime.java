package scripts.utils.timer;


public class RunTime {

    long minutes;
    long seconds;
    long hours;

    public long gettotal(){
        return System.currentTimeMillis() - start;
    }

    public long getseconds(){
        seconds = getElapsed()/1000;
        minutes = getElapsed()/60000;
        if(seconds > 59)
            seconds = seconds - (minutes * 60);
        if(minutes > 59.99)
            minutes = minutes -(hours * 60);
        return seconds;
    }
    public long getminutes(){
        seconds = getElapsed()/1000;
        minutes = getElapsed()/60000;
        if(seconds > 59)
            seconds = seconds - (minutes * 60);
        if(minutes > 59.98)
            minutes = minutes -(hours * 60);
        return minutes;
    }

    public long gethours(){
        hours = getElapsed()/3600000;
        return hours;
    }
    private long period;
    private long start;


    public RunTime(long period)
    {
        this.period = period;
        start = System.currentTimeMillis();
    }

    public long getElapsed()
    {
        return System.currentTimeMillis() - start;
    }

    public long getElapsed2()
    {
        return System.currentTimeMillis() - start;
    }

    public long getRemaining()
    {
        return period - getElapsed();
    }

    public boolean isRunning()
    {
        return getElapsed() <= period;
    }

    public void reset()
    {
        start = System.currentTimeMillis();
    }


    public void stop()
    {
        period = 0;
    }

    public static String format(long milliSeconds)
    {
        long secs = milliSeconds / 1000L;
        return String.format("%02d:%02d:%02d", new Object[] {
                Long.valueOf(secs / 3600L), Long.valueOf((secs % 3600L) / 60L), Long.valueOf(secs % 60L)
        });
    }

    public int getPerHour(int value) {
        if (this != null && this.getElapsed() > 0) {
            return (int) (value * 3600000d / this.getElapsed());
        }
        else {
            return 1;
        }
    }
    public long getPerHour(long value) {
        if (this != null && this.getElapsed() > 0) {
            return (long) (value * 3600000d / this.getElapsed());
        }
        else {
            return 0;
        }
    }

}
