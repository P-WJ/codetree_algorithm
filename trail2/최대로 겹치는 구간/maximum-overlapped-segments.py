n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
arr = [0 for _ in range(201)]

min_x = min(segments)[0]
if min_x < 0:
    for a, b in segments:
        for i in range(a + abs(min_x), b + abs(min_x)):
            arr[i] += 1
else:
    for a, b in segments:
        for i in range(a, b):
            arr[i] += 1

print(max(arr))