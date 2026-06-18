n, t = map(int, input().split())
r, c, d = input().split()
r, c = int(r), int(c)

# Please write your code here.

for i in range(t):

    if d == "D":
        r += 1

        if r == n+1:
            r = n
            d = "U"
    
    elif d == "U":
        r -= 1

        if r == 0:
            r = 1
            d = "D"
            
    elif d == "R":
        c += 1

        if c == n+1:
            c = n
            d = "L"
    
    elif d == "L":
        c -= 1

        if c == 0:
            c = 1
            d = "R"

print(r, c)
