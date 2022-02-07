package oracle.interview.implementation;

import java.sql.SQLException;

import oracle.interview.metrics.MetricStorage;
import oracle.interview.metrics.MetricWriter;
import oracle.interview.metrics.TargetMetricsContainer;

public class MetricWriterImplementation implements MetricWriter {

    private final MetricStorage storage;

    public MetricWriterImplementation(MetricStorage storage) {
        this.storage = storage;
    }

    @Override
    public void writeMetricsContainer(TargetMetricsContainer metricsContainer) {
        boolean bError = true;
        do{
            try{
                storage.write(metricsContainer);
                bError = false;
            
              }
              catch (SQLException e) {
                e.printStackTrace();

            }
            }while(bError);  

       
    }
}
