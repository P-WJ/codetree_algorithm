import sys

n = int(input())
seat = list(input())

# Please write your code here.
empty = []
for i in range(n):
    if seat[i] == "0":
        empty.append(i)

ans = 0

for i in range(len(empty)):
    for j in range(i+1, len(empty)):
        tmp = seat[:]
        tmp[empty[i]] = "1"
        tmp[empty[j]] = "1"

        people = []

        for k in range(n):
            if tmp[k] == "1":
                people.append(k)

        min_d = sys.maxsize

        for a in range(len(people)):
            for b in range(a+1, len(people)):
                min_d = min(min_d, people[b] - people[a])

        ans = max(ans, min_d)

print(ans)