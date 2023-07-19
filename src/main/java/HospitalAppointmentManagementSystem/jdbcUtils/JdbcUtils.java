package HospitalAppointmentManagementSystem.jdbcUtils;

import java.sql.*;

public class JdbcUtils {


    private static final Connection connection;
    static {
        try {Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HospitalAppointmentManagementSystem",
                    "dev_user", "password");
        }catch (Throwable ex){
            System.err.println("Initial Connection creation is failed ...."+ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void shutDown() throws SQLException {getConnection().close();}
    public static void closePrepareStatement(PreparedStatement preparedStatement) throws SQLException {
        if(preparedStatement!=null && !preparedStatement.isClosed()){
                preparedStatement.close();
        }
    }
    public static void closeStatement(Statement statement) throws SQLException {
        if (statement!=null && !statement.isClosed()){
            statement.close();
        }
    }

}
