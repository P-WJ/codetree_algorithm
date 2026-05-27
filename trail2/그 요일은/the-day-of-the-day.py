m1, d1, m2, d2 = map(int, input().split())
A = input()

# Please write your code here.

day = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
a = sum(day[:m1]) + d1
b = sum(day[:m2]) + d2

diff = b - a

if A in week[:diff % 7 + 1]:
    print(diff // 7 + 1)
else:
    print(diff // 7)
