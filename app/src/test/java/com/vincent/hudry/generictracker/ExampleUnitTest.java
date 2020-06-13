package com.vincent.hudry.generictracker;

import com.vincent.hudry.generictracker.utils.CSVParser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCSVEngine() {
        CSVParser parser = new CSVParser();
        String[] headerArray = {"sexe", "prenom", "annee de naissance"};
        ArrayList<String> header = new ArrayList<>(Arrays.asList(headerArray));
        parser.setHeader(header);
        String[] l1 = {"M", "Alphonse", "1932"};
        String[] l2 = {"F", "Beatrice", "1964"};
        String[] l3 = {"F", "Charlotte", "1988"};
        for (String[] sa : new String[][]{l1, l2, l3}) {
            ArrayList<String> sal = new ArrayList<>(Arrays.asList(sa));
            try {
                parser.appendData(sal);
            } catch (Exception e) {
                assert (false);
            }
        }
        //parser.parse(s);
        String tostring = parser.toString();
        assert (tostring.equals("sexe,prenom,annee de naissance\n" +
                "M,Alphonse,1932\n" +
                "F,Beatrice,1964\n" +
                "F,Charlotte,1988\n"));
        parser = new CSVParser();
        try {
            parser.parse(tostring);
        } catch (Exception e) {
            assert (false);
        }
        String s2 = parser.toString();
        assert (s2.equals("sexe,prenom,annee de naissance\n" +
                "M,Alphonse,1932\n" +
                "F,Beatrice,1964\n" +
                "F,Charlotte,1988\n"));
    }
}