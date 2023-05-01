using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GeneradorCroquetas : MonoBehaviour
{
    public GameObject[] tiposDeCroquetas;
    public Transform[] generadorPuntos;
    public float VelocidadGeneracion;

    private void OnMouseDown()
    {
        InvokeRepeating("GenerarCroquetas", VelocidadGeneracion, 1f);
        print("Hiciste un click");
    }
    private void OnMouseUp()
    {
        CancelInvoke("GenerarCroquetas");
        print("Dejaste de hacer click");
    }
    void GenerarCroquetas()
    {
        // seleccionar un prefab de croqueta al azar del arreglo de prefabs
        GameObject prefabDeCroqueta = tiposDeCroquetas[Random.Range(0, tiposDeCroquetas.Length)];
        Instantiate(prefabDeCroqueta, generadorPuntos[Random.Range(0, generadorPuntos.Length)].position, Quaternion.identity);
    }
    
}
