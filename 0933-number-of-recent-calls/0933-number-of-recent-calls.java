class RecentCounter {


    int arr[] = {3000,0};
    Queue<Integer>q = new LinkedList<>();

    public RecentCounter() {
        q.clear();
    }
    
    public int ping(int t) {

        q.add(t);
        
        arr = new int[]{t - 3000, t};
    
        while(!q.isEmpty() && q.peek()<arr[0]){
            q.poll();
        }

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */