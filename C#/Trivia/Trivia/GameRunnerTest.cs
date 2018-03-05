using System;
using Xunit;

namespace Trivia
{
    public class GameRunnerTest
    {
        [Fact]
        public void RunGame()
        {
            GameRunner.Run(new Random(11));
        }
    }
}
