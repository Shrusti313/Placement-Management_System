public class Student {
    private String name;
    private String skills;
    private String branch;
    private int experience;

    public Student(String name, String skills, String branch, int experience) {
        this.name = name;
        this.skills = skills;
        this.branch = branch;
        this.experience = experience;
    }

    // Getters
    public String getName() { return name; }
    public String getSkills() { return skills; }
    public String getBranch() { return branch; }
    public int getExperience() { return experience; }
}