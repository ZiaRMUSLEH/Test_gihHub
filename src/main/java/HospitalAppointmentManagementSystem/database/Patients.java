package HospitalAppointmentManagementSystem.database;

public class Patients {

    private String patientSSN;

    private String patientName;

    private String patientSurname;

    private String patientGender;

    private String patientSecurityNum;

    private String patientHistory;

    public String getPatientSSN () {
        return patientSSN;
    }

    public void setPatientSSN (String patientSSN) {
        this.patientSSN = patientSSN;
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

    public String getPatientGender () {
        return patientGender;
    }

    public void setPatientGender (String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientSecurityNum () {
        return patientSecurityNum;
    }

    public void setPatientSecurityNum (String patientSecurityNum) {
        this.patientSecurityNum = patientSecurityNum;
    }

    public String getPatientHistory () {
        return patientHistory;
    }

    public void setPatientHistory (String patientHistory) {
        this.patientHistory = patientHistory;
    }


}
