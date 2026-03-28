import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDao = new StudentDAO();
        JobDAO jobDao = new JobDAO();

        while (true) {
            System.out.println("\n--- PLACEMENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Job Role");
            System.out.println("3. Show Recommended Jobs (Matching Logic)");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Skills (Java, SQL, etc): "); String sSkills = sc.nextLine();
                    System.out.print("Branch: "); String branch = sc.nextLine();
                    System.out.print("Experience: "); int exp = sc.nextInt();
                    studentDao.addStudent(new Student(name, sSkills, branch, exp));
                    break;

                case 2:
                    System.out.print("Job Title: "); String title = sc.nextLine();
                    System.out.print("Required Skills: "); String rSkills = sc.nextLine();
                    System.out.print("Company: "); String company = sc.nextLine();
                    jobDao.addJob(new Job(title, rSkills, company));
                    break;

                case 3:
                    showRecommendations();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }

    private static void showRecommendations() {
    ApplicationDAO appDao = new ApplicationDAO(); 

    try (Connection conn = DBConnection.getConnection()) {
        // We need to get the IDs to link the tables
        Statement st = conn.createStatement();
        ResultSet rsStudents = st.executeQuery("SELECT id, name, skills FROM Students");

        while (rsStudents.next()) {
            int sId = rsStudents.getInt("id");
            String studentName = rsStudents.getString("name");
            String studentSkills = rsStudents.getString("skills");
            
            Statement st2 = conn.createStatement();
            ResultSet rsJobs = st2.executeQuery("SELECT id, job_title, skills_required, company FROM Jobs");
            
            while (rsJobs.next()) {
    int jId = rsJobs.getInt("id");
    String currentJobTitle = rsJobs.getString("job_title"); // Make sure this line exists
    String jobSkills = rsJobs.getString("skills_required");
    
    int score = PlacementService.calculateMatch(studentSkills, jobSkills);
    
    // Use 'currentJobTitle' here
    System.out.println("DEBUG: Comparing " + studentName + " with " + currentJobTitle + ". Score: " + score);
    
    if (score >= 0) {
        appDao.saveApplication(sId, jId, score);
    }
}
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}