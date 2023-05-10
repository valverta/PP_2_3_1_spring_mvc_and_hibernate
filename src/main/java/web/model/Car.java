package web.model;

public class Car {
    private int series;
    private String model;
    private String color;

    public Car(int series, String model, String color) {
        this.series = series;
        this.model = model;
        this.color = color;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}
