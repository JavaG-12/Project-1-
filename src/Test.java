import in.edu.scse.xim.linalg.RealMatrix;
import in.edu.scse.xim.linalg.impl.AbstractRealMatrix;
import in.edu.scse.xim.linalg.impl.DiagonalMatrix;

public class Test {

    public static void main(String[] args) {

        // REAL MATRIX ADDITION & MULTIPLICATION
        AbstractRealMatrix matrix1 = new AbstractRealMatrix(3, 3);
        AbstractRealMatrix matrix2 = new AbstractRealMatrix(3, 3);
        
        //System.out.println(matrix1.getRowDimension());
        //System.out.println(matrix1.getColumnDimension());
        //System.out.println(matrix1.isSquare());
        //System.out.println(matrix1.getEntry(1, 2));

        // Matrix Addition
        RealMatrix resultMatrix1 = matrix1.add(matrix2);
        
        // Matrix Multiplication
        //RealMatrix resultMatrix2 = matrix1.multiply(matrix2);
        
        System.out.println("Matrix 1##################");
        matrix1.printMatrix();

        System.out.println("Matrix 2##################");
        matrix2.printMatrix();

        System.out.println("Result Matrix##################");
        resultMatrix1.printMatrix();
        //resultMatrix2.printMatrix();



/*        
        // DIAGONAL MATRIX ADDITION & MULTIPLICATION
        DiagonalMatrix matrix1 = new DiagonalMatrix(3);
        DiagonalMatrix matrix2 = new DiagonalMatrix(3);
        
        // Matrix Addition
        RealMatrix resultMatrix1 = matrix1.add(matrix2);
        
        // Matrix Multiplication
        //RealMatrix resultMatrix2 = matrix1.multiply(matrix2);
        
        System.out.println("Matrix 1##################");
        matrix1.printMatrix();
        
        System.out.println("Matrix 2##################");
        matrix2.printMatrix();
        
        System.out.println("Result Matrix##################");
        resultMatrix1.printMatrix();
        //resultMatrix2.printMatrix();

*/

    }

}
