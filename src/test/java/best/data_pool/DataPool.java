package best.data_pool;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import data_model.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool<T> {

    Collection<T> accountData;

    public void processDataFile(String filePath, Class<T> clazz){

        accountData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T account = (T) objectMapper.readValue(new File(filePath), clazz);
            accountData.add(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {

        Object[][] data = new Object[ accountData.size() ][ 1 ];

        Iterator<T> it = accountData.iterator();


        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }

}
