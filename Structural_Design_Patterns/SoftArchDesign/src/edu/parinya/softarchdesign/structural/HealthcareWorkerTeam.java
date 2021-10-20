package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private Set<HealthcareServiceable> workers = new LinkedHashSet<>();

    @Override
    public void service() {
        for(HealthcareServiceable w : workers) {
            w.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for(HealthcareServiceable w : workers) {
            totalPrice = totalPrice + w.getPrice();
        }
        return Double.parseDouble((String.format("%.1f", totalPrice)));
//        return totalPrice;
    }

    public void addMember(HealthcareServiceable w) {
        this.workers.add(w);
    }

    public void removeMember(HealthcareServiceable w) {
        this.workers.remove(w);
    }
}
