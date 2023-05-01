using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovHearth : MonoBehaviour
{
    [SerializeField] private float tamMin = 5f;
    [SerializeField] private float tamMax = 15f;
    [SerializeField] private float VelMinRotacion = 30f;
    [SerializeField] private float VelMaxRotacion = 100f;
    [SerializeField] private float VelRotacion;
    [SerializeField] private float escala_minGrav = -0.1f;
    [SerializeField] private float escala_maxGrav = -0.6f;
    private Rigidbody2D rb;

    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        GeneraAleatorio();
        Destroy(this.gameObject, 5f);
    }


    void Update()
    {
        this.transform.Rotate(0, 0, VelRotacion * Time.deltaTime);
    }

    private void GeneraAleatorio()
    {
        float randomEscala = Random.Range(tamMin, tamMax);
        this.transform.localScale = new Vector3(randomEscala, randomEscala, randomEscala);
        VelRotacion = Random.Range(VelMinRotacion, VelMaxRotacion);
        rb.gravityScale = Random.Range(escala_minGrav, escala_maxGrav);
    }
}
