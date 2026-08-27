package library.Main;
import library.model.*;
import library.service.*;
import library.util.*;

public class Main{
    public static void main(){
        LibraryResource lis[]=new LibraryResource[6];
        LibraryResource book1=new DigitalResource("Let Us C","Stephen",0);
        lis[1]=book1;
        LibraryResource book2=new DigitalResource("Gunahon ka Devta","Bharti",4);
        lis[2]=book2;
        LibraryResource book3=new Book("Java","Rampal",0);
        lis[3]=book3;
        LibraryResource book4=new Book("HanumanChalsa","Sitaram",3);
        lis[4]=book4;
        LibraryResource book5=new Book("Mahabharat","Tulsidas",0);
        lis[5]=book5;
        for(int i=1;i<6;i++){
            Printable p=(Printable) lis[i];
            p.printdetails(lis[i]);
            System.out.println();
        }
        System.out.println();
        System.out.println("Total Fine -> " +LibraryResource.TotalFine);

    }
}

