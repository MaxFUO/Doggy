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
		$result["ID_Albergue"]=$registro['ID_Albergue'];
		$result["NombreAlb"]=$registro['NombreAlb'];
		$result["HoraAperturaAlb"]=$registro['HoraAperturaAlb'];
		$result["LatitudAlb"]=$registro['LatitudAlb'];
		$result["LongitudAlb"]=$registro['LongitudAlb'];
		$result["NumeroTelf"]=$registro['NumeroTelf'];
		$result["Direccion"]=$registro['Direccion'];
		$result["CorreoElectronico"]=$registro['CorreoElectronico'];
		$json['albergue'][]=$result;
	}else{
		$resultar["ID_Albergue"]=0;
		$resultar["NombreAlb"]='no registra';
		$resultar["HoraAperturaAlb"]='no registra';
		$resultar["LatitudAlb"]='no registra';
		$resultar["LongitudAlb"]='no registra';
		$result["NumeroTelf"]=0;
		$result["Direccion"]='no registra';
		$result["CorreoElectronico"]='no registra';
		$json['albergue'][]=$resultar;
	}
	
	mysqli_close($conexion);
	echo json_encode($json);
?>