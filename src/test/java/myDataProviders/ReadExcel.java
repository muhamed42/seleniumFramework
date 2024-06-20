package myDataProviders;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.IOException;
import java.util.ArrayList;

public class ReadExcel {
    public static void main(String[] args) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("data/DataSample.xlsx");
        String strQuery="Select * from Sheet1";
        Recordset recordset=connection.executeQuery(strQuery);
        int rowCount = recordset.getCount();
        int columnCount = recordset.getFieldNames().size();
        ArrayList<String> fieldNames = recordset.getFieldNames();
//        while(recordset.next()){
//            System.out.println(
//                    recordset.getField("op1")+"\t"+
//                    recordset.getField("op")+"\t"+
//                    recordset.getField("op2")+"\t ="+
//                    recordset.getField("expected")
//            );
//        }

        String[][] data=new String[rowCount][columnCount];
        int rowIndex = 0;
//        recordset.moveFirst();
        while(recordset.next()){
            for(int colIndex=0; colIndex<columnCount; colIndex++){
                data[rowIndex][colIndex] = recordset.getField(colIndex).value();
            }
            rowIndex++;
        }

        recordset.close();
        connection.close();
    }

    public static String[][] getDataFromExcel(String file, String strQuery ) throws IOException, FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(file);
        Recordset recordset=connection.executeQuery(strQuery);

        int rowCount = recordset.getCount();
        int columnCount = recordset.getFieldNames().size();
        String[][] data=new String[rowCount][columnCount];//Create data object 2d array

        // Fill data from recordset into the data object
        int rowIndex = 0;
        while(recordset.next()){ //run for each row
            for(int colIndex=0; colIndex<columnCount; colIndex++){ //for each column
                //Set the value of the cell in the specified position.
                data[rowIndex][colIndex] = recordset.getField(colIndex).value();
            }
            rowIndex++;// go to next row index.
        }
        // close the connection, and recordset objects.
        recordset.close();
        connection.close();
        return data; //return the data object.
    }
}

