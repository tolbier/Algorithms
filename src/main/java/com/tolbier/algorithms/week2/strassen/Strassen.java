package com.tolbier.algorithms.week2.strassen;

public class Strassen {
	protected static int[][] multiply(int[][] x, int[][] y) {
		int n = x.length;
		if (n==1) return new int[][]{{x[0][0]*y[0][0]}};
		int[][] a = subMatrix(x,0,0),
				b = subMatrix(x,1,0),
				c = subMatrix(x,0,1),
				d = subMatrix(x,1,1),
				e = subMatrix(y,0,0),
				f = subMatrix(y,1,0),
				g = subMatrix(y,0,1),
				h = subMatrix(y,1,1);
		int[][] p1 = multiply(a,subtract(f,h)),
				p2 = multiply(sum(a,b),h),
				p3 = multiply(sum(c,d),e),
				p4 = multiply(d,subtract(g,e)),
				p5 = multiply(sum(a,d),sum(e,h)),
				p6 = multiply(subtract(b,d),sum(g,h)),
				p7 = multiply(subtract(a,c),sum(e,f));

		int[][] ap = sum(subtract(sum(p5 ,p4),p2),p6), 
				bp = sum(p1,p2),
				cp = sum(p3,p4),
				dp = subtract(subtract(sum(p1 ,p5),p3),p7);
		
		
		int[][] p = new int[n][n] ;
		join(p,ap,0,0);
		join(p,bp,1,0);
		join(p,cp,0,1);
		join(p,dp,1,1);

		return p;
	}
	protected static int[][] join(int[][] p, int[][] x,int ip,int jp) {
		int n = p.length;

		int iOffset= (ip * n) / 2, jOffset= (jp * n) / 2;
		for (int j = 0; j < n / 2; j++) {
			for (int i = 0; i < n / 2; i++) {
				p[j+ jOffset][i+ iOffset] = x[j][i];
			}
		}
		return p;
	}
	protected static int[][] sum(int[][] x, int[][] y) {
		int n = x.length;
		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum[i][j] = x[i][j] + y[i][j];
			}
		}
		return sum;
	}

	public static int[][] subtract(int[][] x, int[][] y) {
		int n = x.length;
		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum[i][j] = x[i][j] - y[i][j];
			}
		}
		return sum;
	}

	public static int[][] subMatrix(int[][] x, int ix, int jx) {
		int n = x.length;

		int[][] submatrix = new int[n / 2][n / 2];
		int iOffset= (ix * n) / 2, jOffset= (jx * n) / 2;
		for (int j = 0; j < n / 2; j++) {
			for (int i = 0; i < n / 2; i++) {
				submatrix[j][i] = x[j + jOffset][i + iOffset];
			}
		}
		return submatrix;
	}
}
