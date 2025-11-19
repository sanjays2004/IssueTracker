import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IssueService service = new IssueService();

        // Load old issues
        FileManager.loadFromFile(service.getIssues());

        while (true) {
            System.out.println("\n=== ISSUE TRACKER SYSTEM ===");
            System.out.println("1. Add Issue");
            System.out.println("2. View All Issues");
            System.out.println("3. Update Issue");
            System.out.println("4. Search Issue");
            System.out.println("5. Delete Issue");
            System.out.println("6. Save & Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume extra newline

            switch (ch) {

                case 1:
                    System.out.print("Enter Issue ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Priority (Low/Medium/High): ");
                    String pr = sc.nextLine();

                    System.out.print("Enter Status (Open/In Progress/Resolved): ");
                    String st = sc.nextLine();

                    Issue newIssue = new Issue(id, title, desc, pr, st);
                    service.addIssue(newIssue);
                    break;

                case 2:
                    service.viewAllIssues();
                    break;

                case 3:
                    System.out.print("Enter Issue ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Title: ");
                    String nt = sc.nextLine();

                    System.out.print("New Description: ");
                    String nd = sc.nextLine();

                    System.out.print("New Priority (Low/Medium/High): ");
                    String np = sc.nextLine();

                    System.out.print("New Status (Open/In Progress/Resolved): ");
                    String ns = sc.nextLine();

                    service.updateIssue(uid, nt, nd, np, ns);
                    break;

                case 4:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    service.searchIssues(keyword);
                    break;

                case 5:
                    System.out.print("Enter Issue ID to delete: ");
                    int did = sc.nextInt();
                    service.deleteIssue(did);
                    break;

                case 6:
                    FileManager.saveToFile(service.getIssues());
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
