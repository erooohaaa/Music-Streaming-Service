package music.decorator;

import org.example.models.Song;

public class BaseStream implements AudioStream {
    private Song song;
    public BaseStream (Song song){
        this.song = song;

    }




    @Override
    public void play(){
        System.out.println("Playing:  "+ song.getTitle());
    }
}
