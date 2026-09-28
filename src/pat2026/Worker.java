package pat2026;

public class Worker {

    String workerCode, name, surname, gender, dob, age, dateStarted,
            serviceYears, role, type, group, wage, status;

    public Worker(String workerCode, String name, String surname, String gender,
            String dob, String age, String dateStarted, String serviceYears,
            String role, String type, String group, String wage, String status) {
        this.workerCode = workerCode;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.dateStarted = dateStarted;
        this.serviceYears = serviceYears;
        this.role = role;
        this.type = type;
        this.group = group;
        this.wage = wage;
        this.status = status;
    }

    public String getWorkerCode() {
        return workerCode; 
    }
    
    public String getName() {
        return name; 
    }
    
    public String getSurname() {
        return surname; 
    }
    
    public String getGender() {
        return gender; 
    }
    
    public String getDob() {
        return dob; 
    }
    
    public String getAge() {
        return age; 
    }
    
    public String getDateStarted() {
        return dateStarted; 
    }
    
    public String getServiceYears() {
        return serviceYears; 
    }
    
    public String getRole() {
        return role; 
    }
    
    public String getType() {
        return type; 
    }
    
    public String getGroup() {
        return group; 
    }
    
    public String getWage() {
        return wage; 
    }
    
    public String getStatus() {
        return status; 
    }
}