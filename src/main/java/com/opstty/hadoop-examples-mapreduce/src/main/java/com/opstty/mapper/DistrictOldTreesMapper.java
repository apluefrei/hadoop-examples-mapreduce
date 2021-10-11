package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictOldTreesMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
    public int line = 0;
    public Integer year;
    public Integer district;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (line != 0) {
            try {
                year = Integer.parseInt(value.toString().split(";")[5]);
                district = Integer.parseInt(value.toString().split(";")[1]);
                context.write(new IntWritable(district), new IntWritable(year));
            } catch (NumberFormatException ex) {
                System.out.println("Exception: " + ex);
            }
        } line++;
    }
}
