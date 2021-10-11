package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TreesMapperTest {
    @Mock
    private Mapper.Context context;
    private TreesMapper treesMapper;
    @Before
    public void setup() {
        this.treesMapper = new TreesMapper();
    }
    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.8302532096, 2.41400587444);12;Acer;opalus;Sapindaceae;1870;15.0;160.0;Ile de Bercy;Erable d'Italie;;91;Bois de Vincennes (Ile de Bercy)";

        this.treesMapper.map(null, new Text(value), this.context);
        verify(this.context, times(1)).write(new IntWritable(12), new IntWritable(1));
    }
}
