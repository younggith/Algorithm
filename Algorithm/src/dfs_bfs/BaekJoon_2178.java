package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 2178번 문제
public class BaekJoon_2178 {

	static int arr[][];
	static boolean check[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행번호
		M = Integer.parseInt(st.nextToken()); //열번호
		
		arr = new int[N][M];
		String temp = "";
		for(int i=0; i<N; i++) {
			temp = br.readLine();
			for(int j=0; j<temp.length(); j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		check = new boolean[N][M];
		check[0][0] = true;
		bfs();
		System.out.println(arr[N-1][M-1]);
	}
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX>=N || nextY>=M)
					continue;
				if(check[nextX][nextY] || arr[nextX][nextY] == 0)
					continue;
				queue.offer(new int[] {nextX, nextY});
				arr[nextX][nextY] = arr[nowX][nowY] + 1;
				check[nextX][nextY] = true;
			}
		}
	}

}
