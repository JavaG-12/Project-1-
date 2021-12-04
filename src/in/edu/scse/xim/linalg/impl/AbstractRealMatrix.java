package in.edu.scse.xim.linalg.impl;

import in.edu.scse.xim.linalg.AnyMatrix;
import in.edu.scse.xim.linalg.DimensionMismatchException;
import in.edu.scse.xim.linalg.MatrixDimensionMismatchException;
import in.edu.scse.xim.linalg.NotStrictlyPositiveException;
import in.edu.scse.xim.linalg.OutOfRangeException;
import in.edu.scse.xim.linalg.RealMatrix;
import java.util.Scanner;

public class AbstractRealMatrix implements RealMatrix {

    protected int rowDimension, columnDimension;
    protected double[][] matrix;

    //Creates a matrix with no data
    public AbstractRealMatrix() {

    }

    //Create a new RealMatrix with the supplied row and column dimensions
    public AbstractRealMatrix(int rowDimension, int columnDimension) {
        //this.rowDimension = rowDimension;
        //this.columnDimension = columnDimension;

        createMatrix(rowDimension, columnDimension);
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
                    System.out.print("Enter value for [" + i + "," + j + "] : ");
                    matrix[i][j] = sc.nextDouble();
                }
            }
            
            System.out.println("End Input***********************************");
            
            return this;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    @Override
    public RealMatrix add(RealMatrix m) throws MatrixDimensionMismatchException {

        AbstractRealMatrix arm = (AbstractRealMatrix) m;
        
        AbstractRealMatrix resultMatrix = new AbstractRealMatrix();
        resultMatrix.rowDimension = this.rowDimension;
        resultMatrix.columnDimension = this.columnDimension;

        if (canAdd(m)) {
            double[][] c = new double[this.rowDimension][this.columnDimension];

            //adding and printing addition of 2 matrices
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    c[i][j] = this.getEntry(i, j) + arm.getEntry(i, j);
                    //System.out.print(c[i][j] + "\t");
                }
                //System.out.println();
            }

            resultMatrix.matrix = c;
        } else {
            throw new MatrixDimensionMismatchException("matrix size mismatch");
        }

        return resultMatrix;

    }

    @Override
    public RealMatrix multiply(RealMatrix m) throws DimensionMismatchException {

        AbstractRealMatrix arm = (AbstractRealMatrix) m;

        int columnDimensionOfFirstMatrix = this.getColumnDimension();
        int rowDimensionOfSecondMatrix = arm.getRowDimension();
        
        AbstractRealMatrix resultMatrix = new AbstractRealMatrix();
        resultMatrix.rowDimension = rowDimensionOfSecondMatrix;
        resultMatrix.columnDimension = columnDimensionOfFirstMatrix;

        if (canMultiply(m)) {

            double c[][] = new double[rowDimensionOfSecondMatrix][columnDimensionOfFirstMatrix];

            //multiplying and printing multiplication of 2 matrices    
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    c[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        c[i][j] += this.getEntry(i, k) * arm.getEntry(k, j);
                    }
                    //System.out.print(c[i][j] + "\t");
                }
                //System.out.println();
            }

            resultMatrix.matrix = c;
            
        } else {
            throw new DimensionMismatchException("Dimension mismatch");
        }

        return resultMatrix;

    }

    @Override
    public double getEntry(int row, int column) throws OutOfRangeException {
        if (row < this.getRowDimension() && column < this.getColumnDimension()) {
            return matrix[row][column];
        } else {
            throw new NotStrictlyPositiveException("Invalid row or column index");
        }
    }

    @Override
    public boolean canAdd(AnyMatrix other) {
        //AnyMatrix am = (AnyMatrix) other;

        return (this.getRowDimension() == other.getRowDimension() && this.getColumnDimension() == other.getColumnDimension());
    }

    @Override
    public boolean canMultiply(AnyMatrix other) {
        AnyMatrix am = (AnyMatrix) other;

        int columnDimensionOfFirstMatrix = this.getColumnDimension();
        int rowDimensionOfSecondMatrix = am.getRowDimension();

        return columnDimensionOfFirstMatrix == rowDimensionOfSecondMatrix;
    }

    @Override
    public int getColumnDimension() {
        return columnDimension;
    }

    @Override
    public int getRowDimension() {
        return rowDimension;
    }

    @Override
    public boolean isSquare() {
        return rowDimension == columnDimension;
    }

}
