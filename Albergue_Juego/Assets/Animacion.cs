using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Animacion : MonoBehaviour
{
    public GeneradorHearth clickdetectado;
    private Animator animator;

    private void Start()
    {
        clickdetectado = GetComponent<GeneradorHearth>();
        animator = GetComponent<Animator>();
    }
    void Update()
    {
        if (clickdetectado.VelocidadGeneracion==0)
        {
            animator.Play("Perro_caricia");
        }
    }
}
