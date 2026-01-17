#include <bits/stdc++.h>
using namespace std;
int N,M;

string maps[30];

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,-1,1};


int shift(int step, int x1, int y1 , int x2, int y2) {
  if (step == 11) return -1;

  bool fall1 = false;
  bool fall2 = false;
  if (x1 < 0 || N  <= x1  || y1 < 0 || M <= y1) {
    fall1 = true;
  }

  if (x2 < 0 || N  <= x2  || y2 < 0 || M <= y2) {
    fall2 = true;
  }

  if (fall1 && fall2) return -1;

  if (fall1 || fall2) return step;

  int ans = -1;
  for(int i = 0;i<4;i++) {
    int nx1 = x1 + dx[i];
    int ny1 = y1 + dy[i];

    int nx2 = x2 + dx[i];
    int ny2 = y2 + dy[i];

    if (0<= nx1 && nx1 < N && 0 <= ny1 && ny1 <M && maps[nx1][ny1] == '#') {
      nx1 = x1;
      ny1 = y1;
    }

    if (0<= nx2 && nx2 < N && 0 <= ny2 && ny2 <M && maps[nx2][ny2] == '#') {
      nx2 = x2;
      ny2 = y2;
    }

    int temp = shift(step+1,nx1,ny1,nx2,ny2);

    if (temp == -1) continue;
    if (ans == -1 || ans > temp) {
      ans = temp;
    }
  }

  return ans;


}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
 
  cin >> N  >> M;

  int x1,y1,x2,y2;
  x1 = x2 = y1 = y2 = -1;

  for(int i = 0; i<N;i++) {
    cin >> maps[i];
    for(int j = 0; j< M;j++) {
      if (maps[i][j] == 'o') {
        if (x1 == -1) {
          x1 = i;
          y1 = j;
        } else {
          x2 = i;
          y2 = j;
        }
        maps[i][j] = '.';
      }
    }
  }

  cout << shift(0,x1,y1,x2,y2) << "\n";

} 