using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OnClikDetected : MonoBehaviour
{
    public GameObject Corazonprefab;
    public Transform[] generadorPuntos;
    public float VelocidadGeneracion;

    private void OnMouseDown()
    {
        InvokeRepeating("GeneradorCorazones", VelocidadGeneracion, VelocidadGeneracion);
        print("Hiciste un click");
    }
    private void OnMouseUp()
    {
        CancelInvoke("GeneradorCorazones");
        print("Dejaste de hacer click");
    }
    private void GeneradorCorazones()
    {
        Instantiate(Corazonprefab, generadorPuntos[Random.Range(0, generadorPuntos.Length)].position, Quaternion.identity);
    }
}
