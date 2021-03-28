package demo;

public class Timer {
    private double startTime;
    private  double endTime;
    public void start()
    {
        startTime = System.currentTimeMillis();
    }
    public void pause()
    {
        endTime = System.currentTimeMillis();
    }

    public double elapsedTime()
    {

        double elapsedTIme = endTime - startTime;
        startTime =0; endTime=0;
        return elapsedTIme;
    }
}
