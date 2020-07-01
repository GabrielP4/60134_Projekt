package pl.wsiz.gui3.sortie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sortie {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("activation")
    @Expose
    private String activation;
    @SerializedName("startString")
    @Expose
    private String startString;
    @SerializedName("expiry")
    @Expose
    private Date expiry;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("rewardPool")
    @Expose
    private String rewardPool;
    @SerializedName("variants")
    @Expose
    private ArrayList<Variant> variants;
    @SerializedName("boss")
    @Expose
    private String boss;
    @SerializedName("faction")
    @Expose
    private String faction;
    @SerializedName("expired")
    @Expose
    private Boolean expired;
    @SerializedName("eta")
    @Expose
    private String eta;

    public String getId() {
        return id;
    }

    public String getActivation() {
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

    public String getRewardPool() {
        return rewardPool;
    }

    public ArrayList<Variant> getVariants() {
        return variants;
    }

    public String getBoss() {
        return boss;
    }

    public String getFaction() {
        return faction;
    }

    public Boolean getExpired() {
        return expired;
    }

    public String getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Sortie{" +
                "id='" + id + '\'' +
                ", activation='" + activation + '\'' +
                ", startString='" + startString + '\'' +
                ", expiry='" + expiry + '\'' +
                ", active=" + active +
                ", rewardPool='" + rewardPool + '\'' +
                ", variants=" + variants +
                ", boss='" + boss + '\'' +
                ", faction='" + faction + '\'' +
                ", expired=" + expired +
                ", eta='" + eta + '\'' +
                '}';
    }
}
