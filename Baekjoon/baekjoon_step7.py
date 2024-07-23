from pprint import pprint

# mat = []
# for i in range(9):
#     mat.append(list(map(int, input().split())))

# # pprint(mat)

# max = 0
# loc_i = 999
# loc_j = 999

# for i in range(9):
#     for j in range(9):
#         if mat[i][j] >= max : # 반례 : 모든 행렬이 0인 경우 주의
#             loc_i = i
#             loc_j = j
#             max = mat[i][j]

# print(max)
# print(loc_i+1, loc_j+1)


# ----------------------------------
# mat = []

# # 이차원 배열 생성
# for _ in range(5):
#     mat.append(list(input()))

# longest = 0

# # 각 리스트에서 제일 긴 리스트 뽑아내기
# for i in range(5):
#     if len(mat[i]) >= longest:
#         longest = len(mat[i])

# # 짧은 리스트에 공백 넣기
# for i in range(5):
#     if len(mat[i]) < longest:
#         for _ in range(longest-len(mat[i])):
#             mat[i].append(' ')

# str = ''
# # 글자 붙이기
# for j in range(longest):
#     for i in range(5):
#         str += mat[i][j]

# answer = str.replace(' ', '')

# print(answer)


# ------------------------------- 색종이
# T = int(input())

# 100*100짜리 배열이 있다고 생각하고 들어온 배열에 따라 0이 1으로 치환된다고 생각하기

a = 3
b = 7

mat = [[0 for _ in range(10)] for _ in range(10)]

pprint(mat)

x = a - 1
y = b - 1

for i in range(y, 10-y):
    for j in range(x, 10-x):
        mat[i][j] = 1

pprint(mat)