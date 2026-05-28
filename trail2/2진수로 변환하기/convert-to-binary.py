n = int(input())

# Please write your code here.
arr = []

while True:
    arr.append(n % 2)
    n = n // 2

    if n == 0:
        break

for i in arr[::-1]:
    print(i, end = "")