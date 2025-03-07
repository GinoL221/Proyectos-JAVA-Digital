public class Worker implements Comparable<Worker> {
    private String name;
    private Integer hoursWorked;

    public Worker(String name, Integer hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return name;
    }

    /*
    @Override
    public int compareTo(Worker otherWorker) {
        if(this.hoursWorked > otherWorker.hoursWorked) {
            return 1;
        }
        if(this.hoursWorked < otherWorker.hoursWorked) {
            return -1;
        }
        return 0;
    }
    */

    @Override
    public int compareTo(Worker otherWorker) {
        return this.hoursWorked.compareTo(otherWorker.hoursWorked);
    }
}

