n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

# Please write your code here.
offset = 100000
cur = offset

last = [0 for _ in range(2 * offset + 1)]

for i in range(n):
    if dir[i] == "L":
        while x[i] > 0:
            last[cur] = 1
            x[i] -= 1
            
            if x[i]:
                cur -= 1

    else:
        while x[i] > 0:
            last[cur] = 2
            x[i] -= 1

            if x[i]:
                cur += 1

w, b = 0, 0

for i in range(2 * offset + 1):
    if last[i] == 1:
        w += 1
    elif last[i] == 2:
        b += 1

print(w, b)