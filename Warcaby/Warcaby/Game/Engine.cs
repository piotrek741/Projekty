using System.Collections.Generic;

namespace Warcaby
{
    internal class Engine
    {
        internal bool Move(int sourceX, int sourceY, int targetX, int targetY)
        {
            Object enemyChecker = Player == Player.A ? Object.PlayerB : Object.PlayerA;

            if (Board[targetX, targetY] != Object.WarArea) return false;
            else if (sourceX - targetX > 2 || sourceX - targetX < -2) return false;
            else if (sourceY - targetY > 2 || sourceY - targetY < -2) return false;
            else if (sourceX - targetX == 2 || sourceX - targetX == -2 || sourceY - targetY == 2 || sourceY - targetY == -2)
            {
                if (targetX == sourceX + 2 && targetY == sourceY + 2)
                    if (IsValidArea(sourceX + 1, sourceY + 1) && Board[sourceX + 1, sourceY + 1] == enemyChecker)
                        Insert(Object.WarArea, sourceX + 1, sourceY + 1);
                    else
                        return false;
                else if (targetX == sourceX - 2 && targetY == sourceY + 2)
                    if (IsValidArea(sourceX - 1, sourceY + 1) && Board[sourceX - 1, sourceY + 1] == enemyChecker)
                        Insert(Object.WarArea, sourceX - 1, sourceY + 1);
                    else
                        return false;
                else if (targetX == sourceX + 2 && targetY == sourceY - 2)
                    if (IsValidArea(sourceX + 1, sourceY - 1) && Board[sourceX + 1, sourceY - 1] == enemyChecker)
                        Insert(Object.WarArea, sourceX + 1, sourceY - 1);
                    else
                        return false;
                else if (targetX == sourceX - 2 && targetY == sourceY - 2)
                    if (IsValidArea(sourceX - 1, sourceY - 1) && Board[sourceX - 1, sourceY - 1] == enemyChecker)
                        Insert(Object.WarArea, sourceX - 1, sourceY - 1);
                    else
                        return false;
                else
                    return false;

                points[Player]++;
            }

            Insert(Board[sourceX, sourceY], targetX, targetY);
            Insert(Object.WarArea, sourceX, sourceY);

            ChangePlayer();

            End = IsEnd();

            return true;
        }
        public bool IsPossibleSource(int x, int y)
        {
            if (Player == Player.A && Board[x, y] == Object.PlayerA)
                return true;
            else if (Player == Player.B && Board[x, y] == Object.PlayerB)
                return true;

            return false;
        }

        private bool IsEnd()
        {
            int playerACheckers = 0;
            int playerBCheckers = 0;

            for (int i = 0; i < Config.AREA_COUNT; i++)
                for (int j = 0; j < Config.AREA_COUNT; j++)
                    if (Board[i, j] == Object.PlayerA)
                        playerACheckers++;
                    else if (Board[i, j] == Object.PlayerB)
                        playerBCheckers++;

            return playerACheckers == 0 || playerBCheckers == 0;
        }
        private bool IsValidArea(int x, int y)
        {
            return x >= 0 && x <= Config.AREA_COUNT && y >= 0 && y <= Config.AREA_COUNT;
        }
        private void Insert(Object gameObject, int targetX, int targetY)
        {
            Board[targetX, targetY] = gameObject;
        }
        private void ChangePlayer()
        {
            Player = Player == Player.A ? Player.B : Player.A;
        }

        internal bool End { get; private set; } = false;
        internal IReadOnlyDictionary<Player, int> Points { get => points; }
        internal Player Player { get; private set; } = Player.A;
        internal Object[,] Board { get; } = new Object[,]
        {
            { Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB },
            { Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea },
            { Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB, Object.EmptyArea, Object.PlayerB },
            { Object.WarArea, Object.EmptyArea, Object.WarArea, Object.EmptyArea, Object.WarArea, Object.EmptyArea, Object.WarArea, Object.EmptyArea },
            { Object.EmptyArea, Object.WarArea, Object.EmptyArea, Object.WarArea, Object.EmptyArea, Object.WarArea, Object.EmptyArea, Object.WarArea },
            { Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea },
            { Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA },
            { Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea, Object.PlayerA, Object.EmptyArea }
        };
        private readonly Dictionary<Player, int> points = new Dictionary<Player, int>() { { Player.A, 0}, { Player.B, 0} };
    }
}