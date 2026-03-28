import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobDAO {
    public void addJob(Job job) {
        String query = "INSERT INTO Jobs (job_title, skills_required, company) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getSkillsRequired());
            pstmt.setString(3, job.getCompany());
            
            pstmt.executeUpdate();
            System.out.println("✅ Job role added successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}