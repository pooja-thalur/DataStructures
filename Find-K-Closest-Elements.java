class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> {
            int diff = Integer.compare(a[0], b[0]);;
            if(diff!=0){
                return diff;
            }

            return Integer.compare(arr[a[1]], arr[b[1]]);
        });
        for(int i=0; i <arr.length; i++){
            // if(arr[i]==x){
            //     continue;
            // }
            queue.offer(new int[]{Math.abs(arr[i]-x), i});
        }
        // queue.stream().forEach(a -> System.out.println(\ diff \+a[0]+\ val \+arr[a[1]]));
        List<Integer> res = new ArrayList<>();
        for(int i=k; i>0; i--){
            res.add(arr[queue.poll()[1]]);
        }

        Collections.sort(res);
        return res;

    }
}