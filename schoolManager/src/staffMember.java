public class staffMember {
    private String forename;
    private String surname;
    private String jobTitle;
    private staffMember superior;

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public staffMember getSuperior() {
        return superior;
    }

    public void setSuperior(staffMember superior) {
        this.superior = superior;
    }
}
