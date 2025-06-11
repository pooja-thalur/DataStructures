class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }

        // put it in pq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int f: freq){
            if(f>0){
                pq.offer(f);
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> store = new ArrayList();
            int cycle = n+1;
            int taskCount = 0;

            while(cycle-->0 && !pq.isEmpty()){
                int fre = pq.poll();
                if(fre>1){
                    store.add(fre-1);
                }
                
                taskCount++;
            }

            //put the store back
            store.forEach(pq::offer);

            time+= (pq.isEmpty()?taskCount: n+1);
        }
        return time;
    }
}