#include<string>
#include<fstream>
#include<vector>


enum TypeFigure { _Point, _Line, _Rectangle, _Curve };



class TBase {

protected:
	TypeFigure Figure;
	std::string Name;
	bool Visible;
	int Color;
	int R;
	int Width;
	int Rating;
public:
	TBase(TypeFigure _type = _Point , std::string _name = "", int _r = 7, bool _visible = true,int _color = 0, int _width = 15, int _rating = 1){
		Figure = _type;
		Name = _name;
		Visible = _visible;
		Color = _color; 
		R = _r;
		Width = _width;
		Rating = _rating;
	};
	virtual ~TBase() {};
	TBase(const TBase & tmp) {
		Figure = tmp.Figure;
		Name = tmp.Name;
		Visible = tmp.Visible;
		Color = tmp.Color;
		R = tmp.R;
		Width = tmp.Width;
		Rating = tmp.Rating;
	};
	TypeFigure GetType() const {
		return Figure;
	};
	bool GetVisability() const {
		return Visible;
	};
	int GetWidth() const {
		return Width;
	};
	int GetRating() const {
		return Rating;
	};
	std::string GetName() const {
		return Name;
	};
	int GetColor() const {
		return Color;
	};
	void SetColor(int _c) {
		Color = _c;
	};
	void SetWidth(int _width) {
		Width = _width;
	};
	void SetVisability(bool _vis) {
		Visible = _vis;
	};
	virtual void IncRating() = 0;
	virtual void Draw(System::Drawing::Graphics^ g) = 0;
	virtual bool IsFigure(int _x, int _y) = 0;
	virtual std::string to_string() = 0;
};

