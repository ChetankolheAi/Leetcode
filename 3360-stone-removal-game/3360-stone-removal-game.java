class Solution {
    public boolean canAliceWin(int n) {
        int x = 10;
        int j = 10;
        int len = 1;
        while(n>x){
            x += --j;
            len++;
        }

        if(len%2==0 && x==n || len%2==1 && x!=n )return false;
        else if(len%2==0 && x!=n || len%2==1 && x==n )return true;
        
        return false;
    }
}