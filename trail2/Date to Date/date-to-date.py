m1, d1, m2, d2 = map(int, input().split())

# Please write your code here.
day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

ans = sum(day[m1: m2])

print(ans - d1 + 1 + d2)