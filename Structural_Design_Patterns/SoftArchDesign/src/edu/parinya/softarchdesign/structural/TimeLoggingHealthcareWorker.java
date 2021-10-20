package edu.parinya.softarchdesign.structural;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{
    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TimeLoggin");
    }

    @Override
    public void service() {
        System.out.print(new java.util.Date() + ": ");
        worker.service();
    }
}
