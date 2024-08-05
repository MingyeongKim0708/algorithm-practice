for _ in range (10):
    tc = int(input())

    arr = [list(map(int, input().split())) for _ in range(100)]

    row_sum = [0] * 100 # 행들의 합 리스트
    col_sum = [0] * 100 # 열들의 합 리스트
    dia_sum = 0 # 대각선의 합
    dia2_sum = 0 # 대각선2의 합

    # 가로
    for i in range(100):
        for j in range(100):
            row_sum[i] += arr[i][j]

    # 세로
    for j in range(100):
        for i in range(100):
            col_sum[j] += arr[i][j]

    # 대각선
    for x in range(100):
        dia_sum += arr[x][x]

    # 대각선2
    for y in range(99, -1, -1):
        dia2_sum += arr[y][99-y]

    answer = []
    answer.extend(row_sum)
    answer.extend(col_sum)
    answer.append(dia_sum)
    answer.append(dia2_sum)

    # 최대값 구하기
    result = max(answer)
    print(f'#{tc} {result}')