package HospitalAppointmentManagementSystem.main;

import HospitalAppointmentManagementSystem.service.*;

import java.util.Scanner;

public class HospitalAppointmentManagementSystemClass {

    private static Scanner scanner;




    public static void displayMenuHospitalAppointmentManagementSystem(){

        HelperService helperService = new HelperServiceImpl();
        DoctorService doctorService = new DoctorServiceImpl();
        PatientService patientService = new PatientServiceImpl();
        scanner= new Scanner(System.in);

        boolean exit= false;
        while (!exit){

            System.out.println("Welcome TO Hospital Appointment Management System Menu ");
            System.out.println("please chose a valid role\n1 -> Helper\n2 -> Doctor \n3 -> Patient\n4 -> Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("----- Helper Role -----");
                    helperService.helperRoleOperations();
                    break;
                case 2:
                    System.out.println("----- Doctor Role -----");
                    doctorService.doctorRoleOperations();
                    break;
                case 3:
                    System.out.println("----- Patient Role -----");
                    patientService.patientRoleOperations();
                    break;
                case 4:
                    exit=true;
                    System.out.println("Have a nice day !!!");
                    break;
                default:
                    System.out.println("please chose a valid role");
                    break;

            }

        }

    }




}
