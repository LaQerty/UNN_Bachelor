#pragma once
#include"polinom.h"
#include<msclr/marshal_cppstd.h>
namespace VisualPol {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// —водка дл€ MyForm
	/// </summary>
	public ref class MyForm : public System::Windows::Forms::Form
	{
	public:
		MyForm(void)
		{
			InitializeComponent();
			//
			//TODO: добавьте код конструктора
			//
		}

	protected:
		/// <summary>
		/// ќсвободить все используемые ресурсы.
		/// </summary>
		~MyForm()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::TextBox^  textBox1;
	protected:
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox3;
	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::TextBox^  textBox5;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::TextBox^  textBox6;
	private: System::Windows::Forms::Label^  label6;


	private:
		/// <summary>
		/// ќб€зательна€ переменна€ конструктора.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// “ребуемый метод дл€ поддержки конструктора Ч не измен€йте 
		/// содержимое этого метода с помощью редактора кода.
		/// </summary>
		void InitializeComponent(void)
		{
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox3 = (gcnew System::Windows::Forms::TextBox());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->textBox5 = (gcnew System::Windows::Forms::TextBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->textBox6 = (gcnew System::Windows::Forms::TextBox());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->SuspendLayout();
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(44, 119);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(324, 20);
			this->textBox1->TabIndex = 0;
			this->textBox1->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox1_TextChanged);
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(44, 180);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(324, 20);
			this->textBox2->TabIndex = 1;
			// 
			// textBox3
			// 
			this->textBox3->Location = System::Drawing::Point(159, 360);
			this->textBox3->Name = L"textBox3";
			this->textBox3->Size = System::Drawing::Size(324, 20);
			this->textBox3->TabIndex = 2;
			this->textBox3->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox3_TextChanged);
			// 
			// textBox4
			// 
			this->textBox4->Location = System::Drawing::Point(386, 41);
			this->textBox4->Name = L"textBox4";
			this->textBox4->Size = System::Drawing::Size(89, 20);
			this->textBox4->TabIndex = 3;
			this->textBox4->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox4_TextChanged);
			// 
			// textBox5
			// 
			this->textBox5->Location = System::Drawing::Point(101, 37);
			this->textBox5->Name = L"textBox5";
			this->textBox5->Size = System::Drawing::Size(82, 20);
			this->textBox5->TabIndex = 4;
			this->textBox5->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox5_TextChanged);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(3, 122);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(20, 13);
			this->label1->TabIndex = 5;
			this->label1->Text = L"P1";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(3, 183);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(20, 13);
			this->label2->TabIndex = 6;
			this->label2->Text = L"P2";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(116, 363);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(37, 13);
			this->label3->TabIndex = 7;
			this->label3->Text = L"Result";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(53, 40);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(42, 13);
			this->label4->TabIndex = 8;
			this->label4->Text = L"MaxPw";
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Location = System::Drawing::Point(345, 44);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(35, 13);
			this->label5->TabIndex = 9;
			this->label5->Text = L"Count";
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(38, 256);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(57, 48);
			this->button1->TabIndex = 10;
			this->button1->Text = L"+";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(119, 257);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(51, 47);
			this->button2->TabIndex = 11;
			this->button2->Text = L"-";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(190, 255);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(60, 50);
			this->button3->TabIndex = 12;
			this->button3->Text = L"*";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// button4
			// 
			this->button4->Location = System::Drawing::Point(282, 255);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(62, 49);
			this->button4->TabIndex = 13;
			this->button4->Text = L"*5";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &MyForm::button4_Click);
			// 
			// button5
			// 
			this->button5->Location = System::Drawing::Point(449, 122);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(100, 49);
			this->button5->TabIndex = 14;
			this->button5->Text = L"ADD";
			this->button5->UseVisualStyleBackColor = true;
			this->button5->Click += gcnew System::EventHandler(this, &MyForm::button5_Click);
			// 
			// button6
			// 
			this->button6->Location = System::Drawing::Point(449, 183);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(100, 49);
			this->button6->TabIndex = 15;
			this->button6->Text = L"ERASE";
			this->button6->UseVisualStyleBackColor = true;
			this->button6->Click += gcnew System::EventHandler(this, &MyForm::button6_Click);
			// 
			// textBox6
			// 
			this->textBox6->Location = System::Drawing::Point(449, 85);
			this->textBox6->Name = L"textBox6";
			this->textBox6->Size = System::Drawing::Size(162, 20);
			this->textBox6->TabIndex = 16;
			this->textBox6->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox6_TextChanged);
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(401, 85);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(42, 13);
			this->label6->TabIndex = 17;
			this->label6->Text = L"Monom";
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(642, 492);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->textBox6);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox5);
			this->Controls->Add(this->textBox4);
			this->Controls->Add(this->textBox3);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			this->Load += gcnew System::EventHandler(this, &MyForm::MyForm_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void textBox3_TextChanged(System::Object^  sender, System::EventArgs^  e) {
	}
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {

	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox2->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a=new polinom(st, c, step);
	polinom *b = new polinom(st1, c, step);
	polinom *x = new polinom(st1, c,step);
	*x = *a + *b;
	std::string res = x->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void MyForm_Load(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox2->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a = new polinom(st, c, step);
	polinom *b = new polinom(st1, c, step);
	polinom *x = new polinom(st1, c, step);
	*x = *a - *b;
	std::string res = x->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox2->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a = new polinom(st, c, step);
	polinom *b = new polinom(st1, c, step);
	polinom *x = new polinom(st1, c, step);
	*x = *a * *b;
	std::string res = x->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox2->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a = new polinom(st, c, step);
	polinom *b = new polinom(st1, c, step);
	polinom *x = new polinom(st1, c, step);
	*x = *a *5;
	std::string res = x->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}

private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox6->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a = new polinom(st, c, step);
	monom b(st1, c, step);
	a->add(b);
	std::string res = a->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void textBox6_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string st = msclr::interop::marshal_as < std::string >(textBox1->Text);
	std::string st1 = msclr::interop::marshal_as < std::string >(textBox6->Text);
	int step, c;
	c = Convert::ToInt32(textBox4->Text);
	step = Convert::ToInt32(textBox5->Text);
	polinom *a=new polinom(st, c, step);
	monom b(st1, step, c);
	a->erase(b);
	std::string res = a->to_string();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void textBox1_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox4_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox5_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
};
}
