package Model;

public class Task {

    private int arrivalTime;
    private int serviceTime;
    private int clientID;

    public Task(int arrivalTime, int serviceTime, int clientID)
    {
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
        this.clientID=clientID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getClientId()
    {
        return this.clientID;
    }
}
