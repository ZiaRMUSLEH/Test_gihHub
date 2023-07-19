package HospitalAppointmentManagementSystem.service;

import HospitalAppointmentManagementSystem.ropsitory.DoctorRepository;
import HospitalAppointmentManagementSystem.ropsitory.DoctorRepositoryImpl;

import java.util.Scanner;

public class DoctorServiceImpl implements DoctorService {


    DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public void doctorRoleOperations () {
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            int counter = 0;
            while (counter < 4) {
                System.out.println("Please enter your SSN? ");
                String ssn = scanner.nextLine();
                System.out.println("Please enter your Password?");
                String password = scanner.nextLine();
                boolean isdoctorExist = doctorRepository.doctorRoleIdentification(ssn, password);
                if (isdoctorExist) {
                    String doctorName = doctorRepository.doctorName(ssn);
                    System.out.println("Welcome " + doctorName);
                    doctorRepository.todaysListPrinter(doctorName);
                    boolean exit1 = false;
                    while (!exit1) {
                        System.out.println("1 -> Update\n2 -> Exit");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Write your patient SSN");
                                String patientssn = scanner.next();
                                System.out.println("Write your patient New History");
                                String newHistory = scanner.next();
                                int numOfUpdatedRows = doctorRepository.updatePatientHis(patientssn, newHistory);
                                System.out.println("Row Updated: " + numOfUpdatedRows);
                                break;
                            case 2:
                                System.out.println("Have a healthy day Doctor!");
                                exit1 = true;
                                counter = 4;
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }

                } else {
                    System.out.println("Failed to enter! Please check your SSN and Password! ");
                    counter++;
                }

            } exit = true;

        }
    }


}