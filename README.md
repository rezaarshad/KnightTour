# A Knight’s Tour

## Algorithms

### Backtracking
1. If the steps reach i*j (step=i*j means all points marked as visited), return true.
2. Otherwise:
    a) Pick one of the 8 possible knight moves and continue trying to find a Knight’s tour from that point.
    b) If the chosen move doesn't lead to a solution, mark the move as unvisited and try an alternative move.
    c) If none of the moves work, return false.

### Warnsdorff’s Algorithm
Warnsdorff's algorithm is a heuristic and might not find a solution on the first try. The algorithm retries until a solution is found. The `maxRetry` is set to 1000.

1. Start at the given `startingPoint`.
2. Mark the board at `startingPoint` with move number “1.”
3. For each move from 2 to `row*col`:
    * Let S be the set of positions accessible from the current point P.
    * Set P to be the position in S with minimum accessibility (least number of onward moves).
    * Mark the board at P with the current move number.
4. Return the marked board.

**Note**: You might need to retry the algorithm multiple times to find a solution.

## References for Warnsdorff's Algorithm
1. [Knight's Tour](https://en.wikipedia.org/wiki/Knight%27s_tour)
2. [GeeksforGeeks - Warnsdorff's Algorithm](https://www.geeksforgeeks.org/warnsdorffs-algorithm-knights-tour-problem/)
3. [Oregon State University Research Paper](http://sites.science.oregonstate.edu/~math_reu/proceedings/REU_Proceedings/Proceedings2004/2004Ganzfried.pdf)

## Running Tests

To compile and run the project, ensure you have Java 8 and Maven installed.

```bash
mvn clean compile
mvn test
mvn clean compile exec:java -Dexec.mainClass="com.tour.Main"


