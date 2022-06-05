//#include "TPoint.h"
//
//
//TPoint::TPoint(const TPoint & tmp) :TBase(_Point, tmp.GetName(), tmp.R, tmp.Visible) {
//	X = tmp.X;
//	Y = tmp.Y;
//}
//
//TPoint & TPoint::operator=(const TPoint & tmp) {
//	X = tmp.X;
//	Y = tmp.Y;
//	Figure = tmp.Figure;
//	Name = tmp.Name;
//	Visible = tmp.Visible;
//	Color = tmp.Color;
//	R = tmp.R;
//	Width = tmp.Width;
//	Rating = tmp.Rating;
//	return *this;
//}
//
//int TPoint::GetX() const {
//	return X;
//}
//
//int TPoint::GetY() const {
//	return Y;
//}
//
//void TPoint::MovePoint(int dx, int dy) {
//	X += dx;
//	Y += dy;
//}
//
//void TPoint::Draw(System::Drawing::Graphics ^ g) {
//	if (Visible == false) return;
//	int red, green, blue;
//	int tmp = Color;
//	blue = tmp % 256;
//	tmp /= 256;
//	green = tmp % 256;
//	tmp /= 256;
//	red = tmp;
//	System::Drawing::SolidBrush^ brush = gcnew System::Drawing::SolidBrush(
//	System::Drawing::Color::FromArgb(255, red, green, blue));
//	g->FillEllipse(brush, X, Y, Width, Width);
//}
//
//void TPoint::DecRating() {
//	if (Rating > 0) Rating--;
//}
//
//void TPoint::IncRating() {
//	Rating++;
//}
//
//bool TPoint::IsFigure(int _x, int _y) {
//	auto sqr = [](int x) ->long long {
//		return (long long)x * x;
//	};
//	if (sqr(_x - X) + sqr(_y - Y) <= sqr(R)) return 1;
//	return 0;
//}
//
//std::string TPoint::to_string() {
//	std::string res;
//	res += GetName() + "(";
//	res += std::to_string(GetX()) + ' ' + std::to_string(GetY()) + ")";
//	return res;
//}
