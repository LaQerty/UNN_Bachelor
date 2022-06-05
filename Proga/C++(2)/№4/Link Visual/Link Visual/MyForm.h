#pragma once
#include <cmath>
#include "msclr\marshal_cppstd.h"
#include "Header.h"

int count_of_steps = 0;

void sep_dif_w(std::string st, std::string *w, int &k) {
	int i, l;
	std::string zn = " ,.";
	st += " ";
	for (int i = 0; i < st.length(); i++) {
		l = zn.find(st[i]);
		if (!((l >= 0) && (l < zn.length()))) {
			w[k] += st[i];
		}
		else {

			if (st[i] == ' ') {
				if (w[k] != "") {
					w[++k] = "";
				}
			}
			else {
				if (w[k] != "") {
					w[++k] = st[i];
				}
				else {
					w[k] = st[i];
				}
				w[++k] = "";
			}
		}
	}
}

namespace LinkVisual{

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// —водка дл€ Form_queue
	/// </summary>
	public ref class Form_queue : public System::Windows::Forms::Form
	{
	public:
		Form_queue(void)
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
		~Form_queue()
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
	private: System::Windows::Forms::DataGridView^  dataGridView1;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn1;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn2;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn3;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn4;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn5;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn6;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn7;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn8;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn9;
	private: System::Windows::Forms::DataGridViewTextBoxColumn^  dataGridViewTextBoxColumn10;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;

	private: System::Windows::Forms::TextBox^  textBox4;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;

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
			this->dataGridView1 = (gcnew System::Windows::Forms::DataGridView());
			this->dataGridViewTextBoxColumn1 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn2 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn3 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn4 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn5 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn6 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn7 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn8 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn9 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->dataGridViewTextBoxColumn10 = (gcnew System::Windows::Forms::DataGridViewTextBoxColumn());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->textBox4 = (gcnew System::Windows::Forms::TextBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->BeginInit();
			this->SuspendLayout();
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(9, 32);
			this->textBox1->Margin = System::Windows::Forms::Padding(2);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(675, 20);
			this->textBox1->TabIndex = 0;
			this->textBox1->TextChanged += gcnew System::EventHandler(this, &Form_queue::textBox1_TextChanged);
			// 
			// textBox2
			// 
			this->textBox2->BackColor = System::Drawing::SystemColors::ButtonHighlight;
			this->textBox2->Location = System::Drawing::Point(9, 76);
			this->textBox2->Margin = System::Windows::Forms::Padding(2);
			this->textBox2->Name = L"textBox2";
			this->textBox2->ReadOnly = true;
			this->textBox2->Size = System::Drawing::Size(675, 20);
			this->textBox2->TabIndex = 2;
			// 
			// textBox3
			// 
			this->textBox3->BackColor = System::Drawing::SystemColors::ButtonHighlight;
			this->textBox3->Location = System::Drawing::Point(11, 119);
			this->textBox3->Margin = System::Windows::Forms::Padding(2);
			this->textBox3->Name = L"textBox3";
			this->textBox3->ReadOnly = true;
			this->textBox3->Size = System::Drawing::Size(673, 20);
			this->textBox3->TabIndex = 4;
			// 
			// dataGridView1
			// 
			this->dataGridView1->Anchor = static_cast<System::Windows::Forms::AnchorStyles>((((System::Windows::Forms::AnchorStyles::Top | System::Windows::Forms::AnchorStyles::Bottom)
				| System::Windows::Forms::AnchorStyles::Left)
				| System::Windows::Forms::AnchorStyles::Right));
			this->dataGridView1->AutoSizeColumnsMode = System::Windows::Forms::DataGridViewAutoSizeColumnsMode::AllCells;
			this->dataGridView1->Columns->AddRange(gcnew cli::array< System::Windows::Forms::DataGridViewColumn^  >(10) {
				this->dataGridViewTextBoxColumn1,
					this->dataGridViewTextBoxColumn2, this->dataGridViewTextBoxColumn3, this->dataGridViewTextBoxColumn4, this->dataGridViewTextBoxColumn5,
					this->dataGridViewTextBoxColumn6, this->dataGridViewTextBoxColumn7, this->dataGridViewTextBoxColumn8, this->dataGridViewTextBoxColumn9,
					this->dataGridViewTextBoxColumn10
			});
			this->dataGridView1->Location = System::Drawing::Point(69, 163);
			this->dataGridView1->Margin = System::Windows::Forms::Padding(2);
			this->dataGridView1->Name = L"dataGridView1";
			this->dataGridView1->RowHeadersVisible = false;
			this->dataGridView1->RowTemplate->Height = 24;
			this->dataGridView1->Size = System::Drawing::Size(510, 118);
			this->dataGridView1->TabIndex = 6;
			// 
			// dataGridViewTextBoxColumn1
			// 
			this->dataGridViewTextBoxColumn1->HeaderText = L"0";
			this->dataGridViewTextBoxColumn1->Name = L"dataGridViewTextBoxColumn1";
			this->dataGridViewTextBoxColumn1->Width = 38;
			// 
			// dataGridViewTextBoxColumn2
			// 
			this->dataGridViewTextBoxColumn2->HeaderText = L"1";
			this->dataGridViewTextBoxColumn2->Name = L"dataGridViewTextBoxColumn2";
			this->dataGridViewTextBoxColumn2->Width = 38;
			// 
			// dataGridViewTextBoxColumn3
			// 
			this->dataGridViewTextBoxColumn3->HeaderText = L"2";
			this->dataGridViewTextBoxColumn3->Name = L"dataGridViewTextBoxColumn3";
			this->dataGridViewTextBoxColumn3->Width = 38;
			// 
			// dataGridViewTextBoxColumn4
			// 
			this->dataGridViewTextBoxColumn4->HeaderText = L"3";
			this->dataGridViewTextBoxColumn4->Name = L"dataGridViewTextBoxColumn4";
			this->dataGridViewTextBoxColumn4->Width = 38;
			// 
			// dataGridViewTextBoxColumn5
			// 
			this->dataGridViewTextBoxColumn5->HeaderText = L"4";
			this->dataGridViewTextBoxColumn5->Name = L"dataGridViewTextBoxColumn5";
			this->dataGridViewTextBoxColumn5->Width = 38;
			// 
			// dataGridViewTextBoxColumn6
			// 
			this->dataGridViewTextBoxColumn6->HeaderText = L"5";
			this->dataGridViewTextBoxColumn6->Name = L"dataGridViewTextBoxColumn6";
			this->dataGridViewTextBoxColumn6->Width = 38;
			// 
			// dataGridViewTextBoxColumn7
			// 
			this->dataGridViewTextBoxColumn7->HeaderText = L"6";
			this->dataGridViewTextBoxColumn7->Name = L"dataGridViewTextBoxColumn7";
			this->dataGridViewTextBoxColumn7->Width = 38;
			// 
			// dataGridViewTextBoxColumn8
			// 
			this->dataGridViewTextBoxColumn8->HeaderText = L"7";
			this->dataGridViewTextBoxColumn8->Name = L"dataGridViewTextBoxColumn8";
			this->dataGridViewTextBoxColumn8->Width = 38;
			// 
			// dataGridViewTextBoxColumn9
			// 
			this->dataGridViewTextBoxColumn9->HeaderText = L"8";
			this->dataGridViewTextBoxColumn9->Name = L"dataGridViewTextBoxColumn9";
			this->dataGridViewTextBoxColumn9->Width = 38;
			// 
			// dataGridViewTextBoxColumn10
			// 
			this->dataGridViewTextBoxColumn10->HeaderText = L"9";
			this->dataGridViewTextBoxColumn10->Name = L"dataGridViewTextBoxColumn10";
			this->dataGridViewTextBoxColumn10->Width = 38;
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(740, 77);
			this->button1->Margin = System::Windows::Forms::Padding(2);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(112, 47);
			this->button1->TabIndex = 7;
			this->button1->Text = L"Ўаг";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Form_queue::button1_Click);
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(740, 163);
			this->button2->Margin = System::Windows::Forms::Padding(2);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(112, 42);
			this->button2->TabIndex = 8;
			this->button2->Text = L"—ортировка";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &Form_queue::button2_Click);
			// 
			// textBox4
			// 
			this->textBox4->BackColor = System::Drawing::SystemColors::ButtonHighlight;
			this->textBox4->Location = System::Drawing::Point(740, 32);
			this->textBox4->Margin = System::Windows::Forms::Padding(2);
			this->textBox4->Name = L"textBox4";
			this->textBox4->ReadOnly = true;
			this->textBox4->Size = System::Drawing::Size(57, 20);
			this->textBox4->TabIndex = 10;
			this->textBox4->TextChanged += gcnew System::EventHandler(this, &Form_queue::textBox4_TextChanged);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(8, 9);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(56, 13);
			this->label1->TabIndex = 11;
			this->label1->Text = L"»сходна€";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(737, 9);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(47, 13);
			this->label2->TabIndex = 12;
			this->label2->Text = L"є Ўага";
			// 
			// Form_queue
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(912, 330);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox4);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->dataGridView1);
			this->Controls->Add(this->textBox3);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Margin = System::Windows::Forms::Padding(2);
			this->Name = L"Form_queue";
			this->Text = L"Form_queue";
			this->Load += gcnew System::EventHandler(this, &Form_queue::Form_queue_Load);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Form_queue_Load(System::Object^  sender, System::EventArgs^  e) {
	}
	private: System::Void textBox1_TextChanged(System::Object^  sender, System::EventArgs^  e) {
	}
	private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {
		dataGridView1->RowCount = 1;

		String ^ Final_Str = gcnew String(std::string("").c_str());
		textBox1->Text = Final_Str;
		textBox2->Text = Final_Str;
		textBox3->Text = Final_Str;
		textBox4->Text = Final_Str;

		count_of_steps = 0;
	}
	private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {
		int* a = new int[300];
		int count_of_rasr = 0;
		std::string* w = new std::string[300];
		int k = 0;

		sep_dif_w(msclr::interop::marshal_as < std::string >(textBox1->Text), w, k);

		for (int i = 0; i < k; i++) {
			a[i] = std::stoi(w[i]);
			if (count_of_rasr < w[i].length()) {
				count_of_rasr = w[i].length();
			}
		}

		int** rasr = new int*[10];
		for (int i = 0; i < 10; i++) {
			rasr[i] = new int[300];
		}
		int* count_for_rasr = new int[10];
		for (int i = 0; i < 10; i++) {
			count_for_rasr[i] = 0;
		}
		for (int i = 0; i < count_of_rasr; i++) {
			for (int j = 0; j < k; j++) {
				rasr[(a[j] % int(std::pow(10, i + 1))) / int(std::pow(10, i))][count_for_rasr[(a[j] % int(std::pow(10, i + 1))) / int(std::pow(10, i))]++] = a[j];
				a[j] = 0;
			}
			k = 0;

			for (int j = 0; j < 10; j++) {
				for (int o = 0; o < count_for_rasr[j]; o++) {
					a[k++] = rasr[j][o];
					rasr[j][o] = 0;
				}
				count_for_rasr[j] = 0;
			}
		}

		std::string str = "";
		for (int i = 0; i < k; i++) {
			str += (std::to_string(a[i]) + " ");
		}
		String ^ Final_Str = gcnew String(str.c_str());
		textBox3->Text = Final_Str;
	}
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
		String ^ Final_Str1 = gcnew String(std::to_string(count_of_steps + 1).c_str());
		textBox4->Text = Final_Str1;

		int* a = new int[300];
		int count_of_rasr = 0;
		std::string* w = new std::string[300];
		int k = 0;

		if (msclr::interop::marshal_as < std::string >(textBox2->Text) == "" | msclr::interop::marshal_as < std::string >(textBox1->Text).length() != msclr::interop::marshal_as < std::string >(textBox2->Text).length()) {
			sep_dif_w(msclr::interop::marshal_as < std::string >(textBox1->Text), w, k);
		}
		else {
			sep_dif_w(msclr::interop::marshal_as < std::string >(textBox2->Text), w, k);
		}

		for (int i = 0; i < k; i++) {
			a[i] = std::stoi(w[i]);
			if (count_of_rasr < w[i].length()) {
				count_of_rasr = w[i].length();
			}
		}

		dataGridView1->RowCount = 1;

		int** rasr = new int*[10];
		for (int i = 0; i < 10; i++) {
			rasr[i] = new int[300];
		}
		int* count_for_rasr = new int[10];
		for (int i = 0; i < 10; i++) {
			count_for_rasr[i] = 0;
		}
		for (int j = 0; j < k; j++) {
			rasr[(a[j] % int(std::pow(10, count_of_steps + 1))) / int(std::pow(10, count_of_steps))][count_for_rasr[(a[j] % int(std::pow(10, count_of_steps + 1))) / int(std::pow(10, count_of_steps))]++] = a[j];
			a[j] = 0;
		}
		k = 0;

		for (int j = 0; j < 10; j++) {
			std::string str = "";
			for (int o = 0; o < count_for_rasr[j]; o++) {
				a[k++] = rasr[j][o];
				if (str.length()) {
					str += " // ";
				}
				str += std::to_string(rasr[j][o]);
				rasr[j][o] = 0;
			}
			String ^ Final_Str = gcnew String(str.c_str());
			dataGridView1->Rows[0]->Cells[j]->Value = Final_Str;
			count_for_rasr[j] = 0;
		}

		count_of_steps++;
		if (count_of_steps == count_of_rasr) {
			count_of_steps = 0;
		}

		std::string str = "";
		for (int i = 0; i < k - 1; i++) {
			str += (std::to_string(a[i]) + " ");
		}
		str += std::to_string(a[k - 1]);
		String ^ Final_Str2 = gcnew String(str.c_str());
		textBox2->Text = Final_Str2;
	}
	private: System::Void textBox4_TextChanged(System::Object^  sender, System::EventArgs^  e) {
	}
	};
}