using System;
using System.Windows.Forms;

namespace Warcaby
{
    static class Run
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Window(new Engine()));
        }
    }
}
