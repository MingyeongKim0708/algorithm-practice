n = int(input())
lst = list(map(int, input().split()))

max_score = max(lst)
score = [0 for _ in range(n)]

sum = 0
for i in range (len(lst)) :
    score[i] = lst[i] / max_score * 100
    sum += score[i]

avg = sum / n

print(avg)