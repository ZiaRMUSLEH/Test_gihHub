package HospitalAppointmentManagementSystem.service;

import HospitalAppointmentManagementSystem.ropsitory.PatientRepository;
import HospitalAppointmentManagementSystem.ropsitory.PatientRepositoryImpl;

import java.util.Scanner;

public class PatientServiceImpl implements PatientService{

    PatientRepository patientRepository = new PatientRepositoryImpl();


    @Override
    public void patientRoleOperations () {
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            int counter = 0;
            while (counter < 4) {
                System.out.println("Please enter your SSN? ");
                String ssn = scanner.nextLine();
                System.out.println("Please enter your Name?");
                String patientName = scanner.nextLine();
                boolean isPatientExist = patientRepository.patientRoleIdentification(ssn,patientName);
                if (isPatientExist) {
                    System.out.println("Welcome " + patientName);
                    boolean exit1 = false;
                    while (!exit1) {
                        System.out.println("What do you want to do?");
                        System.out.println("1 -> New appointment");
                        System.out.println("2 -> Update/Check appointment");
                        System.out.println("3 -> Delete appointment");
                        System.out.println("4 -> Exit");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                if(patientRepository.isAppointmentExists(patientName)){
                                    System.out.println("You have already an appointment");}
                                    else {
                                        System.out.println("Could not find any info. You do not have any appointment");
                                    System.out.println("please enter information for new appointment");
                                    System.out.println("Enter hospital Id");
                                        Long hospitalId = scanner.nextLong();
                                    System.out.println("Enter specialty");
                                        String specialty = scanner.next();
                                    System.out.println("Enter doctor Name");
                                        String doctorName = scanner.next();
                                    System.out.println("Enter doctor Last Name");
                                        String doctorLastName = scanner.next();
                                    System.out.println("Enter patient Surname");
                                        String patientSurname = scanner.next();
                                        int numOfAppAdded = patientRepository.addAppointment(hospitalId,specialty,doctorName,doctorLastName,patientName,patientSurname);
                                    if (numOfAppAdded>0){
                                        System.out.println("Your appointment added successfully");
                                    }else {System.out.println("An error occurred!");}
                                    }break;
                            case 2:
                                System.out.println("1 -> Check appointment\n2 -> Update appointment");
                                int choice2 = scanner.nextInt();
                                if (choice2==1){
                                    patientRepository.appointmentPrinter(patientName);
                                }else if (choice2==2){
                                    System.out.println("1 -> Update appointment Hospital\n2 -> Update appointment specialty");
                                    int choice3 = scanner.nextInt();
                                    if(choice3==1){
                                        System.out.println("Please enter new hospital Id?");
                                        Long newHospitalId = scanner.nextLong();
                                        int updateHospital = patientRepository.updateHospital(patientName,newHospitalId);
                                        if (updateHospital>0){
                                            System.out.println("Your appointment's hospital was updated successfully");
                                        }else {System.out.println("An error occurred!");}
                                    }else if(choice3==2) {
                                        System.out.println("Please enter new specialty?");
                                        String newSpecialty = scanner.next();
                                        int updateSpecialty = patientRepository.updateSpecialty(patientName,newSpecialty);
                                        if (updateSpecialty>0){
                                            System.out.println("Your appointment's specialty was updated successfully");
                                        }else {System.out.println("An error occurred!");
                                    }
                                }else {
                                    System.out.println("Invalid Choice");

                                }}else {System.out.println("Invalid Choice");}
                                break;

                            case 3:
                                System.out.println("Are you sure Y/N?");
                                String answer1 = scanner.next();
                                if(answer1.equalsIgnoreCase("y")){
                                    int deleteAppointment = patientRepository.deleteAppointment(patientName);
                                    if (deleteAppointment>0){
                                        System.out.println("Your appointment was deleted successfully");
                                    }else {System.out.println("An error occurred!");}
                                }else {
                                    System.out.println("Delete operation cancelled");
                                } break;

                            case 4: exit1=true;
                            counter=4;

                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }

                } else {
                    System.out.println("Failed to enter! Please check your SSN or Name! ");
                    counter++;
                }

            } exit = true;

        }
    }


    }
