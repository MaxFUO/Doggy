using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CambiarPlato : MonoBehaviour
{
    [SerializeField] public int ContadorCroquetas;
    [SerializeField] public Sprite nuevoSprite;

    private SpriteRenderer spriteRenderer;
    void Start()
    {
        spriteRenderer = GetComponent<SpriteRenderer>();
    }

    void Update()
    {
        if (ContadorCroquetas>=5)
        {
            spriteRenderer.sprite = nuevoSprite;
        }
    }
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Croquetas"))
        {
            ContadorCroquetas++;
        }
    }
}
