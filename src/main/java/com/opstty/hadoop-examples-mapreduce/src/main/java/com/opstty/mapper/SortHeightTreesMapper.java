package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortHeightTreesMapper extends Mapper<Object, Text, FloatWritable, Text> {
    public int line = 0;
    public Float height;
    public String id;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (line != 0) {
            try {
                id = value.toString().split(";")[11];
                height = Float.parseFloat(value.toString().split(";")[6]);
                context.write(new FloatWritable(height), new Text(id));
            } catch (NumberFormatException ex) {
                System.out.println("Exception: " + ex);
            }
        } line++;
    }
}
