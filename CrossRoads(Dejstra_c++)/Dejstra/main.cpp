/*План города представляет собой множество перекрёстков, соединённых дорогами (по дороге движение разрешено в обоих направлениях). Каждая дорога задается номерами перекрёстков, которые она соединяет, и временем движения по ней. Между двумя различными перекрёстками может быть не более одной дороги. Дорога может соединять только различные перекрёстки. Кроме того, время преодоления перекрёстка i равно q ⋅ ki, где q — заданная константа, а ki — число дорог, подходящих к перекрёстку i.

Необходимо найти кратчайший по времени маршрут от перекрёстка с номером s до перекрёстка с номером f.

Замечание
Конечный перекрёсток f преодолевать не надо, а стартовая вершина s маршрута преодолевается как перекрёсток.

Формат входных данных
В первой строке находятся числа n и m — число перекрёстков и число дорог на плане города соответственно (1 ≤ n ≤ 11 000, 0 ≤ m ≤ 100 000). В каждой из следующих m строк сначала расположены номера перекрёстков, которые связывает очередная дорога, а затем время движения по ней (от 0 до 1 000). В последней строке находятся номера перекрёстков s и f (1 ≤ s, f ≤ n), а также константа q (0 ≤ q ≤ 100).

Формат выходных данных
Если проехать от перекрёстка с номером s до перекрёстка с номером f можно, выведите в первой строке сообщение Yes, а во второй строке — минимальное время движения. Если проехать нельзя, то в единственной строке выведите сообщение No.*/
#include <iostream>
#include <fstream>
#include <vector>
#include <exception>
#include <cstring>

using namespace std;

int main()
{
	ifstream fin("input.txt");
	ofstream fout("output.txt");
	int s;
	int m[101], n[101];
	int c[101][101];
	int i, j, k, len, v;
	fin >> s;
	for (i = 0; i < s; ++i)
		fin >> n[i] >> m[i];
	n[s] = m[s - 1];
	for (i = 0; i < s; ++i)
		c[i][i + 1] = 0;
	for (len = 2; len <= s; ++len)
		for (i = 0; i <= s - len; ++i)
		{
			j = i + len;
			k = i + 1;
			c[i][j] = c[i][k] + c[k][j] + n[i] * n[k] * n[j];
			for (k = i + 2; k < j; ++k)
			{
				v = c[i][k] + c[k][j] + n[i] * n[k] * n[j];
				if (v < c[i][j])
					c[i][j] = v;
			}
		}
	fout << c[0][s] << endl;
	cout << c[0][s] << endl;
	int a = 0;
	cin >> a;
	fout.close();
	fin.close();
	return 0;
}