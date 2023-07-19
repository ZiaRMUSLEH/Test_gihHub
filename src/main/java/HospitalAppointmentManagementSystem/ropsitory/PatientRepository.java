package HospitalAppointmentManagementSystem.ropsitory;

public interface PatientRepository {

    boolean patientRoleIdentification (String ssn, String patientName);

    boolean isAppointmentExists(String patentName);

    int addAppointment(Long hospitalId,String specialty,String doctorName,String doctorLastName,String patientName,String patientSurname);

    void appointmentPrinter(String patientName);

    int deleteAppointment(String patientName);

    int updateSpecialty(String patientName, String newSpecialty);

    int updateHospital(String patientName, Long newHospitalId);
}
