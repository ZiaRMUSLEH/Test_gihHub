package HospitalAppointmentManagementSystem.ropsitory;

import HospitalAppointmentManagementSystem.jdbcUtils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorRepositoryImpl implements DoctorRepository {
    @Override
    public boolean doctorRoleIdentification (String ssn, String password) {
       try{Connection connection = JdbcUtils.getConnection();
            String q1 = "SELECT doctorSSN FROM Doctors WHERE doctorSSN = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(q1);
            preparedStatement.setString(1, ssn);
            ResultSet isNameExists = preparedStatement.executeQuery();

            String q2 = "SELECT doctorPassword FROM Doctors WHERE doctorPassword = ? ";
            preparedStatement = connection.prepareStatement(q2);
            preparedStatement.setString(1, password);
            ResultSet isSecurityNumberExists = preparedStatement.executeQuery();

            if (isNameExists.next() && isSecurityNumberExists.next()) {
                return true;
            }
       }catch (SQLException e){
        e.printStackTrace();}
       return false;
    }


    @Override
    public String doctorName (String ssn) {
        try {Connection connection = JdbcUtils.getConnection();
            String q3 = "SELECT doctorName FROM Doctors WHERE doctorSSN = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(q3);
            preparedStatement.setString(1, ssn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String doctorName = resultSet.getString("doctorName");
                return doctorName;}
        } catch (SQLException e) {
            e.printStackTrace();

        }
    return null;
    }


    @Override
        public void todaysListPrinter(String doctorName){
            try{Connection connection = JdbcUtils.getConnection();
           String q = "SELECT hospitalid, specialty, patientname,patientsurname FROM Appointments WHERE doctorname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(q);
           preparedStatement.setString(1, doctorName);
           ResultSet resultSet1 = preparedStatement.executeQuery();
           while (resultSet1.next()) {
               System.out.println("Today's list: " + resultSet1.getInt("hospitalid") + "----" + resultSet1.getString("specialty")
                       + "----" + resultSet1.getString("patientname") + "----" + resultSet1.getString("patientsurname"));
                    }
                }catch (SQLException e){
                e.printStackTrace();
            }
        }


    @Override
    public int updatePatientHis (String patientssn, String newHistory)  {
        try{
            String q = "SELECT * FROM Patients WHERE patientssn = ?";
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(q);
                preparedStatement.setString(1, patientssn);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                if(resultSet1.next()) {
                    String query = "UPDATE Patients SET patienthistory = ? WHERE patientssn = ?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setObject(1, newHistory);
                    preparedStatement.setObject(2, patientssn);
                    int numOfUpdatedRows = preparedStatement.executeUpdate();
                    JdbcUtils.closePrepareStatement(preparedStatement);
                    return numOfUpdatedRows;
                } else {
                    System.out.println("we could not find the patient. Please check SSN again");
                }

    }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
}

}
