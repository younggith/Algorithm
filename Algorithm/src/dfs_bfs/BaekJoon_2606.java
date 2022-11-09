package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 2606번 문제
public class BaekJoon_2606 {

	static int arr[][];
	static boolean check[];
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //컴퓨터 수
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //노드선 수
		
		arr = new int[N+1][N+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		check = new boolean[N+1];
		dfs(1);
		System.out.println(result);
	}
	static void dfs(int start) {
		check[start] = true;
		
		for(int i=1; i<N+1; i++) {
			if(arr[start][i] == 1 && !check[i]) {
				check[i] = true;
				result++;
				dfs(i);
			}
		}
	}
}
	
	

