//#define _CRT_SECURE_NO_WARNINGS
#include <string>
using namespace std;

int summing(int *a, int n)
{
	int sum, i;
	sum = 0;
	for (i = 0; i < n; i++) {
		sum += a[i];
	}
	return sum;
}
void minimum(int *a, int n, int &min, int &l)
{
	int i;
	min = a[0];
	l = 0;
	for (i = 0; i < n; i++)
	{
		if (min > a[i])
		{
			min = a[i];
			l = i;
		}
	}
}
void otbor(int n, string *name, string *best)
{
	int k = 0;
	for (int i = 0; i < n; i++) {
		if (name[i].find("a") == 0)
		{
			best[k++] = name[i];
		}

	}
	
}
int linp(int n, string *name, string ctrl, int l)
{
	l = -1;
int	i = 0;
	while ((l == -1) && (i < n))
	{
		if (name[i] == ctrl)
		{
			l = i;
		}
		i++;
	}
	return l;
}

int binp(string *name, string ctrl, int n)
{
	int l;
	int s;
	int f;
	int midle;
	s = 0;
	f = n - 1;
	l = -1;
	while ((l == -1) && (s <= f))
	{
		int midle = (s + f) / 2;
		if (name[midle] < ctrl)
			s = midle + 1;
		if (name[midle] == ctrl)
			l = midle;
		if (name[midle] > ctrl)
			f = midle - 1;
	}
	return l;
}
void wsr(int n, string *name, string *sp, double *ch, double *sum, int*reit, int &k)
{

	int l;
	k = 0;
	for (int i = 0; i < n; i++)
	{
		l = -1;
		int j = 0;
		while ((l == -1) && (j < k))
		{
			if (sp[j] == name[i])
			{
				l = j;
			}
			j++;
		}
		if (l == -1)
		{
			sp[k] = name[i];
			reit[k] = 1;
			sum[k] = ch[i];
			k++;
		}
		else
		{
			reit[l]++;
			sum[l] += ch[i];
		}
	}
}
void delim(string st, string*w, int &k)
{
	st += ' ';
	k = 0;
	while (st.length() > 0)
	{
		int l = st.find(" ");
		if (l > 0)
		{
			w[k++] = st.substr(0, l);
			st.erase(0, l + 1);
		}
		else
		{
			st.erase(0, l + 1);
		}
	}
}
void echedelim(string *w, string zn, string st, int &k)
{
	int l;
	k = 0;
	w[0] = "";
	st += " ";
	for (int i = 0; i < st.length(); i++)
	{
		l = zn.find(st[i]);
		if (!((l >= 0) && (l < zn.length())))
		{
			w[k] += st[i];
		}
		else
		{
			if (st[i] == ' ')
			{
				if (w[k] != "")
				{
					w[++k] = "";
				}
			}
			else
			{
				if (w[k] != "")
				{
					w[++k] = st[i];
				}
				else
				{
					w[k] = st[i];
				}

				w[++k] = "";

			}
		}
	}
}
void predl(int n, string last, string *tk, string *&line, int &m)
{
	m = 0;
	line[m] = "";
	for (int i = 0; i < n; i++)
	{
		tk[i] += " ";
		for (int j = 0; j < tk[i].length(); j++)
		{
			if (last.find(tk[i][j]) == -1)
			{
				line[m] += tk[i][j];
			}
			else {
				line[m++] += tk[i][j];
			}
		}
	}
}