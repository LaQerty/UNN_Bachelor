#pragma once
#include"Header.h"
#include <iostream>
#include<string>
#include "msclr\marshal_cppstd.h"
namespace Project1 {

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

	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::TextBox^  textBox3;
	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::TextBox^  textBox5;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox6;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::Button^  button7;
	private: System::Windows::Forms::Button^  button8;

	protected:

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
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->textBox3 = (gcnew System::Windows::Forms::TextBox());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->textBox5 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox6 = (gcnew System::Windows::Forms::TextBox());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->button7 = (gcnew System::Windows::Forms::Button());
			this->button8 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(7, 34);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(99, 20);
			this->textBox1->TabIndex = 1;
			this->textBox1->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox1_TextChanged);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(12, 166);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(56, 13);
			this->label1->TabIndex = 3;
			this->label1->Text = L"Massive B";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(12, 77);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(50, 13);
			this->label2->TabIndex = 4;
			this->label2->Text = L"Massiv A";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(12, 9);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(49, 13);
			this->label3->TabIndex = 5;
			this->label3->Text = L"Universe";
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(222, 278);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(104, 28);
			this->button1->TabIndex = 6;
			this->button1->Text = L"A+B";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(564, 104);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(113, 28);
			this->button2->TabIndex = 7;
			this->button2->Text = L"Dell";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(407, 180);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(104, 28);
			this->button3->TabIndex = 8;
			this->button3->Text = L"Add";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// button4
			// 
			this->button4->Location = System::Drawing::Point(564, 180);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(113, 28);
			this->button4->TabIndex = 9;
			this->button4->Text = L"Dell";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &MyForm::button4_Click);
			// 
			// textBox3
			// 
			this->textBox3->Location = System::Drawing::Point(222, 105);
			this->textBox3->Name = L"textBox3";
			this->textBox3->Size = System::Drawing::Size(144, 20);
			this->textBox3->TabIndex = 11;
			this->textBox3->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox3_TextChanged);
			// 
			// textBox4
			// 
			this->textBox4->Location = System::Drawing::Point(222, 188);
			this->textBox4->Name = L"textBox4";
			this->textBox4->Size = System::Drawing::Size(144, 20);
			this->textBox4->TabIndex = 12;
			this->textBox4->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox4_TextChanged);
			// 
			// textBox5
			// 
			this->textBox5->Location = System::Drawing::Point(12, 278);
			this->textBox5->Name = L"textBox5";
			this->textBox5->Size = System::Drawing::Size(153, 20);
			this->textBox5->TabIndex = 13;
			this->textBox5->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox5_TextChanged);
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(7, 188);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(150, 20);
			this->textBox2->TabIndex = 14;
			this->textBox2->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox2_TextChanged);
			this->textBox2->Leave += gcnew System::EventHandler(this, &MyForm::textBox2_Leave);
			// 
			// textBox6
			// 
			this->textBox6->Location = System::Drawing::Point(7, 104);
			this->textBox6->Name = L"textBox6";
			this->textBox6->Size = System::Drawing::Size(150, 20);
			this->textBox6->TabIndex = 15;
			this->textBox6->TextChanged += gcnew System::EventHandler(this, &MyForm::textBox6_TextChanged);
			this->textBox6->Leave += gcnew System::EventHandler(this, &MyForm::textBox6_Leave);
			// 
			// button5
			// 
			this->button5->Location = System::Drawing::Point(407, 104);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(104, 28);
			this->button5->TabIndex = 16;
			this->button5->Text = L"Add";
			this->button5->UseVisualStyleBackColor = true;
			this->button5->Click += gcnew System::EventHandler(this, &MyForm::button5_Click);
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(12, 246);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(42, 13);
			this->label4->TabIndex = 17;
			this->label4->Text = L"Results";
			// 
			// button6
			// 
			this->button6->Location = System::Drawing::Point(222, 327);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(104, 33);
			this->button6->TabIndex = 18;
			this->button6->Text = L"A^B";
			this->button6->UseVisualStyleBackColor = true;
			this->button6->Click += gcnew System::EventHandler(this, &MyForm::button6_Click);
			// 
			// button7
			// 
			this->button7->Location = System::Drawing::Point(222, 386);
			this->button7->Name = L"button7";
			this->button7->Size = System::Drawing::Size(103, 31);
			this->button7->TabIndex = 19;
			this->button7->Text = L"~A";
			this->button7->UseVisualStyleBackColor = true;
			this->button7->Click += gcnew System::EventHandler(this, &MyForm::button7_Click);
			// 
			// button8
			// 
			this->button8->Location = System::Drawing::Point(564, 386);
			this->button8->Name = L"button8";
			this->button8->Size = System::Drawing::Size(113, 31);
			this->button8->TabIndex = 20;
			this->button8->Text = L"EXIT";
			this->button8->UseVisualStyleBackColor = true;
			this->button8->Click += gcnew System::EventHandler(this, &MyForm::button8_Click);
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(684, 425);
			this->Controls->Add(this->button8);
			this->Controls->Add(this->button7);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->textBox6);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox5);
			this->Controls->Add(this->textBox4);
			this->Controls->Add(this->textBox3);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			this->Load += gcnew System::EventHandler(this, &MyForm::MyForm_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void MyForm_Load(System::Object^  sender, System::EventArgs^  e) {
	}
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
	//A+B
	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox3->Text));
	TSet b(u, msclr::interop::marshal_as < std::string >(textBox4->Text));
	std::string res = (a + b).TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox5->Text = fin;
}
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {
	//Add B

	int u = Convert::ToInt32(textBox1->Text);
	TSet b(u, msclr::interop::marshal_as < std::string >(textBox2->Text));
	std::string res = b.TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox4->Text = fin;

}
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
	//Del B
	int u = Convert::ToInt32(textBox1->Text);
	TSet c(u, msclr::interop::marshal_as < std::string >(textBox6->Text));
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox3->Text));
	std::string res = (a^~c).TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {
	// Del B
	int u = Convert::ToInt32(textBox1->Text);
	TSet c(u, msclr::interop::marshal_as < std::string >(textBox2->Text));
	TSet b(u, msclr::interop::marshal_as < std::string >(textBox4->Text));
	std::string res = (b^~c).TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox4->Text = fin;
}
private: System::Void label4_Click(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e) {
	//Add A

	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox6->Text));
	std::string res = a.TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox3->Text = fin;
}
private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e) {
	//A^B
	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox3->Text));
	TSet b(u, msclr::interop::marshal_as < std::string >(textBox4->Text));
	std::string res = (a ^ b).TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox5->Text = fin;
}
private: System::Void button7_Click(System::Object^  sender, System::EventArgs^  e) {
	//~A
	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox3->Text));
	std::string res = (~a).TSet_ToStr();
	String ^ fin = gcnew String(res.c_str());
	textBox5->Text = fin;
}
private: System::Void button8_Click(System::Object^  sender, System::EventArgs^  e) {
	Close();
}
private: System::Void textBox1_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox2_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox3_TextChanged(System::Object^  sender, System::EventArgs^  e) {		
}
private: System::Void textBox4_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox5_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox6_TextChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void textBox6_Leave(System::Object^  sender, System::EventArgs^  e) {
	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox6->Text));
	std::string res = a.TSet_ToStr();
	String ^ Fin = gcnew String(res.c_str());
	textBox6->Clear();
	textBox6->Text = Fin;
}
private: System::Void textBox2_Leave(System::Object^  sender, System::EventArgs^  e) {
	int u = Convert::ToInt32(textBox1->Text);
	TSet a(u, msclr::interop::marshal_as < std::string >(textBox2->Text));
	std::string res = a.TSet_ToStr();
	String ^ Fin = gcnew String(res.c_str());
	textBox2->Clear();
	textBox2->Text = Fin;
}
};
}
