class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair> zeroPairs = new ArrayList<Pair>();
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    zeroPairs.add(new Pair(i,j));
                }
            }
        }

        //for each pair - make that row, col 0
        for(Pair zeroPair: zeroPairs){
            int row = zeroPair.i;
            int col = zeroPair.j;
            for(int c=0; c<n; c++){
                matrix[row][c] = 0;
            }

            for(int r=0; r<m; r++){
                matrix[r][col] = 0;
            }
        }
    }
}

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}