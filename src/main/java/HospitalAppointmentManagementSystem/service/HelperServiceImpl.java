package HospitalAppointmentManagementSystem.service;

import HospitalAppointmentManagementSystem.ropsitory.HelperRepositoryImpl;

import java.util.Scanner;

public class HelperServiceImpl implements HelperService {
    public static Scanner scanner;

    HelperRepositoryImpl helperRepository= new HelperRepositoryImpl();

    @Override
    public void helperRoleOperations () {
        scanner = new Scanner(System.in);
        int counter = 0;
        while (counter < 4) {
            boolean result = helperRepository.helperRoleIdentification();
            if (result) {
                System.out.println("Which documents you want to check: \n1 -> Hospitals \n2 ->Patients");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        helperRepository.hospitalsAndDoctorsPrinter();
                        boolean exit = false;
                        while (!exit) {
                            System.out.println("1 -> Update data\n2 -> Delete data\n3 ->Exit");
                            int choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("Enter Table name");
                                    scanner.nextLine();
                                    String tableName = scanner.nextLine();
                                    System.out.println("Enter updatable Column name");
                                    String updatableColumnName = scanner.nextLine();
                                    System.out.println("Enter New Value");
                                    String newValue = scanner.nextLine();
                                    System.out.println("Enter previous value");
                                    String previousValue = scanner.nextLine();
                                    helperRepository.updateRow(tableName, updatableColumnName, newValue, previousValue);
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Enter Table name");
                                    String tableName1 = scanner.nextLine();
                                    System.out.println("Enter Column name");
                                    String columnName = scanner.nextLine();
                                    System.out.println("Enter value");
                                    String value = scanner.nextLine();
                                    helperRepository.deleteRow(tableName1, columnName, value);
                                    break;

                                case 3:
                                    exit = true;
                                    break;

                                default:
                                    System.out.println("Invalid Choice!");
                                    break;
                            }
                        } break;



                    case 2:
                        helperRepository.patientsPrinterWithoutHis();
                        boolean exit1 = false;
                        while (!exit1) {
                            System.out.println("1 -> Update data\n2 -> Delete data\n3 ->Exit");
                            int choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("Enter Table name");
                                    scanner.nextLine();
                                    String tableName = scanner.nextLine();
                                    System.out.println("Enter updatable Column name");
                                    String updatableColumnName = scanner.nextLine();
                                    System.out.println("Enter New Value");
                                    String newValue = scanner.nextLine();
                                    System.out.println("Enter previous value");
                                    String previousValue = scanner.nextLine();
                                    helperRepository.updateRow(tableName, updatableColumnName, newValue, previousValue);
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Enter Table name");
                                    String tableName1 = scanner.nextLine();
                                    System.out.println("Enter Column name");
                                    String columnName = scanner.nextLine();
                                    System.out.println("Enter value");
                                    String value = scanner.nextLine();
                                    helperRepository.deleteRow(tableName1, columnName, value);
                                    break;

                                case 3:
                                    exit1 = true;
                                    break;

                                default:
                                    System.out.println("Invalid Choice!");
                                    break;
                            }
                        } break;

                    default:
                        System.out.println("Invalid Choice!");
                        break;
                }

            }else {
                System.out.println("Failed to enter! Please check your name and Security number!");
                counter++;
            }
        }


    }


}
