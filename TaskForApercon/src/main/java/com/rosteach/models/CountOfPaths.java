/**
 * @author Pavlenko R.A.
 * this class describe the algorithm of our count of path calculation
 * input parameters are the sides of our matrix(mXn)
 */
package com.rosteach.models;

public class CountOfPaths {

	public String countOfPath(int m, int n){
		System.out.println("Input parameters: ["+m+"]  ["+n+"]");
		int [][] matrix= new int [m][n];
		// Count of paths to reach any cell in first column is 1
		for (int i = 0; i < m; i++){
			matrix[i][0] = 1;
		}
		// Count of paths to reach any cell in first line is 1
		for (int j = 0; j < n; j++){
			matrix[0][j] = 1;
		}
		// Calculate count of paths for other cells in bottom-up manner using
		// the recursive solution
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
				// By uncommenting the last part the code calculates the total
				// possible paths if the diagonal Movements are allowed
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]; //+ count[i-1][j-1];
		}
		return matrix[m-1][n-1]+"";
	}
}
