package music.strategy;

import music.models.Track;

import java.util.List;

public interface PlayBackStrategy {
    int next(List<Track> playList, int currentIndex);
}
