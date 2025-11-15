package music.strategy;

import music.models.Track;
import java.util.List;
import java.util.Objects;

public class Player {
    private List<Track> playlist;
    private PlayBackStrategy strategy;
    private int currentIndex = 0;

    public Player(List<Track> playlist, PlayBackStrategy strategy) {
        this.playlist = Objects.requireNonNull(playlist, "Playlist cannot be null");
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public void setStrategy(PlayBackStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
        System.out.println("Strategy changed to: " + strategy.getClass().getSimpleName());
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentIndex < 0 || currentIndex >= playlist.size()) {
            System.out.println("End of playlist.");
            return;
        }

        Track track = playlist.get(currentIndex);
        System.out.println("Playing: " + track);
    }

    public void next() {
        currentIndex = strategy.next(playlist, currentIndex);

        if (currentIndex == -1) {
            System.out.println("Playback finished.");
        } else {
            play();
        }
    }

    public void setPlaylist(List<Track> playlist) {
        this.playlist = Objects.requireNonNull(playlist, "Playlist cannot be null");
        this.currentIndex = 0;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int index) {
        if (index >= 0 && index < playlist.size()) {
            this.currentIndex = index;
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}