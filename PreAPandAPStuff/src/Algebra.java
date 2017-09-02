import java.util.Arrays;
import java.util.Scanner;


public class Algebra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();           			//total number of graphs to print
		
		for(int i = 0;i < total;i++){
			
			int size = sc.nextInt() * 10; 				//what is the size of one quadrant
			
			double a = sc.nextDouble()/20;				//what is a
			double b = sc.nextDouble()/2;				//what is b
			double c = sc.nextDouble()*5;				//what is c
			
			int[] x = new int[size];
			int[] y = new int[size];
			
			boolean nextHasHash = false;
			boolean noMoreHashes = false;
			int lastPos = 0;
			
			char[] line = new char[size];				//make the line			

			for(int k = 0; k < size; k++){				//make coordinates for every X
				x[k] = k;								//set the X to the X
				y[k] = (int)Math.round(size-			//find the y in relation to the X
				(a*(Math.pow(k,2))+(b*k)+(c)));													
			}	
			
			for(int d = 0;d < size;d++){				//set up the line 
				line[d] = '.';
				
			}
			
			
			
			
			
			
			
			
			for(int j = size/2; j < size; j++){ 		//print every row
				nextHasHash = false;
				if(j % 5 == 0){
					for(int s = 0;s < size;s++){ 		//make horizontal interval line unless its a hash
						if(line[s] == '.'){
						line[s] = '+';
						}
					}	
				}
				else{
					for(int s = 0;s < size;s++){ 		//change to normal line unless its a hash
						if(line[s] == '+'){
						line[s] = '.';
						}
					}
				}
				
				for( int r = 0; r < size; r++){			//check every column
					if(r % 10 == 0){					//change to plus if its on vertical interval column
						if(line[r] == '.'){
							line[r] = '+';
						}				
					}

					if(y[r] == j){						//change the correct one to a hash
						line[x[r]] = '#';
						lastPos = r;
					}
					if(y[r] == j + 1){					//look and see if the next line has a hash
						nextHasHash = true;				//set it to true if it does

					}
					
					
				}

				System.out.println(line);				//print out the line
				

				
				if(nextHasHash == true || noMoreHashes == true){//if the next row has a hash in it or no more hashes
					for(int d = 0;d < size;d++){				//set everything back
						line[d] = '.';
						
					}
				}
				else{											//check if there's any more
					
					if(lastPos != 0 && lastPos != size){
						if(y[lastPos - 1] <= j && y[lastPos + 1] <= j){
							noMoreHashes = true;							
							
							for(int d = 0;d < size;d++){				//set everything back
								line[d] = '.';
								
							}
							
						}

					}
						
				}
																	
			}

		}

	}

}
