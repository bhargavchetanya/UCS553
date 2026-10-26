import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class Event {
    String name;
    LocalDate date;
    LocalTime startTime;
    Optional<String> venue;

    Event(String name, LocalDate date, LocalTime startTime, String venue) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.venue = Optional.ofNullable(venue);
    }

    void showDetails() {
        LocalDate today = LocalDate.now();
        System.out.println("Event Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + startTime.plusHours(2));
        System.out.println("Venue: " + venue.orElse("Venue not specified"));

        if (date.isAfter(today)) {
            System.out.println("Status: Event is in the future");
            System.out.println("Days remaining: " + ChronoUnit.DAYS.between(today, date));
        } else if (date.isEqual(today)) {
            System.out.println("Status: Event is today");
            System.out.println("Days remaining: 0");
        } else {
            System.out.println("Status: Event is in the past");
            System.out.println("Days since event: " + ChronoUnit.DAYS.between(date, today));
        }
        System.out.println();
    }
}

public class Q4 {
    public static void main(String[] args) {
        System.out.println("Today's Date: " + LocalDate.now());
        System.out.println();

        Event e1 = new Event("Tech Fest", LocalDate.of(2026, 12, 15), LocalTime.of(10, 30), "Main Auditorium");
        Event e2 = new Event("Coding Contest", LocalDate.now(), LocalTime.of(14, 0), null);
        Event e3 = new Event("Freshers Party", LocalDate.of(2026, 8, 20), LocalTime.of(18, 0), "Open Air Theatre");

        e1.showDetails();
        e2.showDetails();
        e3.showDetails();
    }
}

/*
Output:
Today's Date: 2026-10-26

Event Name: Tech Fest
Event Date: 2026-12-15
Start Time: 10:30
End Time: 12:30
Venue: Main Auditorium
Status: Event is in the future
Days remaining: 50

Event Name: Coding Contest
Event Date: 2026-10-26
Start Time: 14:00
End Time: 16:00
Venue: Venue not specified
Status: Event is today
Days remaining: 0

Event Name: Freshers Party
Event Date: 2026-08-20
Start Time: 18:00
End Time: 20:00
Venue: Open Air Theatre
Status: Event is in the past
Days since event: 67
*/
