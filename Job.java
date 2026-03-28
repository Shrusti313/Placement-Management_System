public class Job {
    private String title;
    private String skillsRequired;
    private String company;

    public Job(String title, String skillsRequired, String company) {
        this.title = title;
        this.skillsRequired = skillsRequired;
        this.company = company;
    }

    // Getters
    public String getTitle() { return title; }
    public String getSkillsRequired() { return skillsRequired; }
    public String getCompany() { return company; }
}