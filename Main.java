import java.util.*;
import java.util.stream.*;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args) {
        TestLambda testLambda = new TestLambda();
        testLambda.allColor();


        TestStream testStream = new TestStream();
        testStream.stream1();
        testStream.stream2();
        testStream.stream3();

        // Demo
        Demo demo = new Demo();
        demo.findAllRockSongs();
        demo.listAllGenres();
    }
}


class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    public Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", timesPlayed=" + timesPlayed +
                '}';
    }
}

class Songs {
    public List<Song> getSongs() {
        return List.of(
                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
                new Song("Silence", "Delerium", "Electronic", 1999, 134),
                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
                new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
                new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
                new Song("What's Going On", "Gaye", "R&B", 1971, 420),
                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
                new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
                new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
                new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
                new Song("Smooth", "Santana", "Latin", 1999, 244),
                new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484));
    }
}


class Demo {
    Songs songs = new Songs();
    List<Song> songList = songs.getSongs();

    public void findAllRockSongs() {
        List<Song> rockSongList = songList
                .stream()
                .filter(song -> song.getGenre().contains("Rock"))
                .collect(Collectors.toList());
        System.out.println("rockSongList ===>");
        System.out.println(rockSongList);
        System.out.println("Total: " + rockSongList.size());
    }

    public void listAllGenres() {
        List<String> genreList = songList
                .stream()
                .map(song -> song.getGenre())
                .distinct() // Remove Duplicate
                .collect(Collectors.toList());
        System.out.println("genreList ===>");
        System.out.println(genreList);
        System.out.println("Total: " + genreList.size());

    }

}




class TestLambda {
    // forEach
    public void allColor() {
        List<String> colors = List.of("Red", "Green", "Blue");
        colors.forEach(color -> System.out.println("Color: " + color));
    }

}

class TestStream {

    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");


    public void stream1() {
        Stream<String> stream = strings.stream();
        System.out.println("stream");
        System.out.println(stream);

        stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        System.out.println("limit");
        System.out.println(limit);

        // counting
        System.out.println(limit.count());
    }

    public void stream2() {
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        List<String> limitResult = limit.collect(Collectors.toList());
        System.out.println(limitResult);
    }

    public void stream3() {
        // Stream Pipeline
        List<String> result = strings
                .stream() // Source
                .limit(5) // Intermediate operation
                .collect(Collectors.toList()); // terminal operation
                // then output
        System.out.println("Result : " + result);

        List<String> result2 = strings
                .stream()
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Result 2 : " + result2);

        List<String> result3 = strings
                .stream()
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .skip(2)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Result 3 : " + result3);

    }


}