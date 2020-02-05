using System;
using System.Collections.Generic;
using System.Text;

namespace Checkers
{
    public class Grid
    {
        private Button button;
        private char Mark;
        private int location;

        public Grid(Button _button, char _mark, int _location)
        {
            button = _button;
            Mark = _mark;
            location = _location;
        }

        public Button GetButton
        {
            get { return button; }
            set { button = value; }
        }

        public char getmark
        {
            get { return Mark; }
            set { Mark = value; }
        }

        public int getlocation
        {
            get { return location; }
            set { location = value; }
        }
    }
}