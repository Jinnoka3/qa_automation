package best.data_pool;

import data_model.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool {

    Collection<AccountData> accountData;

    public void processDataFile(String filePath){

        accountData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AccountData account = objectMapper.readValue( new File( filePath), AccountData.class );
            accountData.add( account );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {

        Object[][] data = new Object[ accountData.size() ][ 1 ];

        Iterator<AccountData> it = accountData.iterator();

        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }

}
