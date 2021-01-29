
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * An client that demonstrates polymorphism.
 *
 * @author latimerlocal
 * @version 01/19/2021
 */
public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        Employee[] employeeList = new Employee[20];
        int index = 0;
        String readType = null;
        int readID = -1;
        String readName = null;
        String readTitlePosition = null;
        int readSalary = -1;
        double readHourlyRate = -1.0;
        String input = null;
        String writeType;
        int writeID = -1;
        String writeName;
        String writeTitlePosition;
        int writeSalary = -1;
        double writeHourlyRate = -1;

        try {
//            Scanner file = new Scanner(new File("/Users/chris/NetBeansProjects/Inheritance2/Lab101-RobinsonCC/src/employeeList.txt"));
            Scanner file = new Scanner(new File("C:\\data\\employeeList.txt"));
            while (file.hasNext()) {
                String readLine = file.nextLine();
                Scanner scan = new Scanner(readLine);
                if (scan.hasNext()) {
                    readType = scan.next();
                }
                if (scan.hasNextInt()) {
                    readID = scan.nextInt();
                }
                if (scan.hasNext()) {
                    readName = scan.next();
                }
                if (scan.hasNext()) {
                    readTitlePosition = scan.next();
                }
                if (scan.hasNextInt()) {
                    readSalary = scan.nextInt();
                }
                if (scan.hasNextDouble()) {
                    readHourlyRate = scan.nextDouble();
                }
                if (readType.equals("S")) {
                    employeeList[index] = new Salaried(readID, readName, readTitlePosition, readSalary);
                    index++;
                }
                if (readType.equals("H")) {
                    employeeList[index] = new Hourly(readID, readName, readTitlePosition, readHourlyRate);
                    index++;
                }
            }
            file.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //asking if you would want to add employee
        Scanner scan = new Scanner(System.in);

        // create employee type safe loop
        //type
        System.out.println("Please make an hourly employee.");

        //hourly
        writeType = "H";
        //ID
        System.out.println("Enter employee ID: ");
        //checks if correct value
        while (!scan.hasNextInt()) {
            System.out.println("Invalid entry.\nEnter employee ID: ");
            scan.next();
        }
        //checks if value already taken
        if (scan.hasNextInt()) {
            int id = scan.nextInt();
            boolean exists = true;
            while (exists == true) {
                try {
                    for (int x = 0; x < employeeList.length;) {

                        if (employeeList[x].getId() == id) {
                            exists = true;

                            System.out.println("ID already exists.\nEnter employee ID: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Invalid entry.\nEnter employee ID: ");
                                scan.next();
                            }
                            x = 0;
                            id = scan.nextInt();
                        } else {
                            exists = false;

                            if (employeeList[x] == null && exists == false) {
                                break;
                            }
                            x++;
                        }
                        writeID = id;
                    }
                } catch (NullPointerException npe) {
                } finally {
                    break;
                }

            }

        }
        //name
        System.out.println("Enter employee name: ");
        while (scan.hasNextInt() || scan.hasNextDouble() || scan.hasNextBoolean()) {
            System.out.println("You may have entered a number.\nPlease enter employee name: ");
            scan.next();
        }
        writeName = scan.next();
        //position
        System.out.println("Enter employee position: ");
        while (scan.hasNextInt() || scan.hasNextDouble() || scan.hasNextBoolean()) {
            System.out.println("You may have entered a number.\nPlease enter employee position: ");
            scan.next();
        }
        writeTitlePosition = scan.next();
        //hourly rate
        System.out.println("Enter the hourly rate as a decimal: ");
        while (!scan.hasNextDouble()) {
            System.out.println("You may not have entered the hourly wage correctly.\nEnter the hourly rate as a decimal: ");
            scan.next();
        }
        if (scan.hasNextDouble()) {
            writeHourlyRate = scan.nextDouble();
        }

        employeeList[index] = new Hourly(writeID, writeName, writeTitlePosition, writeHourlyRate);
        index++;
        //                try {
        //                    // Append to the end of the file  
        //                    FileOutputStream fos;
        //                    fos = new FileOutputStream("/Users/chris/NetBeansProjects/Inheritance2/Lab101-RobinsonCC/src/employeeList.txt", true);
        //
        //                    PrintWriter pw = new PrintWriter(fos);
        //
        //                    pw.print(writeType + "\t" + writeID + "\t" + writeName + "\t" + writeTitlePosition + "\t" + writeHourlyRate + "\n");
        //
        //                    pw.close();
        //                } catch (FileNotFoundException e) {
        //                    System.out.println("Couldn’t find file.");
        //                }
        //salary
        System.out.println("Please make an salaried employee.");
        writeType = "S";
        //ID
        System.out.println("Enter employee ID: ");
        //checks if correct value
        while (!scan.hasNextInt()) {
            System.out.println("Invalid entry.\nEnter employee ID: ");
            scan.next();
        }
        //checks if value already taken
        if (scan.hasNextInt()) {
            int id = scan.nextInt();
            boolean exists = true;
            while (exists == true) {
                try {
                    for (int x = 0; x < employeeList.length;) {

                        if (employeeList[x].getId() == id) {
                            exists = true;

                            System.out.println("ID already exists.\nEnter employee ID: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Invalid entry.\nEnter employee ID: ");
                                scan.next();
                            }
                            x = 0;
                            id = scan.nextInt();
                        } else {
                            exists = false;

                            if (employeeList[x] == null && exists == false) {
                                break;
                            }
                            x++;
                        }
                        writeID = id;
                    }
                } catch (NullPointerException npe) {
                } finally {
                    break;
                }

            }

        }
        //name
        System.out.println("Enter employee name: ");
        while (scan.hasNextInt() || scan.hasNextDouble() || scan.hasNextBoolean()) {
            System.out.println("You may have entered a number.\nPlease enter employee name: ");
            scan.next();
        }
        writeName = scan.next();
        //title
        System.out.println("Enter employee title: ");
        while (scan.hasNextInt() || scan.hasNextDouble() || scan.hasNextBoolean()) {
            System.out.println("You may have entered a number.\nPlease enter employee title: ");
            scan.next();
        }
        writeTitlePosition = scan.next();
        //yearly salary
        System.out.println("Enter the yearly salary as an int: ");
        while (!scan.hasNextInt()) {
            System.out.println("You may not have entered the yearly salary correctly.\nEnter the yearly salary as an int: ");
            scan.next();
        }
        if (scan.hasNextInt()) {
            writeSalary = scan.nextInt();
        }

        employeeList[index] = new Salaried(writeID, writeName, writeTitlePosition, writeSalary);
        index++;

