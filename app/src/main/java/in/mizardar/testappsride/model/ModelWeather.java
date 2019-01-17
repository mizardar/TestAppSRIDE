package in.mizardar.testappsride.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelWeather<T> {

    @SerializedName("coord")
    private ModelCord coord;//":{  },
    @SerializedName("weather")
    private List<ModelWeatherDetails> weather;//":[  ],
    @SerializedName("base")
    private String base;//":"stations",
    @SerializedName("main")
    private ModelMain main;//":{  },
    @SerializedName("visibility")
    private long visibility;//":10000,
    @SerializedName("dt")
    private long dt;//":1485789600,
    @SerializedName("id")
    private long id;//":2643743,
    @SerializedName("name")
    private String name;//":"London",
    @SerializedName("cod")
    private int cod;//":200

    public ModelCord getCoord() {
        return coord;
    }

    public void setCoord(ModelCord coord) {
        this.coord = coord;
    }

    public List<ModelWeatherDetails> getWeather() {
        return weather;
    }

    public void setWeather(List<ModelWeatherDetails> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ModelMain getMain() {
        return main;
    }

    public void setMain(ModelMain main) {
        this.main = main;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
