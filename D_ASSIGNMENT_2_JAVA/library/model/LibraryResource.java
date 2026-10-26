package library.model;

public abstract class LibraryResource{
    private static int counter =0;
    public static int TotalFine =0;
    int ResourceId;
    String Title;
    String Author;
    static String LibraryName="Nalanda";
    public LibraryResource(String t,String a){
        counter++;
        ResourceId=counter;
        Title=t;
        Author=a;
    }
    public abstract double CalculateFine(int OverdueDays);
    public int getResourceId(LibraryResource l){
        return l.ResourceId;
    }
    public String getTitle(LibraryResource l){
        return l.Title;
    }
    public String getAuthor(LibraryResource l){
        return l.Author;
    }
}