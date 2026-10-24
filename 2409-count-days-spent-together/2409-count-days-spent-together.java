class Solution {
    public int CountNumberOfDatesinRange(String Start , String End){

        int NoOfDays = 0;
        int StartMonth = Integer.parseInt(Start.substring(0,2));
        int StartDate = Integer.parseInt(Start.substring(3,5));
        
        int EndMonth = Integer.parseInt(End.substring(0,2));
        int EndDate = Integer.parseInt(End.substring(3,5));

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

        if(StartMonth == EndMonth){
            NoOfDays = EndDate - StartDate + 1;
        }
        else{
            int StartMonthDays = Dates.get(StartMonth)-StartDate + 1;
            int EndMonthDays = EndDate;
        System.out.println(StartMonthDays);
        System.out.println(EndMonthDays);
            
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
        int AliceInMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int AliceInDate = Integer.parseInt(arriveAlice.substring(3,5));
        
        int BobInMonth = Integer.parseInt(arriveBob.substring(0,2));
        int BobInDate = Integer.parseInt(arriveBob.substring(3,5));

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
        

        
        int AliceOutMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int AliceOutDate = Integer.parseInt(leaveAlice.substring(3,5));
        
        int BobOutMonth = Integer.parseInt(leaveBob.substring(0,2));
        int BobOutDate = Integer.parseInt(leaveBob.substring(3,5));

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