package pl.wsiz.gui3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FlashSales {
    @SerializedName("item")
    @Expose
    public String item;
    @SerializedName("expiry")
    @Expose
    public Date expiry;
    @SerializedName("activation")
    @Expose
    public String activation;
    @SerializedName("originalPrice")
    @Expose
    public Integer originalPrice;
    @SerializedName("salePrice")
    @Expose
    public Integer salePrice;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("sold")
    @Expose
    public Integer sold;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("eta")
    @Expose
    public String eta;
    @SerializedName("discount")
    @Expose
    public Integer discount;

    public String getItem() {
        return item;
    }

    public Date getExpiry() {
        return expiry;
    }

    public String getActivation() {
        return activation;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getSold() {
        return sold;
    }

    public String getId() {
        return id;
    }

    public String getEta() {
        return eta;
    }

    public Integer getDiscount() {
        return discount;
    }
}
