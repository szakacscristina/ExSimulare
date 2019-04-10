package Domain;

public class Event {
    private String id;
    private String name;
    private String day;
    private String duration;
    private String starthour;

    /**
     *
     * @param id
     * @param name
     * @param day
     * @param duration
     */

    public Event(String id, String name, String day, String duration, String starthour) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getStarthour() {
        return starthour;
    }

    public void setStarthour(String starthour) {
        this.starthour = starthour;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", day='" + day + '\'' +
                ", duration='" + duration + '\'' +
                ", starthour='" + starthour +'\''+
                '}';
    }
}
