import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, skills, branch, experience) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSkills());
            pstmt.setString(3, student.getBranch());
            pstmt.setInt(4, student.getExperience());
            
            pstmt.executeUpdate();
            System.out.println("✅ Student added to database successfully!");
            
        } catch (SQLException e) {
            System.out.println("❌ Error adding student.");
            e.printStackTrace();
        }
    }
}