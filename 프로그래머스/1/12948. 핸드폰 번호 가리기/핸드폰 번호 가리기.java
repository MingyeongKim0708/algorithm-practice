class Solution {
    public String solution(String phone_number) {
    	StringBuffer sb = new StringBuffer();
    	String str = phone_number;
    	int endIdx = str.length();
    	String answer = "";
    	for(int i = 0; i <str.length()-4; i++) {
    		sb.append("*");
    	}
    	
    	sb.append(str.substring(endIdx-4, endIdx));

    	answer = sb.toString();
    	System.out.println(answer);
        return answer;
    }
}