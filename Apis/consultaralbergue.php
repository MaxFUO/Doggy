<?PHP
$hostname_localhost ="localhost";
$database_localhost ="doggydb";
$username_localhost ="root";
$password_localhost ="";

$json=array();
		
	$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

	$consulta="select * from albergue";
	$resultado=mysqli_query($conexion,$consulta);
		
	if($registro=mysqli_fetch_array($resultado)){
		$result["IDAlbergue"]=$registro['IDAlbergue'];
		$result["NombreAlb"]=$registro['NombreAlb'];
		$result["LatitudAlb"]=$registro['LatitudAlb'];
		$result["LongitudAlb"]=$registro['LongitudAlb'];
		$result["HoraAperturaAlb"]=$registro['HoraAperturaAlb'];
		$json['albergue'][]=$result;
	}else{
		$resultar["IDAlbergue"]=0;
		$resultar["NombreAlb"]='no registra';
		$resultar["LatitudAlb"]='no registra';
		$resultar["LongitudAlb"]='no registra';
		$resultar["HoraAperturaAlb"]='no registra';
		$json['albergue'][]=$resultar;
	}
	
	mysqli_close($conexion);
	echo json_encode($json);
?>