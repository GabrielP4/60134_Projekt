package pl.wsiz.gui3.sortie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {
    @SerializedName("boss")
    @Expose
    private String boss;
    @SerializedName("planet")
    @Expose
    private String planet;
    @SerializedName("missionType")
    @Expose
    private String missionType;
    @SerializedName("modifier")
    @Expose
    private String modifier;
    @SerializedName("modifierDescription")
    @Expose
    private String modifierDescription;
    @SerializedName("node")
    @Expose
    private String node;

    public String getBoss() {
        return boss;
    }

    public String getPlanet() {
        return planet;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getModifier() {
        return modifier;
    }

    public String getModifierDescription() {
        return modifierDescription;
    }

    public String getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "boss='" + boss + '\'' +
                ", planet='" + planet + '\'' +
                ", missionType='" + missionType + '\'' +
                ", modifier='" + modifier + '\'' +
                ", modifierDescription='" + modifierDescription + '\'' +
                ", node='" + node + '\'' +
                '}';
    }
}
