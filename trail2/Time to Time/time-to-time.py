a, b, c, d = map(int, input().split())

# Please write your code here.
A = 0
B = 0
if c != 0:
    B = c * 60
B += d

if a != 0:
    A = a * 60
A += b

print(B-A)