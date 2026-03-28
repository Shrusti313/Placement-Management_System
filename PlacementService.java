import java.util.*;

public class PlacementService {
    public static int calculateMatch(String studentSkills, String jobSkills) {
        // The names here ^ must match the names used below
        if (studentSkills == null || jobSkills == null) return 0;

        Set<String> sSet = new HashSet<>(Arrays.asList(studentSkills.toLowerCase().split(",\\s*")));
        Set<String> jSet = new HashSet<>(Arrays.asList(jobSkills.toLowerCase().split(",\\s*")));

        int matches = 0;
        for (String skill : jSet) {
            if (sSet.contains(skill.trim())) {
                matches++;
            }
        }

        return (jSet.isEmpty()) ? 0 : (matches * 100) / jSet.size();
    }
}