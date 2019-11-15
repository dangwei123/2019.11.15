有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。

现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是
由0结束

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
       while(i<bits.length-1){
            if(bits[i]==0){
                i++;
            }if(bits[i]==1){
                i+=2;
            }
        }
        return i==bits.length-1;
    }
}

回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。

 class Solution {
    public boolean isBoomerang(int[][] points) {
       int x1=points[0][0];
       int x2=points[1][0];
       int x3=points[2][0];
       int y1=points[0][1];
       int y2=points[1][1];
       int y3=points[2][1];
       return (x1*y2-x2*y1)+(x2*y3-x3*y2)+(x3*y1-x1*y3)!=0;
    }
}

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约
因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统
会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况
下，能够偷窃到的最高金额。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] res=new int[nums.length+1];
        res[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            res[i]=Math.max(res[i-2]+nums[i-1],res[i-1]);
        }
        return res[nums.length];
    }
}

如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。

给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/toeplitz-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
法一：
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int M=matrix.length;
        int N=matrix[0].length;
        for(int i=0;i<N;i++){
            int tmp=matrix[0][i];
            int x=1;
            int y=i+1;
            while(x<M&&y<N){
                if(matrix[x][y]!=tmp){
                    return false;
                }
                x++;
                y++;
            }
        }
        for(int i=1;i<M;i++){
            int tmp=matrix[i][0];
            int x=i+1;
            int y=1;
            while(x<M&&y<N){
                if(matrix[x][y]!=tmp){
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
}
法二：
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int M=matrix.length;
        int N=matrix[0].length;
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
