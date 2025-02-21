#include <bits/stdc++.h>
using namespace std;

int main(){
	  ios::sync_with_stdio(0);
 	 cin.tie(0);
	string word; 
	cin >> word;
	list<char> w;
	for(char c : word) {
		w.push_back(c);
	} 
	
	auto cursor = w.end();
	
	int count;
	cin >> count;
	while(count--) {
		char key;
		cin >> key;
	if (key == 'P') {
		char value;
		cin >> value;
		w.insert(cursor, value);
	} else if (key == 'L') {
		if (cursor != w.begin()) {
			cursor--;	
		}
	} else if (key == 'D') {
		if (cursor != w.end()) {
			cursor++;
		}
	} else if ( key == 'B') {
		if (cursor != w.begin()) {
			cursor--;
		cursor = w.erase(cursor);
		}
		
	}
	}
	
	for(auto c : w) {
		cout << c;
	}
	

}