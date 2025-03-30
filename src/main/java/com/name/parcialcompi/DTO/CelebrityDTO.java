package com.name.parcialcompi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CelebrityDTO {
    private String name;
    private String profession;
    private double netWorth;
    private boolean suspiciousActivity;

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public boolean isSuspiciousActivity() {
        return suspiciousActivity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public void setSuspiciousActivity(boolean suspiciousActivity) {
        this.suspiciousActivity = suspiciousActivity;
    }
}
