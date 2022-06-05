#include <math.h>
using namespace System;
using namespace System::ComponentModel;
using namespace System::Collections;
using namespace System::Windows::Forms;
using namespace System::Data;
using namespace System::Drawing; 
class Pr
{
protected:
	int x, y, a, b;
public:
	Pr(int _x = 0, int _y = 0,int _a = 0, int _b = 0) {
		x = _x;
		y = _y;
		a = _a;
		b = _b;
	}
	~Pr() {};
	virtual void show(Graphics^g)=0;
	void move(int dx){
		x += dx;
}

};
class my_door :public Pr {
public:
	my_door(int _x = 0, int _y = 0, int _h = 0):Pr(_x,_y,3*_h,7*_h)
	{};
	void show(Graphics^g) {
		SolidBrush^brush = gcnew SolidBrush(Color::Goldenrod);
		g->FillRectangle(brush, x, y, a, b);
		Pen^pen = gcnew Pen(Color::DeepPink, 3);
		g->DrawRectangle(pen, x, y, a, b);
	}
};
class my_window :public Pr {
public:
	my_window(int _x = 0, int _y = 0, int _h = 0) :Pr(_x, _y, 2 * _h, 4 * _h) {};
	void show(Graphics^g) {
		SolidBrush^brush = gcnew SolidBrush(Color::LightBlue);
		g->FillRectangle(brush, x, y, a, b);
		Pen^pen = gcnew Pen(Color::Blue,3);
		g->DrawRectangle(pen, x, y, a, b);
	}
}; 
class my_body :public Pr {
public:
	my_body(int _x = 0, int _y = 0, int _h = 0) :Pr(_x, _y, 14 * _h, 10 * _h) {};
	void show(Graphics^g) {
		SolidBrush^brush = gcnew SolidBrush(Color::HotPink);
		g->FillRectangle(brush, x, y, a, b);
		Pen^pen = gcnew Pen(Color::DeepPink, 3);
		g->DrawRectangle(pen, x, y, a, b);
	}
};
class my_circle :public Pr {
public:
	my_circle(int _x = 0, int _y = 0, int _h = 0) :Pr(_x, _y, 4 * _h, 4 * _h) {};
	void show(Graphics^g) {
		SolidBrush^brush = gcnew SolidBrush(Color::Gold);
		g->FillEllipse(brush, x, y, a, b);
		Pen^pen = gcnew Pen(Color::DarkGoldenrod, 3);
		g->DrawEllipse(pen, x, y, a, b);
	}
};
class vagon {
private:
	my_body body;
	my_door door;
	my_window *wind;
	my_circle rcircle, lcircle;
public:
	vagon(int _x = 0, int _y = 0, int _h = 1) {
		body = my_body(_x, _y, _h);
		door = my_door(_x, _y+3*_h, _h);
		lcircle = my_circle(_x + _h, _y + 10 * _h, _h);
		rcircle = my_circle(_x + 9 * _h, _y + 10 * _h, _h);
		wind = new my_window[3];
		for (int i = 0; i < 3; i++) {
			wind[i] = my_window(_x + 5 * _h + i * 3 * _h, _y + 3 * _h, _h);
		}}
	vagon(const vagon& tmp) {
		body = tmp.body;
		door = tmp.door;
		rcircle = tmp.rcircle;
		lcircle = tmp.lcircle;
		wind = new my_window[3];
		for (int i = 0; i < 3; i++) {
			wind[i] = tmp.wind[i];
		}
	}
	~vagon() {
		delete[]wind;
	}
	vagon&operator=(const vagon&tmp) {
		body = tmp.body;
		door = tmp.door;
		rcircle = tmp.rcircle;
		lcircle = tmp.lcircle;
		wind = new my_window[3];
		for (int i = 0; i < 3; i++) {
			wind[i] = tmp.wind[i];
		}
		return *this;
	}
	void show(Graphics^g) {
		body.show(g);
		door.show(g);
		rcircle.show(g);
		lcircle.show(g);
		for (int i = 0; i < 3; i++) {
			wind[i].show(g);
		}
	}
	void move(int dx) {
		body.move(dx);
		door.move(dx);
		rcircle.move(dx);
		lcircle.move(dx);
		for (int i = 0; i < 3; i++) {
			wind[i].move(dx);
		}
	}
	
};
class lin {
protected:
	int xl, yl, xr, yr;
public:
	lin(int _xl = 0, int _yl = 0, int _xr = 0, int _yr = 0) {
		xl = _xl;
		yl = _yl;
		xr = _xr;
		yr = _yr;

	}
	~lin() {};
	virtual void move(int dx) {
		xl += dx;
		xr += dx;
	}
	virtual void show(Graphics ^g) {
		Pen^pen = gcnew Pen(Color::Honeydew);
		pen->Width = 3;
		g->DrawLine(pen, xl, yl, xr, yr);
	}
};


