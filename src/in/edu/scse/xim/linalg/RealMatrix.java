package in.edu.scse.xim.linalg;

public interface RealMatrix extends AnyMatrix {

    RealMatrix createMatrix(int rowDimension, int columnDimension) throws NotStrictlyPositiveException;

    RealMatrix add(RealMatrix m) throws MatrixDimensionMismatchException;

    RealMatrix multiply(RealMatrix m) throws DimensionMismatchException;

    double getEntry(int row, int column) throws OutOfRangeException;
    
    void printMatrix();

}
