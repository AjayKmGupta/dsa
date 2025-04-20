package practice.solution.tree.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static List<Integer> levelSums(Node root) {

		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {

			int levelSize = q.size();
			int levelSum = 0;

			for (int i = 0; i < levelSize; i++) {

				Node current = q.poll();
				levelSum += current.val;

				for (Node child : current.children) {
					q.offer(child);
				}
			}
			result.add(levelSum);

		}

		return result;
	}

	public static void main(String[] args) {

		Node root = new Node(1,

				Arrays.asList(new Node(5), new Node(1), new Node(2, Arrays.asList(new Node(5), new Node(7)))

				));

		List<Integer> ls = levelSums(root);

		System.out.println("Sum" + ls);

		for (int i = 0; i < ls.size(); i++) {
			System.out.println("Index" + (i + 1) + "-->" + ls.get(i));
		}
	}

}