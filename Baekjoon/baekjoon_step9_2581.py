M = int(input())
N = int(input())
lst = []
for num in range(M, N+1):
    if num > 1:
        is_prime = True
        for i in range(2, int(num**0.5) + 1):
            if num % i == 0:
                is_prime = False
                break
        if is_prime:
            lst.append(num)

if len(lst) == 0:
    print(-1)
else:
    print(sum(lst))
    print(min(lst))

# 런타임에러(Name Error)