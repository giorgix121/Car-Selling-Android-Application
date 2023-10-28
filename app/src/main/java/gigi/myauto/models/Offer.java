package gigi.myauto.models;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by UGLemondoTrainings on 4/26/16.
 */
public class Offer implements Serializable, Comparable, Comparator {

    private int id;
    private int price;
    private String color;
    private String engine;
    private String mileage;
    private String drivetrain;
    private String model;
    private String description;
    private String location;
    private String year;
    private int abs;
    private int aircon;
    private int fourxfour;
    private int power_windows;
    private int system_monitor;
    private int power_door_locks;
    private int mp3_player;
    private int analog_display;
    private int air_filtration;
    private int chrome_bodysided_insert;
    private int rear_spoiler;
    private int bluetooth;
    private int stereo;
    private String image;
    private int cruise_control;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getAircon() {
        return aircon;
    }

    public void setAircon(int aircon) {
        this.aircon = aircon;
    }

    public int getFourxfour() {
        return fourxfour;
    }

    public void setFourxfour(int fourxfour) {
        this.fourxfour = fourxfour;
    }

    public int getPower_windows() {
        return power_windows;
    }

    public void setPower_windows(int power_windows) {
        this.power_windows = power_windows;
    }

    public int getSystem_monitor() {
        return system_monitor;
    }

    public void setSystem_monitor(int system_monitor) {
        this.system_monitor = system_monitor;
    }

    public int getPower_door_locks() {
        return power_door_locks;
    }

    public void setPower_door_locks(int power_door_locks) {
        this.power_door_locks = power_door_locks;
    }

    public int getMp3_player() {
        return mp3_player;
    }

    public void setMp3_player(int mp3_player) {
        this.mp3_player = mp3_player;
    }

    public int getAnalog_display() {
        return analog_display;
    }

    public void setAnalog_display(int analog_display) {
        this.analog_display = analog_display;
    }

    public int getAir_filtration() {
        return air_filtration;
    }

    public void setAir_filtration(int air_filtration) {
        this.air_filtration = air_filtration;
    }

    public int getChrome_bodysided_insert() {
        return chrome_bodysided_insert;
    }

    public void setChrome_bodysided_insert(int chrome_bodysided_insert) {
        this.chrome_bodysided_insert = chrome_bodysided_insert;
    }

    public int getRear_spoiler() {
        return rear_spoiler;
    }

    public void setRear_spoiler(int rear_spoiler) {
        this.rear_spoiler = rear_spoiler;
    }

    public int getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(int bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getStereo() {
        return stereo;
    }

    public void setStereo(int stereo) {
        this.stereo = stereo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCruise_control() {
        return cruise_control;
    }

    public void setCruise_control(int cruise_control) {
        this.cruise_control = cruise_control;
    }


    @Override
    public int compareTo(Object another) {
        return 0;
    }

    @Override
    public int compare(Object lhs, Object rhs) {
        return 0;
    }
}





