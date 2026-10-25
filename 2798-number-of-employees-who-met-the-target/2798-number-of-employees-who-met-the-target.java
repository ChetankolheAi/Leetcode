class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int countEmp = 0;
        for(int hoursWorked : hours) countEmp = (hoursWorked >= target)?countEmp+1:countEmp;
        return countEmp;
    }
}