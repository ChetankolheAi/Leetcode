class Solution {
public:
    bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        int x1 = rec1[0];
        int x2 = rec1[1];
        int x3 = rec1[2];
        int x4 = rec1[3];
        int y1 = rec2[0];
        int y2 = rec2[1];
        int y3 = rec2[2];
        int y4 = rec2[3];


        if(x1>=y3 || x2>=y4 || y1>=x3 || y2>=x4){
           
            return  false;
            
        }
   
        return true;
    }
};