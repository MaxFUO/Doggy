using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CroquetasComp : MonoBehaviour
{
    [SerializeField] private float VelMinRotacion = 30f;
    [SerializeField] private float VelMaxRotacion = 100f;
    [SerializeField] private float VelRotacion;
    [SerializeField] private float escala_minGrav = 0.1f;
    [SerializeField] private float escala_maxGrav = 0.6f;
    private Rigidbody2D rb;

    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        GeneraAleatorio();
        Destroy(this.gameObject, 5f);
    }

    // Update is called once per frame
    void Update()
    {
        this.transform.Rotate(0, 0, VelRotacion * Time.deltaTime);
    }
    private void GeneraAleatorio()
    {
        VelRotacion = Random.Range(VelMinRotacion, VelMaxRotacion);
        rb.gravityScale = Random.Range(escala_minGrav, escala_maxGrav);
    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Plato"))
        {
            Destroy(this.gameObject);
        }
    }
}
