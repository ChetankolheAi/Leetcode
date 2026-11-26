class ProductOfNumbers {
    List<Integer>li;

    public ProductOfNumbers() {
        li =  new ArrayList<>();
    }
    
    public void add(int num) {
        li.add(num);
    }
    
    public int getProduct(int k) {
        int i = li.size()-1;
        int ans = 1;
        int count = 0;
        while(count<k){
            ans *= li.get(i);
            i--;
            count++;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */