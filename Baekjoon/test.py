T = int(input())

mat = [[0 for _ in range(100)] for _ in range(100)]
answer = 0

for t in range(T) :
    a, b = map(int, input().split())
    x = a - 1
    y = b - 1

    for i in range(x, x + 10):
        for j in range(y, y + 10):
            mat[i][j] = 1

for k in range(100):
    answer += sum(mat[k])

print(answer)
