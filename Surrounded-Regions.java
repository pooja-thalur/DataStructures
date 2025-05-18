class Pair<U,V>{
    U first;
    V second;

    Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int rows = 0;
    public int cols = 0;
    public void solve(char[][] board) {
        if(board==null || board.length==0){
            return;
        }

        this.rows = board.length;
        this.cols = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<>();

        for(int i=0; i<rows; i++){
            borders.add(new Pair(i, 0));
            borders.add(new Pair(i,cols-1));
        }

        for(int j=0; j<cols; j++){
            borders.add(new Pair(0, j));
            borders.add(new Pair(rows-1, j));
        }

        //step2
        for(Pair<Integer, Integer> pair: borders){
            dfs(board, pair.first, pair.second);
        }

        //3
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }

                if(board[i][j]=='E'){
                    board[i][j]='O';
                }
            }
        }
    }

    void dfs(char[][] board, int r, int c){
        // if(i<0 || j<0 || i>board.length || j>board[0].length || board[i][j] == 'X'){
        //     return;
        // }

        if(board[r][c]!='O'){
            return ;
        }
        board[r][c]='E';

        if(c<cols-1){
            dfs(board, r, c+1);
        }
        if(r<rows-1){
            dfs(board, r+1, c);
        }

        if(r>0){
            dfs(board, r-1, c);
        }

        if(c>0){
            dfs(board, r, c-1);
        }
    }
}