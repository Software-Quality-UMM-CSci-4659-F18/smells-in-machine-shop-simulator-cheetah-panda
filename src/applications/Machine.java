package applications;

import dataStructures.LinkedQueue;

class Machine {
    // data members
    private LinkedQueue jobQ; // queue of waiting jobs for this machine
    private int changeTime; // machine change-over time
    private int totalWait; // total delay at this machine
    private int numTasks; // number of tasks processed on this machine
    private Job activeJob; // job currently active on this machine

    // constructor
    Machine() {
        jobQ = new LinkedQueue();
    }
    // jobReady checks to see if there is a job in the queue
    // and if there is, goes to runJob() and returns time
    // it took to finish
    public int jobReady() {
        // wait over, ready for new job
        if (jobQ.isEmpty()) // no waiting job
            return(MachineShopSimulator.getLargeTime());
        else {// take job off the queue and work on it
            runJob();
            int t = activeJob.removeNextTask();
            return MachineShopSimulator.getTimeNow() + t;
        }
    }
    // runJob removes the current job frome the queue
    // and increments totalWait by the timeNow subtracted
    // by the arrival time
    public void runJob() {
        activeJob = (Job)jobQ.remove();
        totalWait = totalWait + MachineShopSimulator.getTimeNow() - activeJob.getArrivalTime();
        numTasks++;
    }

    public LinkedQueue getJobQ() {
        return jobQ;
    }

    public int getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(int changeTime) {
        this.changeTime = changeTime;
    }

    public int getTotalWait() {
        return totalWait;
    }

    public void setTotalWait(int totalWait) {
        this.totalWait = totalWait;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public Job getActiveJob() {
        return activeJob;
    }

    public void setActiveJob(Job activeJob) {
        this.activeJob = activeJob;
    }
}
