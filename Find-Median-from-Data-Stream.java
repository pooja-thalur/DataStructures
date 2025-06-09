class MedianFinder {
    PriorityQueue<Integer> lowElements;//max heap - stores lower valued elements
    PriorityQueue<Integer> highElements; // min heap - stores the higher valued elemnts

    public MedianFinder() {
        lowElements = new PriorityQueue<>((a, b)-> (b-a));
        highElements = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lowElements.add(num);
        highElements.add(lowElements.poll());
        if(lowElements.size()<highElements.size()){
            //add the element to low list
            lowElements.add(highElements.poll());
        }
        

    }
    
    public double findMedian() {
        return (lowElements.size() > highElements.size())? lowElements.peek() : (lowElements.peek() + highElements.peek())*0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */