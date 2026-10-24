class Solution {
    public int getDateNumber(int starIndex , int endIndex , String str){
        return Integer.parseInt(str.substring(starIndex,endIndex));
    }
    public int CountNumberOfDatesinRange(String Start , String End){

        Map<Integer,Integer>Dates = new HashMap<>();
        Dates.put(1,31);
        Dates.put(2,28);
        Dates.put(3,31);
        Dates.put(4,30);
        Dates.put(5,31);
        Dates.put(6,30);
        Dates.put(7,31);
        Dates.put(8,31);
        Dates.put(9,30);
        Dates.put(10,31);
        Dates.put(11,30);
        Dates.put(12,31);
        System.out.println(Start);
        System.out.println(End);

        int NoOfDays = 0;
        int StartMonth = getDateNumber(0,2,Start);
        int StartDate =  getDateNumber(3,5,Start);
        
        int EndMonth = getDateNumber(0,2,End);
        int EndDate =  getDateNumber(3,5,End);

        if(StartMonth == EndMonth){
            NoOfDays = EndDate - StartDate + 1;
        }
        else{
            int StartMonthDays = Dates.get(StartMonth)-StartDate + 1;
            int EndMonthDays = EndDate;
            
            for(int i=StartMonth+1 ; i<EndMonth;i++){
                NoOfDays += Dates.get(i);
            }
            NoOfDays += StartMonthDays;
            NoOfDays += EndMonthDays;
            
        }
        return NoOfDays;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        // Max of Alice and Bob  // Enter Date
        int AliceInMonth = getDateNumber(0,2,arriveAlice);
        int AliceInDate =  getDateNumber(3,5,arriveAlice);
        
        int BobInMonth = getDateNumber(0,2,arriveBob);
        int BobInDate =  getDateNumber(3,5,arriveBob);

        String StartDate ;

         //Select Alice In Month
        if(AliceInMonth > BobInMonth) StartDate = arriveAlice;
        //Select BobInMonth
        else if(AliceInMonth <  BobInMonth) StartDate = arriveBob;
        //Here Both In Months Are Same
        //Comapre Dates
        else
            //Select Alice In Date as start date
            if(AliceInDate > BobInDate) StartDate = arriveAlice;
            //Select Bob In Date as Start Date
            else    StartDate = arriveBob;
        

        
        int AliceOutMonth = getDateNumber(0,2,leaveAlice);
        int AliceOutDate = getDateNumber(3,5,leaveAlice);
        
        int BobOutMonth = getDateNumber(0,2,leaveBob);
        int BobOutDate = getDateNumber(3,5,leaveBob);

        String EndDate ;

         //Select Alice In Month
        if(AliceOutMonth < BobOutMonth) EndDate = leaveAlice;
        //Select BobInMonth
        else if(AliceOutMonth >  BobOutMonth) EndDate = leaveBob;
        //Here Both In Months Are Same
        //Comapre Dates
        else
        
            //Select Alice In Date as start date
            if(AliceOutDate < BobOutDate) EndDate = leaveAlice;
            //Select Bob In Date as Start Date
            else    EndDate = leaveBob;
        
        if(AliceOutMonth < BobInMonth || BobOutMonth < AliceInMonth) return 0;
        else if(AliceOutMonth == BobInMonth){
            if(AliceOutDate < BobInDate) return 0;
        }
        else if(AliceInMonth == BobOutMonth){
            if(BobOutDate < AliceInDate) return 0;
        }
          
       
        return CountNumberOfDatesinRange(StartDate , EndDate);

    }
}