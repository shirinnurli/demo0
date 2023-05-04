package BusinessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.*;

import javax.swing.JOptionPane;

import Model.Task;
import Model.Client;
import Model.IdGenerator;
import Model.Server;
import GUI.SimulationFrame;

public class SimulationManager implements Runnable {

    private SimulationFrame simulationFrame;

    private int arrivalMin;
    private int arrivalMax;
    private int serviceMin;
    private int serviceMax;
    private int nbQueues;
    private int simulationDuration;
    private int numberOfClients;

    private int clientsInterval=0;
    private int serviceInterval=0;

    private TimeStrategy timeStrategy;
    private Thread controllerThread;
    private Server[] myQueues;

    private int maxClientsAtaTime = 0;
    private int nbClients = 0;
    private int peakHour = 0;
    private int totalServiceTime = 0;

    public void start() {

        simulationFrame = new SimulationFrame();
        simulationFrame.setVisible(true);
        initializeSimulation();

        timeStrategy = new TimeStrategy(simulationFrame);
        controllerThread = new Thread(this);
    }

    public boolean checkInputData() {
        String arrivalMin = simulationFrame.getTimeMin();
        String arrivalMax = simulationFrame.getTimeMax();
        String serviceMin = simulationFrame.getServiceTimeMin();
        String serviceMax = simulationFrame.getServiceTimeMax();
        String numberOfQueues = simulationFrame.getNumberOfQueues();
        String simulationTime = simulationFrame.getSimulationTime();
        String numberOfClients = simulationFrame.getNumberOfClients();

        int arrMin, arrMax, serMin, serMax, nbQueues, simTime, nbClients;
        try {
            arrMin = Integer.parseInt(arrivalMin);
            arrMax = Integer.parseInt(arrivalMax);
            serMin = Integer.parseInt(serviceMin);
            serMax = Integer.parseInt(serviceMax);
            nbQueues = Integer.parseInt(numberOfQueues);
            simTime = Integer.parseInt(simulationTime);
            nbClients = Integer.parseInt(numberOfClients);

            if (arrMin > 0 && arrMax > 0 && serMax > 0 && serMin > 0 && nbQueues > 0 && nbQueues <= 20 && simTime > 0
                    && nbClients > 0 && arrMin < arrMax && serMin < serMax) {
                setData(arrMin, arrMax, serMin, serMax, nbQueues, simTime, nbClients);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input data!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input data!");
            return false;
        }
    }


    public void setData(int arrMin, int arrMax, int serMin, int serMax, int nbQueues, int simTime, int nbClients) {
        this.arrivalMin = arrMin;
        this.arrivalMax = arrMax;
        this.serviceMin = serMin;
        this.serviceMax = serMax;
        this.nbQueues = nbQueues;
        this.simulationDuration = simTime;
        this.numberOfClients = nbClients;
    }

    public void initializeSimulation() {
        simulationFrame.addStartButtonActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (checkInputData() == true) {
                    System.out.println("Good input data!");
                    System.out.println(arrivalMin);
                    System.out.println(arrivalMax);
                    System.out.println(serviceMin);
                    System.out.println(serviceMax);
                    System.out.println(nbQueues);
                    System.out.println(simulationDuration);
                    System.out.println(numberOfClients);


                    myQueues = new Server[nbQueues];

                    for (int i = 0; i < nbQueues; i++) {
                        myQueues[i] = new Server(i + 1, timeStrategy, simulationFrame);
                    }
                    System.out.println("Starting clock");
                    timeStrategy.startClock();
                    System.out.println();
                    controllerThread.start();
                }
            }
        });
    }

    public int getShortestQueue() {
        int minIndex = 0;
        int minQ = myQueues[0].getNumberOfClientsInQueue();
        for (int i = 1; i < myQueues.length; i++) {
            if (myQueues[i].getNumberOfClientsInQueue() < minQ) {
                minQ = myQueues[i].getNumberOfClientsInQueue();
                minIndex = i;
            }
        }
        return minIndex;
    }


    public void run() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create list of clients with their arrival time and service time
        List<Client> clients = new ArrayList<>();
        Random randomVar = new Random();
        for (int i = 1; i <= numberOfClients; i++) {
            int arrivalTime = arrivalMin + randomVar.nextInt((arrivalMax - arrivalMin) + 1);
            int serviceTime = serviceMin + randomVar.nextInt((serviceMax - serviceMin) + 1);
            clients.add(new Client(i, arrivalTime, serviceTime));
        }

        // Sort the clients list by arrival time
        clients.sort(Comparator.comparingInt(Client::getArrivalTime));

        while (timeStrategy.getTime() < simulationDuration) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            // Add clients to queues if their arrival time has come
            while (!clients.isEmpty() && clients.get(0).getArrivalTime() <= timeStrategy.getTime()) {
                Client client = clients.remove(0);
                Task newTask = new Task(client.getArrivalTime(), client.getServiceTime(), client.getId());
                this.totalServiceTime += client.getServiceTime();
                this.nbClients++;
                int minQIndex = getShortestQueue();
                myQueues[minQIndex].addClientToQueue(newTask);

                if (timeStrategy.getTime() > numberOfClients) {
                    clientsInterval++;
                    serviceInterval += client.getServiceTime();
                }

                int max = numberOfClients - clients.size();
                if (maxClientsAtaTime < max) {
                    this.maxClientsAtaTime = max;
                    this.peakHour = timeStrategy.getTime();
                }
            }

           /* boolean allQueuesEmpty = true;
            for (int i = 0; i < myQueues.length; i++) {
                if (myQueues[i].getNumberOfClientsInQueue() > 0) {
                    allQueuesEmpty = false;
                    break;
                }
            }*/
            boolean allQueuesEmpty = false;
            while (!allQueuesEmpty) {
                allQueuesEmpty = true;
                for (int i = 0; i < myQueues.length; i++) {
                    if (myQueues[i].getNumberOfClientsInQueue() > 0) {
                        allQueuesEmpty = false;
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            if (allQueuesEmpty && clients.isEmpty()) {
                break;
            }
        }


        // Stop the simulation
        System.out.println("Stopping simulation : ");
        for (int i = 0; i < myQueues.length; i++) {
            myQueues[i].stop();
            System.out.println("Stopping queue number " + myQueues[i].getQueueIndex());
        }
        System.out.println("Stopping clock.");
        timeStrategy.stopClock();

        try {
            fileWriter.write("Total clients served : " + this.nbClients + "\n");
            fileWriter.write("Average service time : " + (float) (this.totalServiceTime) / this.nbClients + "\n");
            fileWriter.write("Peak hour : " + this.peakHour + "\n");
            fileWriter.write("Maximum clients at a time : " + this.maxClientsAtaTime + "\n");
            fileWriter.write("Clients interval : " + (float) (this.clientsInterval) / (float) (this.nbClients) + "\n");
            fileWriter.write("Service interval : " + (float) (this.serviceInterval) / (float) (this.nbClients) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
