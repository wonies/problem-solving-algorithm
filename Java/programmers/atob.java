package programmers;// BOJ 16953 | A->B
import java.io.*;
// import java.util.*;

public class atob {

   static int target;
   static int res = -1;

   public static void dfs(long num, int cnt) {
      if (num > target){
         return ;
      }
      else if (num == target) {
         if (res == -1) {
            res = cnt;
         }
         else
         {
            res = Math.min(res, cnt);
         }
      }
      
      dfs(num * 2, cnt + 1);
      dfs(num * 10 + 1, cnt + 1);
   }
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String[] line = br.readLine().split(" ");
      int origin  = Integer.parseInt(line[0]);
      target  = Integer.parseInt(line[1]);
      
      dfs(origin, 0);
      // bw.write(origin + " " + target + "\n");
      if (res == -1)
         bw.write(res + "");
      else
         bw.write(res + 1 + "");
      bw.flush();
   }
}