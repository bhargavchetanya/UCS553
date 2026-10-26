package library.service;
import library.model.LibraryResource;
import library.util.Printable;

public class DigitalResource extends LibraryResource implements Printable{
    int days;
    public DigitalResource(String t,String a,int days){
        super(t,a);
        this.days=days;
    }
    @Override
    public double CalculateFine(int days){
        TotalFine+=2*days;
        return 2*days;
    }
    @Override
    public void printdetails(LibraryResource l){
        System.out.println("Resource Id -> "+ getResourceId(l));
        System.out.println("Title -> "+ getTitle(l));
        System.out.println("Author -> "+ getAuthor(l));
        if(days>0){
            System.out.println("Fine Applicable on days -> "+ days);
            System.out.println("Fine Amount -> "+CalculateFine(days));
        }
    }
}
