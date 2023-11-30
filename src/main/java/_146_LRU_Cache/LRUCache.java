package _146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final Map<Integer, Node> data;
  private final Node dummyHead;
  private final Node dummyTail;

  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    dummyHead = new Node();
    dummyTail = new Node();
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
    data = new HashMap<>();
  }

  public int get(int key) {
    Node node = data.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }


  public void put(int key, int value) {
    Node existingNode = data.get(key);
    if (existingNode != null) {
      existingNode.value = value;
      removeNode(existingNode);
      addToHead(existingNode);
    } else {
      Node newNode = new Node(key, value);
      data.put(key, newNode);
      addToHead(newNode);
      if (capacity < data.size()) {
        Node toBeRemovedNode = dummyTail.prev;
        removeNode(toBeRemovedNode);
        data.remove(toBeRemovedNode.key);
      }
    }
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }
  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void addToHead(Node node) {
    node.prev = dummyHead;
    node.next = dummyHead.next;
    dummyHead.next = node;
    node.next.prev = node;
  }

  public static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

}
