package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightTreesSpeciesMapper extends Mapper<Object, Text, Text, FloatWritable> {
    public int line = 0;
    public Float height;
    public String species;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (line != 0) {
            try {
                height = Float.parseFloat(value.toString().split(";")[6]);
                species = value.toString().split(";")[3];
                context.write(new Text(species), new FloatWritable(height));
            } catch (NumberFormatException ex) {
                System.out.println("Exception: " + ex);
            }
        } line++;
    }
}