class TPoint : public TBase {
protected:
	int X, Y;
public:
	TPoint(int _x, int _y, std::string _name, int _r = 15) : TBase(_Point, _name, _r) {
		X = _x;
		Y = _y;
	};
	~TPoint() {};
	TPoint(const TPoint & tmp) :TBase(_Point, tmp.GetName(), tmp.R, tmp.Visible) {
		X = tmp.X;
		Y = tmp.Y;
	};
	TPoint &operator=(const TPoint & tmp){
	X = tmp.X;
	Y = tmp.Y;
	Figure = tmp.Figure;
	Name = tmp.Name;
	Visible = tmp.Visible;
	Color = tmp.Color;
	R = tmp.R;
	Width = tmp.Width;
	Rating = tmp.Rating;
	return *this;
};
	int GetX() const {
		return X;
	};
	int GetY() const {
		return Y;
	};
	void MovePoint(int dx = 0, int dy = 0) {
		X += dx;
		Y += dy;
	};
	void Draw(System::Drawing::Graphics^ g) {
		if (Visible == false) return;
		int red, green, blue;
		int tmp = Color;
		blue = tmp % 256;
		tmp /= 256;
		green = tmp % 256;
		tmp /= 256;
		red = tmp;
		System::Drawing::SolidBrush^ brush = gcnew System::Drawing::SolidBrush(System::Drawing::Color::FromArgb(255, red, green, blue));
		g->FillEllipse(brush, X, Y, Width, Width);
	};
	void DecRating() {
		if (Rating > 0) Rating--;
	};
	void IncRating() {
		Rating++;
	};
	bool IsFigure(int _x, int _y) {
		auto sqr = [](int x) ->long long {
			return (long long)x * x;
		};
		if (sqr(_x - X) + sqr(_y - Y) <= sqr(R)) return 1;
		return 0;
	};
	std::string to_string() {
		std::string res;
		res += GetName() + "(";
		res += std::to_string(GetX()) + ' ' + std::to_string(GetY()) + ")";
		return res;
	};
};
class TLine : public TBase {
protected:
	TBase *left;
	TBase *right;
public:
	TLine(TPoint *_left, TPoint *_right) : TBase(_Line, _left->GetName() + ' ' + _right->GetName(), 7) {
		left = _left;
		right = _right;
	}
	TLine(const TLine & tmp) : TBase(_Line, tmp.left->GetName() + ' ' + tmp.right->GetName(), 7, tmp.Visible, tmp.Color, tmp.Width, tmp.Rating) {

		if (tmp.left->GetType() == _Point) {
			left = new TPoint(*((TPoint*)tmp.left));
		}
		else {
			left = new TLine(*((TLine*)tmp.left));
		}

		if (tmp.right->GetType() == _Point) {
			right = new TPoint(*((TPoint*)tmp.right));
		}

		else {
			right = new TLine(*((TLine*)tmp.right));
		}
		Figure = tmp.Figure;
		Name = tmp.Name;
		Visible = tmp.Visible;
		Color = tmp.Color;
		R = tmp.R;
		Width = tmp.Width;
		Rating = tmp.Rating;
	};
	TLine &operator= (const TLine & tmp) {

		if (left) delete left;
		if (right) delete right;
		if (tmp.left->GetType() == _Point) {
			left = new TPoint(*((TPoint*)tmp.left));
		}
		else {
			left = new TLine(*((TLine*)tmp.left));
		}
		if (tmp.right->GetType() == _Point) {
			right = new TPoint(*((TPoint*)tmp.right));
		}
		else {
			right = new TLine(*((TLine*)tmp.right));
		}
		Figure = tmp.Figure;
		Name = tmp.Name;
		Visible = tmp.Visible;
		Color = tmp.Color;
		R = tmp.R;
		Width = tmp.Width;
		Rating = tmp.Rating;
		return *this;
	};
	~TLine() {
		delete left;
		delete right;
	}
	void SetLeft(TBase* tmp) {
		left = tmp;
	};
	void SetRight(TBase* tmp) {
		right = tmp;
	};
	TBase* GetLeft() {
		return left;
	};
	TBase* GetRight() {
		return right;
	};
	void Inverse() {
		TBase* tmp = left;
		left = right;
		right = tmp;
		std::string newName;
		int index = Name.find(' ');
		newName += Name.substr(index + 1, Name.size());
		newName += ' ';
		newName += Name.substr(0, index);
		Name = newName;
	};
	void Draw(System::Drawing::Graphics^ g) {
		if (Visible == false) return;
		int red, green, blue,x1,y1,x2,y2;
		int tmp = Color;
		blue = tmp % 256;
		tmp /= 256;
		green = tmp % 256;
		tmp /= 256;
		red = tmp;
		x1 = ((TPoint*)left)->GetX()+((TPoint*)left)->GetWidth() / 2;
		y1 = ((TPoint*)left)->GetY() +((TPoint*)left)->GetWidth() / 2;
		x2 = ((TPoint*)right)->GetX() +((TPoint*)right)->GetWidth() / 2;
		y2 = ((TPoint*)right)->GetY() +((TPoint*)right)->GetWidth() / 2;
		System::Drawing::Pen^ pen = gcnew System::Drawing::Pen(System::Drawing::Color::FromArgb(255, red, green, blue));
		pen->Width = R;
		g->DrawLine(pen, x1, y1, x2, y2 );
	};
	void IncRating() {
		Rating++;
		if (Rating == 4) Rating = 1;
	};
	bool IsFigure(int _x, int _y) {
		if (left->IsFigure(_x, _y) || right->IsFigure(_x, _y)) return true;

	};
	void MovePoint(int dx, int dy) {
		if (left->GetType() == _Point) {
			((TPoint*)left)->MovePoint(dx, dy);
		}
		else {
			((TLine*)left)->MovePoint(dx, dy);
		}
		if (right->GetType() == _Point) {
			((TPoint*)right)->MovePoint(dx, dy);
		}
		else {
			((TLine*)right)->MovePoint(dx, dy);
		}
	};
	std::string to_string() {
		std::string ans;
		ans += "LINE | ";
		ans += GetName();
		/*if (left->GetType() == _Point) {
			ans += ((TPoint*)left)->to_string();
		} else {
			ans += ((TLine*)left)->to_string();
		}
		ans += ' ';
		if (right->GetType() == _Point) {
			ans += ((TPoint*)right)->to_string();
		}
		else {
			ans += ((TLine*)right)->to_string();
		}*/
		return ans;
	};
};
class Plex {
private:
	TBase* start;
public:
	Plex(TLine* tmp = nullptr) {
		start = new TLine(*tmp);
	};
	void plexcop(TBase* start, TBase* x)
	{
		if (x->GetType() == _Point) {
			start = new TPoint(*((TPoint*)(x)));
		}
		else if (x->GetType() == _Line) {
			start = new TLine(*((TLine*)(x)));
			if (((TLine*)(x))->GetLeft()) {
				plexcop(((TLine*)(start))->GetLeft(), ((TLine*)(x))->GetLeft());
			}
			if (((TLine*)(x))->GetRight()) {
				plexcop(((TLine*)(start))->GetRight(), ((TLine*)(x))->GetRight());
			}
		}
	}
	Plex(const Plex & tmp) {
		plexcop(start, tmp.start);
	};
	Plex &operator=(const Plex & tmp) {
		if (start) delete start;
		plexcop(start, tmp.start);
		return *this;
	};
	~Plex() {
		delete start;
	}
	void InsertLine(TLine* le, TLine* ri) {
			ri->SetLeft(le->GetRight());
			le->SetRight(ri);
	};
	void addLine(TLine* tm) {
		TLine* tmp = new TLine(*tm);
	
		if (start == nullptr) {
			start = tmp;
			return;
		}
		TLine* le = SearchLineWithPoint(tmp->GetLeft()->GetName());
		TLine* ri = SearchLineWithPoint(tmp->GetRight()->GetName());
		if (le && !ri) {
			InsertLine(le, tmp);
		}
		else if (!le && ri) {
			tmp->Inverse();
			InsertLine(ri, tmp);
		}
		else if (le && ri) {
			
			InsertLine(le, tmp);
			if (ri->GetLeft()->GetName() == tmp->GetLeft()->GetName()) {
				ri->GetLeft()->IncRating();
				
				tmp->SetRight(ri->GetLeft());
				tmp->GetRight()->IncRating();
			}
			else {
				
				tmp->GetRight()->IncRating();
			}
		}
	};
	
