n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

# Please write your code here.
white = [0] * 200001
black = [0] * 200001
last = [0] * 200001
cur = 100000

for i in range(n):
    if dir[i] == "L":
        
        for j in range(cur, cur - x[i], -1):
            white[j] += 1
            last[j] = 1
        cur -= x[i] - 1

    else:
        for j in range(cur, cur + x[i]):
            black[j] += 1
            last[j] = 2
        cur += x[i] - 1

white_cnt = 0
black_cnt = 0
gray_cnt = 0

for i in range(200001):
    if white[i] >= 2 and black[i] >= 2:
        gray_cnt += 1
    
    elif last[i] == 1:
        white_cnt += 1
    
    elif last[i] == 2:
        black_cnt += 1

print(white_cnt, black_cnt, gray_cnt)