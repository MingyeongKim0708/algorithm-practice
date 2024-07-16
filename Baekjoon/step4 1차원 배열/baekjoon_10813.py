# n 바구니 수
# m 공을 넣는 횟수
n, m = map(int, input().split())

# n 수 만큼 0을 넣어서 초기화
lst = [0 for _ in range(n)]

# 바구니에 공 넣기
for i in range(n):
    lst[i] = i+1

for i in range(m) :
    b1, b2 = map(int,input().split())
    a = b1-1
    b = b2-1
    temp = lst[a]
    lst[a] = lst[b]
    lst[b] = temp

# 문자열 변환
answer = ' '.join(str(s) for s in lst)
print(answer)