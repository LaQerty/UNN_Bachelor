
#include<string>
using namespace std;
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
				if ((w[k] != "")&&(w[k]!="+")&&(w[k]!="-"))
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

				//w[++k] = "";

			}
		}
	}
}