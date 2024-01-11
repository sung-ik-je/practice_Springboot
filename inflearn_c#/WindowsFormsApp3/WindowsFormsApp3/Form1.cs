using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp3
{
    public partial class Form1 : Form
    {
        private int findNumber = 0;
        private int chance = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void input_click(object sender, EventArgs e)
        {
            int inputNumber = Int32.Parse(textBox.Text);

            if (inputNumber == findNumber)
            {
                display.Text = "승리했습니다";
            }
            else
            {
                chance--;
                display.Text = "기회는 " + chance + "번 남았습니다.";
            }

            if (chance <= 0)
            {
                display.Text = "실패했습니다";
            }
        }

        private void start_click(object sender, EventArgs e)
        {
            var rand = new Random();
            findNumber = rand.Next(1, 21);
            chance = 10;
            display.Text = "맞출 숫자를 입력하세요";
        }
    }
}
