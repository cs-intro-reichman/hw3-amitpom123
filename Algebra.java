// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(-2,-3));   // 2 + 3
	    System.out.println(minus(0,-2));  // 7 - 2
   		System.out.println(minus(2,-7));  // 2 - 7
 		System.out.println(times(-3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int resault = x1;
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				resault--;
			}
		} else if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				resault++;
			}
		} else {
			resault = x1;
		}
		return resault;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int resault = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				resault--;
			}
		} else if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				resault++;
			}
		} else {
			resault = x1;
		}
		return resault;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int resault = x1;
		if ((x1 == 0) || (x2 == 0)) {
			resault = 0;
		} else if (x1 == 1) {
			resault = x2;
		} else if (x2 == 1) {
			resault = x1;
		} else if (x1 == -1) {
			resault = -x2;
		} else if (x2 == -1) {
			resault = -x1;
		} else {
			if (x2 > 1) {
				// x2 is pos
				if (x1 > 1) {
					//x1 is also pos
					for (int i = 1; i < x2; i++) {
						resault = plus(resault, x1);
					}
				} else {
					//x1 is neg
					for (int i = 1; i < x2; i++) {
						resault = plus(resault, x1);
					}
				}
			} else {
				//x2 is neg
				if (x1 < -1) {
					//x1 is also neg
					for (int i = -1; i > x2; i--) {
						resault = plus(resault, x1);
					}
					resault = minus(0, resault);
				} else {
					//x1 is pos
					for (int i = -1; i > x2; i--) {
						resault = plus(resault, x1);
					}
					resault = minus(0, resault);
				}
			}
		}
		return resault;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int resault = 1;
		if (x == 1) {
			resault = 1;
		} else if (x == 0) {
			resault = 0;
		} else {
			for (int i = 0; i < n; i++) {
				resault = times(resault, x);
			}
		}
		return resault;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
		int count = 0;
		if (x2 == 1) {
			result = x1;
		} else if (x2 == 0) {
			result = -1;
		} else if (x1 == x2) {
			result = 1;
		} else if (x1 > x2) {
			int m = x2;
			while (m <= x1) {
				m = plus(m, x2);
				count++;
			}
			result = count;
		} else if (x1 > x2) {
			result = 0;
		} else if (x2 < 0 && x1 > 0) {
			int m = -x2;
			while (m <= x1) {
				m = plus(m, x2);
				count++;
			}
			result = -count;
		} else if (x2 > 0 && x1 < 0) {
			int m = x2;
			while (m <= -x1) {
				m = plus(m, x2);
				count++;
			}
			result = -count;
		} else {
			int m = -x2;
			while (m <= -x1) {
				m = plus(m, x2);
				count++;
			}
			result = count;
		}
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int a = div(x1, x2);
		int b = times(a, x2);
		int resault = minus(x1, b);
		return resault;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int resault = 0;
		if (x < 0) {
			resault = -1;
		} if (x == 0) {
			resault = 0;
		} else if (x == 1) {
			resault = 1;
		} else {
			int g = 1;
			while ((pow(g, 2) < x)) {
				g++;
			}
			resault = g;
		} 
		return resault;
	}	  	  
}