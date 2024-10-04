import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static int T, N;
    static int[][] sng;
 
    static int[] mateNo; // 재료 번호 체크용 배열
    static int[] sel; // 뽑은 재료 저장
    static int[] sel2; // 남은 재료 저장
    static boolean[] use; // 사용 여부 확인
    static int answer; // 최소 시너지 차이 저장
 
    public static void main(String[] args) throws Exception {
 
        T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine());
 
            // 재료 번호 체크용 배열
            mateNo = new int[N];
            for (int i = 0; i < N; i++) {
                mateNo[i] = i;
            }
 
//          System.out.println("mateNo");
//          System.out.println(Arrays.toString(mateNo));
 
            // 재료간 시너지 배열
            sng = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sng[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
//          System.out.println("sng");
//          System.out.println(Arrays.deepToString(sng));
 
            // 조합
            sel = new int[N / 2];
            sel2 = new int[N / 2];
            use = new boolean[N];
            answer = Integer.MAX_VALUE;
 
            combination(0, 0);
            System.out.println("#" + tc + " " + answer);
 
        } // tc
 
    }// main
 
    // 조합
    public static void combination(int idx, int sidx) {
 
        // 기저 조건
        if (sidx == N / 2) {
            int s1 = 0;
            int s2 = 0;
 
            // sel2 배열 만들기
            Arrays.fill(use, false); // use 배열 초기화
            for (int i = 0; i < N / 2; i++) {
                use[sel[i]] = true;
            }
 
//          System.out.println(Arrays.toString(use));
 
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (!use[i]) {
                    sel2[index++] = i;
                }
            }
 
//          System.out.println(Arrays.toString(sel));
//          System.out.println(Arrays.toString(sel2));
//          System.out.println("-------");
 
            // 이 안에서도 조합?
            // A음식 (sel) ex) 0,1,3 // 어차피 이중 for문으로 가능하니까 그냥 for문으로 부분집합 구하기?
            // 시너지 총합 계산
            // A음식
            for (int i = 0; i < sel.length - 1; i++) {
                for (int j = i + 1; j < sel.length; j++) {
                    s1 += sng[sel[i]][sel[j]] + sng[sel[j]][sel[i]];
                    s2 += sng[sel2[i]][sel2[j]] + sng[sel2[j]][sel2[i]];
                }
 
            }
            // B음식
//          for (int i = 0; i < sel2.length - 1; i++) {
//              for (int j = i + 1; j < sel2.length; j++) {
//                  s2 += sng[sel2[i]][sel2[j]] + sng[sel2[j]][sel2[i]];
//              }
//
//          }
            answer = Math.min(answer, Math.abs(s1 - s2));
 
            // System.out.println(answer);
//                  s2 += sng[sel2[i]][sel2[j]] + sng[sel2[j]][sel2[i]];
//              System.out.println("s1 " + s1 + " s2 " + s2);
            return;
 
        }
 
        if (idx == N) {
            return;
        }
 
        // 재귀 조건
        sel[sidx] = mateNo[idx];
        combination(idx + 1, sidx + 1);
        combination(idx + 1, sidx);
 
    }
 
}