package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import BusinessLogic.TimeStrategy;
import GUI.SimulationFrame;

public class Server implements Runnable {

    private List<Task> clientsList;
    private int queueIndex;
    private boolean isRunning;
    private int totalClientsEver;
    private int deadQueueTime;
    private int totalWaitingTime;
    private TimeStrategy timeStrategy;
    private Thread queueThread;
    private SimulationFrame simulationFrame;


    public Server(int index, TimeStrategy timer, SimulationFrame simulationFrame) {
        this.clientsList = new ArrayList<Task>();
        this.queueIndex = index;
        this.isRunning = false;
        this.totalClientsEver = 0;
        this.deadQueueTime = 0;
        this.totalWaitingTime = 0;
        this.timeStrategy = timer;
        this.queueThread = new Thread(this);
        this.simulationFrame = simulationFrame;

        start();
    }

    public List<Task> getClientsList() {
        return this.clientsList;
    }

    public int getNumberOfClientsInQueue() {
        return this.clientsList.size();
    }

    public int getQueueIndex() {
        return this.queueIndex;
    }

    public void displayClients() {
        int k = 0;
        Iterator<Task> myIterator = clientsList.iterator();
        while (myIterator.hasNext()) {
            Task currentTask = myIterator.next();
            System.out.println("Client " + k + " arrival " + currentTask.getArrivalTime() + " service "
                    + currentTask.getServiceTime());
            k++;
        }
    }

    public void addClientToQueue(Task myTask) {
        totalClientsEver++;
        this.clientsList.add(myTask);
        String logMessage = "Client"+ myTask.getClientId() +" arrived at queue " + this.queueIndex ;
        simulationFrame.updateLogs(logMessage);
        simulationFrame.updateQueue(this.queueIndex, this.getNumberOfClientsInQueue());
    }

    public void removeClientFromQueue(Task myTask) {
        this.clientsList.remove(myTask);
        String logMessage = "Client"+ myTask.getClientId() +" left queue " + this.queueIndex ;
        simulationFrame.updateLogs(logMessage);
        simulationFrame.updateQueue(this.queueIndex, this.getNumberOfClientsInQueue());

    }


    public void run() {

        while (isRunning == true || clientsList.size() > 0) {
            if (clientsList.isEmpty() == false) {
                Task currentTask = this.clientsList.get(0);
                int serviceTime = currentTask.getServiceTime();
                totalWaitingTime += timeStrategy.getTime() - currentTask.getArrivalTime();
                //totalWaitingTime +=getWaitingTime();
                try {
                    Thread.sleep(serviceTime * 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                removeClientFromQueue(currentTask);

            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                deadQueueTime++;
            }

        }
        if (totalClientsEver > 0) {
            System.out.println("Average waiting time for queue " + this.queueIndex + " : " + totalWaitingTime / (totalClientsEver * 1.0));
        }
        System.out.println("Queue " + this.queueIndex + " is empty, total dead time =" + deadQueueTime);

    }


    public void start() {
        this.isRunning = true;
        queueThread.start();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Server ").append(queueIndex).append(": \n");
        int i = 0;
        for (Task task : clientsList) {
            sb.append("Client ").append(i).append(": arrival ").append(task.getArrivalTime())
                    .append(", service ").append(task.getServiceTime()).append("\n");
            i++;
        }
        return sb.toString();
    }

    public void stop() {
        this.isRunning = false;
    }



}
