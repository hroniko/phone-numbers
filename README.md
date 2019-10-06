# phone-numbers
Prototype for select List Of Phone For Continuous Range Size


1. Load all phones, distances and phone for range 5:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
[101, 102, 103, 104, 105, 106, 107]

2. Load all phones, distances and phone for range 2 after select 106:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[4, 3, 2, 1, 0, -1, -1, 3, 2, 1, 0]

3. Load all phones, distances and phone for range 2 after select 102:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[0, -1, -1, 1, 0, -1, -1, 3, 2, 1, 0]
[104, 108, 109, 110]

4. Load all phones, distances and phone for range 2 after increase range to 4:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[0, -1, -1, -1, -1, -1, -1, 3, 2, 1, 0]
[108, 109, 110]

5. Load all phones, distances and phone for range 2 after increase range to 3:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[0, -1, -1, -1, 0, -1, -1, 3, 2, 1, 0]
[108, 109, 110]

6. Load all phones, distances and phone for range 2 after unSelect current range:
[101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
[4, 3, 2, 1, 0, -1, -1, 3, 2, 1, 0]
[101, 102, 103, 104, 108, 109, 110]
