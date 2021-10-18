#include <iostream>
#include <fstream>
#include <vector>
#include <exception>
#include <cstring>
#include <algorithm>
#include <queue>
#include <stack>
#include <set>
using namespace std;

const long long int MXN = 1e6 + 1;
const long long int INF = 1e16 + 1;

long long int n, m, f, s, x, y, val;
long long int dp[MXN], used[MXN];
vector < pair < long long int, long long int > > g[MXN];
set < pair < long long int, long long int > > q;

int main()
{
	ifstream fin("input.txt");
	ofstream fout("output.txt");

	fin >> n >> m;
	for (long long int i = 1; i <= m; i++) {
		fin >> x >> y >> val;
		g[x].push_back(make_pair(y, val));
		g[y].push_back(make_pair(x, val));
	}

	int v;
	for (long long int i = 1; i <= n; i++) {
		dp[i] = INF;
	}
	s = 1;
	f = n;
	dp[s] = 0;
	q.insert(make_pair(dp[s], s));
	while (!q.empty()) {
		v = q.begin()->second;
		q.erase(q.begin());
		for (long long int i = 0; i < g[v].size(); i++) {
			long long int to = g[v][i].first, len = g[v][i].second;
			if (dp[v] + len < dp[to]) {
				q.erase(make_pair(dp[to], to));
				dp[to] = dp[v] + len;
				q.insert(make_pair(dp[to], to));
			}
		}
	}
	fout << (dp[n] == INF ? -1 : dp[n]);

	fin.close();
	fout.close();

	return 0;
}