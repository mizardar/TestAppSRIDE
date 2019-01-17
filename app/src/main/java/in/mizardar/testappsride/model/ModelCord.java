package in.mizardar.testappsride.model;

import com.google.gson.annotations.SerializedName;

public class ModelCord {

    @SerializedName("lon")
    private double lon;//":-0.13,
    @SerializedName("lat")
    private double lat;//":51.51

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
