N, M, D, S = map(int, input().split())

p, m, t = [], [], []
for _ in range(D):
    person, milk, time = map(int, input().split())
    p.append(person)
    m.append(milk)
    t.append(time)

sick_p, sick_t = [], []
for _ in range(S):
    person, time = map(int, input().split())
    sick_p.append(person)
    sick_t.append(time)

# Please write your code here.

# sick_p(아픈사람)이 sick_t(아픈 시간)전에 먹은 치즈 => 이 치즈 먹은 사람들 몇명?

sick_ch = [] # 상한 치즈

for i in range(S):
    li = []
    for j in range(D):

        if p[j] == sick_p[i] and t[j] < sick_t[i]: 
            li.append(m[j])

    sick_ch.append(li)

arr1 = []

for ch in sick_ch[0]:
    f = True
    
    for i in range(1, len(sick_ch)):
        if ch not in sick_ch[i]:
            f = False
            break

    if f:
        arr1.append(ch)

arr = []

for i in range(D):
    if m[i] in arr1: 
        if p[i] not in arr:
            arr.append(p[i])

print(len(arr))
