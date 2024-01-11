using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void SigninButton(object sender, EventArgs e)
        {
            string userId = id.Text;
            string userPassword = pw.Text;

            if(userId.Equals("MyId") && userPassword.Equals("MyPassword"))
            {
                MessageBox.Show("로 그 인 성 공", "로그인");
            } else
            {
                MessageBox.Show("로 그 인 실 패", "로그인");
            }
        }
    }
}
