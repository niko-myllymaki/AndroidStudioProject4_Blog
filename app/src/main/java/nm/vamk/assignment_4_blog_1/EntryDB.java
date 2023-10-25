package nm.vamk.assignment_4_blog_1;

import java.util.ArrayList;
import java.util.List;

public class EntryDB {

    static List<Entry> entriesList = new ArrayList<>();

    public static List<Entry> getEntriesList() {
        return entriesList;
    }

    public static String addNewEntryToDatabase(String dateTime, String username, String comment) {
        int entryNumber = entriesList.size() + 1;
        entriesList.add(new Entry(entryNumber, dateTime, username, comment));
        return "New entry was added to the database";
    }




}
