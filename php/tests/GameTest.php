<?php

include __DIR__.'/../GameShell.php';
use PHPUnit\Framework\TestCase;

class GoldenMasterTest extends TestCase
{
    public function testGameRun()
    {
        $ob_file = fopen('trivia-current-output.txt', 'w');
        $ob_file_callback = function($buffer) use ($ob_file) {
            fwrite($ob_file, $buffer);
        };
        ob_start($ob_file_callback);

        srand(11);
        run();

        ob_end_flush();
    }
}
?>