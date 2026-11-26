class Solution {
    public boolean canAliceWin(int n) {
        int x = 10;
        int j = 10;
        int len = 1;
        while(n>x){
            x += --j;
            len++;
        }
        System.out.println(x+","+len);
        if(len%2==0 && x==n )return false;
        else if(len%2==0 && x!=n )return true;
        else if(len%2==1 && x==n )return true;
        else if(len%2==1 && x!=n )return false;
        else return false;
    }
}