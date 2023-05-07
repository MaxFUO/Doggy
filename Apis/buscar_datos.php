<?php
include 'conexion.php';

if(isset($_GET['idAnimal'])){
    $idAnimal = $_GET['idAnimal'];

    $consulta = "SELECT IDAnimal, NombreAni, GeneroAni, CuidadosEspeciales, DescripcionAnim, ImagenAnim, RutaImagen FROM animal WHERE IDAnimal ='$idAnimal'";

    $resultado = $conexion->query($consulta);

    if ($resultado->num_rows == 0) {
        echo "No se encontró ningún animal con ese ID.";
    } else {
        while ($fila = $resultado->fetch_array()) {
            $fila['ImagenAnim'] = base64_encode($fila['ImagenAnim']); // Codificar la imagen como base64
            $animal[] = array_map('utf8_encode', $fila);
        }

        echo json_encode($animal);

        $resultado->close();
    }
} else {
    echo "No se ha proporcionado ningún ID de animal.";
}
?>
