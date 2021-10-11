package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CountTreesSpeciesMapper extends Mapper<Object, Text, Text, IntWritable> {
    public int line = 0;
    public String species;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (line != 0) {
            species = value.toString().split(";")[3];
            context.write(new Text(species), new IntWritable(1));
        }
        line++;
    }
}

