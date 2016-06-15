package algorithm;

public class DFS {
	static int n = 8;

	public static void main(String[] args) {
		int map[][] = new int[30][30];
		boolean visit[] = new boolean[30];

		DFS dfs = new DFS();
		dfs.init(map);
		System.out.println(map);
		DFS(1,map,visit);
	}

	public void init(int map[][]) {
		map[1][2] = 1; map[1][3] = 1; map[2][4] = 1; map[2][5] = 1; map[4][8] = 1; map[5][8] = 1; map[3][6] = 1;
		map[3][7] = 1; map[6][8] = 1; map[7][8] = 1; map[2][1] = 1; map[3][1] = 1; map[4][2] = 1; map[5][2] = 1;
		map[8][4] = 1; map[8][5] = 1; map[6][3] = 1; map[7][3] = 1; map[8][6] = 1; map[8][7] = 1;
	}

	public static void DFS(int v, int map[][], boolean visit[]) {
		visit[v] = true;
		for(int i = 1; i <= n ; i++) {
			if(map[v][i] == 1 && !visit[i]) {
				System.out.println(v + "에서 " + i + "로 이동");
				DFS(i, map, visit);
			}
		}
	}
}
