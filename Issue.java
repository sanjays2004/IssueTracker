public class Issue {
    private int id;
    private String title;
    private String description;
    private String priority;   // Low, Medium, High
    private String status;     // Open, In Progress, Resolved

    public Issue(int id, String title, String description, String priority, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public String getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return id + "," + title + "," + description + "," + priority + "," + status;
    }
}
