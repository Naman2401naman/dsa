import java.util.*;

class Robot {

    int width, height;
    int x = 0, y = 0;
    int dir = 0; // 0=East, 1=North, 2=West, 3=South

    // Directions: East → North → West → South
    int[][] directions = {
        {1, 0},   // East
        {0, 1},   // North
        {-1, 0},  // West
        {0, -1}   // South
    };

    String[] dirNames = {"East", "North", "West", "South"};

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
    int move = num % perimeter;

    // 🔥 EDGE CASE
    if (move == 0 && num > 0) {
        move = perimeter;
    }

    while (move-- > 0) {
        int nx = x + directions[dir][0];
        int ny = y + directions[dir][1];

        if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
            dir = (dir + 1) % 4;
            nx = x + directions[dir][0];
            ny = y + directions[dir][1];
        }

        x = nx;
        y = ny;
    }

    }

    public int[] getPos() {
        return new int[]{x, y}; // ✅ fixed
    }

    public String getDir() {
        return dirNames[dir];
    }
}