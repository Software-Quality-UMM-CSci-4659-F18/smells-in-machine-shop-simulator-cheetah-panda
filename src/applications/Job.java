package applications;

import dataStructures.LinkedQueue;

class Job {
    // data members
    private LinkedQueue taskQ; // this job's tasks
    private int length; // sum of scheduled task times
    private int arrivalTime; // arrival time at current queue
    private int id; // job identifier

    // constructor
    Job(int theId) {
        id = theId;
        taskQ = new LinkedQueue();
        // length and arrivalTime have default value 0
    }



    public int getTaskMachine() {
        int[] i = (int[])taskQ.getFrontElement();
        return i[0];
    }


    public void addTask(int theMachine, int theTime) {
        int[] task = {theMachine, theTime};
        getTaskQ().put(task);
    }

    /**
     * remove next task of job and return its time also update length
     */
    public int removeNextTask() {
        int[] task = (int[])taskQ.remove();
        int theTime = task[1];
        length = getLength() + theTime;
        return theTime;
    }

    public LinkedQueue getTaskQ() {
        return taskQ;
    }

    public int getLength() {
        return length;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

}
