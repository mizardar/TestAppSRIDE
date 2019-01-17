package in.mizardar.testappsride.model;

import com.google.gson.annotations.SerializedName;

public class ModelWeatherDetails {

    @SerializedName("id")
    private int id;//":300,
    @SerializedName("main")
    private String main;//":"Drizzle",
    @SerializedName("description")
    private String description;//":"light intensity drizzle",
    @SerializedName("icon")
    private String icon;//":"09d"

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
