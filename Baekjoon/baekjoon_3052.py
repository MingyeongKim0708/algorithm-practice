import sys
numbers = []
rest = []

for i in range (10):
    numbers.append(int(sys.stdin.readline()))
    rest.append(numbers[i] % 42)

print(len(set(rest)))
