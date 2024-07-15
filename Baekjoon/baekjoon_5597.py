import sys 
A = [] # 제출한 학생
B = [] # 미제출 학생
n = 0

# 제출한 학생
for i in range(28):
    C = int(sys.stdin.readline())
    A.append(C)

for i in range(30):
    n += 1
    D = A.count(n) # n이 있으면 D에 1으로 들어감

    if D == 0:
        B.append(n)
        B.sort()

print(B[0])
print(B[1])