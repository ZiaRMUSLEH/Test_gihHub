package HospitalAppointmentManagementSystem.ropsitory;

import HospitalAppointmentManagementSystem.jdbcUtils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRepositoryImpl implements PatientRepository {

    public boolean patientRoleIdentification (String ssn, String patientName) {
        try{
            Connection connection = JdbcUtils.getConnection();
            String q1 = "SELECT patientSSN FROM Patients WHERE patientSSN = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(q1);
            preparedStatement.setString(1, ssn);
            ResultSet isSSNExists = preparedStatement.executeQuery();

            String q2 = "SELECT patientName FROM Patients WHERE patientName = ? ";
            preparedStatement = connection.prepareStatement(q2);
            preparedStatement.setString(1, patientName);
            ResultSet isNameExists = preparedStatement.executeQuery();

            if (isSSNExists.next() && isNameExists.next()) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();}
        return false;
    }

    public boolean isAppointmentExists(String patentName){
        try {
            Connection connection = JdbcUtils.getConnection();
            String q2 = "SELECT patientName FROM Appointments WHERE patientName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(q2);
            preparedStatement.setString(1, patentName);
            ResultSet isNameExists = preparedStatement.executeQuery();
            if(isNameExists.next()){
                return true;

            }else {
                return false;}
            } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public void appointmentPrinter(String patientName){
        try {
            Connection connection = JdbcUtils.getConnection();
            String q2 = "SELECT hospitalid,specialty, doctorname,doctorlastname FROM Appointments WHERE patientName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(q2);
            preparedStatement.setString(1, patientName);
            ResultSet isNameExists = preparedStatement.executeQuery();
            while (isNameExists.next()) {
                System.out.println(isNameExists.getInt("hospitalid") + "----" + isNameExists.getString("specialty")
                        + "----" + isNameExists.getString("doctorname") + "----" + isNameExists.getString("doctorlastname"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int addAppointment(Long hospitalId,String specialty,String doctorName,String doctorLastName,String patientName,String patientSurname){
        try{Connection connection = JdbcUtils.getConnection();
            String query = "INSERT INTO Appointments VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, hospitalId);
            preparedStatement.setString(2, specialty);
            preparedStatement.setString(3, doctorName);
            preparedStatement.setString(4, doctorLastName);
            preparedStatement.setString(5, patientName);
            preparedStatement.setString(6, patientSurname);
            int numOfInsertedRows = preparedStatement.executeUpdate();
            JdbcUtils.closePrepareStatement(preparedStatement);
            return numOfInsertedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteAppointment(String patientName){
        try{Connection connection = JdbcUtils.getConnection();
            String query = "DELETE FROM Appointments  WHERE patientname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setObject(1, patientName);
                int numOfDeletedRows = preparedStatement.executeUpdate();
                JdbcUtils.closePrepareStatement(preparedStatement);
                return numOfDeletedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


 public int updateSpecialty(String patientName, String newSpecialty){
     try{Connection connection = JdbcUtils.getConnection();
         String query = "UPDATE Appointments SET specialty = ? WHERE patientName = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setObject(1, newSpecialty);
         preparedStatement.setObject(2, patientName);
         int numOfUpdatedRows = preparedStatement.executeUpdate();
         JdbcUtils.closePrepareStatement(preparedStatement);
             return numOfUpdatedRows;
     }catch (SQLException e){
         e.printStackTrace();
     }
     return 0;
 }


    public int updateHospital(String patientName, Long newHospitalId){
        try{Connection connection = JdbcUtils.getConnection();
            String query = "UPDATE Appointments SET hospitalId = ? WHERE patientName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, newHospitalId);
            preparedStatement.setObject(2, patientName);
            int numOfUpdatedRows = preparedStatement.executeUpdate();
            JdbcUtils.closePrepareStatement(preparedStatement);
            return numOfUpdatedRows;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }




}
