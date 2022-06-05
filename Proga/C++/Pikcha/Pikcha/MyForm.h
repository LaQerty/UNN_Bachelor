#pragma once
namespace Pikcha {

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
	private: System::Windows::Forms::Button^  Exit_button;
	private: System::Windows::Forms::Button^  Line_button;
	private: System::Windows::Forms::PictureBox^  pictureBox1;
	private: System::Windows::Forms::Button^  Rectungle_button;

	private: System::Windows::Forms::Button^  Elipse_button;

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
			this->Exit_button = (gcnew System::Windows::Forms::Button());
			this->Line_button = (gcnew System::Windows::Forms::Button());
			this->pictureBox1 = (gcnew System::Windows::Forms::PictureBox());
			this->Rectungle_button = (gcnew System::Windows::Forms::Button());
			this->Elipse_button = (gcnew System::Windows::Forms::Button());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->pictureBox1))->BeginInit();
			this->SuspendLayout();
			// 
			// Exit_button
			// 
			this->Exit_button->BackColor = System::Drawing::SystemColors::HotTrack;
			this->Exit_button->ForeColor = System::Drawing::SystemColors::InactiveCaption;
			this->Exit_button->Location = System::Drawing::Point(510, 3);
			this->Exit_button->Name = L"Exit_button";
			this->Exit_button->Size = System::Drawing::Size(85, 26);
			this->Exit_button->TabIndex = 0;
			this->Exit_button->Text = L"Exit";
			this->Exit_button->UseVisualStyleBackColor = false;
			this->Exit_button->Click += gcnew System::EventHandler(this, &MyForm::Exit_button_Click);
			// 
			// Line_button
			// 
			this->Line_button->BackColor = System::Drawing::SystemColors::HotTrack;
			this->Line_button->ForeColor = System::Drawing::SystemColors::InactiveCaption;
			this->Line_button->Location = System::Drawing::Point(402, 4);
			this->Line_button->Name = L"Line_button";
			this->Line_button->Size = System::Drawing::Size(82, 25);
			this->Line_button->TabIndex = 1;
			this->Line_button->Text = L"Line";
			this->Line_button->UseVisualStyleBackColor = false;
			this->Line_button->Click += gcnew System::EventHandler(this, &MyForm::Pr_button_Click);
			// 
			// pictureBox1
			// 
			this->pictureBox1->Location = System::Drawing::Point(-3, 35);
			this->pictureBox1->Name = L"pictureBox1";
			this->pictureBox1->Size = System::Drawing::Size(598, 442);
			this->pictureBox1->TabIndex = 2;
			this->pictureBox1->TabStop = false;
			// 
			// Rectungle_button
			// 
			this->Rectungle_button->BackColor = System::Drawing::SystemColors::HotTrack;
			this->Rectungle_button->ForeColor = System::Drawing::SystemColors::InactiveCaption;
			this->Rectungle_button->Location = System::Drawing::Point(306, 4);
			this->Rectungle_button->Name = L"Rectungle_button";
			this->Rectungle_button->Size = System::Drawing::Size(86, 24);
			this->Rectungle_button->TabIndex = 3;
			this->Rectungle_button->Text = L"Rect";
			this->Rectungle_button->UseVisualStyleBackColor = false;
			this->Rectungle_button->Click += gcnew System::EventHandler(this, &MyForm::Rectungle_button_Click);
			// 
			// Elipse_button
			// 
			this->Elipse_button->BackColor = System::Drawing::SystemColors::HotTrack;
			this->Elipse_button->ForeColor = System::Drawing::SystemColors::InactiveCaption;
			this->Elipse_button->Location = System::Drawing::Point(210, 6);
			this->Elipse_button->Name = L"Elipse_button";
			this->Elipse_button->Size = System::Drawing::Size(72, 23);
			this->Elipse_button->TabIndex = 5;
			this->Elipse_button->Text = L"Elipse";
			this->Elipse_button->UseVisualStyleBackColor = false;
			this->Elipse_button->Click += gcnew System::EventHandler(this, &MyForm::Elipse_button_Click);
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ButtonHighlight;
			this->ClientSize = System::Drawing::Size(598, 470);
			this->Controls->Add(this->Elipse_button);
			this->Controls->Add(this->Rectungle_button);
			this->Controls->Add(this->pictureBox1);
			this->Controls->Add(this->Line_button);
			this->Controls->Add(this->Exit_button);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			this->Load += gcnew System::EventHandler(this, &MyForm::MyForm_Load);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->pictureBox1))->EndInit();
			this->ResumeLayout(false);

		}
#pragma endregion
	private: System::Void MyForm_Load(System::Object^  sender, System::EventArgs^  e) {
	}
	private: System::Void Exit_button_Click(System::Object^  sender, System::EventArgs^  e) {
		Close();
	}
	private: System::Void Pr_button_Click(System::Object^  sender, System::EventArgs^  e) {
		    
		
			Pen^pen = gcnew Pen(Color::Red, 3);

			Graphics^g = pictureBox1->CreateGraphics();
	        g->DrawLine(pen, 100,100,200,200);
			g->DrawLine(pen, 500, 100, 400, 200);
			g->DrawLine(pen,270, 250, 325, 250);
		
	}
	private: System::Void Rectungle_button_Click(System::Object^  sender, System::EventArgs^  e) {
		Pen^pen = gcnew Pen(Color::Purple, 3);
		SolidBrush^brush = gcnew SolidBrush(Color::Purple);
		Graphics^g = pictureBox1->CreateGraphics();
		g->DrawRectangle(pen, 200, 100,200,200);
		g->FillRectangle(brush,200,100,200,200);

	}


private: System::Void Elipse_button_Click(System::Object^  sender, System::EventArgs^  e) {

	Pen^pen = gcnew Pen(Color::Blue, 3);
	Pen^pen1 = gcnew Pen(Color::Yellow, 3);
	SolidBrush^brush1 = gcnew SolidBrush(Color::Yellow);
	Graphics^g = pictureBox1->CreateGraphics();
	SolidBrush^brush = gcnew SolidBrush(Color::Blue);
	g->DrawEllipse(pen, 200, 100, 200, 200);
	g->FillEllipse(brush, 200, 100, 200, 200);
	g->DrawEllipse(pen1, 250, 150, 20, 20);
	g->FillEllipse(brush1, 250, 150, 20, 20);
	g->DrawEllipse(pen1, 325, 150, 20, 20);
	g->FillEllipse(brush1, 325, 150, 20, 20);

}
};
}