class engine {
private:
	int xlc, xrc; int yc;
	int xlb, ylb;
	int xre, yre; int yd;
	int h;
	double a; //=0

	int yv;
	lin leftline;
	lin middleline;
	lin rightline;
public:
	engine() {};
	engine(int x, int y, int _h) {
		h = _h;
		yc = y + 2 * h;
		yd = yc - h;
		xlc = x + 2 * h;
		xrc = x + 12 * h;
		xlb = x + 2 * h;
		xre = x + 12 * h;
		leftline = lin(xlc, yc, xlb, yd);
		middleline = lin(xlb, yd, xre, yd);
		rightline = lin(xre, yd, xrc, yc);


	}
	engine(const engine &tmp) {
		leftline = tmp.leftline;
		middleline = tmp.middleline;
		rightline = tmp.rightline;

	}

	void move(int dx) {
		a += 5 * 3.14159265 / 180;
		xlc += dx;
		xrc += dx;
		xlb = xlc + dx + h * cos(a);
		yd = yc + h * sin(a);
		xre = xrc + dx + h * cos(a);
		yre = ylb;
		leftline = lin(xlc, yc, xlb, yd);
		middleline = lin(xlb, yd, xre, yd);
		rightline = lin(xre, yd, xrc, yc);


	}
	void show(Graphics ^g) {
		leftline.show(g);
		middleline.show(g);
		rightline.show(g);
	}
};

class coup :public lin
{public:
	coup(int _x = 0, int _y = 0, int _h = 0) :lin(_x, _y, _x+2*_h, _y) {};//vozmojno ne rabotaet
	~coup() {};
	void show(Graphics^g) {
		Pen^pen = gcnew Pen(Color::Red,3);
		g->DrawLine(pen, xl, yl, xr, yr);
	}
};
class Truba :public Pr {
public:
	Truba(int t_x = 0, int t_y = 0, int h = 0) :Pr(t_x, t_y, 2 * h, 4 * h) { ; };
	void show(Graphics^ g) {
		SolidBrush^ myBrush = gcnew SolidBrush(Color::MediumPurple);
		g->FillRectangle(myBrush, x, y, a, b);
		Pen^ myPen = gcnew Pen(Color::MediumPurple, 2.0f);
		g->DrawRectangle(myPen, x, y, a, b);
	}
};
class par {
private:
	vagon vag;
	Truba tr;
	engine eng;
public:
	par(int x = 0, int y = 0, int h = 1) {
		vag = vagon(x, y, h);
		tr= Truba(x+10*h,y-4*h,h);
		eng = engine(x , y + 10 * h, h);
	}
		
		par(const par& tmp) {
			vag = tmp.vag;
			tr=tmp.tr;
			eng = tmp.eng;
		}
		~par() {};
		par&operator=(const par&tmp) {
			vag = tmp.vag;
			tr=tmp.tr;
			eng = tmp.eng;
			return*this;
		}
		void move(int dx){
			vag.move(dx);
			tr.move(dx);
			eng.move(dx);
		}
		void show(Graphics^g) {
			vag.show(g);
			tr.show(g);
			eng.show(g);
		}
};
class train {
private:
	par p;
	int n;
	vagon *vag;
	coup *c;
public:
	train(int _x = 0, int _y = 0, int _h = 0, int _n = 0) {
		n = _n;
		p = par(_x - 14 * _h, _y - 10 * _h, _h);
		c = new coup[n];
		vag = new vagon[n];
		for (int i = 0; i < n; i++) {
			c[i]=coup(_x-16*_h*(i+1),_y,_h);
			vag[i] = vagon(_x - (14 * _h + 16 * _h*(i + 1)), _y - 10 * _h, _h);
		}
	}
	train(const train&tmp) {
		p = tmp.p;
		n = tmp.n;
		c = new coup[n];
		vag = new vagon[n];
		for (int i = 0; i < n; i++) {
			c[i] = tmp.c[i];
			vag[i] = tmp.vag[i];
		}

	}
	~train() {
		delete[]c;
		delete[]vag;
	}
	train&operator=(const train tmp) {
		if (n != tmp.n) {
			if (n != 0) {
				delete[]c;
				delete[]vag;
			}
			n = tmp.n;
			vag = new vagon[n];
			c = new coup[n];
		}
		for (int i = 0; i < n; i++) {
			c[i] = tmp.c[i];
			vag[i] = tmp.vag[i];
		}
		return *this;
	}
	void show(Graphics^g) {
		p.show(g);
		for (int i = 0; i < n; i++) {
			c[i].show(g);
			vag[i].show(g);
		}
	}
	void move(int dx) {
		p.move(dx);
		for (int i = 0; i < n; i++) {
			c[i].move(dx);
			vag[i].move(dx);
		}

	}
};


