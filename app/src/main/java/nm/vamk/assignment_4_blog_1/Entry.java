package nm.vamk.assignment_4_blog_1;

public class Entry {
    private int entryNumber;
    private String dateTime;
    private String username;
    private String comment;

    public Entry(int entryNumber, String dateTime, String username, String comment) {
        this.entryNumber = entryNumber;
        this.dateTime = dateTime;
        this.username = username;
        this.comment = comment;
    }

    public int getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return entryNumber + ". " + dateTime + " " + username + " - " + comment;
    }


}
