 <!DOCTYPE html>
<html>
<head> <link rel="stylesheet" type="text/css" href="../css/stylesheet.css"></head>
<body>

<div id='div5'>
<form id='buttons' method="post" action="../php/displayResults.php"> 
		
		<?php
			echo "<a id='sub' href=\"javascript:history.go(-1)\">GO BACK</a><br>";
			$filelist="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/op/list.txt";
			$myfile1=fopen($filelist,"r")or die("Unable to open file!");
			echo "<p id='p2'>The annotators are</p>";
			echo "<br>";
			echo "<div id='div6'>";
			$count=1;
			while(!feof($myfile1)) {
				$an=trim(fgets($myfile1));
				//echo $an;
				if($an)echo "<input type='radio' id='b".$count ."' value=".$an." name='Option'>".$an."<br>";
				$count++;

			}

			fclose($myfile1);
			/*if($an !="DocumentAnnotation"){
		//$an = str_replace(array("\r\n", "\r", "\n"), "<br />", $an);
		   echo $an."<br>";
		    $fileop="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/op/".$an.".txt";
		   // echo "filename ".$fileop."<br>";
			$myfile2=fopen($fileop,"r")or die("Unable to open file!");
			//fwrite($myfile, $text);
			echo "    values";
			echo "<br>";
			while(!feof($myfile2)) {
				echo "    ";
			  echo fgets($myfile2) . "<br>";
			}
			fclose($myfile2);
		//echo "ok";
		}*/
		?>	
		<br><br>
		<input id='sub' type='submit' value='View'>

		<br>
	</div>
	
	
</form>
</div>

</body>
</html> 