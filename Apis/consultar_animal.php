<?PHP
$hostname_localhost ="localhost";
$database_localhost ="doggydb";
$username_localhost ="root";
$password_localhost ="";

$json=array();
				
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$consulta="select * from animal";
		$resultado=mysqli_query($conexion,$consulta);
		
		while($registro=mysqli_fetch_array($resultado)){
			$result["IDAnimal"]=$registro['IDAnimal'];
			$result["NombreAni"]=$registro['NombreAni'];
            $result["GeneroAni"]=$registro['GeneroAni'];
            $result["CuidadosEspeciales"]=$registro['CuidadosEspeciales'];
            $result["AlimentoFavorito"]=$registro['AlimentoFavorito'];
            $result["PesoAni"]=$registro['PesoAni'];
            $result["RazaAni"]=$registro['RazaAni'];
            $result["FuerzaAni"]=$registro['FuerzaAni'];
            $result["VelocidadAni"]=$registro['VelocidadAni'];
            $result["BuffAni"]=$registro['BuffAni'];
            $result["DesBuffAni"]=$registro['DesBuffAni'];
            $result["DebilidadAni"]=$registro['DebilidadAni'];
            $result["DescripcionAnim"]=$registro['DescripcionAnim'];

			$result["ImagenAnim"]=base64_encode($registro['ImagenAnim']);
			$result["RutaImagen"]=$registro['RutaImagen'];
			$json['imagenes'][]=$result;
			//echo $registro['id'].' - '.$registro['nombre'].'<br/>';
		}
		mysqli_close($conexion);
		echo json_encode($json);
?>

