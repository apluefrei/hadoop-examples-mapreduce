package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class DistrictOldTreesReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    public boolean bool = true;

    public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) {
        if (bool) {
            StreamSupport.stream(values.spliterator(), false).distinct().forEach(v -> {
                try {
                    context.write(key, v);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        bool = false;
    }
}
