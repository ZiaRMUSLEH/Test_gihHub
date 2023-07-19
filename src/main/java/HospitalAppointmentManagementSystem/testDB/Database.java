package HospitalAppointmentManagementSystem.testDB;

import HospitalAppointmentManagementSystem.jdbcUtils.JdbcUtils;
import HospitalAppointmentManagementSystem.ropsitory.DoctorRepositoryImpl;
import HospitalAppointmentManagementSystem.ropsitory.PatientRepository;
import HospitalAppointmentManagementSystem.ropsitory.PatientRepositoryImpl;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    public static void main (String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HospitalAppointmentManagementSystem", "dev_user", "password");
        Statement statement = con.createStatement();
        PreparedStatement prs;

//------------------------------------Hospitals-------------------------------------------
//        //1. create hospital table
//        boolean sql1 = statement.execute("CREATE TABLE Hospitals (hospitalId INT PRIMARY KEY , hospitalName VARCHAR(50), hospitalCountry VARCHAR(50))")
//                ;System.out.println(sql1);
//        //2. insert data to hospital table
//        String sql2 = "INSERT INTO Hospitals VALUES ( ?, ? , ?)";
//        prs = con.prepareStatement(sql2);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//        prs.setInt(1, 100+i);
//        prs.setString(2, "hospital_"+i);
//        prs.setString(3, "country_"+i);
//             insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);

        //------------------------------------Appointments-------------------------------------------


//        //1. create Appointments table
//        boolean sql = statement.execute("CREATE TABLE Appointments (hospitalId INT PRIMARY KEY, specialty VARCHAR(50), doctorName VARCHAR(50), doctorLastName VARCHAR(50), patientName VARCHAR(50), patientSurname VARCHAR(50))");
//        System.out.println(sql);
//
//        //2. insert data to Appointments table
//        String sql1 = "INSERT INTO Appointments VALUES (?,?,?,?,?,?)";
//        prs = con.prepareStatement(sql1);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//            prs.setInt(1, 100+i);
//            prs.setString(2, "specialty_"+i);
//            prs.setString(3, "doctorName_"+i);
//            prs.setString(4, "doctorLastName_"+i);
//            prs.setString(5, "patientName_"+i);
//            prs.setString(6, "patientSurName_"+i);
//            insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);


        //------------------------------------Doctors-------------------------------------------


//        //1. create Doctors table
//        boolean sql = statement.execute("CREATE TABLE Doctors (hospitalId INT, specialty VARCHAR(50)," +
//                " doctorName VARCHAR(50), doctorLastName VARCHAR(50), doctorSSN VARCHAR(50), doctorPassword VARCHAR(50))");
//        System.out.println(sql);
//
//        //2. insert data to Doctors table
//        String sql1 = "INSERT INTO Doctors VALUES (?,?,?,?,?,?)";
//        prs = con.prepareStatement(sql1);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//            prs.setInt(1, 100+i);
//            prs.setString(2, "specialty_"+i);
//            prs.setString(3, "doctorName_"+i);
//            prs.setString(4, "doctorLastName_"+i);
//            prs.setString(5, "doctorSNN_"+i);
//            prs.setString(6, "doctorPassword_"+i);
//            insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);


        //------------------------------------Helper-------------------------------------------


//        //1. create Helper table
//        boolean sql = statement.execute("CREATE TABLE Helper (helperName VARCHAR(50), securityNumber VARCHAR(50))");
//        System.out.println(sql);
//
//        //2. insert data to Helper table
//        String sql1 = "INSERT INTO Helper VALUES (?,?)";
//        prs = con.prepareStatement(sql1);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//            prs.setString(1, "helperName_"+i);
//            prs.setString(2, "helperSecurityNum_"+i);
//            insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);


        //------------------------------------Patients-------------------------------------------

//
//        //1. create Patients table
//        boolean sql = statement.execute("CREATE TABLE Patients (patientSSN VARCHAR(50), patientName VARCHAR(50)," +
//                " patientSurname VARCHAR(50), patientGender VARCHAR(50), patientSecurityNum VARCHAR(50), patientHistory VARCHAR(50))");
//        System.out.println(sql);
//
//        //2. insert data to Patients table
//        String sql1 = "INSERT INTO Patients VALUES (?,?,?,?,?,?)";
//        prs = con.prepareStatement(sql1);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//            prs.setString(1, "patientSSN_"+i);
//            prs.setString(2, "patientName_"+i);
//            prs.setString(3, "patientSurname_"+i);
//            prs.setString(4, "patientGender_"+i);
//            prs.setString(5, "patientSecurityNum_"+i);
//            prs.setString(6, "patientHistory_"+i);
//            insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);


        //------------------------------------Specialities-------------------------------------------
//
//
//        //1. create Specialities table
//        boolean sql = statement.execute("CREATE TABLE Specialities (hospitalId INT, specialty VARCHAR(50))");
//        System.out.println(sql);
//
//        //2. insert data to Specialities table
//        String sql1 = "INSERT INTO Specialities VALUES (?,?)";
//        prs = con.prepareStatement(sql1);
//        int insertedRows = 0;
//        for(int i = 1; i<21;i++ ){
//            prs.setInt(1, 100+i);
//            prs.setString(2, "specialty_"+i);
//            insertedRows = insertedRows+ prs.executeUpdate();}
//        System.out.println("insertedRows = " + insertedRows);





        //Scanner scanner;

        //scanner= new Scanner(System.in);





        //preparedStatement.close();
        //prs.close();
       statement.close();
      con.close();


    }}



