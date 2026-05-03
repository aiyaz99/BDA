package meanmaxtemp;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MeanMaxMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    public static final int MISSING = 9999;

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();

        // skip invalid lines
        if (line.length() < 93) return;

        try {
            String year = line.substring(15, 19);
            String month = line.substring(19, 21);

            int temperature;

            if (line.charAt(87) == '+') {
                temperature = Integer.parseInt(line.substring(88, 92));
            } else {
                temperature = Integer.parseInt(line.substring(87, 92));
            }

            String quality = line.substring(92, 93);

            // ✅ REMOVED TMAX CONDITION
            if (temperature != MISSING && quality.matches("[01459]")) {

                String yearMonth = year + "-" + month;

                context.write(new Text(yearMonth), new IntWritable(temperature));
            }

        } catch (Exception e) {
            // ignore bad lines
        }
    }
}