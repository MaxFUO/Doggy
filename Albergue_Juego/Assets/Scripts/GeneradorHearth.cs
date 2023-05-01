using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GeneradorHearth : MonoBehaviour
{
    public GameObject Corazonaprefab;
    public Transform[] generadorPuntos;
    public float VelocidadGeneracion;

    void Start()
    {
        InvokeRepeating("GeneradorCorazones", VelocidadGeneracion, 1f);
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    private void GeneradorCorazones()
    {
        Instantiate(Corazonaprefab, generadorPuntos[Random.Range(0, generadorPuntos.Length)].position, Quaternion.identity);
    }
}
