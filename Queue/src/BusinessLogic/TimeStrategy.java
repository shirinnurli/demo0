package BusinessLogic;

import GUI.SimulationFrame;

public class TimeStrategy implements Runnable {

    private Thread clockThread;
    private int time;
    private boolean isRunning;
    private SimulationFrame simulationFrame;

    public TimeStrategy(SimulationFrame usrInterface) {
        clockThread = new Thread(this);
        isRunning = false;
        time = 0;
        simulationFrame =usrInterface;
    }

    public void startClock() {
        isRunning = true;
        time = 0;
        clockThread.start();
    }

    public void stopClock() {
        isRunning = false;
        // clockThread.stop();
    }

    public int getTime() {
        return this.time;
    }

    public void run() {

        while (isRunning == true) {
            try {
                int currentTime = this.getTime();
                String curTime = ""+currentTime;
                simulationFrame.updateCurrentTime(curTime);
                // sleep 1000 miliseconds -> "stop" for 1 second then reiterate
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("");
            }
            time++;

        }
    }
}
