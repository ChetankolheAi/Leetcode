class RecentCounter {


    int arr[] = {3000,0};
    Queue<Integer>q = new LinkedList<>();
    int num = 0;
    public RecentCounter() {

    }
    
    public int ping(int t) {
        q.add(t);
        

        arr = new int[]{t - 3000, t};
        System.out.println(" ,"+arr[0]);
        while(!q.isEmpty() && q.peek()<arr[0]){
            q.poll();
        }
        num = t;
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */