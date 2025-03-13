#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int board[600][600];
bool visit[600][600];


int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,-1,1};
int n,k;

int bfs(int x,int y) {
  int area = 0;
  queue<pair<int,int>> q;
  visit[x][y] = true;
  q.push({x,y});

  while(!q.empty()) {
    area++;
    pair<int,int> cursor = q.front();
    q.pop();

    for(int i = 0; i<4;i++) {
      int nx = cursor.X + dx[i];
      int ny = cursor.Y + dy[i];

      if (nx < 0 || nx >= n || ny < 0 || ny >= k) {
        continue;
      }
      if (board[nx][ny] == 0 || visit[nx][ny]) {
        continue;
      }
      q.push({nx,ny});
      visit[nx][ny] = true;
    }
  }
  return area;
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> n >> k;

  for(int i = 0; i<n;i++) {
    for(int j = 0; j<k;j++) {
      cin >> board[i][j];
    }
  }
  
  int MX = 0;
  int cnt = 0;
  for(int i = 0; i<n;i++) {
    for(int j = 0; j<k;j++) {
      if (board[i][j] == 1 && !visit[i][j]) {
        cnt++;
        MX = max(MX,bfs(i,j));
      }
    }
  }

  cout << cnt << "\n" << MX;

}