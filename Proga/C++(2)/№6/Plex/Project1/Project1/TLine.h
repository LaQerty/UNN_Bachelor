//#include"TBase.h"
//
//#include"TPoint.h"
//
//
//
//class TLine : public TBase {
//protected:
//	TBase *left;
//	TBase *right;
//public:
//	TLine(TPoint *_left, TPoint *_right, bool _visible = true, int _color = 0, int _width = 15, int _rating = 1) : TBase(_Line, _left->GetName()+' '+_right->GetName(), 7, _visible, _color, _width, _rating) {
//		left = _left;
//		right = _right;
//	}
//	TLine(const TLine & tmp);
//	TLine &operator= (const TLine & tmp);
//	~TLine() {
//		delete left;
//		delete right;
//	}
//	void SetLeft(TBase* tmp);
//	void SetRight(TBase* tmp);
//	TBase* GetLeft();
//	TBase* GetRight();
//	void Inverse();
//	void Draw(System::Drawing::Graphics^ g) override;
//	void IncRating() override;
//	bool IsFigure(int _x, int _y) override;
//	void MovePoint(int dx, int dy);
//	std::string to_string() override;
//};