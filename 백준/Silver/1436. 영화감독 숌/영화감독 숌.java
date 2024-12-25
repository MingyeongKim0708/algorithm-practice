
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력받은 N이 1이면 첫 번째 숫자 666을 출력하고 종료
        if (N > 1) {
            func(N); // N번째 영화 제목 숫자를 찾는 함수 호출
        } else {
            System.out.println(666); // 첫 번째 숫자 666
        }
    }

    public static void func(int n) {
        int count = 1; // 현재까지 찾은 '666' 숫자의 개수 (처음엔 666만 찾음)
        int prev_digit = 0; // '666' 앞부분 (선수 자릿수)
        int num = 0; // '666' 뒷부분 (남은 자릿수)

        while (true) {
            /*
             * CASE 1: prev_digit이 X...666X (ex. 6660_000, 6660_001) 
             * -> 뒷부분(num)을 0~999까지 증가시킴
             */
            if (((prev_digit % 10000) / 10) == 666 && prev_digit % 10 != 6) {
                for (int i = 0; i < 1000; i++) {
                    if (count == n) { // N번째 숫자를 찾으면 출력
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    num++; // 뒷부분 증가
                    count++; // 찾은 개수 증가
                }
                prev_digit++; // 선수 자릿수 증가
            }

            /*
             * CASE 2: prev_digit이 X...666 (ex. 666_000, 1666_001) 
             * -> 뒷부분(num)을 0~999까지 증가시킴
             */
            else if (prev_digit % 1000 == 666) {
                num = 0; // 뒷부분 초기화
                for (int i = 0; i < 1000; i++) {
                    if (count == n) { // N번째 숫자를 찾으면 출력
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    count++; // 찾은 개수 증가
                    num++; // 뒷부분 증가
                }
                prev_digit++; // 선수 자릿수 증가
            }

            /*
             * CASE 3: prev_digit이 X...66 (ex. 66_600, 166_604)
             * -> 뒷부분(num)을 600~699까지 증가시킴
             */
            else if (prev_digit % 100 == 66) {
                num = 600; // '666'을 포함하려면 600부터 시작
                for (int i = 0; i < 100; i++) {
                    if (count == n) { // N번째 숫자를 찾으면 출력
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    count++; // 찾은 개수 증가
                    num++; // 뒷부분 증가
                }
                prev_digit++; // 선수 자릿수 증가
            }

            /*
             * CASE 4: prev_digit이 X...6 (ex. 6_660, 16_662)
             * -> 뒷부분(num)을 660~669까지 증가시킴
             */
            else if (prev_digit % 10 == 6) {
                num = 660; // '666'을 포함하려면 660부터 시작
                for (int i = 0; i < 10; i++) {
                    if (count == n) { // N번째 숫자를 찾으면 출력
                        System.out.print(prev_digit * 1000 + num);
                        return;
                    }
                    num++; // 뒷부분 증가
                    count++; // 찾은 개수 증가
                }
                prev_digit++; // 선수 자릿수 증가
            } 

            /*
             * CASE 5: 그 외 경우 (ex. 2, 3, 241_666, 23_666)
             * -> 뒷부분(num)을 666으로 설정
             */
            else {
                num = 666; // 기본적으로 '666'을 포함하는 숫자
                if (count == n) { // N번째 숫자를 찾으면 출력
                    System.out.print(prev_digit * 1000 + num);
                    return;
                }
                count++; // 찾은 개수 증가
                prev_digit++; // 선수 자릿수 증가
            }
        }
    }
}

// 브루트포스를 쓰면 오래 걸리지만 로직은 간단해진다...
