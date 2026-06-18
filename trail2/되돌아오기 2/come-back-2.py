commands = input()

# Please write your code here.
dir = [[1,0],[0,-1],[-1,0],[0,1]]
d = 0
r, c = 0, 0
cnt = 0
ans = -1

for comm in commands:
    if comm == "L":
        d = (d+1) % 4
        cnt += 1

    elif comm == "R":
        d = (d-1) % 4
        cnt += 1

    elif comm == "F":
        r = r + dir[d][0]
        c = c + dir[d][1]
        cnt += 1
    
        if r == 0 and c == 0:
            ans = cnt
            break
        
print(ans)