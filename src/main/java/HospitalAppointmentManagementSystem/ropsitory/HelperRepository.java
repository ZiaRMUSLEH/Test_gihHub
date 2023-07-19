package HospitalAppointmentManagementSystem.ropsitory;

public interface HelperRepository {
    public boolean helperRoleIdentification ();
    public void hospitalsAndDoctorsPrinter();
    public void patientsPrinterWithoutHis();


    public void deleteRow(String tableName, String columnName, Object value);
    public void updateRow(String tableName, String updatableColumnName, Object newValue, Object previousValue);
}
