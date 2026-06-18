dirs = input()

# Please write your code here.

dir = [[0, 1], [-1, 0], [0, -1], [1, 0]] # N, W, S, E
x,y = 0, 0
f_d = 0

for d in dirs:
    if d == "L":
        f_d += 1
        if f_d == 4:
            f_d = 0
    
    elif d == "R":
        f_d -= 1
        if f_d == -1:
            f_d = 3
    
    elif d == "F":
        x += dir[f_d][0]
        y += dir[f_d][1]

print(x, y)