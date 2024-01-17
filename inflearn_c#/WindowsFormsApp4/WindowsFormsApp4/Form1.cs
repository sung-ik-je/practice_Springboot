using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        enum Operators
        {
            None,
            Add,
            Subtract,
            Multiply,
            Divide,
            Result
        }

        Operators currentOperator = Operators.None;
        Boolean operatorChangeFlag = false;
        int firstOperand = 0;
        int secondOperand = 0;
        Operators beforeOperator = Operators.None;

        private void ButtonSeven_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "7";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonEight_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "8";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonNine_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "9";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonFour_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "4";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonFive_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "5";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonSix_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "6";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonOne_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "1";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonTwo_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "2";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonThree_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "3";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonZero_Click(object sender, EventArgs e)
        {
            if (operatorChangeFlag == true)
            {
                display.Text = "";
                operatorChangeFlag = false;
            }
            string strNumber = display.Text += "0";
            int intNumber = Int32.Parse(strNumber);
            display.Text = intNumber.ToString();
        }

        private void ButtonDot_Click(object sender, EventArgs e)
        {
            display.Text += ".";
        }

        private void ButtonAc_Click(object sender, EventArgs e)
        {
            display.Text = "";
            firstOperand = 0;
            secondOperand = 0;
            currentOperator = Operators.None;
            display.Text = "0";
        }

        private void ButtonPlus_Click(object sender, EventArgs e)
        {
            if (currentOperator != Operators.None)
            {
                if (currentOperator == Operators.Add)
                {
                    firstOperand += Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Subtract)
                {
                    firstOperand -= Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Multiply)
                {
                    firstOperand *= Int32.Parse(display.Text);
                }
                else
                {
                    firstOperand /= Int32.Parse(display.Text);
                }
                display.Text = firstOperand.ToString();
            }
            firstOperand = Int32.Parse(display.Text);
            currentOperator = Operators.Add;
            operatorChangeFlag = true;
        }

        private void ButtonMinus_Click(object sender, EventArgs e)
        {
            if (currentOperator != Operators.None)
            {
                if (currentOperator == Operators.Add)
                {
                    firstOperand += Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Subtract)
                {
                    firstOperand -= Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Multiply)
                {
                    firstOperand *= Int32.Parse(display.Text);
                }
                else
                {
                    firstOperand /= Int32.Parse(display.Text);
                }
                display.Text = firstOperand.ToString();
            }
            firstOperand = Int32.Parse(display.Text);
            currentOperator = Operators.Subtract;
            operatorChangeFlag = true;
        }

        private void ButtonMulti_Click(object sender, EventArgs e)
        {
            if (currentOperator != Operators.None)
            {
                if (currentOperator == Operators.Add)
                {
                    firstOperand += Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Subtract)
                {
                    firstOperand -= Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Multiply)
                {
                    firstOperand *= Int32.Parse(display.Text);
                }
                else
                {
                    firstOperand /= Int32.Parse(display.Text);
                }
                display.Text = firstOperand.ToString();
            }
            firstOperand = Int32.Parse(display.Text);
            currentOperator = Operators.Multiply;
            operatorChangeFlag = true;
        }

        private void ButtonDiv_Click(object sender, EventArgs e)
        {
            if (currentOperator != Operators.None)
            {
                if (currentOperator == Operators.Add)
                {
                    firstOperand += Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Subtract)
                {
                    firstOperand -= Int32.Parse(display.Text);
                }
                else if (currentOperator == Operators.Multiply)
                {
                    firstOperand *= Int32.Parse(display.Text);
                }
                else
                {
                    firstOperand /= Int32.Parse(display.Text);
                }
                display.Text = firstOperand.ToString();
            }
            firstOperand = Int32.Parse(display.Text);
            currentOperator = Operators.Divide;
            operatorChangeFlag = true;
        }

        private void ButtonResult_Click(object sender, EventArgs e)
        {
            secondOperand = Int32.Parse(display.Text);
            if(currentOperator == Operators.Add)
            {
                firstOperand += secondOperand;
                display.Text = firstOperand.ToString();
            }
            else if (currentOperator == Operators.Subtract)
            {
                firstOperand -= secondOperand;
                if (firstOperand < 0)
                {
                    display.Text = "음수";
                }
                else
                {
                    display.Text = firstOperand.ToString();
                }
            }
            else if (currentOperator == Operators.Multiply)
            {
                firstOperand *= secondOperand;
                display.Text = firstOperand.ToString();
            }
            else if (currentOperator == Operators.Divide)
            {
                if(secondOperand == 0)
                {
                    display.Text = "0으로 나눌 수 없습니다.";
                }
                else
                {
                    firstOperand /= secondOperand;
                    display.Text = firstOperand.ToString();
                }
            }
        }
    }
}
