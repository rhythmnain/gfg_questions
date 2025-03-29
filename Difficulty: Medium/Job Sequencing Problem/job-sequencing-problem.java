//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    static class Job {
        int deadline, profit, index;
        Job(int d, int p, int i) {
            this.deadline = d;
            this.profit = p;
            this.index = i;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Create Job objects
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i], i);
        }

        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // Job slots (index 0 to maxDeadline - 1)
        boolean[] slot = new boolean[maxDeadline];
        int totalProfit = 0, jobCount = 0;

        // Schedule jobs
        for (Job job : jobs) {
            // Find a free slot from job.deadline - 1 to 0
            for (int j = Math.min(job.deadline, maxDeadline) - 1; j >= 0; j--) {
                if (!slot[j]) { // Slot available
                    slot[j] = true;
                    totalProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends