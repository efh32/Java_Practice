import java.util.*;
import java.util.concurrent.*;


interface SongCache {
    /**
     * Record number of plays for a song.
     */
    void recordSongPlays(String songId, int
            numPlays);
    /**
     * Fetch the number of plays for a song.
     *
     We are looking for both correctness and good coding style. Please make sure that your code is well-designed and architected, in addition to being algorithmically efficient.
     See this unit test for guidance.
     * @return the number of plays, or -1 if the
    song ID is unknown.
     */
    int getPlaysForSong(String songId);
    /**
     * Return the top N songs played, in descending
     order of number of plays.
     */
    List<String> getTopNSongsPlayed(int n);
}

class SongCacheImpl implements SongCache{

    //Private Data members
    private ConcurrentHashMap<String, Integer> hm;

    //Constructor
    SongCacheImpl(){
        hm = new ConcurrentHashMap<String, Integer>();
    }

    /**
     * Record number of plays for a song.
     */
    public void recordSongPlays(String songId, int numPlays){
        if(songId == null){
            throw new IllegalArgumentException("songId cannot be null.");
        }

        if(numPlays < 0){
            throw new IllegalArgumentException("Song cannot be played negative times.");
        }

        hm.computeIfAbsent(songId, k -> (0));
        hm.computeIfPresent(songId, (k, v)-> v + 1);
    }

    /**
     * Fetch the number of plays for a song.
     *
     We are looking for both correctness and good coding style. Please make sure that your code is well-designed and architected, in addition to being algorithmically efficient.
     See this unit test for guidance.
     * @return the number of plays, or -1 if the
    song ID is unknown.
     */
    public int getPlaysForSong(String songId){
        Integer ret = hm.get(songId);
        Optional<Integer> checkNull = Optional.ofNullable(ret);

        if(checkNull.isPresent()){
            return ret;
        }

        return -1;
    }

    /**
     * Return the top N songs played, in descending
     order of number of plays.
     */
    public List<String> getTopNSongsPlayed(int n){
        if(n < 0){
            throw new IllegalArgumentException("Cannot use negative numbers for top N songs played");
        }

        if(n > hm.size()){
            System.out.println("Input exceeds number of songs.  Will print all songs in descending " +
                    "order based on number of plays");
            n = hm.size();
        }


        PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->{
            Integer v1 = hm.get(a);
            Integer v2 = hm.get(b);

            return v2 - v1;
        });

        List<String> ret = new ArrayList<String>();

        for(String str : hm.keySet()){
            pq.add(str);
        }

        while(n > 0){
            ret.add(pq.poll());
            n--;
        }

        return ret;
    }

}

public class Challenge1 {

    public void cacheIsWorking() {
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);

        /*
        assertThat(cache.getPlaysForSong("ID-1"), is(4));
        assertThat(cache.getPlaysForSong("ID-9"), is(-1));
        assertThat(cache.getTopNSongsPlayed(2), contains("ID-3",
                "ID-1"));
        assertThat(cache.getTopNSongsPlayed(0), is(empty()));
        */

        assert cache.getPlaysForSong("ID-1") == 4;
        assert cache.getPlaysForSong("ID-9") == -1;



    }




    public static void main(String[] args) {
        Challenge1 c1 = new Challenge1();

        c1.cacheIsWorking();

        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);
        cache.recordSongPlays("ID-33", 20);
        cache.recordSongPlays("ID-19", 12);
        cache.recordSongPlays("ID-3", 19);

        System.out.println("top 3 songs: " );
        List<String> topSongs = cache.getTopNSongsPlayed(3);

        Iterator<String> it = topSongs.iterator();

        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        System.out.println("\ntop 10 songs: ");
        List<String> topSongs2 = cache.getTopNSongsPlayed(10);

        it = topSongs2.iterator();

        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        System.out.println("\nTest getPlaysForSongs: ");
        System.out.println(cache.getPlaysForSong("ID-3"));
        System.out.println(cache.getPlaysForSong("ID-24"));

    }



}







