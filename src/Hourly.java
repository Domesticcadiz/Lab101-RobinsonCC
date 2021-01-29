
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
public class Hourly extends Employee {

    private String position;
    private double hourlyRate;

    /**
     *
     * @param id
     * @param name
     * @param position
     * @param hourlyRate
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    /**
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position updates position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     *
     * @param hourlyRate updates hourlyRate
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     *
     * @return contents of instance
     */
    @Override
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate;
    }

    /**
     *
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hourly)) {
            return false;
        }

        Hourly h = (Hourly) o;

        return super.equals(h)
                && position.equals(h.position)
                && hourlyRate == h.hourlyRate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.position);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.hourlyRate) ^ (Double.doubleToLongBits(this.hourlyRate) >>> 32));
        return hash;
    }

}