	TLine* dfsSearchLine(TBase* x, int &find, const std::string & name) {
		if (x->GetType() == _Point) {
			if (x->GetName() == name) {
				find = 1;
				return nullptr;
			}
		}
		else if (x->GetType() == _Line) {
			if (((TLine*)(x))->GetLeft()) {
				TLine* ans = dfsSearchLine(((TLine*)(x))->GetLeft(), find, name);
				if (find == 1) {
					find = 2;
					return ((TLine*)(x));
				}
				if (find == 2) return ans;
			}
			if (((TLine*)(x))->GetRight()) {
				TLine* ans = dfsSearchLine(((TLine*)(x))->GetRight(), find, name);
				if (find == 1) {
					find = 2;
					return ((TLine*)(x));
				}
				if (find == 2) return ans;
			}
		}
		return nullptr;
	}

	TLine* dfsSearchLine(TBase* x, int &find, int X, int Y) {
		if (x->GetType() == _Point) {
			if (((TPoint*)(x))->GetX() == X && ((TPoint*)(x))->GetY() == Y) {
				find = 1;
				return nullptr;
			}
		}
		else if (x->GetType() == _Line) {
			if (((TLine*)(x))->GetLeft()) {
				TLine* ans = dfsSearchLine(((TLine*)(x))->GetLeft(), find, X, Y);
				if (find == 1) {
					find = 2;
					return ((TLine*)(x));
				}
				if (find == 2) return ans;
			}
			if (((TLine*)(x))->GetRight()) {
				TLine* ans = dfsSearchLine(((TLine*)(x))->GetRight(), find, X, Y);
				if (find == 1) {
					find = 2;
					return ((TLine*)(x));
				}
				if (find == 2) return ans;
			}
		}
		return nullptr;
	}

	TLine* SearchLineWithPoint(const std::string & name) {
		int find = 0;
		TLine* ans = dfsSearchLine(start, find, name);
		if (find) return ans;
		return nullptr;
	};

	TLine* SearchLineWithPoint(int x, int y) {
		int find = 0;
		TLine* ans = dfsSearchLine(start, find, x, y);
		if (find) return ans;
		return nullptr;
	};
	
	TPoint* dfsSearchPoint(TBase* x, bool &find, const std::string & name) {
		if (x->GetType() == _Point) {
			if (x->GetName() == name) {
				find = 1;
				return ((TPoint*)(x));
			}
		}
		else if (x->GetType() == _Line) {
			if (((TLine*)(x))->GetLeft()) {
				TPoint* res = dfsSearchPoint(((TLine*)(x))->GetLeft(), find, name);
				if (find) return res;
			}
			if (((TLine*)(x))->GetRight()) {
				TPoint* res = dfsSearchPoint(((TLine*)(x))->GetRight(), find, name);
				if (find) return res;
			}
		}
		return nullptr;
	}

