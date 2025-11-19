import java.util.ArrayList;
import java.util.List;

public class IssueService {

    private List<Issue> issues = new ArrayList<>();

    // ADD ISSUE
    public void addIssue(Issue issue) {
        issues.add(issue);
        System.out.println("Issue added successfully!");
    }

    // VIEW ALL ISSUES
    public void viewAllIssues() {
        if (issues.isEmpty()) {
            System.out.println("No issues found.");
            return;
        }

        for (Issue issue : issues) {
            System.out.println(issue.getId() + " | " +
                    issue.getTitle() + " | " +
                    issue.getPriority() + " | " +
                    issue.getStatus());
        }
    }

    // UPDATE ISSUE
    public void updateIssue(int id, String newTitle, String newDesc, String newPriority, String newStatus) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setTitle(newTitle);
                issue.setDescription(newDesc);
                issue.setPriority(newPriority);
                issue.setStatus(newStatus);
                System.out.println("Issue updated successfully!");
                return;
            }
        }
        System.out.println("Issue not found!");
    }

    // DELETE ISSUE
    public void deleteIssue(int id) {
        issues.removeIf(issue -> issue.getId() == id);
        System.out.println("Issue removed (if existed).");
    }

    // SEARCH ISSUE (NEW FEATURE)
    public void searchIssues(String keyword) {
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (Issue issue : issues) {
            if (issue.getTitle().toLowerCase().contains(keyword) ||
                issue.getDescription().toLowerCase().contains(keyword)) {

                System.out.println(issue.getId() + " | " +
                        issue.getTitle() + " | " +
                        issue.getPriority() + " | " +
                        issue.getStatus());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No issues matched your search.");
        }
    }

    // RETURN ISSUE LIST
    public List<Issue> getIssues() {
        return issues;
    }
}
