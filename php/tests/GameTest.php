<?php

include __DIR__.'/../GameShell.php';
use PHPUnit\Framework\TestCase;

class GoldenMasterTest extends TestCase
{
    const GOLDEN_MASTER = 'trivia-golden-master.txt';
    const CURRENT_OUTPUT = 'trivia-current-output.txt';

    public function testGameRun()
    {
        $ob_file = fopen(self::CURRENT_OUTPUT, 'w');
        $ob_file_callback = function($buffer) use ($ob_file) {
            fwrite($ob_file, $buffer);
        };
        ob_start($ob_file_callback);

        srand(11);
        run();

        ob_end_flush();

        $golden_master = file_get_contents(self::GOLDEN_MASTER);
        $current_output = file_get_contents(self::CURRENT_OUTPUT);
        $this->assertEquals($golden_master, $current_output);
    }
}
?>