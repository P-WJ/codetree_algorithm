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

# => 각 배열의 교집합 구함(ex. [[1,4,2].[1,2]] -> [1,2]) => 교집합해서 나온 치즈를 먹은 사람들의 수.

sick_ch = []
for i in range(S):
    li = []
    for j in range(D):

        # sick_p(아픈사람)이 sick_t(아픈 시간)전에 먹은 치즈 각각 배열에 저장
        if p[j] == sick_p[i] and t[j] < sick_t[i]:  
            li.append(m[j])

    sick_ch.append(li)


# sick_ch의 교집합 구함
arr1 = []
for ch in sick_ch[0]:
    f = True
    
    for i in range(1, len(sick_ch)):
        if ch not in sick_ch[i]:
            f = False
            break

    if f:
        arr1.append(ch)


# 교집합 해서 나온 치즈를 먹은 사람의 수
arr = []
for i in range(D):
    if m[i] in arr1: 
        if p[i] not in arr:
            arr.append(p[i])

print(len(arr))