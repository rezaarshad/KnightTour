 # A Knight’s Tour 

 ## Algorithms
 ### Backtracking 
 If the steps reach i*j (step=i*j means all points marked as visited)  
       return true  
 Else  
    a) Peak one of the 8 moves and continue to find a Knight;s tour for this point  
    b) If the move chosen in the above step doesn't reach solution,   
    mark this move as unvisited and continue with alternative moves.  
    c) if none of the moves work return false  
    
 ### Warnsdorff
 Since this algorithm is a heuristic, it might not find a solution at the first try, so we need to retry until we find a solution.
 I have set maxRetry=1000 for this algorithm.
 
 1. Start with startingPoint  
 2. Mark the board at startingPoint with the move number “1”  
 3. Repeat these for each move from 2 to row*col 
     * let S be the set of positions accessible from P.  
     * Set P to be the position in S with minimum accessibility  
     * Mark the board at P with the current move number  
 4. Return the marked board 
 
 **Note: We might need to repeat algorithm multiple times until gets the solution. 
 
 ## References for Warnsdorff Algorithm
 1. [Knight's Tour](https://en.wikipedia.org/wiki/Knight%27s_tour)  
 2. https://www.geeksforgeeks.org/warnsdorffs-algorithm-knights-tour-problem/
 3. http://sites.science.oregonstate.edu/~math_reu/proceedings/REU_Proceedings/Proceedings2004/2004Ganzfried.pdf
 
 ## Run  tests: 
 In order to compile and run the project you need to have Java 8 and Maven.
 
 * mvn clean compile
 * mvn test
 
 ## Run project: 
 with default ChessBoard(10,10) and StartingPoint(0,0) and maxRetry =100 (for Warnsdorff)
 * mvn clean compile exec:java -Dexec.mainClass="com.tour.Main"
