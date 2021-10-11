package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TreesMapper extends Mapper<Object, Text, Text, NullWritable> {
    public int curr_line = 0;
    public String district;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (curr_line != 0) {
            district = value.toString().split(";")[1];
            context.write(new Text(district), NullWritable.get());
        }
        curr_line++;
    }
}
