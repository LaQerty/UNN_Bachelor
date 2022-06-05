#pragma once
#include"TBase.h"
#include<vector>
#include <msclr\marshal_cppstd.h>
namespace Project1 {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	std::vector<TPoint*> Dots;
	std::vector<TLine*> Line;
	Plex* a;
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

	protected:
	private: System::Windows::Forms::PictureBox^  pictureBox1;






	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::DataGridView^  GridDots;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::TextBox^  textBox3;
	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::DataGridView^  Grid;


	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::TextBox^  textBox5;
	private: System::Windows::Forms::TextBox^  textBox6;
	private: System::Windows::Forms::TextBox^  textBox7;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Label^  label7;






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
			this->pictureBox1 = (gcnew System::Windows::Forms::PictureBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->GridDots = (gcnew System::Windows::Forms::DataGridView());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->textBox3 = (gcnew System::Windows::Forms::TextBox());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->Grid = (gcnew System::Windows::Forms::DataGridView());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->textBox5 = (gcnew System::Windows::Forms::TextBox());
			this->textBox6 = (gcnew System::Windows::Forms::TextBox());
			this->textBox7 = (gcnew System::Windows::Forms::TextBox());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->label7 = (gcnew System::Windows::Forms::Label());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->pictureBox1))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->GridDots))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->Grid))->BeginInit();
			this->SuspendLayout();
			// 
			// pictureBox1
			// 
			this->pictureBox1->BackColor = System::Drawing::SystemColors::ButtonHighlight;
			this->pictureBox1->Location = System::Drawing::Point(4, 4);
			this->pictureBox1->Name = L"pictureBox1";
			this->pictureBox1->Size = System::Drawing::Size(580, 576);
			this->pictureBox1->TabIndex = 1;
			this->pictureBox1->TabStop = false;
			this->pictureBox1->Click += gcnew System::EventHandler(this, &MyForm::pictureBox1_Click);
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(606, 83);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(130, 84);
			this->button1->TabIndex = 8;
			this->button1->Text = L"Create Point";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(606, 44);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(51, 20);
			this->textBox1->TabIndex = 9;
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(685, 44);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(51, 20);
			this->textBox2->TabIndex = 10;
			// 
			// GridDots
			// 
			this->GridDots->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->GridDots->Location = System::Drawing::Point(606, 189);
			this->GridDots->Name = L"GridDots";
			this->GridDots->Size = System::Drawing::Size(130, 192);
			this->GridDots->TabIndex = 11;
			this->GridDots->CellContentClick += gcnew System::Windows::Forms::DataGridViewCellEventHandler(this, &MyForm::dataGridView1_CellContentClick);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(625, 28);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(14, 13);
			this->label1->TabIndex = 12;
			this->label1->Text = L"X";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(705, 28);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(14, 13);
			this->label2->TabIndex = 13;
			this->label2->Text = L"Y";
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(798, 83);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(130, 84);
			this->button2->TabIndex = 14;
			this->button2->Text = L"Create Line";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// textBox3
			// 
			this->textBox3->Location = System::Drawing::Point(798, 44);
			this->textBox3->Name = L"textBox3";
			this->textBox3->Size = System::Drawing::Size(51, 20);
			this->textBox3->TabIndex = 15;
			// 
			// textBox4
			// 
			this->textBox4->Location = System::Drawing::Point(877, 44);
			this->textBox4->Name = L"textBox4";
			this->textBox4->Size = System::Drawing::Size(51, 20);
			this->textBox4->TabIndex = 16;
			// 
			// Grid
			// 
			this->Grid->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->Grid->Location = System::Drawing::Point(798, 189);
			this->Grid->Name = L"Grid";
			this->Grid->Size = System::Drawing::Size(171, 192);
			this->Grid->TabIndex = 17;
			this->Grid->UseWaitCursor = true;
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(884, 28);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(32, 13);
			this->label3->TabIndex = 18;
			this->label3->Text = L"Right";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(809, 28);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(25, 13);
			this->label4->TabIndex = 19;
			this->label4->Text = L"Left";
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(851, 483);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(118, 71);
			this->button3->TabIndex = 20;
			this->button3->Text = L"Create Plex";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// button4
			// 
			this->button4->Location = System::Drawing::Point(606, 483);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(170, 71);
			this->button4->TabIndex = 21;
			this->button4->Text = L"Move";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &MyForm::button4_Click);
			// 
			// textBox5
			// 
			this->textBox5->Location = System::Drawing::Point(725, 442);
			this->textBox5->Name = L"textBox5";
			this->textBox5->Size = System::Drawing::Size(51, 20);
			this->textBox5->TabIndex = 22;
			// 
			// textBox6
			// 
			this->textBox6->Location = System::Drawing::Point(668, 442);
			this->textBox6->Name = L"textBox6";
			this->textBox6->Size = System::Drawing::Size(51, 20);
			this->textBox6->TabIndex = 23;
			// 
			// textBox7
			// 
			this->textBox7->Location = System::Drawing::Point(606, 442);
			this->textBox7->Name = L"textBox7";
			this->textBox7->Size = System::Drawing::Size(51, 20);
			this->textBox7->TabIndex = 24;
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Location = System::Drawing::Point(741, 426);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(18, 13);
			this->label5->TabIndex = 25;
			this->label5->Text = L"dy";
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(682, 426);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(18, 13);
			this->label6->TabIndex = 26;
			this->label6->Text = L"dx";
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Location = System::Drawing::Point(613, 426);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(35, 13);
			this->label7->TabIndex = 27;
			this->label7->Text = L"Name";
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(988, 585);
			this->Controls->Add(this->label7);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->textBox7);
			this->Controls->Add(this->textBox6);
			this->Controls->Add(this->textBox5);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->Grid);
			this->Controls->Add(this->textBox4);
			this->Controls->Add(this->textBox3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->GridDots);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->pictureBox1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->pictureBox1))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->GridDots))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->Grid))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		void ClearPictureBox() {
			Image = gcnew Bitmap(pictureBox1->Width, pictureBox1->Height);
			Graphics^g = pictureBox1->CreateGraphics();
			g->Clear(Color::White);
			pictureBox1->Image = Image;
			pictureBox1->Refresh();
			pictureBox1->Invalidate();
		}
		System::Void MyForm_Load(System::Object^ sender, System::EventArgs^ e) {

			Image = gcnew Bitmap(pictureBox1->Width, pictureBox1->Height);
			g = Graphics::FromImage(Image);
			pictureBox1->Image = Image;
		}

		std::string TranslateTo26(int x) {
			std::string ans;
			while (x) {
				ans += char(x % 26 + 'A');
				x /= 26;
			}
			std::reverse(ans.begin(), ans.end());
			if (ans.size() == 0) {
				ans += 'A';
			}
			return ans;
		}
		std::string GenerateNewName() {
			return TranslateTo26(++DotName);
		}
		int FindPoint(std::string s) {
			for (int i = 0; i < Dots.size(); i++) {
				if (Dots[i]->GetName() == s) return i;
			}
			return -1;
		}
		
		Graphics^ g;
		Bitmap^ Image;
		int DotName = -1;
		int i = 0,j = 0;
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
		int x, y;
		std::string name=GenerateNewName();
		Graphics^g = pictureBox1->CreateGraphics();
		x = Convert::ToInt32(textBox1->Text);
		y= Convert::ToInt32(textBox2->Text);
		Dots.push_back(new TPoint(x, y, name));
		Dots[i]->Draw(g);	
		GridDots->RowHeadersVisible = false;
		GridDots->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToAllHeaders);
		GridDots->AutoResizeColumns();
		GridDots->RowCount = i+1;
		GridDots->ColumnCount = 3;
		GridDots->Rows->Add();
		GridDots->Columns[0]->HeaderCell->Value = "Name";
		GridDots->Columns[1]->HeaderCell->Value = "X";
		GridDots->Columns[2]->HeaderCell->Value = "Y";
		GridDots->Rows[i]->Cells[0]->Value = msclr::interop::marshal_as<String^>(Dots[i]->GetName());
		GridDots->Rows[i]->Cells[1]->Value = System::Convert::ToString(Dots[i]->GetX());
		GridDots->Rows[i]->Cells[2]->Value = System::Convert::ToString(Dots[i]->GetY());
		i++;
		
	}
			 

			
