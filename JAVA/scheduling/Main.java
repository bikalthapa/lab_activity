class ArrayOperation {
    // Constructor
    ArrayOperation() {
        // No initialization needed
    }

    // Method to find the smallest index
    int getSmallestIndx(int n, int[] arr) {
        int smallest = arr[0];
        int smallestIndx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndx = i;
            }
        }
        return smallestIndx;
    }

    int[] deleteElement(int n, int fromPos, int toPos, int[] arr) {
        // Check if fromPos and toPos are valid
        if (fromPos <= toPos && fromPos >= 0 && toPos < n) {
            // Calculate the new size of the array after deletion
            int newArraySize = n - (toPos - fromPos + 1); // Inclusive range, so +1
            int[] tempArray = new int[newArraySize];

            // Copy elements before 'fromPos' (unchanged)
            for (int i = 0; i < fromPos; i++) {
                tempArray[i] = arr[i];
            }

            // Copy elements after 'toPos' (skipping the deleted elements)
            for (int i = toPos + 1; i < n; i++) {
                tempArray[i - (toPos - fromPos + 1)] = arr[i];
            }

            return tempArray;
        } else {
            // Return an empty array if the positions are invalid
            return new int[0];
        }
    }

    // function that returns the sum of an array //
    int getSum(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Function to sort the array of the same size with reference array
    int[][] sortRefArray(int[] refArr, int[] arr1, int[]arr2, boolean isAsc) {
        if (refArr.length != arr1.length && refArr.length != arr2.length ) {
            return new int[0][0]; // Returning an empty 2D array if sizes don't match
        }

        int temp;

        // Sorting both arrays based on refArr
        for (int i = 0; i < refArr.length; i++) {
            for (int j = i + 1; j < refArr.length; j++) {
                if ((isAsc && refArr[i] > refArr[j]) || (!isAsc && refArr[i] < refArr[j])) {
                    // Swapping the refArr
                    temp = refArr[i];
                    refArr[i] = refArr[j];
                    refArr[j] = temp;

                    // Swapping the arr1
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;

                    // Swapping the arr2
                    temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        // Returning both arrays as a 2D array
        return new int[][]{refArr, arr1,arr2};
    }
}

class Scheduler extends ArrayOperation {
    int processLength;
    int[] process_id;
    int[] arrival_time;
    int[] burst_time;
    int[] completion_time;
    int[] turnaround_time;
    int[] waiting_time;

    // Constructor to initialize the Scheduler
    Scheduler(int length) {
        this.processLength = length;
    }

    // This function will set the values for the scheduler processes
    boolean setProcess(int[] processId, int[] arrivalTime, int[] burstTime) {
        // Ensure the two arrays are of the same length
        if (arrivalTime.length != burstTime.length && processId.length!=burstTime.length) {
            return false; // Return false if arrays have unequal lengths
        }
        this.arrival_time = arrivalTime;
        this.burst_time = burstTime;
        this.process_id = processId;
        return true;
    }

    //  Function to print the line for table
    void print_line(int w, String s){
        for (int j = 0; j <= w; j++) {
            System.out.print(s);
        }
        System.out.print("\n");
    }
    // Function to print the process table
    void print_table() {
        int table_width = 10;

        this.print_line(table_width, "__");
        System.out.println("p_id|   AT   |   BT  |"); // Print headers
        this.print_line(table_width, "__");
        for (int i = 0; i < this.processLength; i++) {
            System.out.println(this.process_id[i] + "   |   " + this.arrival_time[i] + "    |   " + this.burst_time[i] + "   |");
            this.print_line(table_width, "__");
        }

    }
}

class NonPreemptiveSchedule extends Scheduler {
    NonPreemptiveSchedule(int length) {
        super(length);
    }

    void applyFCFS() {
       int[][] shorted =  this.sortRefArray(this.arrival_time,this.burst_time,this.process_id,true);
       this.arrival_time = shorted[0];
       this.burst_time = shorted[1];
       this.process_id = shorted[2];
       this.print_table();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Scheduler with 4 processes
        NonPreemptiveSchedule np = new NonPreemptiveSchedule(4);

        // Define the processId, arrival and burst times
        int[] processId = {0, 1, 2, 3};
        int[] arrivalTime = { 1, 1, 5, 4 };
        int[] burstTime = { 4, 3, 2, 1 };

        // Set the processes using the arrival and burst times
        boolean result = np.setProcess(processId, arrivalTime, burstTime);
        if (result) {
            np.applyFCFS(); // Print the process table if the processes are set successfully
        } else {
            System.out.println("Error setting processes. Check the array lengths.");
        }
    }
}
