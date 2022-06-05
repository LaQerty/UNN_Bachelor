#pragma once
#include<cstdlib>
#include"Header.h"
#include"Header1.h"
namespace Matrix {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для MyForm
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
		/// Освободить все используемые ресурсы.
		/// </summary>
		~MyForm()
		{
			if (components)
			{
				delete components;
			}
		}

	protected:
	private: System::Windows::Forms::NumericUpDown^  numericUpDown1;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::DataGridView^  dataGridView1;
	private: System::Windows::Forms::DataGridView^  dataGridView2;
	private: System::Windows::Forms::DataGridView^  dataGridView3;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::Button^  button7;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown2;
	private: System::Windows::Forms::NumericUpDown^  numericUpDown3;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;

	private:
		/// <summary>
		/// Обязательная переменная конструктора.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Требуемый метод для поддержки конструктора — не изменяйте 
		/// содержимое этого метода с помощью редактора кода.
		/// </summary>
		void InitializeComponent(void)
		{
			this->numericUpDown1 = (gcnew System::Windows::Forms::NumericUpDown());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->dataGridView1 = (gcnew System::Windows::Forms::DataGridView());
			this->dataGridView2 = (gcnew System::Windows::Forms::DataGridView());
			this->dataGridView3 = (gcnew System::Windows::Forms::DataGridView());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->button7 = (gcnew System::Windows::Forms::Button());
			this->numericUpDown2 = (gcnew System::Windows::Forms::NumericUpDown());
			this->numericUpDown3 = (gcnew System::Windows::Forms::NumericUpDown());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown1))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView2))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView3))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown2))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown3))->BeginInit();
			this->SuspendLayout();
			// 
			// numericUpDown1
			// 
			this->numericUpDown1->Location = System::Drawing::Point(640, 36);
			this->numericUpDown1->Minimum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			this->numericUpDown1->Name = L"numericUpDown1";
			this->numericUpDown1->Size = System::Drawing::Size(120, 20);
			this->numericUpDown1->TabIndex = 0;
			this->numericUpDown1->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			this->numericUpDown1->ValueChanged += gcnew System::EventHandler(this, &MyForm::numericUpDown1_ValueChanged);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(641, 12);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(75, 13);
			this->label1->TabIndex = 1;
			this->label1->Text = L"Размерность";
			// 
			// dataGridView1
			// 
			this->dataGridView1->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->dataGridView1->Location = System::Drawing::Point(12, 131);
			this->dataGridView1->Name = L"dataGridView1";
			this->dataGridView1->Size = System::Drawing::Size(235, 175);
			this->dataGridView1->TabIndex = 2;
			this->dataGridView1->CellContentClick += gcnew System::Windows::Forms::DataGridViewCellEventHandler(this, &MyForm::dataGridView1_CellContentClick);
			// 
			// dataGridView2
			// 
			this->dataGridView2->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->dataGridView2->Location = System::Drawing::Point(272, 131);
			this->dataGridView2->Name = L"dataGridView2";
			this->dataGridView2->Size = System::Drawing::Size(235, 175);
			this->dataGridView2->TabIndex = 3;
			this->dataGridView2->CellContentClick += gcnew System::Windows::Forms::DataGridViewCellEventHandler(this, &MyForm::dataGridView2_CellContentClick);
			// 
			// dataGridView3
			// 
			this->dataGridView3->ColumnHeadersHeightSizeMode = System::Windows::Forms::DataGridViewColumnHeadersHeightSizeMode::AutoSize;
			this->dataGridView3->Location = System::Drawing::Point(525, 131);
			this->dataGridView3->Name = L"dataGridView3";
			this->dataGridView3->Size = System::Drawing::Size(235, 175);
			this->dataGridView3->TabIndex = 4;
			this->dataGridView3->CellContentClick += gcnew System::Windows::Forms::DataGridViewCellEventHandler(this, &MyForm::dataGridView3_CellContentClick);
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(12, 60);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(143, 48);
			this->button1->TabIndex = 5;
			this->button1->Text = L"Create  A";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &MyForm::button1_Click);
			// 
			// button2
			// 
			this->button2->Location = System::Drawing::Point(272, 60);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(155, 48);
			this->button2->TabIndex = 6;
			this->button2->Text = L"Create B";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &MyForm::button2_Click);
			// 
			// button3
			// 
			this->button3->Location = System::Drawing::Point(12, 343);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(143, 76);
			this->button3->TabIndex = 7;
			this->button3->Text = L"A+B";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &MyForm::button3_Click);
			// 
			// button4
			// 
			this->button4->Location = System::Drawing::Point(175, 343);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(165, 75);
			this->button4->TabIndex = 8;
			this->button4->Text = L"A-B";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &MyForm::button4_Click);
			// 
			// button5
			// 
			this->button5->Location = System::Drawing::Point(360, 344);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(160, 75);
			this->button5->TabIndex = 9;
			this->button5->Text = L"A*B";
			this->button5->UseVisualStyleBackColor = true;
			this->button5->Click += gcnew System::EventHandler(this, &MyForm::button5_Click);
			// 
			// button6
			// 
			this->button6->Location = System::Drawing::Point(690, 423);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(92, 55);
			this->button6->TabIndex = 10;
			this->button6->Text = L"EXIT";
			this->button6->UseVisualStyleBackColor = true;
			this->button6->Click += gcnew System::EventHandler(this, &MyForm::button6_Click);
			// 
			// button7
			// 
			this->button7->Location = System::Drawing::Point(549, 344);
			this->button7->Name = L"button7";
			this->button7->Size = System::Drawing::Size(141, 74);
			this->button7->TabIndex = 11;
			this->button7->Text = L"[ ]";
			this->button7->UseVisualStyleBackColor = true;
			this->button7->Click += gcnew System::EventHandler(this, &MyForm::button7_Click);
			// 
			// numericUpDown2
			// 
			this->numericUpDown2->Location = System::Drawing::Point(591, 423);
			this->numericUpDown2->Minimum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			this->numericUpDown2->Name = L"numericUpDown2";
			this->numericUpDown2->Size = System::Drawing::Size(69, 20);
			this->numericUpDown2->TabIndex = 12;
			this->numericUpDown2->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			// 
			// numericUpDown3
			// 
			this->numericUpDown3->Location = System::Drawing::Point(591, 449);
			this->numericUpDown3->Minimum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			this->numericUpDown3->Name = L"numericUpDown3";
			this->numericUpDown3->Size = System::Drawing::Size(69, 20);
			this->numericUpDown3->TabIndex = 13;
			this->numericUpDown3->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 1, 0, 0, 0 });
			this->numericUpDown3->ValueChanged += gcnew System::EventHandler(this, &MyForm::numericUpDown3_ValueChanged);
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(546, 425);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(34, 13);
			this->label2->TabIndex = 14;
			this->label2->Text = L"Rows";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(551, 451);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(29, 13);
			this->label3->TabIndex = 15;
			this->label3->Text = L"Cells";
			// 
			// MyForm
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(781, 478);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->numericUpDown3);
			this->Controls->Add(this->numericUpDown2);
			this->Controls->Add(this->button7);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->button5);
			this->Controls->Add(this->button4);
			this->Controls->Add(this->button3);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->dataGridView3);
			this->Controls->Add(this->dataGridView2);
			this->Controls->Add(this->dataGridView1);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->numericUpDown1);
			this->Name = L"MyForm";
			this->Text = L"MyForm";
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown1))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView1))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView2))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->dataGridView3))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown2))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->numericUpDown3))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	
	private: System::Void numericUpDown1_ValueChanged(System::Object^  sender, System::EventArgs^  e) {
	}
	private: System::Void dataGridView1_CellContentClick(System::Object^  sender, System::Windows::Forms::DataGridViewCellEventArgs^  e) {
 	

	}
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {

		//Create A

		dataGridView1->RowHeadersVisible = false;
		dataGridView1->ColumnHeadersVisible = false;
		int size = Convert::ToInt32(numericUpDown1->Value);
		TMatrix<int> mass(size);
				dataGridView1->ColumnCount = size;
				dataGridView1->RowCount = size;
				dataGridView1->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
				dataGridView1->AutoResizeColumns();
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (j >= i) {
							mass[i][j] = rand() % 10;
						}
						else {
							mass[i][j] = 0;
							dataGridView1->Rows[i]->Cells[j]->ReadOnly = true;
						}
						//dataGridView1->TopLeftHeaderCell->Value = "A";
						//dataGridView1->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
						//dataGridView1->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
						dataGridView1->Rows[i]->Cells[j]->Value = mass[i][j];
					}
				}
			
		
	}