//                try {
//                    // Append to the end of the file  
//                    FileOutputStream fos;
//                    fos = new FileOutputStream("/Users/chris/NetBeansProjects/Inheritance2/Lab101-RobinsonCC/src/employeeList.txt", true);
//
//                    PrintWriter pw = new PrintWriter(fos);
//
//                    pw.print(writeType + "\t" + writeID + "\t" + writeName + "\t" + writeTitlePosition + "\t" + writeSalary + "\n");
//
//                    pw.close();
//                } catch (FileNotFoundException e) {
//                    System.out.println("Couldn’t find file.");
//                }
        //print out updated list
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        //give 10% raise
        for (Employee employee : employeeList) {
            if (employee != null) {
                if (employee instanceof Hourly) {
                    Hourly h = (Hourly) employee;
                    h.setHourlyRate(h.getHourlyRate() * 1.1);
                } else if (employee instanceof Salaried) {
                    Salaried s = (Salaried) employee;
                    s.setSalary((int) (s.getSalary() * 1.1));
                }
            }
        }

        for (Employee employee : employeeList) {
            if(employee != null){
                System.out.println(employee);
            }
            
        }
        
        //test equals methods
        Hourly h1 = new Hourly(1, "Chris", "CEO", 10.00);
        Hourly h2 = new Hourly(1, "Chris", "CEO", 10.00);
        Hourly h3 = new Hourly(2, "Chriss", "CEOO", 100.00);
        
        Salaried s1 = new Salaried(2, "Kayla", "ABC", 100000);
        Salaried s2 = new Salaried(2, "Kayla", "ABC", 100000);
        Salaried s3 = new Salaried(3, "Kaylaa", "ABCD", 1000000);
        
        System.out.println(h1.equals(h2)); //true
        System.out.println(h2.equals(h3)); //false
        System.out.println(s1.equals(s2)); //true
        System.out.println(s2.equals(s3)); //false

//    public static void main(String[] args) {
//        
//        // create an instance Salaried
//        Salaried salaried1 = new Salaried( 86, "Maxwell", "Agent", 60000 );
//        
//        // display the contents fo the Salaried instance
//        System.out.println( "salaried1 = " + salaried1.toString() );
//        
//        // cast the Salaried instance to Employee to demonstrate polymorphism
//        Employee employee1 = ( Employee ) salaried1;
//                       
//        // try to print out the salary from the Employee reference
//        // uncomment line below to see compiler error
//        //System.out.println("employee1 salary - " + employee1.getSalary );
//        
//        // print out the Employee reference to demonstrate dynamic dispatch
//        System.out.println( "employee1 = " + salaried1.toString() );
//        
//    }
    }
}
