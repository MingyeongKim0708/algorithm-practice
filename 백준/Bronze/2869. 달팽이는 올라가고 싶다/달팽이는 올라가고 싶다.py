A, B, V = map(int, input().split())

goal = 0
day = 1

day1 = V - A
day_add = day1 // (A - B)
day_else = 0

if day1 % (A-B) > 0:
    day_else = 1

day = day + day_add + day_else


print(day)