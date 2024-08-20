class Solution {
    public boolean solution(int num) {
        boolean answer = true;
        int digitSum = 0;
        int num2 = num;
        while(num2 != 0) {
			int digit = num2 % 10;
			digitSum += digit;
			num2 /= 10;
			
		}
		// 하샤드 수 검사
		if(num % digitSum == 0) {
			answer = true;
		}else {
			answer = false;
		}
        return answer;
    }
}