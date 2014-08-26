Calendar now = Calendar.getInstance();
println now.get(Calendar.DAY_OF_WEEK)
println("Current date : " + (now.get(Calendar.MONTH) + 1)
                        + "-"
                        + now.get(Calendar.DATE)
                        + "-"
                        + now.get(Calendar.YEAR));
   
//create an array of days
def strDays = ["Sunday","Monday","Tuesday","Wednesday", "Thusday","Friday","Saturday"]
   
//Day_OF_WEEK starts from 1 while array index starts from 0      
println("Current day is : " +strDays[now.get(Calendar.DAY_OF_WEEK)-1]);