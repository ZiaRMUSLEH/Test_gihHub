package HospitalAppointmentManagementSystem.ropsitory;

import HospitalAppointmentManagementSystem.jdbcUtils.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

public class HelperRepositoryImpl implements HelperRepository {


    @Override
    public boolean helperRoleIdentification () {
        Scanner scanner= new Scanner(System.in);

            System.out.println("Please enter your Name? ");
            String name = scanner.nextLine();
            System.out.println("Please enter your Security Number?");
            String securityNumber = scanner.nextLine();
            try {Connection connection= JdbcUtils.getConnection();
                String q1 = "SELECT helperName FROM Helper WHERE helperName = ?";
                PreparedStatement preparedStatement= connection.prepareStatement(q1);
                preparedStatement.setString(1,name);
                ResultSet isNameExists = preparedStatement.executeQuery();

                String q2 = "SELECT helperName FROM Helper WHERE securityNumber = ? ";
                preparedStatement= connection.prepareStatement(q2);
                preparedStatement.setString(1,securityNumber);
                ResultSet isSecurityNumberExists = preparedStatement.executeQuery();

                if(isNameExists.next() && isSecurityNumberExists.next()){
                    return true;
                }else {return false;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void hospitalsAndDoctorsPrinter () {
        try {Connection connection = JdbcUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql="SELECT * FROM Hospitals h, Doctors d WHERE h.hospitalId=d.hospitalId ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("hospitalId") + " -- " + resultSet.getString("hospitalName") + " -- "
                        + resultSet.getString("hospitalCountry") + " -- " + resultSet.getString("specialty") +
                        " -- " + resultSet.getString("DoctorName") + " -- " + resultSet.getString("DoctorLastName"));}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void patientsPrinterWithoutHis () {
        try {Connection connection = JdbcUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql="SELECT patientSSN, patientName,patientSurname,patientGender,patientSecurityNum FROM Patients";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("patientSSN")+" -- "+resultSet.getString("patientName")
                        +" -- "+resultSet.getString("patientSurname")+" -- "+resultSet.getString("patientGender")+
                        " -- "+resultSet.getString("patientSecurityNum"));
    }} catch (SQLException e) {
            throw new RuntimeException(e);}}

        @Override
    //delete method
    public void deleteRow (String tableName, String columnName, Object value){
        try {String query = "DELETE FROM "+tableName+" WHERE "+columnName+" = ?";
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, value);
            int numOfDeletedRows = preparedStatement.executeUpdate();
            System.out.println("Row Deleted: "+numOfDeletedRows);
            JdbcUtils.closePrepareStatement(preparedStatement);
        }catch (SQLException e){
            e.printStackTrace();
        }
        }



    //update method
    public void updateRow(String tableName, String updatableColumnName, Object newValue, Object previousValue){
        try {String query = "UPDATE "+tableName+" SET "+updatableColumnName+" = ? WHERE "+updatableColumnName+" = ?";
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, newValue);
            preparedStatement.setObject(2, previousValue);
            int numOfUpdatedRows = preparedStatement.executeUpdate();
            System.out.println("Row Updated: "+numOfUpdatedRows);
            JdbcUtils.closePrepareStatement(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
