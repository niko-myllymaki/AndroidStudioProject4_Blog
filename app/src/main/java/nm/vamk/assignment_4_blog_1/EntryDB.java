package nm.vamk.assignment_4_blog_1;

import java.util.ArrayList;
import java.util.List;

public class EntryDB {

    static List<Entry> entriesList = new ArrayList<>();
    public static List<Entry> getEntriesList() {

        List<Entry> reversedEntriesList;
        //Add elements of entriesList reversed to reverseEntriesList
        reversedEntriesList = reverseEntriesList(entriesList);

        return reversedEntriesList;
    }

    public static List<Entry> getEntriesByComment (String commentToSearch) {
        List<Entry> entriesByComment = new ArrayList<>();
        Entry entryTemp = null;

        for(Entry entry : reverseEntriesList(entriesList)) {
            if(entry.getComment().contains(commentToSearch) ||entry.getComment().toLowerCase().contains(commentToSearch)) {
                entryTemp = entry;
                entriesByComment.add(entryTemp);
            }
        }

        return entriesByComment;
    }

    public static List<Entry> getEntriesByDate (String dateToSearch) {
        List<Entry> entriesByDate = new ArrayList<>();
        Entry entryTemp = null;

        for(Entry entry : reverseEntriesList(entriesList)) {
            if(entry.getDateTime().contains(dateToSearch)) {
                entryTemp = entry;
                entriesByDate.add(entryTemp);
            }
        }

        return entriesByDate;
    }

    public static List<Entry> reverseEntriesList(List<Entry> entriesListToReverse) {
        List<Entry> reverseEntriesList = new ArrayList<>();
        for (int i = entriesListToReverse.size() -1; i >= 0; i--) {
            reverseEntriesList.add(entriesListToReverse.get(i));
        }

        return reverseEntriesList;
    }

    public static String addNewEntryToDatabase(String dateTime, String username, String comment) {
        int entryNumber = entriesList.size() + 1;
        entriesList.add(new Entry(entryNumber, dateTime, username, comment));
        return "New entry was added to the database";
    }




}
