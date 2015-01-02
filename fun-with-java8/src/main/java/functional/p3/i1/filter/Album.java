package functional.p3.i1.filter;

/**
 * @author victorp
 */
public class Album {
    public final String name;
    public final int year;
    public final int ukChart;
    public final int usChart;


    public static Album album(String name, int year,  int ukChart,int usChart) {
        return new Album(name,year,ukChart,usChart);
    }

    public Album(String name, int year, int ukChart, int usChart) {
        this.name = name;
        this.year = year;
        this.ukChart = ukChart;
        this.usChart = usChart;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getUkChart() {
        return ukChart;
    }

    public int getUsChart() {
        return usChart;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
