/*
CISC 3130 - Lab #2
Ada Maldonado
09-07-2020
 */
package report;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/*
I imported the Java File class to help scan the csv file using the Scanner class.
I also imported the PrintStream class to print my output into a new file.

The Report class is the source code that is producing the report of the top streamed
music artists on Spotify of a certain week.
 */
public class Report {

    //This is the main method that will contain all the source code of the program.
    public static void main(String[] args) throws Exception {

        //ps will print the output into the text file and sc is scanning the csv file.
        PrintStream ps = new PrintStream("Artists-Weekof09032020.txt");
        Scanner sc = new Scanner(new File("regional-global-weekly-latest.csv"));

        //these int variables are constants that will help set a max limit to the arrays.
        final int maxArtists = 200;
        final int maxCount = 200;

        //The String array is the array of artists that are streamed this week.
        //The int array is the array of how many appearances these artists were on Spotify.
        String[] artists = new String[maxArtists];
        int[] artistsCount = new int[maxCount];

        //This for loop is intitializing the artist array to blank Strings
        for (int i = 0; i < maxArtists; i++) {
            artists[i] = "";
        }//end for loop

        //This String variable will represent the one line of text on each song
        String song;

        //This int variable will be used to search for empty space on the array.
        int i = 0;

        //This while loop checks every single line in the csv file.
        while (sc.hasNextLine()) {

            //This boolean variable sees if an artist has already appeared this week.
            boolean found = false;
            //Scans the line of the csv file and stores it into this String variable.
            song = sc.nextLine();

            //The if statement is checking to see if there are featuring artists in a song.
            if (song.contains("feat. ")) {

                //I found the postions in which the word feat. is in the line of text.
                int firstPos = song.indexOf("feat. ");
                int lastPos = song.lastIndexOf(")");

                //Stored the featuring artist in a String.
                String featArtists = song.substring(firstPos + 6, lastPos);

                //Sees if there is more than 1 featurng artist.
                if (!(featArtists.contains("& "))) {

                    //Searches if the featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(featArtists)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = featArtists;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //The else statement is used to find the other feat artists.
                } else {

                    //Searches the string & separates the first and second feat artists.
                    int andPos = featArtists.indexOf("& ");
                    String first = featArtists.substring(0, andPos - 1);
                    String second = featArtists.substring(andPos + 2);

                    //Searches if the first featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(first)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the 1st feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = first;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //Searches if the second featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(second)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the 2nd feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = second;
                        artistsCount[i]++;
                        i++;
                    }//end if
                }//end if-else

                //Searches for the main artist of the featuring song.
                int firstCom = song.indexOf(",");
                String afterFirst = song.substring(firstCom + 1);
                int secondCom = afterFirst.indexOf(",");
                String afterSecond = afterFirst.substring(secondCom + 1);
                int thirdCom = afterSecond.indexOf(",");

                //Puts the first/main artist in a String variable.
                String firstArtist = afterSecond.substring(0, thirdCom);

                //Checks to see if there are quotations surrounding the artist's name.
                if (!(firstArtist.contains("\""))) {

                    //Searches if the main artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(firstArtist)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the main artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = firstArtist;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //The else statement is used to find the other main artists that had quotes.
                } else {
                    //Made a new String of the main artist's name with no quotes.
                    String noQuotes = firstArtist.substring(1, thirdCom - 1);

                    //Searches if the main artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(noQuotes)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the main artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = noQuotes;
                        artistsCount[i]++;
                        i++;
                    }//end if
                }//end else

                //The else if statement checks feat artists displayed as 'with' in a song.
            } else if (song.contains("(with ")) {

                //I found the postions in which the word (with is in the line of text.
                int firstPos = song.lastIndexOf("(with ");
                int lastPos = song.lastIndexOf(")");

                //Stored the featuring artist in a String.
                String featArtists = song.substring(firstPos + 6, lastPos);

                //Sees if there is more than 1 featurng artist.
                if (!(featArtists.contains("& "))) {

                    //Searches if the featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(featArtists)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = featArtists;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //The else statement is used to find the other feat artists.
                } else {

                    //Searches the string & separates the first and second feat artists.
                    int andPos = featArtists.indexOf("& ");
                    String first = featArtists.substring(0, andPos);
                    String second = featArtists.substring(andPos + 2);

                    //Searches if the first featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(first)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the 1st feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = first;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //Searches if the second featuring artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(second)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the 2nd feat artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = second;
                        artistsCount[i]++;
                        i++;
                    }//end if

                }//end if-else

                //Searches for the main artist of the featuring song.
                int firstCom = song.indexOf(",");
                String afterFirst = song.substring(firstCom + 1);
                int secondCom = afterFirst.indexOf(",");
                String afterSecond = afterFirst.substring(secondCom + 1);
                int thirdCom = afterSecond.indexOf(",");

                //Puts the first/main artist in a String variable.
                String firstArtist = afterSecond.substring(0, thirdCom);

                //Checks to see if there are quotations surrounding the artist's name.
                if (!(firstArtist.contains("\""))) {

                    //Searches if the main artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(firstArtist)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the main artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = firstArtist;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //The else statement is used to find the other main artists that had quotes.
                } else {
                    //Made a new String of the main artist's name with no quotes.
                    String noQuotes = firstArtist.substring(1, thirdCom - 1);

                    //Searches if the main artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(noQuotes)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the main artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = noQuotes;
                        artistsCount[i]++;
                        i++;
                    }//end if
                }//end else

                //The else statement checks the only artist displayed in a song.
            } else {

                //Searches for the only artist of the song.
                int firstCom = song.indexOf(",");
                String afterFirst = song.substring(firstCom + 1);
                int secondCom = afterFirst.indexOf(",");
                String afterSecond = afterFirst.substring(secondCom + 1);
                int thirdCom = afterSecond.indexOf(",");

                //Puts the first/only artist in a String variable.
                String firstArtist = afterSecond.substring(0, thirdCom);

                //Checks to see if there are quotations surrounding the artist's name.
                if (!(firstArtist.contains("\""))) {

                    //Searches if the artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(firstArtist)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = firstArtist;
                        artistsCount[i]++;
                        i++;
                    }//end if

                    //The else statement is used to find the other artists that had quotes.
                } else {
                    //Made a new String of the artist's name with no quotes.
                    String noQuotes = firstArtist.substring(1, thirdCom - 1);

                    //Searches if the artist has already appeared this week.
                    for (int j = 0; j < maxArtists; j++) {
                        //Looks through the artist array to see if anything matches.
                        if (artists[j].equals(noQuotes)) {
                            artistsCount[j]++;
                            found = true;
                        }//end if
                    }//end for

                    //Finds an empty space in the artist array to put the main artist in.
                    if (artists[i].equals("") && !found) {
                        artists[i] = noQuotes;
                        artistsCount[i]++;
                        i++;
                    }//end if
                }//end else
            }//end else if-else
        }//end while

        //The int variable will be the counter for how many artists there are this week.
        int count = 0;
        //Checked which part of the arrays had at least one appearance of an artist.
        for (int j = 0; j < maxCount; j++) {
            if (artistsCount[j] > 0) {
                count++;
            }//end if
        }//end for

        //Prints out the title and labels of the data found into the report text file.
        ps.println("Top Streamed Music Artists Week 09032020\n");
        ps.printf("%-30s %2s%n%n", "Artist", "Appearance");

        //Formats and displays each artist and how many appearances they had this week.
        for (int j = 0; j < count; j++) {
            ps.printf("%-30s %5s%n", artists[j], artistsCount[j]);
        }//end for

    }//end main
}//end class
