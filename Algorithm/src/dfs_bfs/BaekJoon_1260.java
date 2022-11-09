package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 1260번 문제
public class BackJoon_1260 {

	static int arr[][];
	static boolean check[];
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점개수
		int M = Integer.parseInt(st.nextToken()); // 간선개수
		int V = Integer.parseInt(st.nextToken()); // 시작 Node번호
		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 1; i <= M; i++) {
			System.out.println("? "+i);
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			arr[x][y] = arr[y][x] = 1;
		}
		dfs(V);
		bw.flush();
		bw.newLine();
		check = new boolean[N + 1];
		bfs(V);
		bw.flush();
		bw.close();
	}

	static void dfs(int start) {
		check[start] = true;
		try {
			bw.append(start + " ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i < check.length; i++) {
			if (arr[start][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			try {
				bw.append(node + " ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 1; i < check.length; i++) {
				if (arr[node][i] == 1 && !check[i]) {
					queue.offer(i);
					check[i] = true;
				}
			}
		}
	}
}
