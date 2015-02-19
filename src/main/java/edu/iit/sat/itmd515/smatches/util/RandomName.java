/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd515.smatches.util;

import java.util.Random;

/**
 * Credit for the idea to:
 * 
 * https://svn.apache.org/repos/asf/click/trunk/examples/click-bench/src/benchmark/dao/CustomerDao.java
 *
 * @author spyrisos
 */
public class RandomName {

    private static final Random GENERATOR = new Random();

    private static final String[] FIRST_NAMES = new String[]{
        "Emily", "Jacob", "Michael", "Emma", "Joshua", "Madison", "Matthew",
        "Hannah", "Andrew", "Olivia", "Cletus", "Warner", "Sarah", "Billy",
        "Brittany", "Daniel", "David", "Cristman", "Colin", "Royalle"
    };

    private static final String[] LAST_NAMES = new String[]{
        "Aaron", "Bolingbroke", "Crounse", "Duff", "Drake", "Downs", "Driver",
        "Jasper", "Jetter", "O'Leary", "O'Malley", "Neville", "Towers", "Tripp",
        "Trull", "Wakefield", "Waller", "Badger", "Bagley", "Baker"
    };

    public static String generateFirstName() {
        return FIRST_NAMES[GENERATOR.nextInt(FIRST_NAMES.length)];
    }

    public static String generateLastName() {
        return LAST_NAMES[GENERATOR.nextInt(LAST_NAMES.length)];
    }
}
