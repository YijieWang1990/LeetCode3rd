package _739_Daily_Temperatures;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    PriorityQueue<TemperatureIndex> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.temperature));
    priorityQueue.add(new TemperatureIndex(temperatures[0], 0));
    int[] result = new int[temperatures.length];
    for (int i = 1; i < temperatures.length; i++) {
      while (!priorityQueue.isEmpty() && priorityQueue.peek().temperature < temperatures[i]) {
        TemperatureIndex poll = priorityQueue.poll();
        result[poll.index] = i - poll.index;
      }
      priorityQueue.add(new TemperatureIndex(temperatures[i], i));
    }
    return result;
  }

  public static class TemperatureIndex{
    int temperature;

    int index;

    public TemperatureIndex(int temperature, int index) {
      this.temperature = temperature;
      this.index = index;
    }
  }
}