n, t = tuple(map(int, input().split()))
x, y, c_dir = tuple(input().split())

mapper = {
    'R' : 0,
    'D' : 1,
    'U' : 2,
    'L' : 3
}

x, y, move_dir = int(x) - 1, int(y) - 1, mapper[c_dir]

dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]

def in_range(x, y):
    return 0 <= x and x < n and 0 <= y and y < n

for _ in range(t):
    nx, ny = x + dx[move_dir], y + dy[move_dir]

    if in_range(nx, ny):
        x, y = nx, ny

    else:
        move_dir = 3 - move_dir

print(x+1, y+1)