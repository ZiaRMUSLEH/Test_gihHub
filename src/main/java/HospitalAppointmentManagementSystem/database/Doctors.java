package HospitalAppointmentManagementSystem.database;

public class Doctors {
    private Long hospitalId;

    private String speciality;

    private String doctorName;

    private String doctorLastName;

    private String doctorSSN;

    private String doctorPassword;


    public Long getHospitalId () {
        return hospitalId;
    }

    public void setHospitalId (Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSpeciality () {
        return speciality;
    }

    public void setSpeciality (String speciality) {
        this.speciality = speciality;
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

    public String getDoctorSSN () {
        return doctorSSN;
    }

    public void setDoctorSSN (String doctorSSN) {
        this.doctorSSN = doctorSSN;
    }

    public String getDoctorPassword () {
        return doctorPassword;
    }

    public void setDoctorPassword (String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }


}
