public class staffMember {
    private String forename;
    private String surname;
    private String jobTitle;
    private staffMember superior;

    //Constructor for staff member class
    public staffMember(String fname, String sname, String job, staffMember boss) {
        this.forename = fname;
        this.surname = sname;
        this.jobTitle = job;
        this.superior = boss;
    }

    //Returns forename of staff member
    public String getForename() {
        return forename;
    }

    //Sets forename of staff member
    public void setForename(String forename) {
        this.forename = forename;
    }

    //Returns surname of staff member
    public String getSurname() {
        return surname;
    }

    //Sets surname of staff member
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Returns job of staff member
    public String getJobTitle() {
        return jobTitle;
    }

    //Sets job of staff member
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
