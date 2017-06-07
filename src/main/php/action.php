 <!DOCTYPE html>
<html>
	<head> <link rel="stylesheet" type="text/css" href="../css/stylesheet.css"></head>
<body>

<?php

	echo "<a id='sub' href=\"javascript:history.go(-1)\">GO BACK</a><br>";

	$text=$_POST["text"];
	$filename="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/Apache_UIMA.txt";
	$myfile=fopen($filename,"w")or die("Unable to open file!");
	fwrite($myfile, $text);
	//echo fread($myfile,filesize($filename));
	//echo "ok";
	fclose($myfile);
	 
	 $JAVA_HOME = "/usr/lib/jvm/java-8-openjdk-amd64";
	 $PATH = "$JAVA_HOME/bin:".getenv('PATH');
	 putenv("JAVA_HOME=$JAVA_HOME");
	 putenv("PATH=$PATH");
	$output=shell_exec('cd /home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace && mvn assembly:assembly -DdescriptorId=jar-with-dependencies && java -cp /home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/target/com.prescienced.uima-0.1.0-jar-with-dependencies.jar com.prescienced.uima.Test && cd');
	echo "<div id='div4'><p id='p2'>Process complete</p><br>";
	echo "<form id='form1' method='POST' action='../php/new_action.php'>";
	echo "<input id='sub' type='submit' value='click to view results'></form></div>";

?>

</body>
</html> 