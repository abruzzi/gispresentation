import com.esri.core.geometry.*;
import com.esri.core.geometry.QuadTree.QuadTreeIterator;
import com.esri.json.EsriFeatureClass;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.codehaus.jackson.JsonParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SimpleApp {

    public static EsriFeatureClass featureClass;
    public static SpatialReference spatialReference = SpatialReference.create(4326);;
    public static QuadTree quadTree;
    public static QuadTreeIterator quadTreeIter;
    public static Point startPoint = new Point(53.88,-161.68);

    public static void main(String[] args) throws IOException {

        setup();

        String logFile = "/home/hduser/spark-1.0.0-bin-hadoop2/earthquakes.csv"; // Should be some file on your system
        SparkConf conf = new SparkConf().setAppName("Simple Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile);

        List<String> filter = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) throws Exception {
                String[] values = s.split(",");
                float latitude = Float.parseFloat(values[1]);
                float longitude = Float.parseFloat(values[2]);

                Point point = new Point(longitude, latitude);
                int featureIndex = contains(point);

                if (featureIndex >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }).collect();

        System.out.println("Results: " + filter.size());

    }

    public static void setup() throws IOException {

        InputStream iStream = new FileInputStream("/home/hduser/spark-1.0.0-bin-hadoop2/california-counties.json");
        featureClass = EsriFeatureClass.fromJson(iStream);

        System.out.println("Counties: "+featureClass.features.length);
    }

    private static int contains(Point pt){

        for (int i=0;i<featureClass.features.length;i++){
            if (GeometryEngine.contains(featureClass.features[i].geometry, pt, spatialReference)){
                return i;
            }
        }

        return -1;

    }

}
