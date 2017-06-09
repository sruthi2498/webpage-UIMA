 <!DOCTYPE html>
<html>
<head> <link rel="stylesheet" type="text/css" href="../css/stylesheet.css"></head>
<body>

		
		
		<?php
		echo "<div id='div7'><div id='div9'><a id='sub1' href=\"javascript:history.go(-1)\">GO BACK</a></div><br>";

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
			//if($an !="DocumentAnnotation"){
		//$an = str_replace(array("\r\n", "\r", "\n"), "<br />", $an);
		   //echo $an."<br>";
		    $fileop="/home/sruthi/dev/UIMA-NLP-Platform/MyWorkspace/data/text_files/op/".$an.".csv";
		   // echo "filename ".$fileop."<br>";
			$myfile2=fopen($fileop,"r")or die("Unable to open file!");
			//fwrite($myfile, $text);
			//echo "    values"; 
			echo "<br><div id='div8'><table id='table'>";
			echo "<tr><th id='th1'>From</th><th id='th1'>To</th><th id='th2'>".$an."</th></tr>";
			while(!feof($myfile2)) {
				//echo "    ";
			 // echo fgets($myfile2) . "<br>";
				//print_r(fgetcsv($myfile2));
				echo "<tr>";
				$arr=fgetcsv($myfile2,1024);
				if(count($arr)==3){
					if($arr[0])echo "<td id='td1'>".$arr[0]."</td>";
					if($arr[1])echo "<td id='td2'>".$arr[1]."</td>";
					if($arr[2])echo "<td id='td3'>".$arr[2]."</td></tr>";
				}

			}

			fclose($myfile2);

		//echo "ok";
		//}
		?>	

</table>
</div>
<br><br><br>
</div>	
</form>


</body>
</html> 
