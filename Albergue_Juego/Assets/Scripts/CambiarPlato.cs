using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CambiarPlato : MonoBehaviour
{
    [SerializeField] private Sprite nuevoPlato;
    [SerializeField] private int ContadorCroquetas;
    private SpriteRenderer spriteRenderer;
    void Start()
    {
        spriteRenderer = GetComponent<SpriteRenderer>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        
    }
}
