class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        HashSet<Integer> visitedIdx = new HashSet();
        int curIdx = 0;
        long score = 0;
        while(curIdx>=0 && curIdx<instructions.length && !visitedIdx.contains(curIdx)){
            // if(){
            //     break;
            // }
            visitedIdx.add(curIdx);
            if(instructions[curIdx].equals("jump")){
                curIdx+=values[curIdx];
            }
            else{
                
                score+=values[curIdx];
                curIdx++;
            }
        }

        return score;
    }
}