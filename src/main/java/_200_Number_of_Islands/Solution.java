package _200_Number_of_Islands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public int numIslands(char[][] grid) {
    int num = 0;
    boolean[][] isVisit = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!isVisit[i][j] && grid[i][j] == '1') {
          bfs(grid, isVisit, i, j);
          num++;
        }
      }
    }
    return num;
  }

  private void bfs(char[][] grid, boolean[][] vis, int i, int j) {
    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(i, j));
    while (!queue.isEmpty()) {
      List<Position> nextBatch = new ArrayList<>();
      while (!queue.isEmpty()) {
        Position current = queue.poll();
        if (current.x > 0 && !vis[current.x - 1][current.y] && grid[current.x - 1][current.y] == '1') {
          vis[current.x - 1][current.y] = true;
          nextBatch.add(new Position(current.x - 1, current.y));
        }
        if (current.y > 0 && !vis[current.x][current.y - 1] && grid[current.x][current.y - 1] == '1') {
          vis[current.x][current.y - 1] = true;
          nextBatch.add(new Position(current.x, current.y - 1));
        }
        if (current.x < grid.length - 1 && !vis[current.x + 1][current.y] && grid[current.x + 1][current.y] == '1') {
          vis[current.x + 1][current.y] = true;
          nextBatch.add(new Position(current.x + 1, current.y));
        }
        if (current.y < grid[i].length - 1 && !vis[current.x][current.y + 1] && grid[current.x][current.y + 1] == '1') {
          vis[current.x][current.y + 1] = true;
          nextBatch.add(new Position(current.x, current.y + 1));
        }
      }
      queue.addAll(nextBatch);
    }
  }

  public static class Position {

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int x;
    public int y;
  }
}
