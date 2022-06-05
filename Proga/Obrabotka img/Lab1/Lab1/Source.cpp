#include <iostream> 
#include <string>  
#include <iomanip>  
#include <sstream> 
#include<math.h>
#include <opencv2/core/core.hpp>        
#include <opencv2/imgproc/imgproc.hpp>  
#include <opencv2/highgui/highgui.hpp>  
#include<ctime>

using namespace std;
using namespace cv;

double getPSNR(const Mat& I1, const Mat& I2)
{
	Mat s1;
	absdiff(I1, I2, s1);       // |I1 - I2|
	s1.convertTo(s1, CV_32F);  // cannot make a square on 8 bits
	s1 = s1.mul(s1);           // |I1 - I2|^2

	Scalar s = sum(s1);         // sum elements per channel

	double sse = s.val[0] + s.val[1] + s.val[2]; // sum channels

	if (sse <= 1e-10) // for small values return zero
		return 0;
	else
	{
		double  mse = sse / (double)(I1.channels() * I1.total());
		double psnr = 10.0*log10((255 * 255) / mse);
		return psnr;
	}
}

Mat grey(const Mat& img ) {
	Mat res;
	img.copyTo(res);
	for (int i = 0; i < res.rows; i++)
		for (int j = 0; j < res.cols; j++) {
			res.at<Vec3b>(i, j)[0]= res.at<Vec3b>(i, j)[0]* 0.148  + res.at<Vec3b>(i, j)[1] * 0.5547 + res.at<Vec3b>(i, j)[2]* 0.2952;
			res.at<Vec3b>(i, j)[1] =res.at<Vec3b>(i, j)[0] * 0.148 + res.at<Vec3b>(i, j)[1] * 0.5547 + res.at<Vec3b>(i, j)[2] * 0.2952;
			res.at<Vec3b>(i, j)[2] =res.at<Vec3b>(i, j)[0] * 0.148 + res.at<Vec3b>(i, j)[1] * 0.5547 + res.at<Vec3b>(i, j)[2] * 0.2952;
		}
	return res;
}
double CalcMod(double a, int b) {
	return a - floor(a / b) * b;
}
Mat bgrToHsv(Mat& imBGR) {
	imBGR.forEach<Vec3b>([](Vec3b& p, const int* pos) {
		int b = p[0];
		int g = p[1];
		int r = p[2];
		double bb = (double)b / 255;
		double gg = (double)g / 255;
		double rr = (double)r / 255;
		double Cmax = max({ bb, gg, rr });
		double Cmin = min({ bb, gg, rr });
		double d = Cmax - Cmin;
		double H, S, V;
		double qwe = CalcMod((gg - bb) / d, 6);
		if (d == 0) H = 0;
		else if (Cmax == rr) H = 60 * qwe;
		else if (Cmax == gg) H = 60 * (((bb - rr) / d) + 2);
		else if (Cmax == bb) H = 60 * (((rr - gg) / d) + 4);
		if (Cmax == 0) S = 0;
		else S = d / Cmax;
		V = Cmax;
		Vec3d hsv = Vec3d(H, S * 255.0, V * 255.0);
		p = hsv;

	});
	return imBGR;
}




int main(int argc, char *argv[]) {
	//Сравнение
	Mat img = imread("image.jpg"), hsv_img;
	Mat img1 = imread("image1.jpg");
	Mat res,res1,res2;

	double s1,s=0.0;
	namedWindow("img_1");
	namedWindow("img_2");
	imshow("img_1",img);
	imshow("img_2", img1);
	s = getPSNR(img, img1);
	cout << s << endl;
	waitKey(0);
	destroyWindow("img_1");
	destroyWindow("img_2");

	//Монохромное изображение
	res = grey(img);
	cvtColor(img, res1, COLOR_BGR2GRAY);
	namedWindow("img_3");
	namedWindow("img_4");
	imshow("img_3", res);
	imshow("img_4", res1);
	waitKey(0);
	destroyWindow("img_3");
	destroyWindow("img_4");
	//cvtColor меняет каналы, а мы изменили значение пикселей

	//BGR To HSV
	Mat b_t_h = bgrToHsv(img);
	long double t1 = clock();
	cvtColor(img, hsv_img, COLOR_BGR2RGB);
	long double t2 = clock();
	cout << "Time:" << t2 - t1 << endl;
	namedWindow("img_5");
	namedWindow("img_6");
	imshow("img_5", hsv_img);
	imshow("img_6", b_t_h);
	waitKey(0);
	destroyWindow("img_5");
	destroyWindow("img_6");
	s1 = getPSNR(b_t_h, hsv_img);
	cout << s1<<endl;

	// Яркость
	b_t_h *= 4;
	long double t3 = clock();
	hsv_img *= 4;
	long double t4 = clock();
	cout << "Time:" << t4 - t3 << endl;
	namedWindow("img_7");
	namedWindow("img_8");
	imshow("img_7", hsv_img);
	imshow("img_8", b_t_h);
	waitKey(0);

	
}