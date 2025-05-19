class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // int n = firstList.length;
        // int m = firstList[0].length;
        ArrayList<int[]> res = new ArrayList<>();
        int i =0, j=0;
        while(i<firstList.length && j<secondList.length){
            // if(firstList[i][0]< secondList[i][0] && firstList[i][1]> secondList[i][1]){
                int low = Math.max(firstList[i][0], secondList[j][0]);
                int high = Math.min(firstList[i][1], secondList[j][1]);
                

                if(low<=high){
                    res.add(new int[]{low, high});
                }

                if(firstList[i][1]< secondList[j][1]){
                    i++;
                }
                else{
                    j++;
                }
            // }
        }

        return res.toArray(new int[res.size()][]);
    }
}