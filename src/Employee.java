
import java.util.Objects;

/**
 *
 * @author Joe Latimer
 * @version 1/19/2021 An example of a super class.
 *
 */
public class Employee {

    private static int employeeCount = 0;
    private int id;
    private String name;  // the employees name

    /**
     * Constructor for the Employee class
     *
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id updates id instance variable
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name updates name instance variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return number of time Employee constructor called
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     *
     * @return contents of Employee instance
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + id + ":" + name + ":" + employeeCount;
    }

    /**
     *
     * @param o object to be compared
     * @return true if objects equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;

        return id == e.id
                && name.equals(e.name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
