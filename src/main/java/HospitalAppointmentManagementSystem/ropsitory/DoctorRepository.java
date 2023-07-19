package HospitalAppointmentManagementSystem.ropsitory;

import java.sql.SQLException;

public interface DoctorRepository {
   boolean doctorRoleIdentification (String ssn, String password);

   int updatePatientHis (String patientssn, String newHistory);

   String doctorName (String ssn);

   void todaysListPrinter(String doctorName);



}