	TPoint* dfsSearchPoint(TBase* x, bool &find, int X, int Y) {
		if (x->GetType() == _Point) {
			if (((TPoint*)(x))->GetX() == X && ((TPoint*)(x))->GetY() == Y) {
				find = 1;
				return ((TPoint*)(x));
			}
		}
		else if (x->GetType() == _Line) {
			if (((TLine*)(x))->GetLeft()) {
				TPoint* res = dfsSearchPoint(((TLine*)(x))->GetLeft(), find, X, Y);
				if (find) return res;
			}
			if (((TLine*)(x))->GetRight()) {
				TPoint* res = dfsSearchPoint(((TLine*)(x))->GetRight(), find, X, Y);
				if (find) return res;
			}
		}
		return nullptr;
	}
	TPoint* SearchPoint(const std::string & name) {
		bool find = 0;
		TPoint* ans = dfsSearchPoint(start, find, name);
		if (find) return ans;
		return nullptr;
	};

	TPoint* SearchPoint(int x, int y) {
		bool find = 0;
		TPoint* ans = dfsSearchPoint(start, find, x, y);
		if (find) return ans;
		return nullptr;
	};

	void Move(int dx, int dy) {
		if (start == nullptr) return;
		if (start->GetType() == _Point) {
			((TPoint*)start)->MovePoint(dx, dy);
			return;
		}
		((TLine*)start)->MovePoint(dx, dy);
	};

	void Draw(System::Drawing::Graphics^ g){
		if (start == nullptr) return;
		if (start->GetType() == _Point) {
			((TPoint*)start)->Draw(g);
			return;
		}
		((TLine*)start)->Draw(g);
	};

	bool Empty()const {
		return(start ? true : false);
	};
	
	void dfsForSaveGraph(TBase* x, int width, int depth, std::vector<std::string> &ans) {
		if (x == nullptr) return;
		if (x->GetType() == _Point) {
			std::string convert = ((TPoint*)(x))->to_string();
			for (int i = 0; i < convert.size(); i++) {
		
				ans[depth][width + i] = convert[i];
			}
			return;
		}
		if (((TLine*)(x))->GetLeft() != nullptr) {
			
			dfsForSaveGraph(((TLine*)(x))->GetLeft(), width - (15 - depth) * 5, depth + 4, ans);
			
		}
		if (((TLine*)(x))->GetRight() != nullptr) {
			
			dfsForSaveGraph(((TLine*)(x))->GetRight(), width + (15 - depth) * 5, depth + 4, ans);
			
		}
		
		std::string convert = ((TLine*)x)->to_string();
		for (int i = 0; i < convert.size(); i++) {
			ans[depth][width + i] = convert[i];
		}
	}

	void saveGraph() {
		std::vector<std::string> ans(100, std::string(1000, ' '));
		dfsForSaveGraph(start, 500, 0, ans);
		std::fstream out;
		out.open("Plex.txt", std::ios::out);
		for (auto i : ans) {
			out << i << '\n';
		}
		out.close();
	};
	void dfsForSaveFile(TBase* x, std::fstream & out) {
		if (x == nullptr) return;
		if (x->GetType() == _Point) {
			std::string convert = ((TPoint*)(x))->to_string();
			out << convert << '\n';
			return;
		}
		if (((TLine*)(x))->GetLeft() != nullptr) {
			out << "GO LEFT\n";
			dfsForSaveFile(((TLine*)(x))->GetLeft(), out);
			out << "OUT LEFT\n";
		}
		if (((TLine*)(x))->GetRight() != nullptr) {
			out << "GO RIGHT\n";
			dfsForSaveFile(((TLine*)(x))->GetRight(), out);
			out << "OUT RIGHT\n";
		}
		out << ((TLine*)(x))->to_string() << '\n';
	}
	void saveFile() {
		std::fstream out;
		out.open("File.txt", std::ios::out);
		dfsForSaveFile(start, out);
		out.close();
	};
};