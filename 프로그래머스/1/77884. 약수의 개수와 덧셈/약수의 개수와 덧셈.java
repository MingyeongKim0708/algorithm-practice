import java.util.ArrayList;
class Solution {
    public int solution(int left, int right) {
    	int answer = 0;
    	for(int i = left; i <= right; i++) {
    		ArrayList<Integer> arr = new ArrayList<>();
    		// 약수 찾기는 제곱근까지만 반복문을 돌면 됨
    		for(int j = 1; j<= Math.sqrt(i); j++) {
    			if (i % j == 0) {
    				// 자기 자신이 약수 짝이 아닐 경우 짝도 리스트에 추가
    				if(i / j != j) {
    					arr.add(j);
    					arr.add(i/j);    					
    				}else {
    					arr.add(j);
    				}
    			}
    		}
    		if(arr.size() % 2 == 0) {
    			answer += i;
    		}else {
    			answer -= i;
    		}
    		
    	}
    	
        return answer;
    }
}