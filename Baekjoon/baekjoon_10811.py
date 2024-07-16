n , m = map(int, input().split())

# n 수 만큼 0을 넣어서 초기화
basket = [0 for _ in range(n)]

for i in range (n) :
    basket[i] = i+1

for j in range (m) :
    a, b = map(int, input().split())
    temp = basket[a-1:b][::-1]
    # print(temp)

    basket = basket[:a-1] + temp + basket[b:]
    # print(basket)

print(' '.join(str(s) for s in basket))
