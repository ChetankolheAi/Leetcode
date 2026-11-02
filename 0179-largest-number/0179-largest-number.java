class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        for (int i = 0; i < strArr.length; i++) {
           System.out.print(strArr[i]+",");
        }
        
        if (strArr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();

        for (String s : strArr) {
            sb.append(s);
        }

        String ans = sb.toString();

        return ans;

    }
}