private: System::Void dataGridView2_CellContentClick(System::Object^  sender, System::Windows::Forms::DataGridViewCellEventArgs^  e) {
}
private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) {

	// Create B

	int size = Convert::ToInt32(numericUpDown1->Value);
	TMatrix<int> mass(size);
	dataGridView2->RowHeadersVisible = false;
	dataGridView2->ColumnHeadersVisible = false;
	dataGridView2->ColumnCount = size;
	dataGridView2->RowCount = size;
	dataGridView2->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
	dataGridView2->AutoResizeColumns();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			if (j >= i) {
				mass[i][j] = rand() % 10;
			}
			else {
				mass[i][j] = 0;
				dataGridView2->Rows[i]->Cells[j]->ReadOnly = true;
			}
			//dataGridView2->TopLeftHeaderCell->Value = "A";
			//dataGridView2->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
			//dataGridView2->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
			dataGridView2->Rows[i]->Cells[j]->Value = mass[i][j];
		}
	}
	
}
private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e) {

	//A+B

	dataGridView3->RowHeadersVisible = false;
	dataGridView3->ColumnHeadersVisible = false;
	int size = Convert::ToInt32(numericUpDown1->Value);
	TMatrix<int> a(size), b(size), mass(size);
	dataGridView3->ReadOnly = true;

    dataGridView3->ColumnCount = size;
	dataGridView3->RowCount = size;
	dataGridView3->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
	dataGridView3->AutoResizeColumns();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++){
				a[i][j] = Convert::ToInt32(dataGridView1->Rows[i]->Cells[j]->Value);
				b[i][j] = Convert::ToInt32(dataGridView2->Rows[i]->Cells[j]->Value);
				
			
		}
	}
	//dataGridView3->TopLeftHeaderCell->Value = "RES";
	mass = a + b;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			//dataGridView3->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
			//dataGridView3->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
			if (j >= i) {
				dataGridView3->Rows[i]->Cells[j]->Value = mass[i][j];
			}
			else dataGridView3->Rows[i]->Cells[j]->Value = 0;
			}
		}
	}
	

