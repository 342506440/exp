﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Commodity.type
{
    public partial class ShowType : Form
    {
        public static string connectionString = "server=DESKTOP-D8HOK3N;database=spgl;integrated security = SSPI";
        public ShowType()
        {
            InitializeComponent();
        }

        private void ShowType_Load(object sender, EventArgs e)
        {
            DataGridViewDataLoad();
        }
        public void DataGridViewDataLoad()
        {
            SqlConnection conn = new SqlConnection(connectionString);
            conn.Open();
            SqlDataAdapter s = new SqlDataAdapter("select tname from  type", conn);
            DataSet d = new DataSet();
            s.Fill(d, "t");
            dataGridView1.DataSource = d.Tables["t"];
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("确定删除该类型信息？", "删除", MessageBoxButtons.OKCancel);
            if (result == DialogResult.OK)
            {
                SqlCommand cmd;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                object name;
                int a = dataGridView1.CurrentRow.Index;
                name = dataGridView1.Rows[a].Cells[0].Value;
                Console.WriteLine(name);
                string sql2 = string.Format("delete from type where tname='{0}'", name);
                cmd = new SqlCommand(sql2, conn);
                cmd.ExecuteNonQuery();
                MessageBox.Show("删除成功！");
            }
            DataGridViewDataLoad();
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            object name;
            int a = dataGridView1.CurrentRow.Index;
            name = dataGridView1.Rows[a].Cells[0].Value;
            Type.DetailsType d = new Type.DetailsType(name);
            d.Show();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            main m = new main();
            m.Show();
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            AddType a = new AddType();
            a.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DataGridViewDataLoad();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            String text = textBox1.Text.Trim();
            SqlConnection conn = new SqlConnection(connectionString);
            conn.Open();
            String sql = string.Format("select tname from type where tname like'%{0}%'", text);
            SqlDataAdapter s = new SqlDataAdapter(sql, conn);
            DataSet d = new DataSet();
            s.Fill(d, "t");
            dataGridView1.DataSource = d.Tables["t"];
        }

        private void button4_Click(object sender, EventArgs e)
        {
            object name;
            int a = dataGridView1.CurrentRow.Index;
            name = dataGridView1.Rows[a].Cells[0].Value;
            Type.UpdateType d = new Type.UpdateType(name);
            d.Show();
        }
    }
}
