给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。

输入为三个整数：day、month 和 year，分别表示日、月、年。

您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
 "Friday", "Saturday"}。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/day-of-the-week
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] res={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        for(int i=1971;i<year;i++){
            if(leapYear(i)){
                sum+=366;
            }else{
                sum+=365;
            }
        }
        for(int i=1;i<month;i++){
            if(i==2&&leapYear(year)){
                sum+=29;
            }else{
                sum+=monthDay[i-1];
            }
        }
        sum+=day-1;
        return res[(sum+5)%7];
    }
    public boolean leapYear(int year){
        return (year%400==0)||(year%4==0&&year%100!=0);
    }
}

给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个
月的天数与现行公元纪年法（格里高利历）一致。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/day-of-the-year
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int dayOfYear(String date) {
        char[] arr=date.toCharArray();
        int[] monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
        int year=0;
        for(int i=0;i<4;i++){
            year+=(arr[i]-'0')*(int)Math.pow(10,3-i);
        }
        int month=0;
        for(int i=5;i<7;i++){
            month+=(arr[i]-'0')*(int)Math.pow(10,6-i);
        }
        int day=0;
        for(int i=8;i<10;i++){
            day+=(arr[i]-'0')*(int)Math.pow(10,9-i);
        }
        for(int i=1;i<month&&i<12;i++){
            if(i==2&&isLeapYear(year)){
                day+=29;
            }else { 
                day+=monthDay[i-1];
            }
        }
        return day;

    }
    public boolean isLeapYear(int year){
        return (year%400==0)||(year%4==0&&year%100!=0);
    }
}
环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距
离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distance-between-bus-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis=0;
        if(start>destination){
            int tmp=start;
            start=destination;
            destination=tmp;
        }
        while(start<destination){
            dis+=distance[start++];
        }
        int sum=0;
        for(int x:distance){
            sum+=x;
        }
        return Math.min(dis,sum-dis);
    }
}