<?php

include __DIR__.'/../GameShell.php';
use PHPUnit\Framework\TestCase;

class StackTest extends TestCase
{
    public function testGameRun()
    {
        $ob_file = fopen('php-trivia-output-2.txt', 'w');
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