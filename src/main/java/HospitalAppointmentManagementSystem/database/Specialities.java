package HospitalAppointmentManagementSystem.database;

public class Specialities {

    private Long hospitalId;

    private String speciality;

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

}
