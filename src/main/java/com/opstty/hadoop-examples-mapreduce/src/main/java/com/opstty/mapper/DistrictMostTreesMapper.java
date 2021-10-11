package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;

import javax.naming.Context;
import java.io.IOException;

public class DistrictMostTreesMapper extends Mapper<LongWritable, IntWritable, NullWritable, MapWritable> {
    public void map(LongWritable key, IntWritable value, Context context) throws IOException, InterruptedException {
        MapWritable map = new MapWritable();
        map.put(new IntWritable((int) key.get()), value);
        context.write(NullWritable.get(), map);
    }
}