private: System::Void dataGridView1_CellContentClick(System::Object^  sender, System::Windows::Forms::DataGridViewCellEventArgs^  e) {
	
}


private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string a, b;
	int idx1, idx2;
	Graphics^g = pictureBox1->CreateGraphics();
	a= msclr::interop::marshal_as<std::string>(textBox3->Text);
	b = msclr::interop::marshal_as<std::string>(textBox4->Text);
	std::string NameLine = a + ' ' + b;
	idx1 = FindPoint(a);
	idx2 = FindPoint(b);
	Line.push_back(new TLine(Dots[idx1], Dots[idx2])); 
	Line[j]->Draw(g);
	Grid->RowHeadersVisible = false;
	Grid->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToAllHeaders);
	Grid->AutoResizeColumns();
	Grid->RowCount = j + 1;
	Grid->ColumnCount = 5;
	Grid->Rows->Add();
	Grid->Columns[0]->HeaderCell->Value = "Name";
	Grid->Columns[1]->HeaderCell->Value = "X1";
	Grid->Columns[2]->HeaderCell->Value = "X2";
	Grid->Columns[3]->HeaderCell->Value = "Y1";
	Grid->Columns[4]->HeaderCell->Value = "Y2";
	Grid->Rows[j]->Cells[0]->Value = msclr::interop::marshal_as<String^>(Line[j]->GetName());
	Grid->Rows[j]->Cells[1]->Value = System::Convert::ToString(((TPoint*)(Line[j]->GetLeft()))->GetX());
	Grid->Rows[j]->Cells[2]->Value = System::Convert::ToString(((TPoint*)(Line[j]->GetLeft()))->GetY());
	Grid->Rows[j]->Cells[3]->Value = System::Convert::ToString(((TPoint*)(Line[j]->GetRight()))->GetX());
	Grid->Rows[j]->Cells[4]->Value = System::Convert::ToString(((TPoint*)(Line[j]->GetRight()))->GetY());
	j++;
}
private: System::Void pictureBox1_Click(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {
	a = new Plex(Line[0]);
	for (int i = 1; i < Line.size(); i++) {
		a->addLine(Line[i]);
	}
	a->saveFile();
	a->saveGraph();
}
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {
	std::string Name = msclr::interop::marshal_as<std::string>(textBox7->Text);
	int dx = System::Convert::ToInt32(textBox6->Text);
	int dy = System::Convert::ToInt32(textBox5->Text);
	int index = FindPoint(Name); 
	if (a) {
		TPoint* find = a->SearchPoint(Name);
		if (find) {
			find->MovePoint(dx, dy);
		}
		a->saveFile();
		a->saveGraph();
	}
	Dots[index]->MovePoint(dx, dy);
	ClearPictureBox();
	DrawDots_and_Line();
}
		 void DrawDots_and_Line() {
	
			 for (int k = 0; k < Dots.size(); k++) {
				 delete g;
				 g = Graphics::FromImage(Image);
				 pictureBox1->Image = Image;
				 Dots[k]->Draw(g);
				 pictureBox1->Refresh();
				 pictureBox1->Invalidate();
			 }
			 for (int q = 0; q < Line.size(); q++) {
				 delete g;
				 g = Graphics::FromImage(Image);
				 pictureBox1->Image = Image;
				 Line[q]->Draw(g);
				 pictureBox1->Refresh();
				 pictureBox1->Invalidate();
			 }
		 }
	
};
}
