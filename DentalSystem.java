import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a patient
class Patient {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Patient(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("| %-10d | %-20s | %-15s | %-25s |", id, name, phone, email);
    }
}

// Class to represent an appointment
class Appointment {
    private int appointmentId;
    private int patientId;
    private String date;
    private String time;
    private String reason;

    public Appointment(int appointmentId, int patientId, String date, String time, String reason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return String.format("| %-15d | %-10d | %-12s | %-8s | %-30s |", appointmentId, patientId, date, time, reason);
    }
}

// Class to handle the billing
class Billing {
    private int patientId;
    private double amount;

    public Billing(int patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("| %-10d | $%-10.2f |", patientId, amount);
    }
}

// Main system class
public class DentalSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<Billing> bills = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Dental Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Generate Bill");
            System.out.println("6. View Bills");
            System.out.println("7. View All Data");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    generateBill();
                    break;
                case 6:
                    viewBills();
                    break;
                case 7:
                    viewAllData();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        patients.add(new Patient(id, name, phone, email));
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        System.out.println("\n--- List of Patients ---");
        System.out.println("| Patient ID | Name                | Phone          | Email                      |");
        System.out.println("|------------|---------------------|----------------|----------------------------|");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = scanner.nextInt();

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Appointment Time (HH:MM): ");
        String time = scanner.nextLine();

        System.out.print("Enter Reason for Appointment: ");
        String reason = scanner.nextLine();

        appointments.add(new Appointment(appointmentId, patientId, date, time, reason));
        System.out.println("Appointment scheduled successfully!");
    }

    private static void viewAppointments() {
        System.out.println("\n--- List of Appointments ---");
        System.out.println("| Appointment ID | Patient ID | Date        | Time     | Reason                        |");
        System.out.println("|----------------|------------|-------------|----------|-------------------------------|");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        System.out.print("Enter Billing Amount: ");
        double amount = scanner.nextDouble();

        bills.add(new Billing(patientId, amount));
        System.out.println("Bill generated successfully!");
    }

    private static void viewBills() {
        System.out.println("\n--- List of Bills ---");
        System.out.println("| Patient ID | Billing Amount |");
        System.out.println("|------------|----------------|");
        for (Billing bill : bills) {
            System.out.println(bill);
        }
    }

    private static void viewAllData() {
        System.out.println("\n--- All Data ---");

        System.out.println("\n--- Patients ---");
        System.out.println("| Patient ID | Name                | Phone          | Email                      |");
        System.out.println("|------------|---------------------|----------------|----------------------------|");
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println("\n--- Appointments ---");
        System.out.println("| Appointment ID | Patient ID | Date        | Time     | Reason                        |");
        System.out.println("|----------------|------------|-------------|----------|-------------------------------|");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }

        System.out.println("\n--- Bills ---");
        System.out.println("| Patient ID | Billing Amount |");
        System.out.println("|------------|----------------|");
        for (Billing bill : bills) {
            System.out.println(bill);
        }
    }
}