private: System::Void dataGridView3_CellContentClick(System::Object^  sender, System::Windows::Forms::DataGridViewCellEventArgs^  e) {
}
private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e) {

	//A-B

	dataGridView3->RowHeadersVisible = false;
	dataGridView3->ColumnHeadersVisible = false;
	int size = Convert::ToInt32(numericUpDown1->Value);
	TMatrix<int> a(size), b(size), mass(size);
	dataGridView3->ReadOnly = true;

	dataGridView3->ColumnCount = size;
	dataGridView3->RowCount = size;
	dataGridView3->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
	dataGridView3->AutoResizeColumns();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			a[i][j] = Convert::ToInt32(dataGridView1->Rows[i]->Cells[j]->Value);
			b[i][j] = Convert::ToInt32(dataGridView2->Rows[i]->Cells[j]->Value);
	
		}
	}
	//dataGridView3->TopLeftHeaderCell->Value = "RES";
	mass = a - b;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			//dataGridView3->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
			//dataGridView3->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
			if (j >= i) {
				dataGridView3->Rows[i]->Cells[j]->Value = mass[i][j];
			}
			else dataGridView3->Rows[i]->Cells[j]->Value = 0;
		}
	}
}
private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e) {

	//A*B

	dataGridView3->RowHeadersVisible = false;
	dataGridView3->ColumnHeadersVisible = false;
	int size = Convert::ToInt32(numericUpDown1->Value);
	TMatrix<int> a(size), b(size), mass(size);
	dataGridView3->ReadOnly = true;

	dataGridView3->ColumnCount = size;
	dataGridView3->RowCount = size;
	dataGridView3->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
	dataGridView3->AutoResizeColumns();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			a[i][j] = Convert::ToInt32(dataGridView1->Rows[i]->Cells[j]->Value);
			b[i][j] = Convert::ToInt32(dataGridView2->Rows[i]->Cells[j]->Value);

		}
	}
	//dataGridView3->TopLeftHeaderCell->Value = "RES";
	mass = a * b;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			//dataGridView3->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
		//	dataGridView3->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
			if (j >= i) {
				dataGridView3->Rows[i]->Cells[j]->Value = mass[i][j];
			}
			else dataGridView3->Rows[i]->Cells[j]->Value = 0;
		}
	}
}
private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e) {

	//EXIT

	Application::Exit();
}
private: System::Void numericUpDown3_ValueChanged(System::Object^  sender, System::EventArgs^  e) {
}
private: System::Void button7_Click(System::Object^  sender, System::EventArgs^  e) {

	//[ ]

	dataGridView3->RowHeadersVisible = false;
	dataGridView3->ColumnHeadersVisible = false;
	int size = Convert::ToInt32(numericUpDown1->Value);
	int k = Convert::ToInt32(numericUpDown2->Value);//rows
	int m = Convert::ToInt32(numericUpDown3->Value);//cells
	k--;
	m--;
	TMatrix<int> a(size);
	dataGridView3->ColumnCount = size;
	dataGridView3->RowCount = size;
	dataGridView3->AutoResizeRowHeadersWidth(DataGridViewRowHeadersWidthSizeMode::AutoSizeToDisplayedHeaders);
	dataGridView3->AutoResizeColumns();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			a[i][j] = Convert::ToInt32(dataGridView1->Rows[i]->Cells[j]->Value);
		}
	}
		//dataGridView3->TopLeftHeaderCell->Value = "RES";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
			//	dataGridView3->Columns[j]->HeaderCell->Value = Convert::ToString(j + 1);
				//dataGridView3->Rows[i]->HeaderCell->Value = Convert::ToString(i + 1);
				if ((j >= i)&&(i==k)&&(j==m)) {
					dataGridView3->Rows[i]->Cells[j]->Value = a[i][j];
				}
				else dataGridView3->Rows[i]->Cells[j]->Value = 0;
			}
		}


}
};
}
	