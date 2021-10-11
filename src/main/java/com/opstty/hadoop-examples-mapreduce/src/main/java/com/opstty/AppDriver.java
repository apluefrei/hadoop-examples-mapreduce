package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("distinctDistricts", DistinctDistricts.class,
                    "A map/reduce program that returns the distinct districts with trees.");
            programDriver.addClass("treesSpecies", TreesSpecies.class,
                    "A map/reduce program that returns all distinct trees species.");
            programDriver.addClass("countTreesSpecies", CountTreesSpecies.class,
                    "A map/reduce program that counts the tree for each species.");
            programDriver.addClass("maxHeightTreesSpecies", MaxHeightTreesSpecies.class,
                    "A map/reduce program that returns the highest tree for each species.");
            programDriver.addClass("sortHeightTrees", SortHeightTrees.class,
                    "A map/reduce program that returns all the trees sorted by their height.");
            programDriver.addClass("districtOldTrees", DistrictOldTrees.class,
                    "A map/reduce program that returns the oldest tree.");
            programDriver.addClass("districtMostTrees", DistrictMostTrees.class,
                    "A map/reduce program that returns the district which contains most trees.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
