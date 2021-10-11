package com.opstty.reducer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MaxHeightTreesSpeciesReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    private FloatWritable result;

    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        result.set(StreamSupport.stream(values.spliterator(), false).map((v) -> { return v.get(); }).max(Float::compare).get());
        context.write(key, result);
    }
}

