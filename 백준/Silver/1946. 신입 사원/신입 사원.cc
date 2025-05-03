#include <bits/stdc++.h>
using namespace std;

int main(void) {   
  ios_base::sync_with_stdio(false); 
  cin.tie(NULL);
  int tc;
  cin >> tc;
  while(tc--) {
  int n;
  cin >> n;
  int document[n];

  for(int i = 0;i<n;i++) {
    int temp;
    cin >> temp;
    cin >> document[temp-1];
  }

  int tmp = document[0];
  int ans = 1;

  for(int i = 1;i<n;i++) {
    if (tmp > document[i]) {
       tmp = document[i];
       ans++;
    }
  }

  cout << ans << "\n";
  }
}