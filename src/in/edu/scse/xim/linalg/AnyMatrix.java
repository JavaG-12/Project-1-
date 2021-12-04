package in.edu.scse.xim.linalg;

public interface AnyMatrix {

    //Checks that this matrix and the other matrix can be added
    boolean canAdd(AnyMatrix other);

    //Checks that this matrix can be multiplied by the other matrix
    boolean canMultiply(AnyMatrix other);

    //Gets the number of columns
    int getColumnDimension();

    //Gets the number of rows
    int getRowDimension();

    //Indicates whether this is a square matrix
    boolean isSquare();

}
