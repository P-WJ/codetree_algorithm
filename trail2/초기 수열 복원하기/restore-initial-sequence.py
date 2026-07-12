n = int(input())
adjacent = list(map(int, input().split()))

# Please write your code here.
for first in range(1, n + 1):
    arr = [0] * n
    visited = [False] * (n + 1)

    arr[0] = first
    possible = True

    # 첫 번째 숫자가 범위를 벗어나면 실패
    if visited[first]:
        continue
    visited[first] = True

    # 나머지 숫자 복원
    for i in range(1, n):
        arr[i] = adjacent[i - 1] - arr[i - 1]

        # 범위 검사
        if arr[i] < 1 or arr[i] > n:
            possible = False
            break

        # 중복 검사
        if visited[arr[i]]:
            possible = False
            break

        visited[arr[i]] = True

    if possible:
        print(*arr)
        break