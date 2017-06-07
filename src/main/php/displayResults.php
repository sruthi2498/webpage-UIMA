 <!DOCTYPE html>
<html>
<head> <link rel="stylesheet" type="text/css" href="../css/stylesheet.css"></head>
<body>

		
		
		<?php
		echo "<a id='sub' href=\"javascript:history.go(-1)\">GO BACK</a><br>";

			/*$filelist="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/op/list.txt";
			$myfile1=fopen($filelist,"r")or die("Unable to open file!");
			echo "The annotators are\n";
			echo "<br>";

			$count=1;
			while(!feof($myfile1)) {
				$an=trim(fgets($myfile1));
				//echo $an;
				if($an)echo "<input type='checkbox' id='b'".$count ." value=".$an." name=".$an."><br>";
				$count++;

			}
			fclose($myfile1);*/

			$an=$_POST["Option"];
			//echo $an;
			if($an !="DocumentAnnotation"){
		//$an = str_replace(array("\r\n", "\r", "\n"), "<br />", $an);
		   //echo $an."<br>";
		    $fileop="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/op/".$an.".csv";
		   // echo "filename ".$fileop."<br>";
			$myfile2=fopen($fileop,"r")or die("Unable to open file!");
			//fwrite($myfile, $text);
			//echo "    values"; 
			echo "<br>";
			echo "<b>From                   To                  ".$an."<br></b>";
			while(!feof($myfile2)) {
				//echo "    ";
			 // echo fgets($myfile2) . "<br>";
				//print_r(fgetcsv($myfile2));

				$arr=fgetcsv($myfile2,1024);
				print $arr[0]."                   ";
				print $arr[1]."                   ";
				print $arr[2];
				echo "<br>";
			}

			fclose($myfile2);

		//echo "ok";
		}
		?>	


	
	
</form>


</body>
</html> 