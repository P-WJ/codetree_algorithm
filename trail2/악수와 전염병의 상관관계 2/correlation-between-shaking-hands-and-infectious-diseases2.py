N, K, P, T = map(int, input().split())
handshakes = [tuple(map(int, input().split())) for _ in range(T)]

handshakes.sort()

adic = [0 for _ in range(N+1)]
adic[P] = 1
cnt = [0 for _ in range(N+1)]

for i in range(T):
    x_case = False
    y_case = False
    # x만 감염자
    if adic[handshakes[i][1]] and cnt[handshakes[i][1]] < K:
        cnt[handshakes[i][1]] += 1
        x_case = True

    
    # y만 감염자
    if adic[handshakes[i][2]] and cnt[handshakes[i][2]] < K:
        cnt[handshakes[i][2]] += 1
        y_case = True

    if x_case:
        adic[handshakes[i][2]] = 1

    if y_case:
        adic[handshakes[i][1]] = 1



for i in range(1, len(adic)):
    print(adic[i], end="")