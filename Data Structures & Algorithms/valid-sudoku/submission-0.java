class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<HashSet<Integer>> rowLists = new ArrayList<>();
        List<HashSet<Integer>> columnLists = new ArrayList<>();
        List<ArrayList<HashSet<Integer>>> subGrids = new ArrayList<>();

        for(int i = 0; i<9;i++){
            rowLists.add(new HashSet<>());
            columnLists.add(new HashSet<>());
        }

        for(int i =0;i<3;i++){
            subGrids.add(new ArrayList<>());
            for(int j=0;j<3;j++){
                subGrids.get(i).add(new HashSet<>());
            }
        }

        for(int r = 0;r<board.length;r++){
            for(int c = 0;c<board[0].length;c++){
                if(board[r][c] == '.')
                    continue;
                Integer num = Integer.parseInt(String.valueOf(board[r][c]));
                if(rowLists.get(r).contains(num))
                    return false;
                if(columnLists.get(c).contains(num))
                    return false;
                if(subGrids.get(r/3).get(c/3).contains(num))
                    return false;
                rowLists.get(r).add(num);
                columnLists.get(c).add(num);
                subGrids.get(r/3).get(c/3).add(num);
            }
        }
    return true;  
    }
}
