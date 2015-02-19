/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd515.smatches.util;

/**
 * Credit for ideas goes to:
 *
 * http://stackoverflow.com/questions/3985392/generate-random-date-of-birth
 * http://stackoverflow.com/questions/3165319/whats-wrong-with-this-random-date-of-birth-generator
 * http://www.leveluplunch.com/java/examples/generate-random-date/
 *
 * @author spyrisos
 */
import java.util.Date;
import java.util.Random;

public class RandomDate {

    private static final Random GENERATOR = new Random();
    // Beginning and Ending time in MS
    private static final long BEGIN_TIME = 1L * 365L * 24L * 60L * 60L * 1000L;
    private static final long END_TIME = 100L * 365L * 24L * 60L * 60L * 1000L;
    /**
     *
     * @return
     */
    public static Date generate() {
        return new Date(System.currentTimeMillis() - getRandomTimeBetweenTwoDates());
    }

    private static long getRandomTimeBetweenTwoDates() {
        long diff = END_TIME - BEGIN_TIME + 1;
        return BEGIN_TIME + (long)(Math.random() * diff);
    }
}
