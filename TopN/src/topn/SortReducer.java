package topn;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SortReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private Map<String, Integer> map = new HashMap<>();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {

        int sum = 0;

        for (IntWritable val : values) {
            sum += val.get();
        }

        map.put(key.toString(), sum);
    }

    @Override
    protected void cleanup(Context context)
            throws IOException, InterruptedException {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort by frequency (descending)
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Take top 10
        List<Map.Entry<String, Integer>> top10 = new ArrayList<>();
        int count = 0;

        for (Map.Entry<String, Integer> entry : list) {
            if (count == 10)
                break;
            top10.add(entry);
            count++;
        }

        // Sort alphabetically
        top10.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        for (Map.Entry<String, Integer> entry : top10) {
            context.write(new Text(entry.getKey()),
                          new IntWritable(entry.getValue()));
        }
    }
}
