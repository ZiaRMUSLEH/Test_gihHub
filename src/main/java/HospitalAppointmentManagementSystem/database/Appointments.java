package HospitalAppointmentManagementSystem.database;

public class Appointments {

    private Long hospitalId;

    private String specialty;

    private String doctorName;

    private String doctorLastName;

    private String patientName;

    private String patientSurname;

    public Long getHospitalId () {
        return hospitalId;
    }

    public void setHospitalId (Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSpecialty () {
        return specialty;
    }

    public void setSpecialty (String specialty) {
        this.specialty = specialty;
    }

    public String getDoctorName () {
        return doctorName;
    }

    public void setDoctorName (String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorLastName () {
        return doctorLastName;
    }

    public void setDoctorLastName (String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getPatientName () {
        return patientName;
    }

    public void setPatientName (String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname () {
        return patientSurname;
    }

    public void setPatientSurname (String patientSurname) {
        this.patientSurname = patientSurname;
    }


}
