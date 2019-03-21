public class MyClass {
    public static void main(String args[]) {
        int[] data = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765};
        // Max length of array items
        int maxItemLength = 0;
        for (int i=0; i<data.length; i++){
            int length = String.valueOf(data[i]).length();
            if (length > maxItemLength) {maxItemLength = length;}
        }
        // Prepare matrix
        int size = (int) Math.sqrt(data.length-1);
        size++;
        int[][] matrix = new int[size][size];
        // Find center
        int center = (size-1) / 2;
        // Fill matrix
        int x=center, y=center; // Initial coordinates
        int dx=0, dy=-1; // Initial direction
        int pos=0; // Element number
        int dist=0; // Initial distance
        while (pos<data.length) {
            // Step
            for (int k=0; k<dist; k++) {
                if (pos>=data.length) {break;}
                matrix[x][y] = data[pos];
                pos++;
                x+=dx;
                y+=dy;
            }
            // Clocwise turn
            int temp = -dx;
            dx = dy;
            dy = temp;
            // Step
            for (int k=0; k<dist; k++) {
                if (pos>=data.length) {break;}
                matrix[x][y] = data[pos];
                pos++;
                x+=dx;
                y+=dy;
                
            }
            // Clocwise turn
            int t = -dx;
            dx = dy;
            dy = t;
            dist++;
        }
        // Print matrix
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.printf("| %"+ maxItemLength+"d |",matrix[i][j]);
            }   
            System.out.print("\n\n");
        }
    }
}
