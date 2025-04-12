package org.example.basic;

import java.time.LocalDate;

public class EdibleItem {
    private LocalDate expirationDate;
    private Boolean isApprovedForConsumption;
    private Integer inspectorId;

    public EdibleItem(LocalDate expirationDate, Boolean isApprovedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.isApprovedForConsumption = isApprovedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible() {
        return isNotExpired() && isApproved() && hasInspector();
    }

    private boolean isNotExpired() {
        return this.expirationDate.isAfter(LocalDate.now());
    }

    private boolean isApproved() {
        return this.isApprovedForConsumption.equals(Boolean.TRUE);
    }

    private boolean hasInspector() {
        return this.inspectorId != null;
    }
}
