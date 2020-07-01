package pl.wsiz.gui3;

import java.util.Date;

public class Fissures {
    private String id;

    private Date activation;

    private String startString;

    private Date expiry;

    private Boolean active;

    private String node;

    private String missionType;

    private String enemy;

    private String tier;

    private int tierNum;

    private Boolean expired;

    private String eta;

    public String getId() {
        return id;
    }

    public Date getActivation() {
        return activation;
    }

    public String getStartString() {
        return startString;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Boolean getActive() {
        return active;
    }

    public String getNode() {
        return node;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getEnemy() {
        return enemy;
    }

    public String getTier() {
        return tier;
    }

    public int getTierNum() {
        return tierNum;
    }

    public Boolean getExpired() {
        return expired;
    }

    public String getEta() {
        return eta;
    }
}
