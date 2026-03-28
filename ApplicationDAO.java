import java.sql.Connection;
import java.sql.PreparedStatement;

public class ApplicationDAO {
    public void saveApplication(int studentId, int jobId, int score) {
        String query = "INSERT INTO Applications (student_id, job_id, match_score) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, jobId);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}