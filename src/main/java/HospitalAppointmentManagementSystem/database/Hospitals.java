package HospitalAppointmentManagementSystem.database;

public class Hospitals {

    private Long hospitalId;

    private String hospitalName;

    private String hospitalCountry;

    public Long getHospitalId () {
        return hospitalId;
    }

    public void setHospitalId (Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName () {
        return hospitalName;
    }

    public void setHospitalName (String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalCountry () {
        return hospitalCountry;
    }

    public void setHospitalCountry (String hospitalCountry) {
        this.hospitalCountry = hospitalCountry;
    }

}
