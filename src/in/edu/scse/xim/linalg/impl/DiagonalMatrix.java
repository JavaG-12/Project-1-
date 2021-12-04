package in.edu.scse.xim.linalg.impl;

import in.edu.scse.xim.linalg.NotStrictlyPositiveException;
import in.edu.scse.xim.linalg.RealMatrix;
import java.util.Scanner;

public class DiagonalMatrix extends AbstractRealMatrix {

    //Creates a matrix with the supplied dimension
    public DiagonalMatrix(int dimension) {
        createMatrix(dimension, dimension);
    }

    @Override
    public RealMatrix createMatrix(int rowDimension, int columnDimension) throws NotStrictlyPositiveException {
        this.rowDimension = rowDimension;
        this.columnDimension = columnDimension;
        if (rowDimension <= 0 || columnDimension <= 0) {
            throw new NotStrictlyPositiveException("row or column dimension is not positive");
        } else {
            matrix = new double[rowDimension][columnDimension];

            System.out.println("Start Input***********************************");
            // reading matrix elements
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < rowDimension; i++) {
                for (int j = 0; j < columnDimension; j++) {
                    if (i == j) {
                        System.out.print("Enter value for [" + i + "," + j + "] : ");
                        matrix[i][j] = sc.nextDouble();
                    }
                }
            }
            
            System.out.println("End Input***********************************");
            
            return this;
        }
    }

}
