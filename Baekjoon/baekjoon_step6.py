# for i in range(5):
#     print(i)
#     if i%2==1:
#         i += 2
#         print(f'i 는 {i}')
    

# -----
from pprint import pprint

lst = []
new_lst = []

for i in range(20):
    lst.append(list(input().split()))
    lst[i][1] = float(lst[i][1])

    if lst[i][2] != 'P':
        new_lst.append(lst[i])

# pprint(lst)
# pprint(new_lst)
sum_hak = 0
subj = 0

for j in range(len(new_lst)):
    if new_lst[j][2] == 'A+':
        subj += new_lst[j][1] * 4.5
    elif new_lst[j][2] == 'A0':
        subj += new_lst[j][1] * 4.0
    elif new_lst[j][2] == 'B+':
        subj += new_lst[j][1] * 3.5
    elif new_lst[j][2] == 'B0':
        subj += new_lst[j][1] * 3.0
    elif new_lst[j][2] == 'C+':
        subj += new_lst[j][1] * 2.5
    elif new_lst[j][2] == 'C0':
        subj += new_lst[j][1] * 2.0
    elif new_lst[j][2] == 'D+':
        subj += new_lst[j][1] * 1.5
    elif new_lst[j][2] == 'D0':
        subj += new_lst[j][1] * 1.0
    elif new_lst[j][2] == 'F':
        subj += new_lst[j][1] * 0.0
    
    
    # 학점 총합
    sum_hak += new_lst[j][1]
    # print(f'학점 총합 : {sum_hak}')

# 학점 * 과목평점 합 / 학접 총합
result = subj / sum_hak
answer = "{:.6f}".format(result)

print(answer)
