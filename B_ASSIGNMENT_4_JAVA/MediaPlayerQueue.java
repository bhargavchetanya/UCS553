import java.util.*;

class Song {
    private final String title;
    private final String artist;
    private final int durationSeconds;

    Song(String title, String artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    String getTitle() { return title; }
    String getArtist() { return artist; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song other = (Song) o;
        return title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d:%02d)", title, artist, durationSeconds / 60, durationSeconds % 60);
    }
}

public class MediaPlayerQueue {
    private static final int HISTORY_LIMIT = 5;

    private final LinkedList<Song> queue = new LinkedList<>();
    private final LinkedList<Song> history = new LinkedList<>();

    private ListIterator<Song> cursor = queue.listIterator();
    private Song current;
    private boolean movedForward = true;

    private int currentIndex() {
        if (current == null) return -1;
        return movedForward ? cursor.previousIndex() : cursor.nextIndex();
    }

    private void resetCursor(int newCurrentIndex) {
        if (newCurrentIndex < 0) {
            current = null;
            cursor = queue.listIterator();
        } else {
            cursor = queue.listIterator(newCurrentIndex + 1);
        }
        movedForward = true;
    }


    public void addToEnd(Song song) {
        int idx = currentIndex();
        queue.addLast(song);
        resetCursor(idx);
        System.out.println("Added to end      : " + song);
    }

    public void addToFront(Song song) {
        int idx = currentIndex();
        queue.addFirst(song);
        resetCursor(idx < 0 ? -1 : idx + 1);
        System.out.println("Added to front    : " + song);
    }

    public void playNextInQueue(Song song) {
        if (current == null) {
            addToFront(song);
            return;
        }
        if (!movedForward) {
            cursor.next();
            movedForward = true;
        }
        cursor.add(song);
        cursor.previous();
        System.out.println("Play next         : " + song);
    }

    public void insertAt(int position, Song song) {
        if (position < 0 || position > queue.size()) {
            System.out.println("Invalid position " + position + " for " + song);
            return;
        }
        int idx = currentIndex();
        ListIterator<Song> it = queue.listIterator(position);
        it.add(song);
        resetCursor(idx >= 0 && position <= idx ? idx + 1 : idx);
        System.out.println("Inserted at " + position + "     : " + song);
    }

    public void removeDuplicates() {
        int idx = currentIndex();
        int newIdx = -1;
        Map<Song, Integer> firstPosition = new HashMap<>();
        Set<Song> seen = new HashSet<>();
        int removed = 0;
        int kept = 0;

        ListIterator<Song> it = queue.listIterator();
        while (it.hasNext()) {
            int oldIndex = it.nextIndex() + removed;
            Song song = it.next();
            if (!seen.add(song)) {
                it.remove();
                removed++;
                if (oldIndex == idx) newIdx = firstPosition.get(song);
            } else {
                firstPosition.put(song, kept);
                if (oldIndex == idx) newIdx = kept;
                kept++;
            }
        }
        if (newIdx >= 0) current = queue.get(newIdx);
        resetCursor(newIdx);
        System.out.println("Removed " + removed + " duplicate entr" + (removed == 1 ? "y" : "ies"));
    }


    public Song next() {
        if (!movedForward && cursor.hasNext()) {
            cursor.next();
        }
        movedForward = true;
        if (!cursor.hasNext()) {
            System.out.println("End of queue");
            return null;
        }
        current = cursor.next();
        play(current, "Next     ");
        return current;
    }

    public Song previous() {
        if (movedForward && current != null && cursor.hasPrevious()) {
            cursor.previous();
        }
        movedForward = false;
        if (!cursor.hasPrevious()) {
            System.out.println("Start of queue");
            if (current != null) {
                cursor.next();
                movedForward = true;
            }
            return null;
        }
        current = cursor.previous();
        play(current, "Previous ");
        return current;
    }

    private void play(Song song, String action) {
        System.out.println(action + "> Now playing: " + song);
        history.remove(song);
        history.addFirst(song);
        if (history.size() > HISTORY_LIMIT) {
            history.removeLast();
        }
    }


    public void showQueue() {
        int idx = currentIndex();
        System.out.println("---- Queue (" + queue.size() + " songs) ----");
        int i = 0;
        for (Song s : queue) {
            System.out.println((i == idx ? " >> " : "    ") + (i + 1) + ". " + s);
            i++;
        }
    }

    public void showHistory() {
        System.out.println("---- Recently played (latest first) ----");
        for (Song s : history) {
            System.out.println("    " + s);
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();

        Song s1 = new Song("Blinding Lights", "The Weeknd", 200);
        Song s2 = new Song("Shape of You", "Ed Sheeran", 233);
        Song s3 = new Song("Believer", "Imagine Dragons", 204);
        Song s4 = new Song("Perfect", "Ed Sheeran", 263);
        Song s5 = new Song("Levitating", "Dua Lipa", 203);
        Song s6 = new Song("Kesariya", "Arijit Singh", 268);

        System.out.println("=== Building the queue ===");
        player.addToEnd(s1);
        player.addToEnd(s2);
        player.addToEnd(s3);
        player.addToEnd(new Song("shape of you", "ed sheeran", 233));
        player.addToEnd(s4);
        player.addToFront(s5);
        player.insertAt(3, s6);
        player.addToEnd(s1);
        player.showQueue();

        System.out.println("\n=== Forward navigation ===");
        player.next();
        player.next();
        player.next();
        player.showQueue();

        System.out.println("\n=== Backward navigation ===");
        player.previous();
        player.previous();
        player.previous();
        player.next();

        System.out.println("\n=== Removing duplicates ===");
        player.removeDuplicates();
        player.showQueue();

        System.out.println("\n=== Play next + priority while playing ===");
        player.playNextInQueue(new Song("Heat Waves", "Glass Animals", 238));
        player.addToFront(new Song("Tum Hi Ho", "Arijit Singh", 262));
        player.showQueue();
        player.next();
        player.next();

        System.out.println("\n=== Play to the end ===");
        while (player.next() != null) { }
        player.previous();

        System.out.println();
        player.showHistory();
    }
}
