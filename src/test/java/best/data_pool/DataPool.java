package best.data_pool;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import data_model.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DataPool<T> {

    {
        accountData = new ArrayList<>();
    }

    public DataPool(String testParameterName, ITestContext testContext, Class<T> dataClass){
        fillNewDataPool(testParameterName, testContext, dataClass);
    }

    public void fillNewDataPool(String testParameterName , ITestContext testContext,  Class<T> dataClass){
        HashMap<String,String> parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());
        this.processDataFile( parameters.get(testParameterName), dataClass );
    }

    Collection<T> accountData;

    public void processDataFile(String filePath, Class<T> dataClass){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            T data = objectMapper.readValue( new File( filePath ), dataClass );
            accountData.add( data );
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {

        Object[][] data = new Object[ 1 ][ accountData.size() ];

        Iterator<T> it = accountData.iterator();


        int i = 0;
        while( it.hasNext() ) {
            data[0][ i ] = it.next();
            i++;
        }

        return data;
    }

}
